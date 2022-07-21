package com.ccxia.cbcraft.world.gen;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.CbCraftConfig;
import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.world.biome.CocoaBiomes;
import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCocoaSparOre implements IWorldGenerator {
	// �ɿɾ�ʯ��������
	// ����и�Predicate��ԭ���޶�ֻ��ʯͷ�滻�ɿ��������Ҫ�ĳɿɿ���
	// ֱ���ú���ʽд��
	WorldGenMinable cocoaSparOreGen = new WorldGenMinable(ModBlocks.COCOA_SPAR_ORE.getDefaultState(), 8,
			state -> state != null && state.getBlock() == ModBlocks.COCOA_STONE);
	// ��ʯ���ɵĸ߶ȷ�Χ
	private int minHeight;
	private int maxHeight;

	private void generateCocoaWorld(Random rand, int chunkX, int chunkZ, World world) {
		int k = 0;
		// config��������һ�������ڵ����ɴ���
		if (world.getBiome(new BlockPos(chunkX * 16, 16, chunkZ * 16)) == CocoaBiomes.BROWNIE_HILL) {
			k = CbCraftConfig.cocoa_spar_ore_weight_brownie;
		} else {
			k = CbCraftConfig.cocoa_spar_ore_weight;
		}
		for (int i = 0; i < k; i++) {
			BlockPos genPos = new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(16),
					chunkZ * 16 + rand.nextInt(16));
			cocoaSparOreGen.generate(world, rand, genPos);
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
