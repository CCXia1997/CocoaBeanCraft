package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;

public class BlockDarkDoubleSlab extends BlockDarkChocolateSlab {
	public BlockDarkDoubleSlab() {
		this.setUnlocalizedName(CbCraft.MODID + ".darkChocolateSlab");
		this.setRegistryName("dark_chocolate_double_slab");
	}

	@Override
	public boolean isDouble() {
		return true;
	}

}
