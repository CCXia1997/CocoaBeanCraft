package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

public class BlockDarkHalfSlab extends BlockDarkChocolateSlab {
	public BlockDarkHalfSlab() {
		this.setUnlocalizedName(CbCraft.MODID + ".darkChocolateSlab");
		this.setRegistryName("dark_chocolate_slab");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

	@Override
	public boolean isDouble() {
		return false;
	}

}
