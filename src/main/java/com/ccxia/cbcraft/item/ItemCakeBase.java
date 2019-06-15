package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCakeBase extends Item {
	public ItemCakeBase() {
		this.setUnlocalizedName(CbCraft.MODID + ".cakeBase");
		this.setRegistryName("cake_base");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
