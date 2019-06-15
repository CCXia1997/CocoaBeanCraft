package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCookieDough extends Item {
	public ItemCookieDough() {
		this.setUnlocalizedName(CbCraft.MODID + ".cookieDough");
		this.setRegistryName("cookie_dough");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
