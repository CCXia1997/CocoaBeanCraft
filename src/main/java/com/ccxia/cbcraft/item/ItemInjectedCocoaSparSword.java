package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.tool.ItemToolInjectedSpar;

import net.minecraft.item.ItemSword;

public class ItemInjectedCocoaSparSword extends ItemSword {
	public ItemInjectedCocoaSparSword() {
		super(ItemToolInjectedSpar.INJECTED_COCOA_SPAR);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".injectedCocoaSparSword");
		this.setRegistryName("injected_cocoa_spar_sword");
	}

}
