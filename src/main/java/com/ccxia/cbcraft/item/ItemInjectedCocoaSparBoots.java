package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorInjectedCocoaSpar;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemInjectedCocoaSparBoots extends ItemArmorInjectedCocoaSpar {
	public ItemInjectedCocoaSparBoots() {
		super(EntityEquipmentSlot.FEET);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".injectedCocoaSparBoots");
		this.setRegistryName("injected_cocoa_spar_boots");
	}

}
