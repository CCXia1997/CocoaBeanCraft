package com.ccxia.cbcraft.item.crafting;

import java.util.ArrayList;
import java.util.List;

import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

public class RecipesInjectedIronLeggings extends Impl<IRecipe> implements IRecipe {

	private List<ItemStack> recipes = new ArrayList<ItemStack>();

	public RecipesInjectedIronLeggings() {
		this.setRegistryName("recipes_injected_iron_leggings");
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(ItemStack.EMPTY);
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(ItemStack.EMPTY);
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (!inv.getStackInSlot(i).isItemEqual(recipes.get(i))
					&& !(inv.getStackInSlot(i).isEmpty() && recipes.get(i).isEmpty())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack leggings = new ItemStack(Items.IRON_LEGGINGS);
		// ±£»¤2+ÄÍ¾Ã2
		leggings.addEnchantment(Enchantments.PROTECTION, 2);
		leggings.addEnchantment(Enchantments.UNBREAKING, 2);
		return leggings;
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
