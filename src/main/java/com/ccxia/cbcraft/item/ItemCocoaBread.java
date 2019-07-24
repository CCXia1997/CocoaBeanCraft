package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemCocoaBread extends ItemFood {
	public ItemCocoaBread() {
		super(7, 0.572F, false);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaBread");
		this.setRegistryName("cocoa_bread");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
