package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.block.Block;

public class ModBlocks {
	// �ɿɹ��շ���
	public static final Block FERMENTATION_BAKER;// ���ͺ決��
	public static final Block LIT_FERMENTATION_BAKER;// ���ͺ決����ȼ�գ�
	public static final Block CRUSHING_GRINDING_MACHINE;// ������ĥ��
	public static final Block SEPARATOR;// �����
	public static final Block DARK_CHOCOLATE_BLOCK;// ���ɿ�����
	public static final Block MILK_CHOCOLATE_BLOCK;// ���ɿ�����
	public static final Block WHITE_CHOCOLATE_BLOCK;// ���ɿ�����

	static {
		// FERMENTATION_BAKER = BlockLoader.getByName("block." + CbCraft.MODID +
		// ".fermentationBaker");
		FERMENTATION_BAKER = BlockLoader.blocks[0];
		LIT_FERMENTATION_BAKER = BlockLoader.blocks[1];
		CRUSHING_GRINDING_MACHINE = BlockLoader.getByName("block." + CbCraft.MODID + ".crushingGrindingMachine");
		SEPARATOR = BlockLoader.getByName("block." + CbCraft.MODID + ".separator");
		DARK_CHOCOLATE_BLOCK = BlockLoader.getByName("block." + CbCraft.MODID + ".darkChocolateBlock");
		MILK_CHOCOLATE_BLOCK = BlockLoader.getByName("block." + CbCraft.MODID + ".milkChocolateBlock");
		WHITE_CHOCOLATE_BLOCK = BlockLoader.getByName("block." + CbCraft.MODID + ".whiteChocolateBlock");
	}

}
