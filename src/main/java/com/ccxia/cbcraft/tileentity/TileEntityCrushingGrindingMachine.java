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

public class TileEntityCrushingGrindingMachine extends TileEntity implements ITickable {
	protected ItemStackHandler upInventory = new ItemStackHandler();
	protected ItemStackHandler downInventory = new ItemStackHandler();

	private NonNullList<ItemStack> crushingItemStacks = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);

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
			@SuppressWarnings("unchecked")
			T result = (T) (facing == EnumFacing.DOWN ? downInventory : upInventory);
			return result;
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public int getSizeInventory() {
		return crushingItemStacks.size();
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

	public ItemStackHandler getUpInventory() {
		return this.upInventory;
	}

	public ItemStackHandler getDownInventory() {
		return this.downInventory;
	}

}
