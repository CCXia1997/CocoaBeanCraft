package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.item.Item;

public class ModItems {
	public static final Item FLOUR;// 面粉
	public static final Item DOUGH;// 面团
	public static final Item EGG_MILK_DOUGH;// 蛋奶面团
	public static final Item COOKED_COCOA_BEANS;// 熟可可豆
	public static final Item COCOA_PASTE;// 可可膏
	public static final Item SKIM_MILK;// 脱脂奶
	public static final Item CHEESE;// 奶酪
	public static final Item YOGURT;// 酸奶
	public static final Item COCOA_BREAD;// 可可面包
	public static final Item CAKE_BASE;// 蛋糕基底
	public static final Item COCOA_CAKE_BASE;// 可可蛋糕基底
	public static final Item COOKIE_DOUGH;// 曲奇面团
	public static final Item COCOA_POWDER;// 可可粉
	public static final Item COCOA_LIQUOR;// 可可液块
	public static final Item COCOA_BUTTER;// 可可脂
	public static final Item CREAM;// 奶油
	public static final Item DARK_CHOCOLATE;// 黑巧克力
	public static final Item MILK_CHOCOLATE;// 棕巧克力
	public static final Item WHITE_CHOCOLATE;// 白巧克力
	public static final Item COCOA_CREAM;// 可可奶油
	public static final Item HOT_CHOCOLATE;// 巧克力牛奶
	public static final Item PACKED_MILK;// 盒装牛奶
	static {
		FLOUR = ItemLoader.getByName("item." + CbCraft.MODID + ".flour");
		DOUGH = ItemLoader.getByName("item." + CbCraft.MODID + ".dough");
		EGG_MILK_DOUGH = ItemLoader.getByName("item." + CbCraft.MODID + ".eggMilkDough");
		COOKED_COCOA_BEANS = ItemLoader.getByName("item." + CbCraft.MODID + ".cookedCocoaBeans");
		COCOA_PASTE = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaPaste");
		SKIM_MILK = ItemLoader.getByName("item." + CbCraft.MODID + ".skimMilk");
		CHEESE = ItemLoader.getByName("item." + CbCraft.MODID + ".cheese");
		YOGURT = ItemLoader.getByName("item." + CbCraft.MODID + ".yogurt");
		COCOA_BREAD = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaBread");
		CAKE_BASE = ItemLoader.getByName("item." + CbCraft.MODID + ".cakeBase");
		COCOA_CAKE_BASE = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaCakeBase");
		COOKIE_DOUGH = ItemLoader.getByName("item." + CbCraft.MODID + ".cookieDough");
		COCOA_POWDER = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaPowder");
		COCOA_LIQUOR = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaLiquor");
		COCOA_BUTTER = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaButter");
		CREAM = ItemLoader.getByName("item." + CbCraft.MODID + ".cream");
		DARK_CHOCOLATE = ItemLoader.getByName("item." + CbCraft.MODID + ".darkChocolate");
		MILK_CHOCOLATE = ItemLoader.getByName("item." + CbCraft.MODID + ".milkChocolate");
		WHITE_CHOCOLATE = ItemLoader.getByName("item." + CbCraft.MODID + ".whiteChocolate");
		COCOA_CREAM = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaCream");
		HOT_CHOCOLATE = ItemLoader.getByName("item." + CbCraft.MODID + ".hotChocolate");
		PACKED_MILK = ItemLoader.getByName("item." + CbCraft.MODID + ".packedMilk");
	}

}
