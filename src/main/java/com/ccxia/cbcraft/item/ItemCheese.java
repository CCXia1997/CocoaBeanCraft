package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemCheese extends ItemFood {
	public ItemCheese() {
		super(4, 0.75F, false);
		this.setUnlocalizedName(CbCraft.MODID + ".cheese");
		this.setRegistryName("cheese");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
