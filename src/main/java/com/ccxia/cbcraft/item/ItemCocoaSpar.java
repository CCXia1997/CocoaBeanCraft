package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaSpar extends Item {
	public ItemCocoaSpar() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSpar");
		this.setRegistryName("cocoa_spar");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
