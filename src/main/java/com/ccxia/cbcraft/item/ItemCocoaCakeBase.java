package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaCakeBase extends Item {
	public ItemCocoaCakeBase() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaCakeBase");
		this.setRegistryName("cocoa_cake_base");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
