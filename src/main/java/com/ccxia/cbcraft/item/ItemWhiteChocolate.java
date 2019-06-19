package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.ItemFood;

public class ItemWhiteChocolate extends ItemFood {
	public ItemWhiteChocolate() {
		super(6, 0.8F, false);
		this.setUnlocalizedName(CbCraft.MODID + ".whiteChocolate");
		this.setRegistryName("white_chocolate");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
