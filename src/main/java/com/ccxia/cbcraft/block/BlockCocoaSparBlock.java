package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCocoaSparBlock extends Block {
	public BlockCocoaSparBlock() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparBlock");
		this.setRegistryName("cocoa_spar_block");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
	}
}
