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
	}

}
