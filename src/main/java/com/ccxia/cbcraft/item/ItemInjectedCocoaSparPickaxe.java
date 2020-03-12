package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolInjectedSpar;

import net.minecraft.item.ItemPickaxe;

public class ItemInjectedCocoaSparPickaxe extends ItemPickaxe {
	public ItemInjectedCocoaSparPickaxe() {
		super(ItemToolInjectedSpar.INJECTED_COCOA_SPAR);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".injectedCocoaSparPickaxe");
		this.setRegistryName("injected_cocoa_spar_pickaxe");
	}

}
