package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaLiquor extends Item {
	public ItemCocoaLiquor() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaLiquor");
		this.setRegistryName("cocoa_liquor");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
