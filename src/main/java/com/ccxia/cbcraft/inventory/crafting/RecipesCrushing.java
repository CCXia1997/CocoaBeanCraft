package com.ccxia.cbcraft.inventory.crafting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

public class RecipesCrushing extends Impl<IRecipe> implements IRecipe {
	// ÑÐÄ¥µÄºÏ³ÉÃûµ¥
	Map<ItemStack, ItemStack> workList = new HashMap<ItemStack, ItemStack>();
	public static final RecipesCrushing CRUSHING_MANAGER = new RecipesCrushing();

	public RecipesCrushing() {
		// 1Êì¿É¿É¶¹->1¿É¿É¸à
		workList.put(new ItemStack(ModItems.COOKED_COCOA_BEANS), new ItemStack(ModItems.COCOA_PASTE, 1));
		// 1É°Àù->1ìÝÊ¯
		workList.put(new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)), new ItemStack(Items.FLINT, 1));
		// 1µØÓüðà¿é->6µØÓüðà
		workList.put(new ItemStack(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK)),
				new ItemStack(Items.NETHER_WART, 6));
		// 1Ê¯Ó¢¿é->2Ê¯Ó¢
		workList.put(new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK)), new ItemStack(Items.QUARTZ, 2));
		// 1ð¤ÍÁ¿é->4ð¤ÍÁÇò
		workList.put(new ItemStack(Item.getItemFromBlock(Blocks.CLAY)), new ItemStack(Items.CLAY_BALL, 4));
		// 1Î÷¹Ï¿é->6Î÷¹Ï
		workList.put(new ItemStack(Item.getItemFromBlock(Blocks.MELON_BLOCK)), new ItemStack(Items.MELON, 6));
		// 1ÑÒ½¬¿é->2ÑÒ½¬¸à
		workList.put(new ItemStack(Item.getItemFromBlock(Blocks.MAGMA)), new ItemStack(Items.MAGMA_CREAM, 2));
		// 1ÁÒÑæ°ô->3ÁÒÑæ·Û
		workList.put(new ItemStack(Items.BLAZE_ROD), new ItemStack(Items.BLAZE_POWDER, 3));
		// 1¹ÇÍ·->4¹Ç·Û
		workList.put(new ItemStack(Items.BONE), new ItemStack(Items.DYE, 4, 15));
		// 1Ð¡Âó->1Ãæ·Û
		workList.put(new ItemStack(Items.WHEAT), new ItemStack(ModItems.FLOUR, 1));

	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		for (Entry<ItemStack, ItemStack> entry : this.workList.entrySet()) {
			if (inv.getStackInSlot(0).isItemEqual(entry.getKey())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		for (Entry<ItemStack, ItemStack> entry : this.workList.entrySet()) {
			if (inv.getStackInSlot(0).isItemEqual(entry.getKey())) {
				return entry.getValue();
			}
		}
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canFit(int width, int height) {
		return width * height >= 1;
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
