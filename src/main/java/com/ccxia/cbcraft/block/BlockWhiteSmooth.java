package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWhiteSmooth extends Block {
	public BlockWhiteSmooth() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".whiteChocolateBlockSmooth");
		this.setRegistryName("white_chocolate_block_smooth");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}
}
