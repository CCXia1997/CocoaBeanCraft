package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaSpar;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaSparLeggings extends ItemArmorCocoaSpar {
	public ItemCocoaSparLeggings() {
		super(EntityEquipmentSlot.LEGS);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparLeggings");
		this.setRegistryName("cocoa_spar_leggings");
	}

}
