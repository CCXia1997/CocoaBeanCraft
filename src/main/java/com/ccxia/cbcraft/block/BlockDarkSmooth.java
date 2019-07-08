package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockDarkSmooth extends Block {
	public BlockDarkSmooth() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".darkChocolateBlockSmooth");
		this.setRegistryName("dark_chocolate_block_smooth");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
	}
}
