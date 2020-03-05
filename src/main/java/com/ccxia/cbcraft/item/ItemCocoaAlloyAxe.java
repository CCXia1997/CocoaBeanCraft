package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaAlloy;

import net.minecraft.item.ItemAxe;

public class ItemCocoaAlloyAxe extends ItemAxe {
	public ItemCocoaAlloyAxe() {
		super(ItemToolCocoaAlloy.COCOA_ALLOY, 8.0F, -3.1F);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloyAxe");
		this.setRegistryName("cocoa_alloy_axe");
	}

}
