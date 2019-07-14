package com.ccxia.cbcraft.tileentity.crafting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ccxia.cbcraft.item.ModItems;
import com.google.common.collect.Maps;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class CraftingFermentationBaker {
	private static final CraftingFermentationBaker SMELTING_BASE = new CraftingFermentationBaker();
	private final Map<List<ItemStack>, ItemStack> smeltingList = Maps.<List<ItemStack>, ItemStack>newHashMap();
	private final Map<List<ItemStack>, Float> experienceList = Maps.<List<ItemStack>, Float>newHashMap();

	public CraftingFermentationBaker() {
		// �ɿɶ�->��ɿɶ�
		this.add(new ItemStack(Items.DYE, 1, 3), new ItemStack(ModItems.COOKED_COCOA_BEANS), 0.5F);
		// ��֬��->����
		this.add(new ItemStack(ModItems.SKIM_MILK), new ItemStack(ModItems.CHEESE), 0.5F);
		// ţ��+��->����
		this.add(new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR), new ItemStack(ModItems.YOGURT), 0.5F);
		// ֩����+��->����֩����
		this.add(new ItemStack(Items.SPIDER_EYE), new ItemStack(Items.SUGAR), new ItemStack(Items.FERMENTED_SPIDER_EYE),
				0.5F);
		// ��Ģ��->��Ģ����
		this.add(new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM)),
				new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM_BLOCK)), 0.5F);
		// ��Ģ��->��Ģ����
		this.add(new ItemStack(Item.getItemFromBlock(Blocks.RED_MUSHROOM)),
				new ItemStack(Item.getItemFromBlock(Blocks.RED_MUSHROOM_BLOCK)), 0.5F);
		// ������->�������
		this.add(new ItemStack(Items.NETHER_WART), new ItemStack(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK)),
				0.5F);
		// ����->���
		this.add(new ItemStack(ModItems.DOUGH), new ItemStack(Items.BREAD), 0.5F);
		// ����+�ɿɷ�->�ɿ����
		this.add(new ItemStack(ModItems.DOUGH), new ItemStack(ModItems.COCOA_POWDER),
				new ItemStack(ModItems.COCOA_BREAD), 0.5F);
		// ��������->�������
		this.add(new ItemStack(ModItems.EGG_MILK_DOUGH), new ItemStack(ModItems.CAKE_BASE), 0.5F);
		// ��������+�ɿɷ�->�ɿɵ������
		this.add(new ItemStack(ModItems.EGG_MILK_DOUGH), new ItemStack(ModItems.COCOA_POWDER),
				new ItemStack(ModItems.COCOA_CAKE_BASE), 0.5F);
		// ��������->8�����
		this.add(new ItemStack(ModItems.COOKIE_DOUGH), new ItemStack(Items.COOKIE, 8), 0.5F);
	}

	private void add(ItemStack item1, ItemStack itemStack, float experience) {
		List<ItemStack> cookItems = new ArrayList<ItemStack>();
		cookItems.add(item1);
		smeltingList.put(cookItems, itemStack);
		experienceList.put(cookItems, Float.valueOf(experience));
	}

	private void add(ItemStack item1, ItemStack item2, ItemStack itemStack, float experience) {
		List<ItemStack> cookItems = new ArrayList<ItemStack>();
		cookItems.add(item1);
		cookItems.add(item2);
		smeltingList.put(cookItems, itemStack);
		experienceList.put(cookItems, Float.valueOf(experience));
	}

	public Map<List<ItemStack>, ItemStack> getRecipes() {
		return this.smeltingList;
	}

	// �����������Ʒջ�������Map���ҵ���Ӧ��Key������Value�����û�ҵ����ؿ�
	public ItemStack getSmeltItems(List<ItemStack> items) {
		for (Entry<List<ItemStack>, ItemStack> entry : this.smeltingList.entrySet()) {
			List<ItemStack> items1 = entry.getKey();
			if (items.size() != items1.size()) {
				continue;
			} else if (items.size() == 2 && items1.size() == 2) {
				if (items.get(0).isItemEqual(items1.get(0)) && items.get(1).isItemEqual(items1.get(1))) {
					return entry.getValue();
				}
			} else if (items.size() == 1 && items1.size() == 1) {
				if (items.get(0).isItemEqual(items1.get(0))) {
					return entry.getValue();
				}
			}
		}
		return ItemStack.EMPTY;
	}

	public static CraftingFermentationBaker instance() {
		return SMELTING_BASE;
	}
}
