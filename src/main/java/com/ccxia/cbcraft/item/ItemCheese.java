package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCheese extends Item {
	public ItemCheese() {
		this.setUnlocalizedName(CbCraft.MODID + ".cheese");
		this.setRegistryName("cheese");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
