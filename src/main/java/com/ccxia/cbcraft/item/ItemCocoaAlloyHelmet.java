package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaAlloy;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaAlloyHelmet extends ItemArmorCocoaAlloy {
	public ItemCocoaAlloyHelmet() {
		super(EntityEquipmentSlot.HEAD);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloyHelmet");
		this.setRegistryName("cocoa_alloy_helmet");
	}

}
