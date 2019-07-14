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
