package com.ccxia.cbcraft.tileentity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ccxia.cbcraft.item.ModItems;
import com.ccxia.cbcraft.tileentity.crafting.CraftingAutoPressing;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityAutoPressing extends TileEntity implements ITickable {

	// 上方原料，侧边可可粉，下方成品
	protected ItemStackHandler upInventory = new ItemStackHandler();
	protected ItemStackHandler sideInventory = new ItemStackHandler();
	protected ItemStackHandler downInventory = new ItemStackHandler();

	// 可可能量条
	private int cocoaPower;
	// 压合时间
	private int pressTime;

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
			T result = (T) (facing == EnumFacing.DOWN ? downInventory : sideInventory);
			if (facing == EnumFacing.UP)
				result = (T) upInventory;
			return result;
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public void update() {
		if (!this.world.isRemote) {
			// 充能逻辑
			if (!this.isFullPower()) {
				if (this.hasCocoaPowder()) {
					sideInventory.extractItem(0, 1, false);
					this.cocoaPower += 10;
				}
			}
			// 工作逻辑
			if (this.cocoaPower >= 10) {
				if (!CraftingAutoPressing.instance().getResult(this.upInventory.getStackInSlot(0)).resultItem
						.isEmpty()) {
					CraftingAutoPressing.ResultPack result = CraftingAutoPressing.instance()
							.getResult(this.upInventory.getStackInSlot(0));
					ItemStack itemStack = result.resultItem;
					if ((itemStack.isItemEqual(this.downInventory.getStackInSlot(0))
							&& (this.downInventory.getStackInSlot(0).getCount() + itemStack.getCount() <= itemStack
									.getMaxStackSize()))
							|| (this.downInventory.getStackInSlot(0).isEmpty())) {
						if (++this.pressTime == 8) {
							this.upInventory.extractItem(0, result.itemCost, false);
							this.downInventory.insertItem(0, itemStack.copy(), false);
							this.pressTime = 0;
							this.cocoaPower -= 10;
						}
					} else {
						this.pressTime = 0;
					}
				} else {
					this.pressTime = 0;
				}
			}
		}
	}

	private boolean isFullPower() {
		return this.cocoaPower > 990;
	}

	private boolean hasCocoaPowder() {
		return this.sideInventory.getStackInSlot(0).getItem() == ModItems.COCOA_POWDER;
	}

	public int getCocoaPower() {
		return this.cocoaPower;
	}

	public int getPressTime() {
		return this.pressTime;
	}

}
