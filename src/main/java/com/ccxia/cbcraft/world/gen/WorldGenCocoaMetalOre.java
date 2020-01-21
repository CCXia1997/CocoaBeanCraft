package com.ccxia.cbcraft.world.gen;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.block.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCocoaMetalOre implements IWorldGenerator {
	// �ɿɽ�����������
	WorldGenMinable cocoaMetalOreGen = new WorldGenMinable(ModBlocks.COCOA_METAL_ORE.getDefaultState(), 9,
			state -> state != null && state.getBlock() == ModBlocks.COCOA_STONE);
	// һ�������ﳢ�����ɵĴ���
	private int genCountInChunk = 20;
	// ��ʯ���ɵĸ߶ȷ�Χ
	private int minHeight;
	private int maxHeight;

	private void generateCocoaWorld(Random rand, int chunkX, int chunkZ, World world) {
		for (int i = 0; i < this.genCountInChunk; i++) {
			BlockPos genPos = new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(64),
					chunkZ * 16 + rand.nextInt(16));
			cocoaMetalOreGen.generate(world, rand, genPos);
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == CbCraft.dimID) {
			generateCocoaWorld(random, chunkX, chunkZ, world);
		}

	}
}
