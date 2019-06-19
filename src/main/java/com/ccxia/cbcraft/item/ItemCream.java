package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCream extends Item {
	public ItemCream() {
		this.setUnlocalizedName(CbCraft.MODID + ".cream");
		this.setRegistryName("cream");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
