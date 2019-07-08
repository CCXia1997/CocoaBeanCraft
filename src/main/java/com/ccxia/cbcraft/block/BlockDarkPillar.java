package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public class BlockDarkPillar extends BlockRotatedPillar {
	public BlockDarkPillar() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".darkChocolateBlockPillar");
		this.setRegistryName("dark_chocolate_block_pillar");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
	}
}
