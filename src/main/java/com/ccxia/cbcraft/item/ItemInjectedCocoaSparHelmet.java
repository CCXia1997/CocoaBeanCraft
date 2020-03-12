package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorInjectedCocoaSpar;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemInjectedCocoaSparHelmet extends ItemArmorInjectedCocoaSpar {
	public ItemInjectedCocoaSparHelmet() {
		super(EntityEquipmentSlot.HEAD);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".injectedCocoaSparHelmet");
		this.setRegistryName("injected_cocoa_spar_helmet");
	}

}
