package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCocoaCakeBase extends Block {
	public BlockCocoaCakeBase() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaCakeBase");
		this.setRegistryName("cocoa_cake_base");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
	}
}
