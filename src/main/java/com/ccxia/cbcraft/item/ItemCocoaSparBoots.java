package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.armor.ItemArmorCocoaSpar;

import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemCocoaSparBoots extends ItemArmorCocoaSpar {
	public ItemCocoaSparBoots() {
		super(EntityEquipmentSlot.FEET);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparBoots");
		this.setRegistryName("cocoa_spar_boots");
	}

}
