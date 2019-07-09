package com.ccxia.cbcraft.item.crafting;

import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

public class RecipesWhiteChocolate extends Impl<IRecipe> implements IRecipe {
	private int milkSlot;

	public RecipesWhiteChocolate() {
		this.setRegistryName("recipes_white_chocolate_block");
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		int num1 = 0, num2 = 0, num3 = 0, num4 = 0;
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack itemStack = inv.getStackInSlot(i);
			if (itemStack.isItemEqual(new ItemStack(ModItems.COCOA_BUTTER))) {
				num1++;
			} else if (itemStack.isItemEqual(new ItemStack(Items.SUGAR))) {
				num2++;
			} else if (itemStack.isItemEqual(new ItemStack(Items.MILK_BUCKET))) {
				num3++;
				this.milkSlot = i;
			} else if (itemStack.isEmpty()) {
				num4++;
			}
		}
		if (num1 == 1 && num2 == 1 && num3 == 1 && num4 == 6) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return new ItemStack(ModItems.WHITE_CHOCOLATE);
	}

	@Override
	public boolean canFit(int width, int height) {
		return width * height >= 9;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
		NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);
		nonnulllist.set(this.milkSlot, new ItemStack(Items.BUCKET));
		return nonnulllist;
	}

}
