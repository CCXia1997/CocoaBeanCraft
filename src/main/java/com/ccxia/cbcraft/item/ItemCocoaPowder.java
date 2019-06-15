package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaPowder extends Item {
	public ItemCocoaPowder() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaPowder");
		this.setRegistryName("cocoa_powder");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
