package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorInjectedCocoaSpar;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemInjectedCocoaSparLeggings extends ItemArmorInjectedCocoaSpar {
	public ItemInjectedCocoaSparLeggings() {
		super(EntityEquipmentSlot.LEGS);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".injectedCocoaSparLeggings");
		this.setRegistryName("injected_cocoa_spar_leggings");
	}

}
