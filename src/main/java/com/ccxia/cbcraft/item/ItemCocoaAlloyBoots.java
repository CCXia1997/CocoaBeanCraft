package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaAlloy;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaAlloyBoots extends ItemArmorCocoaAlloy {
	public ItemCocoaAlloyBoots() {
		super(EntityEquipmentSlot.FEET);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaAlloyBoots");
		this.setRegistryName("cocoa_alloy_boots");
	}

}
