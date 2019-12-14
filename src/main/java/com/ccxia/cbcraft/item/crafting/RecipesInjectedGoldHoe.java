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

public class RecipesInjectedGoldHoe extends Impl<IRecipe> implements IRecipe {

	private List<ItemStack> recipes1 = new ArrayList<ItemStack>();
	private List<ItemStack> recipes2 = new ArrayList<ItemStack>();

	public RecipesInjectedGoldHoe() {
		this.setRegistryName("recipes_injected_gold_hoe");
		// 1#
		recipes1.add(new ItemStack(ModItems.INJECTED_GOLD_INGOT));
		recipes1.add(new ItemStack(ModItems.INJECTED_GOLD_INGOT));
		recipes1.add(ItemStack.EMPTY);
		recipes1.add(ItemStack.EMPTY);
		recipes1.add(new ItemStack(Items.STICK));
		recipes1.add(ItemStack.EMPTY);
		recipes1.add(ItemStack.EMPTY);
		recipes1.add(new ItemStack(Items.STICK));
		recipes1.add(ItemStack.EMPTY);
		// 2#
		recipes2.add(ItemStack.EMPTY);
		recipes2.add(new ItemStack(ModItems.INJECTED_GOLD_INGOT));
		recipes2.add(new ItemStack(ModItems.INJECTED_GOLD_INGOT));
		recipes2.add(ItemStack.EMPTY);
		recipes2.add(ItemStack.EMPTY);
		recipes2.add(new ItemStack(Items.STICK));
		recipes2.add(ItemStack.EMPTY);
		recipes2.add(ItemStack.EMPTY);
		recipes2.add(new ItemStack(Items.STICK));
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		boolean flag = true;
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (!inv.getStackInSlot(i).isItemEqual(recipes1.get(i))
					&& !(inv.getStackInSlot(i).isEmpty() && recipes1.get(i).isEmpty())) {
				flag = false;
				break;
			}
		}
		if (flag) {
			return true;
		}
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (!inv.getStackInSlot(i).isItemEqual(recipes2.get(i))
					&& !(inv.getStackInSlot(i).isEmpty() && recipes2.get(i).isEmpty())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack hoe = new ItemStack(Items.GOLDEN_HOE);
		// ÄÍ¾Ã5+¾«ÐÞ
		hoe.addEnchantment(Enchantments.UNBREAKING, 5);
		hoe.addEnchantment(Enchantments.MENDING, 1);
		return hoe;
	}

	@Override
	public boolean canFit(int width, int height) {
		return width * height >= 6;
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
