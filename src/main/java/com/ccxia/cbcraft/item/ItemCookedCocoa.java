package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;

public class ItemCookedCocoa extends Item {
	public ItemCookedCocoa() {
		this.setUnlocalizedName(CbCraft.MODID + ".cookedCocoaBeans");
		this.setRegistryName("cooked_cocoa_beans");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

}
