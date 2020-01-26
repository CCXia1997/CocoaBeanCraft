package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaMetal;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaMetalBoots extends ItemArmorCocoaMetal {
	public ItemCocoaMetalBoots() {
		super(EntityEquipmentSlot.FEET);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaMetalBoots");
		this.setRegistryName("cocoa_metal_boots");
	}

}
