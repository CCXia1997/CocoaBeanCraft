package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaSpar;

import net.minecraft.item.ItemSpade;

public class ItemCocoaSparShovel extends ItemSpade {
	public ItemCocoaSparShovel() {
		super(ItemToolCocoaSpar.COCOA_SPAR);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparShovel");
		this.setRegistryName("cocoa_spar_shovel");
	}

}
