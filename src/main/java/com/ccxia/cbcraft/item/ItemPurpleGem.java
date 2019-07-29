package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import net.minecraft.item.Item;

public class ItemPurpleGem extends Item {
	public ItemPurpleGem() {
		this.setUnlocalizedName(CbCraft.MODID + ".purpleGem");
		this.setRegistryName("purple_gem");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

}
