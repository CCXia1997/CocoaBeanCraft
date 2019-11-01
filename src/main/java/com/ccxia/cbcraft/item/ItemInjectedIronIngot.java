package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemInjectedIronIngot extends Item {
	public ItemInjectedIronIngot() {
		this.setUnlocalizedName(CbCraft.MODID + ".injectedIronIngot");
		this.setRegistryName("injected_iron_ingot");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
