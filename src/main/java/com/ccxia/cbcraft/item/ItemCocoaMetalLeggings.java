package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaMetal;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaMetalLeggings extends ItemArmorCocoaMetal {
	public ItemCocoaMetalLeggings() {
		super(EntityEquipmentSlot.LEGS);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaMetalLeggings");
		this.setRegistryName("cocoa_metal_leggings");
	}

}
