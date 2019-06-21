package com.ccxia.cbcraft.inventory;

import com.ccxia.cbcraft.tileentity.TileEntitySeparator;

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

public class ContainerSeparator extends Container {
	private IItemHandler upItems;
	private IItemHandler sideItems;
	private IItemHandler downItems;
	private TileEntitySeparator tileEntity;
	private int furnaceBurnTime;
	private int currentItemBurnTime;
	private int cookTime;
	private int totalCookTime;

	public ContainerSeparator(EntityPlayer player, TileEntity tileEntity) {
		super();
		this.upItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
		this.sideItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		this.downItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
		this.addSlotToContainer(new SlotItemHandler(this.upItems, 0, 56, 17) {

			@Override
			public boolean isItemValid(ItemStack stack) {
				return stack != null && super.isItemValid(stack);
			}

			@Override
			public int getItemStackLimit(ItemStack stack) {
				return 64;
			}
		});
		this.addSlotToContainer(new SlotItemHandler(this.sideItems, 0, 56, 53) {

			@Override
			public boolean isItemValid(ItemStack stack) {
				return stack != null && super.isItemValid(stack);
			}

			@Override
			public int getItemStackLimit(ItemStack stack) {
				return 64;
			}
		});
		this.addSlotToContainer(new SlotItemHandler(this.downItems, 0, 109, 34) {
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
		this.addSlotToContainer(new SlotItemHandler(this.downItems, 1, 127, 34) {
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
		this.tileEntity = (TileEntitySeparator) tileEntity;
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
			if (index == 0 || index == 1 || index == 2 || index == 3) {
				if (!this.mergeItemStack(itemstack1, 4, 40, true)) {
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
		this.furnaceBurnTime = tileEntity.getTime(0);
		this.currentItemBurnTime = tileEntity.getTime(1);
		this.cookTime = tileEntity.getTime(2);
		this.totalCookTime = tileEntity.getTime(3);
		for (IContainerListener i : this.listeners) {
			i.sendWindowProperty(this, 0, this.furnaceBurnTime);
			i.sendWindowProperty(this, 1, this.currentItemBurnTime);
			i.sendWindowProperty(this, 2, this.cookTime);
			i.sendWindowProperty(this, 3, this.totalCookTime);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int id, int data) {
		super.updateProgressBar(id, data);
		switch (id) {
		case 0:
			this.furnaceBurnTime = data;
			break;
		case 1:
			this.currentItemBurnTime = data;
			break;
		case 2:
			this.cookTime = data;
			break;
		case 3:
			this.totalCookTime = data;
			break;
		default:
			break;
		}
	}

	public int getTime(int index) {
		switch (index) {
		case 0:
			return this.furnaceBurnTime;
		case 1:
			return this.currentItemBurnTime;
		case 2:
			return this.cookTime;
		case 3:
			return this.totalCookTime;
		default:
			return 0;
		}
	}
}
