package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaAlloy;

import net.minecraft.item.ItemSpade;

public class ItemCocoaAlloyShovel extends ItemSpade {
	public ItemCocoaAlloyShovel() {
		super(ItemToolCocoaAlloy.COCOA_ALLOY);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloyShovel");
		this.setRegistryName("cocoa_alloy_shovel");
	}

}
