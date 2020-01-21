package com.ccxia.cbcraft.world.gen;

import com.ccxia.cbcraft.block.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;

public class MapGenCocoaCaves extends MapGenCaves {
	@Override
	protected boolean canReplaceBlock(IBlockState p_175793_1_, IBlockState p_175793_2_) {
		if (p_175793_1_.getBlock() == ModBlocks.COCOA_STONE || p_175793_1_.getBlock() == ModBlocks.COCOA_CAKE_BASE
				|| p_175793_1_.getBlock() == ModBlocks.TIRAMISU_BLOCK || p_175793_1_.getBlock() == ModBlocks.OPERA_BLOCK
				|| p_175793_1_.getBlock() == ModBlocks.BROWNIE_BLOCK
				|| p_175793_1_.getBlock() == ModBlocks.SCHWARZWAELDER_BLOCK) {
			return true;
		}
		return false;
	}

}
