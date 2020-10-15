package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCocoaStone extends Block {
	public BlockCocoaStone() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaStone");
		this.setRegistryName("cocoa_stone");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
	}

}
