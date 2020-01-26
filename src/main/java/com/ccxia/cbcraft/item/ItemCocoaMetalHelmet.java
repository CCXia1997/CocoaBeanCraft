package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaMetal;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ItemCocoaMetalHelmet extends ItemArmorCocoaMetal {
	public ItemCocoaMetalHelmet() {
		super(EntityEquipmentSlot.HEAD);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaMetalHelmet");
		this.setRegistryName("cocoa_metal_helmet");
	}

}
