package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaCream extends Item {
	public ItemCocoaCream() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaCream");
		this.setRegistryName("cocoa_cream");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
