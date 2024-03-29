package com.ccxia.cbcraft.world.biome;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.CbCraftConfig;
import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.world.gen.WorldGenHollowTrees;
import com.ccxia.cbcraft.world.gen.WorldGenVerticalTrees;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeBrownieHill extends BiomeHills {

	// 树木生成配置
	private static final WorldGenVerticalTrees VERTICAL_FEATURE = new WorldGenVerticalTrees(false);

	public BiomeBrownieHill(Type p_i46710_1_, BiomeProperties properties) {
		super(p_i46710_1_, properties);
		this.setRegistryName("brownie_hill");
		this.topBlock = ModBlocks.BROWNIE_BLOCK.getDefaultState();
		this.fillerBlock = ModBlocks.COCOA_CAKE_BASE.getDefaultState();
		// 先禁止生物生成
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		// 一些配置
		this.decorator.treesPerChunk = CbCraftConfig.vertical_tree_amount;
		this.decorator.extraTreeChance = 0.2F;
		this.decorator.flowersPerChunk = 0;
		this.decorator.grassPerChunk = 0;
	}

	public void generateBiomeBrownieHillTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z,
			double noiseVal) {
		int i = worldIn.getSeaLevel();
		IBlockState iblockstate = this.topBlock;
		IBlockState iblockstate1 = this.fillerBlock;
		int j = -1;
		int k = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int l = x & 15;
		int i1 = z & 15;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int j1 = 255; j1 >= 0; --j1) {
			if (j1 <= rand.nextInt(5)) {
				chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
			} else {
				IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

				if (iblockstate2.getMaterial() == Material.AIR) {
					j = -1;
				} else if (iblockstate2.getBlock() == ModBlocks.COCOA_STONE) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = AIR;
							iblockstate1 = ModBlocks.COCOA_STONE.getDefaultState();
						} else if (j1 >= i - 4 && j1 <= i + 1) {
							iblockstate = this.topBlock;
							iblockstate1 = this.fillerBlock;
						}

						if (j1 < i && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
							if (this.getTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F) {
								iblockstate = ICE;
							} else {
								iblockstate = WATER;
							}
						}

						j = k;

						if (j1 >= i - 1) {
							chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
						} else if (j1 < i - 7 - k) {
							iblockstate = AIR;
							iblockstate1 = ModBlocks.COCOA_STONE.getDefaultState();
							chunkPrimerIn.setBlockState(i1, j1, l, GRAVEL);
						} else {
							chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
						}
					} else if (j > 0) {
						--j;
						chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);

						if (j == 0 && iblockstate1.getBlock() == Blocks.SAND && k > 1) {
							j = rand.nextInt(4) + Math.max(0, j1 - 63);
							iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND
									? RED_SANDSTONE
									: SANDSTONE;
						}
					}
				}
			}
		}
	}

	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return VERTICAL_FEATURE;
	}

	public void decorate(World worldIn, Random rand, BlockPos pos) {
		this.decorator.decorate(worldIn, rand, this, pos);
	}

}
