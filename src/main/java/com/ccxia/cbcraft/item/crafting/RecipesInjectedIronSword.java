package com.ccxia.cbcraft.item.crafting;

import java.util.ArrayList;
import java.util.List;

import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

public class RecipesInjectedIronSword extends Impl<IRecipe> implements IRecipe {

	private List<ItemStack> recipes = new ArrayList<ItemStack>();

	public RecipesInjectedIronSword() {
		this.setRegistryName("recipes_injected_iron_sword");
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(new ItemStack(Items.STICK));
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		int num = 0;
		List<ItemStack> actualRecipes = new ArrayList<ItemStack>();
		List<Integer> itemSlots = new ArrayList<Integer>();
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (inv.getStackInSlot(i).isEmpty()) {
				num++;
			} else {
				actualRecipes.add(inv.getStackInSlot(i));
				itemSlots.add(i);
			}
		}
		if (num == 6 && (itemSlots.get(1) - itemSlots.get(0) == 3) && (itemSlots.get(2) - itemSlots.get(1) == 3)) {
			for (int i = 0; i < actualRecipes.size(); i++) {
				if (!actualRecipes.get(i).isItemEqual(recipes.get(i))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack sword = new ItemStack(Items.IRON_SWORD);
		// ÇÀ¶á2+·æÀû3+ÄÍ¾Ã2
		sword.addEnchantment(Enchantments.SHARPNESS, 3);
		sword.addEnchantment(Enchantments.UNBREAKING, 2);
		sword.addEnchantment(Enchantments.LOOTING, 2);
		return sword;
	}

	@Override
	public boolean canFit(int width, int height) {
		return width * height >= 3;
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
