package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.item.Item;

public class ModItems {
	public static final Item FLOUR;// ���
	public static final Item DOUGH;// ����
	public static final Item EGG_MILK_DOUGH;// ��������
	public static final Item COOKED_COCOA_BEANS;// ��ɿɶ�
	public static final Item COCOA_PASTE;// �ɿɸ�
	public static final Item SKIM_MILK;// ��֬��
	public static final Item CHEESE;// ����
	public static final Item YOGURT;// ����
	public static final Item COCOA_BREAD;// �ɿ����
	public static final Item CAKE_BASE;// �������
	public static final Item COCOA_CAKE_BASE;// �ɿɵ������
	public static final Item COOKIE_DOUGH;// ��������
	public static final Item COCOA_POWDER;// �ɿɷ�
	public static final Item COCOA_LIQUOR;// �ɿ�Һ��
	public static final Item COCOA_BUTTER;// �ɿ�֬
	public static final Item CREAM;// ����
	public static final Item DARK_CHOCOLATE;// ���ɿ���
	public static final Item MILK_CHOCOLATE;// ���ɿ���
	public static final Item WHITE_CHOCOLATE;// ���ɿ���
	public static final Item COCOA_CREAM;// �ɿ�����
	public static final Item HOT_CHOCOLATE;// �ɿ���ţ��
	public static final Item PACKED_MILK;// ��װţ��
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
