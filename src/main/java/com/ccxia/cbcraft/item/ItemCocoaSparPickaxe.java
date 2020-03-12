package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolCocoaSpar;

import net.minecraft.item.ItemPickaxe;

public class ItemCocoaSparPickaxe extends ItemPickaxe {
	public ItemCocoaSparPickaxe() {
		super(ItemToolCocoaSpar.COCOA_SPAR);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparPickaxe");
		this.setRegistryName("cocoa_spar_pickaxe");
	}

}
