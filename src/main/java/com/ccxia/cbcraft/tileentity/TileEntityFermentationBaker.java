package com.ccxia.cbcraft.tileentity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityFermentationBaker extends TileEntity implements ITickable {

	// 创建4个物品槽位，上方为主料，左右两侧为辅料，后侧（暂且也包括正面）为燃料，下方为成品导出
	protected ItemStackHandler upInventory = new ItemStackHandler();
	protected ItemStackHandler sideInventory = new ItemStackHandler();
	protected ItemStackHandler backInventory = new ItemStackHandler();
	protected ItemStackHandler downInventory = new ItemStackHandler();

	// 描述容器内物品的一个集合
	private NonNullList<ItemStack> ferbakerItemStacks = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	// 这个方法用于确定方块的六个面和物品槽位的对应关系
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {
			// return your IItemHandler
			@SuppressWarnings("unchecked")
			EnumFacing blockfacing = (EnumFacing) this.world.getBlockState(this.pos).getValue(BlockHorizontal.FACING);
			if (facing == EnumFacing.UP)
				return (T) upInventory;
			if (facing == EnumFacing.DOWN)
				return (T) downInventory;
			if (blockfacing == EnumFacing.NORTH || blockfacing == EnumFacing.SOUTH) {
				if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH)
					return (T) backInventory;
				else if (facing == EnumFacing.WEST || facing == EnumFacing.EAST)
					return (T) sideInventory;
			}
			if (blockfacing == EnumFacing.WEST || blockfacing == EnumFacing.EAST) {
				if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH)
					return (T) sideInventory;
				else if (facing == EnumFacing.WEST || facing == EnumFacing.EAST)
					return (T) backInventory;
			}
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public int getSizeInventory() {
		return ferbakerItemStacks.size();
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

	public ItemStackHandler getSideInventory() {
		return this.sideInventory;
	}

	public ItemStackHandler getBackInventory() {
		return this.backInventory;
	}

	public ItemStackHandler getDownInventory() {
		return this.downInventory;
	}

}
