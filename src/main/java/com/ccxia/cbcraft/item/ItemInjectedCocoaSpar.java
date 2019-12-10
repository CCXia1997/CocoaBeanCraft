package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemInjectedCocoaSpar extends Item {
	public ItemInjectedCocoaSpar() {
		this.setUnlocalizedName(CbCraft.MODID + ".injectedCocoaSpar");
		this.setRegistryName("injected_cocoa_spar");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
