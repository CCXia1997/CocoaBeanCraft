package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.block.Block;

public class ModBlocks {
	// 可可工艺方块
	public static final Block FERMENTATION_BAKER;// 发酵烘焙机
	public static final Block LIT_FERMENTATION_BAKER;// 发酵烘焙机（燃烧）
	public static final Block CRUSHING_GRINDING_MACHINE;// 打碎研磨机
	public static final Block SEPARATOR;// 分离机
	static {
		// FERMENTATION_BAKER = BlockLoader.getByName("block." + CbCraft.MODID +
		// ".fermentationBaker");
		FERMENTATION_BAKER = BlockLoader.blocks[0];
		LIT_FERMENTATION_BAKER = BlockLoader.blocks[1];
		CRUSHING_GRINDING_MACHINE = BlockLoader.getByName("block." + CbCraft.MODID + ".crushingGrindingMachine");
		SEPARATOR = BlockLoader.getByName("block." + CbCraft.MODID + ".separator");
	}

}
