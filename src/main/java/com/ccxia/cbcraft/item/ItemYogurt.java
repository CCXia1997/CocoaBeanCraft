package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemYogurt extends Item {
	public ItemYogurt() {
		this.setUnlocalizedName(CbCraft.MODID + ".yogurt");
		this.setRegistryName("yogurt");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
