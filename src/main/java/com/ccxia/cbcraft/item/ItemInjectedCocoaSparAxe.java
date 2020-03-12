package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolInjectedSpar;

import net.minecraft.item.ItemAxe;

public class ItemInjectedCocoaSparAxe extends ItemAxe {
	public ItemInjectedCocoaSparAxe() {
		super(ItemToolInjectedSpar.INJECTED_COCOA_SPAR, 8.0F, -3.0F);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".injectedCocoaSparAxe");
		this.setRegistryName("injected_cocoa_spar_axe");
	}

}
