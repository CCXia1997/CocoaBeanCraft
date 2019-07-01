package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWhiteDark extends Block {
	public BlockWhiteDark() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".whiteDarkChocolateBlock");
		this.setRegistryName("white_dark_chocolate_block");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
	}
}
