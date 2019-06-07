package com.ccxia.cbcraft.creativetab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabsCbCraft extends CreativeTabs {
	public static CreativeTabsCbCraft tabCbCraft = new CreativeTabsCbCraft();

	public CreativeTabsCbCraft() {
		super("cbcraft");
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(Item.getItemById(351), 1, 3);
	}

}
