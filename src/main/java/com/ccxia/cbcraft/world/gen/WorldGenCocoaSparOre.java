package com.ccxia.cbcraft.world.gen;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.block.ModBlocks;
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
	private int genCountInChunk = 8;
	// 矿石生成的高度范围
	private int minHeight;
	private int maxHeight;

	private void generateCocoaWorld(Random rand, int chunkX, int chunkZ, World world) {
		for (int i = 0; i < this.genCountInChunk; i++) {
			BlockPos genPos = new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(128),
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
