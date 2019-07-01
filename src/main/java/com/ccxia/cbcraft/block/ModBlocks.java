package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.block.Block;

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

	static {
		// FERMENTATION_BAKER = BlockLoader.getByName("block." + CbCraft.MODID +
		// ".fermentationBaker");
		FERMENTATION_BAKER = BlockLoader.blocks[0];
		LIT_FERMENTATION_BAKER = BlockLoader.blocks[1];
		CRUSHING_GRINDING_MACHINE = BlockLoader.getByName("block." + CbCraft.MODID + ".crushingGrindingMachine");
		SEPARATOR = BlockLoader.blocks[3];
		LIT_SEPARATOR = BlockLoader.blocks[4];
		DARK_CHOCOLATE_BLOCK = BlockLoader.getByName("block." + CbCraft.MODID + ".darkChocolateBlock");
		MILK_CHOCOLATE_BLOCK = BlockLoader.getByName("block." + CbCraft.MODID + ".milkChocolateBlock");
		WHITE_CHOCOLATE_BLOCK = BlockLoader.getByName("block." + CbCraft.MODID + ".whiteChocolateBlock");
		CHOCOLATE_CAKE = BlockLoader.getByName("block." + CbCraft.MODID + ".chocolateCake");
		DARK_MILK_CHOCOLATE_BLOCK = BlockLoader.getByName("block." + CbCraft.MODID + ".darkMilkChocolateBlock");
		MILK_WHITE_CHOCOLATE_BLOCK = BlockLoader.getByName("block." + CbCraft.MODID + ".milkWhiteChocolateBlock");
		WHITE_DARK_CHOCOLATE_BLOCK = BlockLoader.getByName("block." + CbCraft.MODID + ".whiteDarkChocolateBlock");

	}

}
