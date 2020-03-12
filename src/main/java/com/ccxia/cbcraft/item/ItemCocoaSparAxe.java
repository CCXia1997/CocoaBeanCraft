package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaSpar;

import net.minecraft.item.ItemAxe;

public class ItemCocoaSparAxe extends ItemAxe {
	public ItemCocoaSparAxe() {
		super(ItemToolCocoaSpar.COCOA_SPAR, 8.0F, -3.0F);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparAxe");
		this.setRegistryName("cocoa_spar_axe");
	}

}
