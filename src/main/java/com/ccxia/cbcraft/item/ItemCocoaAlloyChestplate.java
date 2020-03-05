package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaAlloy;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaAlloyChestplate extends ItemArmorCocoaAlloy {
	public ItemCocoaAlloyChestplate() {
		super(EntityEquipmentSlot.CHEST);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloyChestplate");
		this.setRegistryName("cocoa_alloy_chestplate");
	}

}
