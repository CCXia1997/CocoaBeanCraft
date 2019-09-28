package com.ccxia.cbcraft.inventory;

import com.ccxia.cbcraft.item.ModItems;
import com.ccxia.cbcraft.tileentity.TileEntityAutoPressing;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerAutoPressing extends Container {
	private IItemHandler upItems;;
	private IItemHandler sideItems;
	private IItemHandler downItems;
	private TileEntityAutoPressing tileEntity;

	private int cocoaPower;
	private int pressTime;

	public ContainerAutoPressing(EntityPlayer player, TileEntity tileEntity) {
		super();
		this.upItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
		this.sideItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		this.downItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
		this.addSlotToContainer(new SlotItemHandler(this.upItems, 0, 75, 53) {

			@Override
			public boolean isItemValid(ItemStack stack) {
				return stack != null && super.isItemValid(stack);
			}

			@Override
			public int getItemStackLimit(ItemStack stack) {
				return 64;
			}
		});
		this.addSlotToContainer(new SlotItemHandler(this.sideItems, 0, 43, 19) {

			@Override
			public boolean isItemValid(ItemStack stack) {
				return stack.getItem() == ModItems.COCOA_POWDER;
			}

			@Override
			public int getItemStackLimit(ItemStack stack) {
				return 64;
			}
		});
		this.addSlotToContainer(new SlotItemHandler(this.downItems, 0, 138, 53) {
			// 这边返回false，表示成品槽正常情况下不能输入物品
			@Override
			public boolean isItemValid(ItemStack stack) {
				return false;
			}

			@Override
			public int getItemStackLimit(ItemStack stack) {
				return 64;
			}
		});
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
		this.tileEntity = (TileEntityAutoPressing) tileEntity;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index == 0 || index == 1 || index == 2) {
				if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, 2, false)) {
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		this.cocoaPower = tileEntity.getCocoaPower();
		this.pressTime = tileEntity.getPressTime();
		for (IContainerListener i : this.listeners) {
			i.sendWindowProperty(this, 0, this.cocoaPower);
			i.sendWindowProperty(this, 1, this.pressTime);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int id, int data) {
		super.updateProgressBar(id, data);
		switch (id) {
		case 0:
			this.cocoaPower = data;
			break;
		case 1:
			this.pressTime = data;
			break;
		default:
			break;
		}
	}

	public int getCocoaPower() {
		return this.cocoaPower;
	}

	public int getPressTime() {
		return this.pressTime;
	}

}
