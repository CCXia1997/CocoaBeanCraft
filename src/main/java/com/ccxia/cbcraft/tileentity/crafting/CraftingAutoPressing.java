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
		// 4ѩ��->1ѩ
		this.add(new ItemStack(Items.SNOWBALL, 4), new ItemStack(Item.getItemFromBlock(Blocks.SNOW)));
		// 9����->1����
		this.add(new ItemStack(Items.IRON_INGOT, 9), new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK)));
		// 9��->1���
		this.add(new ItemStack(Items.GOLD_INGOT, 9), new ItemStack(Item.getItemFromBlock(Blocks.GOLD_BLOCK)));
		// 9ú̿->1ú̿��
		this.add(new ItemStack(Items.COAL, 9), new ItemStack(Item.getItemFromBlock(Blocks.COAL_BLOCK)));
		// 9��ʯ->1��ʯ��
		this.add(new ItemStack(Items.REDSTONE, 9), new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_BLOCK)));
		// 9�ྦྷʯ->1�ྦྷʯ��
		this.add(new ItemStack(Items.DYE, 9, EnumDyeColor.BLUE.getDyeDamage()),
				new ItemStack(Item.getItemFromBlock(Blocks.LAPIS_BLOCK)));
		// 9�̱�ʯ->1�̱�ʯ��
		this.add(new ItemStack(Items.EMERALD, 9), new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK)));
		// 9��ʯ->1��ʯ��
		this.add(new ItemStack(Items.DIAMOND, 9), new ItemStack(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK)));
		// 9ճҺ��->1ճҺ��
		this.add(new ItemStack(Items.SLIME_BALL, 9), new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK)));
		// 4���ɿ���->4���ɿ�����
		this.add(new ItemStack(ModItems.DARK_CHOCOLATE, 4),
				new ItemStack(Item.getItemFromBlock(ModBlocks.DARK_CHOCOLATE_BLOCK), 4));
		// 4���ɿ���->4���ɿ�����
		this.add(new ItemStack(ModItems.MILK_CHOCOLATE, 4),
				new ItemStack(Item.getItemFromBlock(ModBlocks.MILK_CHOCOLATE_BLOCK), 4));
		// 4���ɿ���->4���ɿ�����
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
