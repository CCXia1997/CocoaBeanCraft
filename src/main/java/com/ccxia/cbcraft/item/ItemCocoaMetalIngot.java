package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaMetalIngot extends Item {
	public ItemCocoaMetalIngot() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaMetalIngot");
		this.setRegistryName("cocoa_metal_ingot");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

}
