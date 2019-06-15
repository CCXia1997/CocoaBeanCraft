package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemSkimMilk extends Item {
	public ItemSkimMilk() {
		this.setUnlocalizedName(CbCraft.MODID + ".skimMilk");
		this.setRegistryName("skim_milk");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
