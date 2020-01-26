package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemCocoaMetalSword extends ItemSword {
	public ItemCocoaMetalSword() {
		// 耐久为钻石耐久，其余跟铁一样
		super(Item.ToolMaterial.IRON);
		this.setMaxDamage(Item.ToolMaterial.DIAMOND.getMaxUses());
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaMetalSword");
		this.setRegistryName("cocoa_metal_sword");
	}

}
