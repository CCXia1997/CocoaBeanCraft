package com.ccxia.cbcraft.tileentity.crafting;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingAutoPressing {
	private static final CraftingAutoPressing PRESS_BASE = new CraftingAutoPressing();
	private final Map<ItemStack, ItemStack> pressList = Maps.<ItemStack, ItemStack>newHashMap();

	public CraftingAutoPressing() {
		// 4Ñ©Çò->1Ñ©
		this.add(new ItemStack(Items.SNOWBALL, 4), new ItemStack(Item.getItemFromBlock(Blocks.SNOW)));
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
