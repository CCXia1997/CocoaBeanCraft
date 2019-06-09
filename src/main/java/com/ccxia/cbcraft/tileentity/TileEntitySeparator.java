package com.ccxia.cbcraft.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntitySeparator extends TileEntity implements ITickable {
	// 分离机的底部成品位置有两个物品槽，输出两种成品
	protected ItemStackHandler upInventory = new ItemStackHandler();
	protected ItemStackHandler sideInventory = new ItemStackHandler();
	protected ItemStackHandler downInventory = new ItemStackHandler(2);

	private NonNullList<ItemStack> separatorItemStacks = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {
			// @SuppressWarnings("unchecked")
			if (facing == EnumFacing.UP)
				return (T) upInventory;
			else if (facing == EnumFacing.DOWN)
				return (T) downInventory;
			else
				return (T) sideInventory;
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	public int getSizeInventory() {
		return separatorItemStacks.size();
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		return compound;
	}

}
