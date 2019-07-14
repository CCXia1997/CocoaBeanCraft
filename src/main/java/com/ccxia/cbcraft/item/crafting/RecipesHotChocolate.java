package com.ccxia.cbcraft.item.crafting;

import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

public class RecipesHotChocolate extends Impl<IRecipe> implements IRecipe {
	public RecipesHotChocolate() {
		this.setRegistryName("recipes_hot_chocolate");
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		int num1 = 0, num2 = 0, num3 = 0;
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack itemStack = inv.getStackInSlot(i);
			if (itemStack.isItemEqual(new ItemStack(Items.MILK_BUCKET))) {
				num1++;
			} else if (itemStack.isItemEqual(new ItemStack(ModItems.COCOA_POWDER))) {
				num2++;
			} else if (itemStack.isEmpty()) {
				num3++;
			}
		}
		if (num1 == 1 && num2 == 1 & num3 == 7) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return new ItemStack(ModItems.HOT_CHOCOLATE);
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
		return nonnulllist;
	}
}
