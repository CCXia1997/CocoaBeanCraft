package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockMilkSmooth extends Block {
	public BlockMilkSmooth() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".milkChocolateBlockSmooth");
		this.setRegistryName("milk_chocolate_block_smooth");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
	}
}
