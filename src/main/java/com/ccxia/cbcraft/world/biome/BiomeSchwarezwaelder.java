package com.ccxia.cbcraft.world.biome;

import java.util.Random;

import com.ccxia.cbcraft.block.BlockHollowChocolateLog;
import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.world.gen.WorldGenMegaTwill;
import com.ccxia.cbcraft.world.gen.WorldGenTwillShurb;
import com.ccxia.cbcraft.world.gen.WorldGenTwillTrees;

import com.ccxia.cbcraft.world.gen.WorldGenTwillTrees2;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class BiomeSchwarezwaelder extends BiomeForest {

    private static final IBlockState DEFAULT_TRUNK = ModBlocks.TWILL_CHOCOLATE_LOG.getDefaultState()
            .withProperty(BlockHollowChocolateLog.LOG_AXIS, BlockLog.EnumAxis.Y);
    ;
    private static final IBlockState DEFAULT_LEAF = ModBlocks.TWILL_CHOCOLATE_LEAVES.getDefaultState()
            .withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    // 树木生成配置
    private static final WorldGenTwillTrees TWILL_FEATURE = new WorldGenTwillTrees(false);

    public BiomeSchwarezwaelder(Type typeIn, BiomeProperties properties) {
        super(typeIn, properties);
        this.setRegistryName("schwarezwaelder");
        this.topBlock = ModBlocks.SCHWARZWAELDER_BLOCK.getDefaultState();
        this.fillerBlock = ModBlocks.COCOA_CAKE_BASE.getDefaultState();
        // 先禁止生物生成
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        // 一些配置
        this.decorator.treesPerChunk = 50;
        this.decorator.extraTreeChance = 0.00F;
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

    // 生成树木
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        if (rand.nextInt(10) == 0)
        {
            return TWILL_FEATURE;
        }
        else if (rand.nextInt(2) == 0)
        {
            return new WorldGenTwillShurb(DEFAULT_TRUNK, DEFAULT_LEAF);
        }
        else
        {
            return (WorldGenAbstractTree)(rand.nextInt(3) == 0 ? new WorldGenMegaTwill(false, 10, 20, DEFAULT_TRUNK, DEFAULT_LEAF) : new WorldGenTwillTrees2(false, 4 + rand.nextInt(7), DEFAULT_TRUNK, DEFAULT_LEAF, false));
        }
    }

    public void decorate(World worldIn, Random rand, BlockPos pos) {
        this.decorator.decorate(worldIn, rand, this, pos);
    }

    // 把藤蔓生成去掉

}
