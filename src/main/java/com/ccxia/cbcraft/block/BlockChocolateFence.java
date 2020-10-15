package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;

public class BlockChocolateFence extends BlockFence {
	public BlockChocolateFence(Block modelBlock) {
		super(modelBlock.getDefaultState().getMaterial(),
				modelBlock.getDefaultState().getMaterial().getMaterialMapColor());
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}
}
