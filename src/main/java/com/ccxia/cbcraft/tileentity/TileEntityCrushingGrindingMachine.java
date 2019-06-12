package com.ccxia.cbcraft.tileentity;

import java.util.HashMap;
import java.util.Map;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.inventory.ContainerCrushingGrindingMachine;
import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
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
	// ��ĥ�Ľ���ʱ�䣬���ڶ�ӦGui�����еĽ���������
	private int loadTime;
	// ��ĥ�Ĺ�������
	Map<Item, ItemStack> workList = new HashMap<Item, ItemStack>();

	public TileEntityCrushingGrindingMachine() {
		// 1��ɿɶ�->1�ɿɸ�
		workList.put(ModItems.COOKED_COCOA_BEANS, new ItemStack(ModItems.COCOA_PASTE, 1));
		// 1ɰ��->1��ʯ
		workList.put(Item.getItemFromBlock(Blocks.GRAVEL), new ItemStack(Items.FLINT, 1));
		// 1�������->6������
		workList.put(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK), new ItemStack(Items.NETHER_WART, 6));
		// 1ʯӢ��->2ʯӢ
		workList.put(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK), new ItemStack(Items.QUARTZ, 2));
		// 1�����->4�����
		workList.put(Item.getItemFromBlock(Blocks.CLAY), new ItemStack(Items.CLAY_BALL, 4));
		// 1���Ͽ�->6����
		workList.put(Item.getItemFromBlock(Blocks.MELON_BLOCK), new ItemStack(Items.MELON, 6));
		// 1�ҽ���->2�ҽ���
		workList.put(Item.getItemFromBlock(Blocks.MAGMA), new ItemStack(Items.MAGMA_CREAM, 2));
		// 1�����->3�����
		workList.put(Items.BLAZE_ROD, new ItemStack(Items.BLAZE_POWDER, 3));
		// 1��ͷ->4�Ƿ�
		workList.put(Items.BONE, new ItemStack(Items.DYE, 4, 15));
		// 1С��->1���
		workList.put(Items.WHEAT, new ItemStack(ModItems.FLOUR, 1));
	}

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
		if (!this.world.isRemote) {
			if (canLoad()) {
				Item item = upInventory.extractItem(0, 1, true).getItem();
				// ע�⣺��ߵ�resultһ��Ҫ��copyһ�ݴ�Map���л�ȡ����Ʒջ�����Բ���ֱ����
				ItemStack result = getResultItem(item).copy();
				if (downInventory.insertItem(0, result, true) == ItemStack.EMPTY) {
					if (this.loadTime == 200) {
						downInventory.insertItem(0, result, false);
						upInventory.extractItem(0, 1, false);
						this.loadTime = 0;
					} else {
						this.loadTime++;
					}
				} else {
					this.loadTime = 0;
				}
			} else {
				this.loadTime = 0;
			}
		}

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

	// �ж���Ʒ���Ƿ��п��Լӹ�����Ʒ
	public boolean canLoad() {
		Item item = upInventory.extractItem(0, 1, true).getItem();
		if (workList.containsKey(item)) {
			return true;
		} else {
			return false;
		}
	}

	// ��ȡ��Ӧ�ӹ���Ʒ�ĳ�Ʒ
	public ItemStack getResultItem(Item item) {
		return workList.get(item);
	}

	public int getLoadTime() {
		return this.loadTime;
	}

}
