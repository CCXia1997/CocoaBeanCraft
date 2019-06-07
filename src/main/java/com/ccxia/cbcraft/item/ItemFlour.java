package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemFlour extends Item {
	public ItemFlour() {
		this.setUnlocalizedName(CbCraft.MODID + ".flour");
		this.setRegistryName("flour");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

}
