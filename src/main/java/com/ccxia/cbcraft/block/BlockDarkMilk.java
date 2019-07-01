package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockDarkMilk extends Block {
	public BlockDarkMilk() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".darkMilkChocolateBlock");
		this.setRegistryName("dark_milk_chocolate_block");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
	}
}
