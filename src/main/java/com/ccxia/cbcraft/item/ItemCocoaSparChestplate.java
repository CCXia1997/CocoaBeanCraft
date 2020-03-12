package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaSpar;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaSparChestplate extends ItemArmorCocoaSpar {
	public ItemCocoaSparChestplate() {
		super(EntityEquipmentSlot.CHEST);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparChestplate");
		this.setRegistryName("cocoa_spar_chestplate");
	}

}
