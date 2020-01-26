package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaMetal;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaMetalChestplate extends ItemArmorCocoaMetal {
	public ItemCocoaMetalChestplate() {
		super(EntityEquipmentSlot.CHEST);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaMetalChestplate");
		this.setRegistryName("cocoa_metal_chestplate");
	}
}
