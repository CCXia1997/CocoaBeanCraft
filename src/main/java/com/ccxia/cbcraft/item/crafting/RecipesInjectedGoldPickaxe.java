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

public class RecipesInjectedGoldPickaxe extends Impl<IRecipe> implements IRecipe {

	private List<ItemStack> recipes = new ArrayList<ItemStack>();

	public RecipesInjectedGoldPickaxe() {
		this.setRegistryName("recipes_injected_gold_pickaxe");
		recipes.add(new ItemStack(ModItems.INJECTED_GOLD_INGOT));
		recipes.add(new ItemStack(ModItems.INJECTED_GOLD_INGOT));
		recipes.add(new ItemStack(ModItems.INJECTED_GOLD_INGOT));
		recipes.add(ItemStack.EMPTY);
		recipes.add(new ItemStack(Items.STICK));
		recipes.add(ItemStack.EMPTY);
		recipes.add(ItemStack.EMPTY);
		recipes.add(new ItemStack(Items.STICK));
		recipes.add(ItemStack.EMPTY);
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
		ItemStack pickaxe = new ItemStack(Items.GOLDEN_PICKAXE);
		// 时运4+效率5+耐久5+精修
		pickaxe.addEnchantment(Enchantments.FORTUNE, 4);
		pickaxe.addEnchantment(Enchantments.EFFICIENCY, 5);
		pickaxe.addEnchantment(Enchantments.UNBREAKING, 5);
		pickaxe.addEnchantment(Enchantments.MENDING, 1);
		return pickaxe;
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
