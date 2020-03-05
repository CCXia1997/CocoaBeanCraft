package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaAlloy;

import net.minecraft.item.ItemHoe;

public class ItemCocoaAlloyHoe extends ItemHoe {
	public ItemCocoaAlloyHoe() {
		super(ItemToolCocoaAlloy.COCOA_ALLOY);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloyHoe");
		this.setRegistryName("cocoa_alloy_hoe");
	}

}
