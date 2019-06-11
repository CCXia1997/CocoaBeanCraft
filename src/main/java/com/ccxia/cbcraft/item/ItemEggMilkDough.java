package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemEggMilkDough extends Item {
	public ItemEggMilkDough() {
		this.setUnlocalizedName(CbCraft.MODID + ".eggMilkDough");
		this.setRegistryName("egg_milk_dough");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
