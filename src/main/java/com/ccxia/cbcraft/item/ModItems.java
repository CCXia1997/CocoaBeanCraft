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
//	public static final Item CAKE_BASE;// 蛋糕基底
//	public static final Item COCOA_CAKE_BASE;// 可可蛋糕基底
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
	public static final Item PRESSING_MACHINE_CORE;// 压合机核心
	public static final Item PURPLE_GEM;// 紫宝石
	public static final Item PACKED_MILK;// 盒装牛奶
	public static final Item INJECTED_IRON_INGOT;// 注魔铁锭
	public static final Item COCOA_SPAR;// 可可晶石
	public static final Item INJECTED_GOLD_INGOT;// 注魔金锭
	public static final Item INJECTED_COCOA_SPAR;// 注魔可可晶石
	public static final Item COCOA_METAL_INGOT;// 可可金属锭
	public static final Item COCOA_ALLOV_INGOT;// 可可合金锭

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
//		CAKE_BASE = ItemLoader.getByName("item." + CbCraft.MODID + ".cakeBase");
//		COCOA_CAKE_BASE = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaCakeBase");
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
		PRESSING_MACHINE_CORE = ItemLoader.getByName("item." + CbCraft.MODID + ".pressingMachineCore");
		PURPLE_GEM = ItemLoader.getByName("item." + CbCraft.MODID + ".purpleGem");
		PACKED_MILK = ItemLoader.getByName("item." + CbCraft.MODID + ".packedMilk");
		INJECTED_IRON_INGOT = ItemLoader.getByName("item." + CbCraft.MODID + ".injectedIronIngot");
		COCOA_SPAR = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaSpar");
		INJECTED_GOLD_INGOT = ItemLoader.getByName("item." + CbCraft.MODID + ".injectedGoldIngot");
		INJECTED_COCOA_SPAR = ItemLoader.getByName("item." + CbCraft.MODID + ".injectedCocoaSpar");
		COCOA_METAL_INGOT = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaMetalIngot");
		COCOA_ALLOV_INGOT = ItemLoader.getByName("item." + CbCraft.MODID + ".cocoaAlloyIngot");
	}

}
