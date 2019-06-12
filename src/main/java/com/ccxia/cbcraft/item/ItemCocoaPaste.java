package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaPaste extends Item {
	public ItemCocoaPaste() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaPaste");
		this.setRegistryName("cocoa_paste");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

}
