package com.ccxia.cbcraft.item.crafting;

import java.util.ArrayList;

import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;
import scala.actors.threadpool.Arrays;

public class RecipesEggMilkDough extends Impl<IRecipe> implements IRecipe {
	private Item[] eggMilkDough = { Items.EGG, ModItems.FLOUR, Items.EGG, ModItems.FLOUR, Items.MILK_BUCKET,
			ModItems.FLOUR, Items.EGG, ModItems.FLOUR, Items.EGG };

	public RecipesEggMilkDough() {
		this.setRegistryName("recipes_egg_milk_dough");
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		ArrayList<Item> result = new ArrayList<Item>();
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			result.add(inv.getStackInSlot(i).getItem());
		}
		Item[] result_array = result.toArray(new Item[result.size()]);
		if (Arrays.equals(result_array, eggMilkDough))
			return true;
		else
			return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return new ItemStack(ModItems.EGG_MILK_DOUGH, 4);
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
		nonnulllist.set(4, new ItemStack(Items.BUCKET));
		return nonnulllist;
	}

}
