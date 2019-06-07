package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.block.Block;

public class ModelBlocks {
	//可可工艺方块
	//发酵烘焙机
	public static final Block FERMENTATION_BAKER;
	static {
		FERMENTATION_BAKER = BlockLoader.getByName("block." + CbCraft.MODID + ".fermentationBaker");
	}

}
