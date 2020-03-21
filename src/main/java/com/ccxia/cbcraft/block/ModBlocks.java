package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;

public class ModBlocks {
	// �ɿɹ��շ���
	public static final Block FERMENTATION_BAKER;// ���ͺ決��
	public static final Block LIT_FERMENTATION_BAKER;// ���ͺ決����ȼ�գ�
	public static final Block CRUSHING_GRINDING_MACHINE;// ������ĥ��
	public static final Block SEPARATOR;// �����
	public static final Block LIT_SEPARATOR;// �������ȼ�գ�
	public static final Block DARK_CHOCOLATE_BLOCK;// ���ɿ�����
	public static final Block MILK_CHOCOLATE_BLOCK;// ���ɿ�����
	public static final Block WHITE_CHOCOLATE_BLOCK;// ���ɿ�����
	public static final Block CHOCOLATE_CAKE;// �ɿ�������
	public static final Block DARK_MILK_CHOCOLATE_BLOCK;// �غ��ɿ�����
	public static final Block MILK_WHITE_CHOCOLATE_BLOCK;// �ذ��ɿ�����
	public static final Block WHITE_DARK_CHOCOLATE_BLOCK;// �ڰ��ɿ�����
	public static final Block DARK_CHOCOLATE_BLOCK_CARVED;// ��̺��ɿ�����
	public static final Block DARK_CHOCOLATE_BLOCK_PILLAR;// ���ƺ��ɿ�����
	public static final Block DARK_CHOCOLATE_BLOCK_SMOOTH;// ƽ�����ɿ�����
	public static final Block MILK_CHOCOLATE_BLOCK_CARVED;// ������ɿ�����
	public static final Block MILK_CHOCOLATE_BLOCK_PILLAR;// �������ɿ�����
	public static final Block MILK_CHOCOLATE_BLOCK_SMOOTH;// ƽ�����ɿ�����
	public static final Block WHITE_CHOCOLATE_BLOCK_CARVED;// ��̰��ɿ�����
	public static final Block WHITE_CHOCOLATE_BLOCK_PILLAR;// ���ư��ɿ�����
	public static final Block WHITE_CHOCOLATE_BLOCK_SMOOTH;// ƽ�����ɿ�����
	public static final Block AUTO_CRUSHING_GRINDING_MACHINE;// �Զ�������ĥ��
	public static final Block DARK_CHOCOLATE_SLAB;// ���ɿ���̨��
	public static final Block MILK_CHOCOLATE_SLAB;// ���ɿ���̨��
	public static final Block WHITE_CHOCOLATE_SLAB;// ���ɿ���̨��
	public static final Block INJECTION_TABLE;// עħ̨
	public static final Block INJECTED_DARK_CHOCOLATE;// עħ���ɿ���
	public static final Block INJECTED_WHITE_CHOCOLATE;// עħ���ɿ���
	public static final Block INJECTED_MILK_CHOCOLATE;// עħţ���ɿ���
	public static final Block DARK_CHOCOLATE_BRICK;
	public static final Block DARK_CHOCOLATE_WALL;
	public static final Block DARK_CHOCOLATE_STAIRS;
	public static final Block DARK_CHOCOLATE_FENCE;
	public static final Block DARK_CHOCOLATE_FENCE_GATE;
	public static final Block MILK_CHOCOLATE_BRICK;
	public static final Block MILK_CHOCOLATE_WALL;
	public static final Block MILK_CHOCOLATE_STAIRS;
	public static final Block MILK_CHOCOLATE_FENCE;
	public static final Block MILK_CHOCOLATE_FENCE_GATE;
	public static final Block WHITE_CHOCOLATE_BRICK;
	public static final Block WHITE_CHOCOLATE_WALL;
	public static final Block WHITE_CHOCOLATE_STAIRS;
	public static final Block WHITE_CHOCOLATE_FENCE;
	public static final Block WHITE_CHOCOLATE_FENCE_GATE;
	public static final Block AUTO_PRESSING_MACHINE; // �Զ�ѹ�ϻ�
	public static final Block COCOA_SPAR_ORE;// �ɿɾ�ʯ��ʯ
	public static final Block COCOA_SPAR_BLOCK;// �ɿɾ�ʯ��
	public static final Block COCOA_STONE;// �ɿ���
	public static final Block CAKE_BASE;// �������
	public static final Block COCOA_CAKE_BASE;// �ɿɵ������
	public static final Block TIRAMISU_BLOCK;// �������շ���
	public static final Block BROWNIE_BLOCK;// �����᷽��
	public static final Block SCHWARZWAELDER_BLOCK;// ��ɭ�ֵ��ⷽ��
	public static final Block OPERA_BLOCK;// ŷ�������ⷽ��
	public static final Block COCOA_PORTAL_BLOCK;// �ɿ������紫���ŷ���
	public static final Block HOLLOW_CHOCOLATE_LOG;// �����ɿ���ԭľ
	public static final Block HORIZONTAL_CHOCOLATE_LOG;// �����ɿ���ԭľ
	public static final Block TWILL_CHOCOLATE_LOG;// б���ɿ���ԭľ
	public static final Block VERTICAL_CHOCOLATE_LOG;// �����ɿ���ԭľ
	public static final Block COCOA_METAL_ORE;// �ɿɽ�����
	public static final Block TIRAMISU_CAKE;// �������յ���
	public static final Block BROWNIE_CAKE;// �����ᵰ��
	public static final Block OPERA_CAKE;// ŷ��������
	public static final Block SCHWARZWAELDERCAKE_CAKE;// ��ɭ�ֵ���
	public static final Block HOLLOW_CHOCOLATE_LEAVES;// �����ɿ�����Ҷ
	public static final Block HORIZONTAL_CHOCOLATE_LEAVES;// �����ɿ�����Ҷ
	public static final Block TWILL_CHOCOLATE_LEAVES;// б���ɿ�����Ҷ
	public static final Block VERTICAL_CHOCOLATE_LEAVES;// �����ɿ�����Ҷ
	public static final Block HOLLOW_CHOCOLATE_SAPLING;// �����ɿ�������
	public static final Block HORIZONTAL_CHOCOLATE_SAPLING;// �����ɿ�������
	public static final Block TWILL_CHOCOLATE_SAPLING;// б���ɿ�������
	public static final Block VERTICAL_CHOCOLATE_SAPLING;// �����ɿ�������

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
		INJECTION_TABLE = BlockLoader.blocks[28];
		INJECTED_DARK_CHOCOLATE = BlockLoader.getByName("tile." + CbCraft.MODID + ".injectedDarkChocolate");
		INJECTED_MILK_CHOCOLATE = BlockLoader.getByName("tile." + CbCraft.MODID + ".injectedMilkChocolate");
		INJECTED_WHITE_CHOCOLATE = BlockLoader.getByName("tile." + CbCraft.MODID + ".injectedWhiteChocolate");
		DARK_CHOCOLATE_BRICK = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateBrick");
		DARK_CHOCOLATE_WALL = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateWall");
		DARK_CHOCOLATE_STAIRS = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateStairs");
		DARK_CHOCOLATE_FENCE = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateFence");
		DARK_CHOCOLATE_FENCE_GATE = BlockLoader.getByName("tile." + CbCraft.MODID + ".darkChocolateFenceGate");
		MILK_CHOCOLATE_BRICK = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateBrick");
		MILK_CHOCOLATE_WALL = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateWall");
		MILK_CHOCOLATE_STAIRS = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateStairs");
		MILK_CHOCOLATE_FENCE = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateFence");
		MILK_CHOCOLATE_FENCE_GATE = BlockLoader.getByName("tile." + CbCraft.MODID + ".milkChocolateFenceGate");
		WHITE_CHOCOLATE_BRICK = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateBrick");
		WHITE_CHOCOLATE_WALL = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateWall");
		WHITE_CHOCOLATE_STAIRS = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateStairs");
		WHITE_CHOCOLATE_FENCE = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateFence");
		WHITE_CHOCOLATE_FENCE_GATE = BlockLoader.getByName("tile." + CbCraft.MODID + ".whiteChocolateFenceGate");
		AUTO_PRESSING_MACHINE = BlockLoader.getByName("tile." + CbCraft.MODID + ".autoPressingMachine");
		COCOA_SPAR_ORE = BlockLoader.getByName("tile." + CbCraft.MODID + ".cocoaSparOre");
		COCOA_SPAR_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".cocoaSparBlock");
		COCOA_STONE = BlockLoader.getByName("tile." + CbCraft.MODID + ".cocoaStone");
		CAKE_BASE = BlockLoader.getByName("tile." + CbCraft.MODID + ".cakeBase");
		COCOA_CAKE_BASE = BlockLoader.getByName("tile." + CbCraft.MODID + ".cocoaCakeBase");
		TIRAMISU_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".tiramisuBlock");
		BROWNIE_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".brownieBlock");
		SCHWARZWAELDER_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".schwarzwaelderBlock");
		OPERA_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".operaBlock");
		COCOA_PORTAL_BLOCK = BlockLoader.getByName("tile." + CbCraft.MODID + ".cocoaPortalBlock");
		HOLLOW_CHOCOLATE_LOG = BlockLoader.getByName("tile." + CbCraft.MODID + ".hollowChocolateLog");
		HORIZONTAL_CHOCOLATE_LOG = BlockLoader.getByName("tile." + CbCraft.MODID + ".horizontalChocolateLog");
		TWILL_CHOCOLATE_LOG = BlockLoader.getByName("tile." + CbCraft.MODID + ".twillChocolateLog");
		VERTICAL_CHOCOLATE_LOG = BlockLoader.getByName("tile." + CbCraft.MODID + ".verticalChocolateLog");
		COCOA_METAL_ORE = BlockLoader.getByName("tile." + CbCraft.MODID + ".cocoaMetalOre");
		TIRAMISU_CAKE = BlockLoader.getByName("tile." + CbCraft.MODID + ".tiramisuCake");
		BROWNIE_CAKE = BlockLoader.getByName("tile." + CbCraft.MODID + ".brownieCake");
		OPERA_CAKE = BlockLoader.getByName("tile." + CbCraft.MODID + ".operaCake");
		SCHWARZWAELDERCAKE_CAKE = BlockLoader.getByName("tile." + CbCraft.MODID + ".schwarzwaelderCake");
		HOLLOW_CHOCOLATE_LEAVES = BlockLoader.getByName("tile." + CbCraft.MODID + ".hollowChocolateLeaves");
		HORIZONTAL_CHOCOLATE_LEAVES = BlockLoader.getByName("tile." + CbCraft.MODID + ".horizontalChocolateLeaves");
		TWILL_CHOCOLATE_LEAVES = BlockLoader.getByName("tile." + CbCraft.MODID + ".twillChocolateLeaves");
		VERTICAL_CHOCOLATE_LEAVES = BlockLoader.getByName("tile." + CbCraft.MODID + ".verticalChocolateLeaves");
		HOLLOW_CHOCOLATE_SAPLING = BlockLoader.getByName("tile." + CbCraft.MODID + ".hollowChocolateSapling");
		HORIZONTAL_CHOCOLATE_SAPLING = BlockLoader.getByName("tile." + CbCraft.MODID + ".horizontalChocolateSapling");
		TWILL_CHOCOLATE_SAPLING = BlockLoader.getByName("tile." + CbCraft.MODID + ".twillChocolateSapling");
		VERTICAL_CHOCOLATE_SAPLING = BlockLoader.getByName("tile." + CbCraft.MODID + ".verticalChocolateSapling");
	}

}
