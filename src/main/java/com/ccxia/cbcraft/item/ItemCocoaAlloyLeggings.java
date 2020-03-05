package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaAlloy;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaAlloyLeggings extends ItemArmorCocoaAlloy {
	public ItemCocoaAlloyLeggings() {
		super(EntityEquipmentSlot.LEGS);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloyLeggings");
		this.setRegistryName("cocoa_alloy_leggings");
	}
}
