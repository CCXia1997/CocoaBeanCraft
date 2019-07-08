package com.ccxia.cbcraft.inventory.slot;

import com.ccxia.cbcraft.inventory.crafting.RecipesCrushing;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class SlotCrushing extends Slot {
	/** The craft matrix inventory linked to this result slot. */
	private final InventoryCrafting craftMatrix;
	/** The player that is using the GUI where this slot resides. */
	private final EntityPlayer player;
	/**
	 * The number of items that have been crafted so far. Gets passed to
	 * ItemStack.onCrafting before being reset.
	 */
	private int amountCrafted;

	public SlotCrushing(EntityPlayer player, InventoryCrafting craftingInventory, IInventory inventoryIn, int slotIndex,
			int xPosition, int yPosition) {
		super(inventoryIn, slotIndex, xPosition, yPosition);
		this.player = player;
		this.craftMatrix = craftingInventory;
	}

	public boolean isItemValid(ItemStack stack) {
		return false;
	}

	public ItemStack decrStackSize(int amount) {
		if (this.getHasStack()) {
			this.amountCrafted += Math.min(amount, this.getStack().getCount());
		}

		return super.decrStackSize(amount);
	}

	protected void onCrafting(ItemStack stack, int amount) {
		this.amountCrafted += amount;
		this.onCrafting(stack);
	}

	protected void onSwapCraft(int p_190900_1_) {
		this.amountCrafted += p_190900_1_;
	}

	protected void onCrafting(ItemStack stack) {

	}

	public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
		NonNullList<ItemStack> nonnulllist = RecipesCrushing.CRUSHING_MANAGER.getRemainingItems(this.craftMatrix);
		for (int i = 0; i < nonnulllist.size(); ++i) {
			ItemStack itemstack = this.craftMatrix.getStackInSlot(i);
			ItemStack itemstack1 = nonnulllist.get(i);

			if (!itemstack.isEmpty()) {
				this.craftMatrix.decrStackSize(i, 1);
				itemstack = this.craftMatrix.getStackInSlot(i);
			}

			if (!itemstack1.isEmpty()) {
				if (itemstack.isEmpty()) {
					this.craftMatrix.setInventorySlotContents(i, itemstack1);
				} else if (ItemStack.areItemsEqual(itemstack, itemstack1)
						&& ItemStack.areItemStackTagsEqual(itemstack, itemstack1)) {
					itemstack1.grow(itemstack.getCount());
					this.craftMatrix.setInventorySlotContents(i, itemstack1);
				} else if (!this.player.inventory.addItemStackToInventory(itemstack1)) {
					this.player.dropItem(itemstack1, false);
				}
			}
		}

		return stack;
	}

}
