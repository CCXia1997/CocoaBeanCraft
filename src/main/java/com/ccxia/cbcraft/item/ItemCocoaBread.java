package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCocoaBread extends Item {
	public ItemCocoaBread() {
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaBread");
		this.setRegistryName("cocoa_bread");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
