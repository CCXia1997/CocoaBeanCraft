package com.ccxia.cbcraft.item.crafting;

import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

import java.util.ArrayList;
import java.util.Arrays;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RecipesDough extends Impl<IRecipe> implements IRecipe {
	private String[] dough = { "item.cbcraft.flour", "item.cbcraft.flour", "item.cbcraft.flour", "item.cbcraft.flour",
			"item.bucketWater", "item.cbcraft.flour", "item.cbcraft.flour", "item.cbcraft.flour",
			"item.cbcraft.flour" };

	public RecipesDough() {
		this.setRegistryName("recipes_dough");
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			result.add(inv.getStackInSlot(i).getUnlocalizedName());
		}
		String[] craft_result = result.toArray(new String[result.size()]);
		if (Arrays.equals(craft_result, dough))
			return true;
		else
			return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return new ItemStack(Item.getByNameOrId(CbCraft.MODID + ":dough"), 8);
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
		nonnulllist.set(4, new ItemStack(Item.getItemById(325), 1));
		return nonnulllist;
	}

}
