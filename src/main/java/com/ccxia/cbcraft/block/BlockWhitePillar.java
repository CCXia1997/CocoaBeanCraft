package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWhitePillar extends BlockRotatedPillar {
	public BlockWhitePillar() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".whiteChocolateBlockPillar");
		this.setRegistryName("white_chocolate_block_pillar");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}
}
