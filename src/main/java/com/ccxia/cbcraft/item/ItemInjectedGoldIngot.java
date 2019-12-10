package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemInjectedGoldIngot extends Item {
	public ItemInjectedGoldIngot() {
		this.setUnlocalizedName(CbCraft.MODID + ".injectedGoldIngot");
		this.setRegistryName("injected_gold_ingot");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
