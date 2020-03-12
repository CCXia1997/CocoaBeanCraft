package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorInjectedCocoaSpar;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemInjectedCocoaSparChestplate extends ItemArmorInjectedCocoaSpar {
	public ItemInjectedCocoaSparChestplate() {
		super(EntityEquipmentSlot.CHEST);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".injectedCocoaSparChestplate");
		this.setRegistryName("injected_cocoa_spar_chestplate");
	}

}
