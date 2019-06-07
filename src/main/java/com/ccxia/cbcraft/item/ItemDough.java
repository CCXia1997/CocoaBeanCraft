package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemDough extends Item {
	public ItemDough() {
		this.setUnlocalizedName(CbCraft.MODID + ".dough");
		this.setRegistryName("dough");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

}
