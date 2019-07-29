package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.item.Item;

public class ModItems {
	public static final Item FLOUR;// 闈㈢矇
	public static final Item DOUGH;// 闈㈠洟
	public static final Item EGG_MILK_DOUGH;// 铔嬪ザ闈㈠洟
	public static final Item COOKED_COCOA_BEANS;// 鐔熷彲鍙眴
	public static final Item COCOA_PASTE;// 鍙彲鑶�
	public static final Item SKIM_MILK;// 鑴辫剛濂�
	public static final Item CHEESE;// 濂堕叒
	public static final Item YOGURT;// 閰稿ザ
	public static final Item COCOA_BREAD;// 鍙彲闈㈠寘
	public static final Item CAKE_BASE;// 铔嬬硶鍩哄簳
	public static final Item COCOA_CAKE_BASE;// 鍙彲铔嬬硶鍩哄簳
	public static final Item COOKIE_DOUGH;// 鏇插闈㈠洟
	public static final Item COCOA_POWDER;// 鍙彲绮�
	public static final Item COCOA_LIQUOR;// 鍙彲娑插潡
	public static final Item COCOA_BUTTER;// 鍙彲鑴�
	public static final Item CREAM;// 濂舵补
	public static final Item DARK_CHOCOLATE;// 榛戝阀鍏嬪姏
	public static final Item MILK_CHOCOLATE;// 妫曞阀鍏嬪姏
	public static final Item WHITE_CHOCOLATE;// 鐧藉阀鍏嬪姏
	public static final Item COCOA_CREAM;// 鍙彲濂舵补
	public static final Item HOT_CHOCOLATE;// 鐑彲鍙�
	public static final Item PRESSING_MACHINE_CORE;// 鍘嬪悎鏈烘牳蹇�
	public static final Item PURPLE_GEM;// 绱疂鐭�
	public static final Item PACKED_MILK;// 鐩掕鐗涘ザ

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
		PRESSING_MACHINE_CORE = ItemLoader.getByName("item." + CbCraft.MODID + ".pressingMachineCore");
		PURPLE_GEM = ItemLoader.getByName("item." + CbCraft.MODID + ".purpleGem");
		PACKED_MILK = ItemLoader.getByName("item." + CbCraft.MODID + ".packedMilk");
	}

}
