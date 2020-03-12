package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaSpar;

import net.minecraft.item.ItemHoe;

public class ItemCocoaSparHoe extends ItemHoe {
	public ItemCocoaSparHoe() {
		super(ItemToolCocoaSpar.COCOA_SPAR);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparHoe");
		this.setRegistryName("cocoa_spar_hoe");
	}

}
