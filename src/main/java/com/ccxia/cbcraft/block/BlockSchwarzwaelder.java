package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSchwarzwaelder extends Block {
	public BlockSchwarzwaelder() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".schwarzwaelderBlock");
		this.setRegistryName("schwarzwaelder_block");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
	}

}
