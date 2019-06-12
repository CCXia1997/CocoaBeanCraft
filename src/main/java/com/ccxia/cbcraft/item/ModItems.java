package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.item.Item;

public class ModItems {
	public static final Item FLOUR;// 面粉
	public static final Item DOUGH;// 面团
	public static final Item EGG_MILK_DOUGH;// 蛋奶面团
	public static final Item COOKED_COCOA_BEANS;// 熟可可豆
	public static final Item COCOA_PASTE;
	static {
		FLOUR = ItemLoader.getByName("item." + CbCraft.MODID + ".flour");
		DOUGH = ItemLoader.getByName("item." + CbCraft.MODID + ".dough");
		EGG_MILK_DOUGH = ItemLoader.getByName("item." + CbCraft.MODID + ".eggMilkDough");
		COOKED_COCOA_BEANS = ItemLoader.getByName("item." + CbCraft.MODID + ".cookedCocoaBeans");
		COCOA_PASTE = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaPaste");
	}

}
