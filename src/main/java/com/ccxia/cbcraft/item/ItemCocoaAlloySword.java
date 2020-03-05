package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaAlloy;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemCocoaAlloySword extends ItemSword {
	public ItemCocoaAlloySword() {
		super(ItemToolCocoaAlloy.COCOA_ALLOY);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloySword");
		this.setRegistryName("cocoa_alloy_sword");
	}

}
