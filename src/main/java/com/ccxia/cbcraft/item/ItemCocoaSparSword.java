package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaSpar;

import net.minecraft.item.ItemSword;

public class ItemCocoaSparSword extends ItemSword {
	public ItemCocoaSparSword() {
		super(ItemToolCocoaSpar.COCOA_SPAR);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparSword");
		this.setRegistryName("cocoa_spar_sword");
	}

}
