package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolInjectedSpar;

import net.minecraft.item.ItemHoe;

public class ItemInjectedCocoaSparHoe extends ItemHoe {
	public ItemInjectedCocoaSparHoe() {
		super(ItemToolInjectedSpar.INJECTED_COCOA_SPAR);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".injectedCocoaSparHoe");
		this.setRegistryName("injected_cocoa_spar_hoe");
	}

}
