package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaButter extends Item {
	public ItemCocoaButter() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaButter");
		this.setRegistryName("cocoa_butter");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
