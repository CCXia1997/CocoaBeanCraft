package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaAllovIngot extends Item {
	public ItemCocoaAllovIngot() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloyIngot");
		this.setRegistryName("cocoa_alloy_ingot");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

}
