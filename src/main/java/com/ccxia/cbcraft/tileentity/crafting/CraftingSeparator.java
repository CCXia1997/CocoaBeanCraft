package com.ccxia.cbcraft.tileentity.crafting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ccxia.cbcraft.item.ModItems;
import com.google.common.collect.Maps;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingSeparator {
	private static final CraftingSeparator SMELTING_BASE = new CraftingSeparator();
	private final Map<ItemStack, List<ItemStack>> smeltingList = Maps.<ItemStack, List<ItemStack>>newHashMap();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

	public CraftingSeparator() {
		// ¿É¿ÉÒº¿é->¿É¿ÉÖ¬+¿É¿É·Û
		this.add(new ItemStack(ModItems.COCOA_LIQUOR), new ItemStack(ModItems.COCOA_BUTTER),
				new ItemStack(ModItems.COCOA_POWDER), 0.5F);
		// ÑÒ½¬¸à->Õ³ÒºÇò+ÁÒÑæ·Û
		this.add(new ItemStack(Items.MAGMA_CREAM), new ItemStack(Items.SLIME_BALL), new ItemStack(Items.BLAZE_POWDER),
				0.5F);
		// Å£ÄÌ->ÄÌÓÍ+ÍÑÖ¬ÄÌ
		this.add(new ItemStack(Items.MILK_BUCKET), new ItemStack(ModItems.CREAM), new ItemStack(ModItems.SKIM_MILK),
				0.5F);
	}

	private void add(ItemStack item1, ItemStack item2, ItemStack item3, float experience) {
		List<ItemStack> smeltItems = new ArrayList<ItemStack>();
		smeltItems.add(item2);
		smeltItems.add(item3);
		smeltingList.put(item1, smeltItems);
		experienceList.put(item1, Float.valueOf(experience));
	}

	public Map<ItemStack, List<ItemStack>> getRecipes() {
		return this.smeltingList;
	}

	public List<ItemStack> getSmeltItems(ItemStack itemStack) {
		for (Entry<ItemStack, List<ItemStack>> entry : this.smeltingList.entrySet()) {
			if (itemStack.isItemEqual(entry.getKey())) {
				return entry.getValue();
			}
		}
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(ItemStack.EMPTY);
		return list;
	}

	public static CraftingSeparator instance() {
		return SMELTING_BASE;
	}
}
