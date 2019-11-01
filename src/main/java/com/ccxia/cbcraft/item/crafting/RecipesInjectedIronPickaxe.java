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

public class RecipesInjectedIronPickaxe extends Impl<IRecipe> implements IRecipe {

	private List<ItemStack> recipes = new ArrayList<ItemStack>();

	public RecipesInjectedIronPickaxe() {
		this.setRegistryName("recipes_injected_iron_pickaxe");
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
		recipes.add(new ItemStack(ModItems.INJECTED_IRON_INGOT));
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
		ItemStack pickaxe = new ItemStack(Items.IRON_PICKAXE);
		// 时运2+效率3+耐久2
		pickaxe.addEnchantment(Enchantments.FORTUNE, 2);
		pickaxe.addEnchantment(Enchantments.EFFICIENCY, 3);
		pickaxe.addEnchantment(Enchantments.UNBREAKING, 2);
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
