package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;

public class ModBlocks {
	// 可可工艺方块
	public static final Block FERMENTATION_BAKER;// 发酵烘焙机
	public static final Block LIT_FERMENTATION_BAKER;// 发酵烘焙机（燃烧）
	public static final Block CRUSHING_GRINDING_MACHINE;// 打碎研磨机
	public static final Block SEPARATOR;// 分离机
	public static final Block LIT_SEPARATOR;// 分离机（燃烧）
	public static final Block DARK_CHOCOLATE_BLOCK;// 黑巧克力块
	public static final Block MILK_CHOCOLATE_BLOCK;// 棕巧克力块
	public static final Block WHITE_CHOCOLATE_BLOCK;// 白巧克力块
	public static final Block CHOCOLATE_CAKE;// 巧克力蛋糕
	public static final Block DARK_MILK_CHOCOLATE_BLOCK;// 棕黑巧克力块
	public static final Block MILK_WHITE_CHOCOLATE_BLOCK;// 棕白巧克力块
	public static final Block WHITE_DARK_CHOCOLATE_BLOCK;// 黑白巧克力块
	public static final Block DARK_CHOCOLATE_BLOCK_CARVED;// 雕刻黑巧克力块
	public static final Block DARK_CHOCOLATE_BLOCK_PILLAR;// 竖纹黑巧克力块
	public static final Block DARK_CHOCOLATE_BLOCK_SMOOTH;// 平滑黑巧克力块
	public static final Block MILK_CHOCOLATE_BLOCK_CARVED;// 雕刻棕巧克力块
	public static final Block MILK_CHOCOLATE_BLOCK_PILLAR;// 竖纹棕巧克力块
	public static final Block MILK_CHOCOLATE_BLOCK_SMOOTH;// 平滑棕巧克力块
	public static final Block WHITE_CHOCOLATE_BLOCK_CARVED;// 雕刻白巧克力块
	public static final Block WHITE_CHOCOLATE_BLOCK_PILLAR;// 竖纹白巧克力块
	public static final Block WHITE_CHOCOLATE_BLOCK_SMOOTH;// 平滑白巧克力块
	public static final Block AUTO_CRUSHING_GRINDING_MACHINE;// 自动打碎研磨机
	public static final Block DARK_CHOCOLATE_SLAB;// 黑巧克力台阶
	public static final Block MILK_CHOCOLATE_SLAB;// 棕巧克力台阶
	public static final Block WHITE_CHOCOLATE_SLAB;// 白巧克力台阶

	static {
		// FERMENTATION_BAKER = BlockLoader.getByName("block." + CbCraft.MODID +
		// ".fermentationBaker");
		FERMENTATION_BAKER = BlockLoader.blocks[0];
		LIT_FERMENTATION_BAKER = BlockLoader.blocks[1];
		CRUSHING_GRINDING_MACHINE = BlockLoader.getByName("tile." + CbCraft.MODID + ".crushingGrindingMachine");
		SEPARATOR = BlockLoader.blocks[3];
		LIT_SEPARATOR = BlockLoader.blocks[4];
		DARK_CHOCOLATE_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateBlock");
		MILK_CHOCOLATE_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateBlock");
		WHITE_CHOCOLATE_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateBlock");
		CHOCOLATE_CAKE = BlockLoader.getByName("tile." + CbCraft.MODID + ".chocolateCake");
		DARK_MILK_CHOCOLATE_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkMilkChocolateBlock");
		MILK_WHITE_CHOCOLATE_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkWhiteChocolateBlock");
		WHITE_DARK_CHOCOLATE_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteDarkChocolateBlock");
		DARK_CHOCOLATE_BLOCK_CARVED = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateBlockCarved");
		DARK_CHOCOLATE_BLOCK_PILLAR = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateBlockPillar");
		DARK_CHOCOLATE_BLOCK_SMOOTH = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateBlockSmooth");
		MILK_CHOCOLATE_BLOCK_CARVED = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateBlockCarved");
		MILK_CHOCOLATE_BLOCK_PILLAR = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateBlockPillar");
		MILK_CHOCOLATE_BLOCK_SMOOTH = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateBlockSmooth");
		WHITE_CHOCOLATE_BLOCK_CARVED = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateBlockCarved");
		WHITE_CHOCOLATE_BLOCK_PILLAR = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateBlockPillar");
		WHITE_CHOCOLATE_BLOCK_SMOOTH = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateBlockSmooth");
		AUTO_CRUSHING_GRINDING_MACHINE = BlockLoader
				.getByName("tile." + CbCraft.MODID + ".autoCrushingGrindingMachine");
		DARK_CHOCOLATE_SLAB = (BlockSlab) BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateSlab");
		MILK_CHOCOLATE_SLAB = (BlockSlab) BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateSlab");
		WHITE_CHOCOLATE_SLAB = (BlockSlab) BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateSlab");
	}

}
