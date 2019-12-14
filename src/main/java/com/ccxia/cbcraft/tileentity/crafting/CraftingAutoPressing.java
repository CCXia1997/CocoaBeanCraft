package com.ccxia.cbcraft.tileentity.crafting;

import java.util.Map;
import java.util.Map.Entry;

import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.item.ModItems;
import com.google.common.collect.Maps;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingAutoPressing {
	private static final CraftingAutoPressing PRESS_BASE = new CraftingAutoPressing();
	private final Map<ItemStack, ItemStack> pressList = Maps.<ItemStack, ItemStack>newHashMap();

	public CraftingAutoPressing() {
		// 4Ñ©Çò->1Ñ©
		this.add(new ItemStack(Items.SNOWBALL, 4), new ItemStack(Item.getItemFromBlock(Blocks.SNOW)));
		// 9Ìú¶§->1Ìú¿é
		this.add(new ItemStack(Items.IRON_INGOT, 9), new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK)));
		// 9½ð¶§->1½ð¿é
		this.add(new ItemStack(Items.GOLD_INGOT, 9), new ItemStack(Item.getItemFromBlock(Blocks.GOLD_BLOCK)));
		// 9ÃºÌ¿->1ÃºÌ¿¿é
		this.add(new ItemStack(Items.COAL, 9), new ItemStack(Item.getItemFromBlock(Blocks.COAL_BLOCK)));
		// 9ºìÊ¯->1ºìÊ¯¿é
		this.add(new ItemStack(Items.REDSTONE, 9), new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_BLOCK)));
		// 9Çà¾§Ê¯->1Çà¾§Ê¯¿é
		this.add(new ItemStack(Items.DYE, 9, EnumDyeColor.BLUE.getDyeDamage()),
				new ItemStack(Item.getItemFromBlock(Blocks.LAPIS_BLOCK)));
		// 9ÂÌ±¦Ê¯->1ÂÌ±¦Ê¯¿é
		this.add(new ItemStack(Items.EMERALD, 9), new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK)));
		// 9×êÊ¯->1×êÊ¯¿é
		this.add(new ItemStack(Items.DIAMOND, 9), new ItemStack(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK)));
		// 9Õ³ÒºÇò->1Õ³Òº¿é
		this.add(new ItemStack(Items.SLIME_BALL, 9), new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK)));
		// 4ºÚÇÉ¿ËÁ¦->4ºÚÇÉ¿ËÁ¦¿é
		this.add(new ItemStack(ModItems.DARK_CHOCOLATE, 4),
				new ItemStack(Item.getItemFromBlock(ModBlocks.DARK_CHOCOLATE_BLOCK), 4));
		// 4×ØÇÉ¿ËÁ¦->4×ØÇÉ¿ËÁ¦¿é
		this.add(new ItemStack(ModItems.MILK_CHOCOLATE, 4),
				new ItemStack(Item.getItemFromBlock(ModBlocks.MILK_CHOCOLATE_BLOCK), 4));
		// 4°×ÇÉ¿ËÁ¦->4°×ÇÉ¿ËÁ¦¿é
		this.add(new ItemStack(ModItems.WHITE_CHOCOLATE, 4),
				new ItemStack(Item.getItemFromBlock(ModBlocks.WHITE_CHOCOLATE_BLOCK), 4));
	}

	private void add(ItemStack item1, ItemStack item2) {
		pressList.put(item1, item2);
	}

	public ResultPack getResult(ItemStack itemStack) {
		for (Entry<ItemStack, ItemStack> entry : this.pressList.entrySet()) {
			if (itemStack.isItemEqual(entry.getKey()) && itemStack.getCount() >= entry.getKey().getCount()) {
				ResultPack result = new ResultPack();
				result.itemCost = entry.getKey().getCount();
				result.resultItem = entry.getValue();
				return result;
			}
		}
		ResultPack result = new ResultPack();
		result.resultItem = ItemStack.EMPTY;
		return result;
	}

	public static CraftingAutoPressing instance() {
		return PRESS_BASE;
	}

	public class ResultPack {
		public int itemCost;
		public ItemStack resultItem;
	}
}
