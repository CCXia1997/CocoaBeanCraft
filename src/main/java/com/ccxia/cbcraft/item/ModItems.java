package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.item.Item;

public class ModItems {
	public static final Item FLOUR;// 面粉
	public static final Item DOUGH;// 面团
	public static final Item EGG_MILK_DOUGH;// 蛋奶面团
	static {
		FLOUR = ItemLoader.getByName("item." + CbCraft.MODID + ".flour");
		DOUGH = ItemLoader.getByName("item." + CbCraft.MODID + ".dough");
		EGG_MILK_DOUGH = ItemLoader.getByName("item." + CbCraft.MODID + ".eggMilkDough");
	}

}
