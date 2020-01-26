package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ItemCocoaMetalPickaxe extends ItemPickaxe {
	public ItemCocoaMetalPickaxe() {
		super(Item.ToolMaterial.IRON);
		this.setMaxDamage(Item.ToolMaterial.DIAMOND.getMaxUses());
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaMetalPickaxe");
		this.setRegistryName("cocoa_metal_pickaxe");
	}

}
