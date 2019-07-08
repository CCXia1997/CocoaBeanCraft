package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWhiteCarved extends Block {
	public BlockWhiteCarved() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".whiteChocolateBlockCarved");
		this.setRegistryName("white_chocolate_block_carved");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
	}
}
