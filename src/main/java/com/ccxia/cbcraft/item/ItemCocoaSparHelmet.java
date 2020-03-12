package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaSpar;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaSparHelmet extends ItemArmorCocoaSpar {
	public ItemCocoaSparHelmet() {
		super(EntityEquipmentSlot.HEAD);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparHelmet");
		this.setRegistryName("cocoa_spar_helmet");
	}

}
