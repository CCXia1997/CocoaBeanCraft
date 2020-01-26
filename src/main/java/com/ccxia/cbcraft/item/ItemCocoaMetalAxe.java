package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class ItemCocoaMetalAxe extends ItemAxe {
	public ItemCocoaMetalAxe() {
		super(Item.ToolMaterial.IRON);
		this.setMaxDamage(Item.ToolMaterial.DIAMOND.getMaxUses());
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaMetalAxe");
		this.setRegistryName("cocoa_metal_axe");
	}

}
