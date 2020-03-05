package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaAlloy;

import net.minecraft.item.ItemPickaxe;

public class ItemCocoaAlloyPickaxe extends ItemPickaxe {
	public ItemCocoaAlloyPickaxe() {
		super(ItemToolCocoaAlloy.COCOA_ALLOY);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloyPickaxe");
		this.setRegistryName("cocoa_alloy_pickaxe");
	}

}
