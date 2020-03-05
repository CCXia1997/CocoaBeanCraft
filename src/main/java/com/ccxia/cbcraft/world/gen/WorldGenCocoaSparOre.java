package com.ccxia.cbcraft.world.gen;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
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
	// 可可晶石矿脉生成
	// 这边有个Predicate，原版限定只能石头替换成矿脉，这边要改成可可岩
	// 直接用函数式写法
	WorldGenMinable cocoaSparOreGen = new WorldGenMinable(ModBlocks.COCOA_SPAR_ORE.getDefaultState(), 8,
			state -> state != null && state.getBlock() == ModBlocks.COCOA_STONE);
	// 一个区块里尝试生成的次数
	private int genCountInChunk = 1;
	// 矿石生成的高度范围
	private int minHeight;
	private int maxHeight;

	private void generateCocoaWorld(Random rand, int chunkX, int chunkZ, World world) {
		int k = 0;
		// 布朗尼山地的生成数量更多
		if (world.getBiome(new BlockPos(chunkX * 16, 16, chunkZ * 16)) == CocoaBiomes.BROWNIE_HILL) {
			k = 4;
		} else {
			k = this.genCountInChunk;
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
