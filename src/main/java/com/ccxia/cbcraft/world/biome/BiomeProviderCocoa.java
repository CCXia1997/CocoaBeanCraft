package com.ccxia.cbcraft.world.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.init.Biomes;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.storage.WorldInfo;

public class BiomeProviderCocoa extends BiomeProvider {
    private ChunkGeneratorSettings settings;
    private List<Biome> spawnBiomes;
    private GenLayer genCocoaBiomes;
    private GenLayer biomeIndexLayerCocoa;
    private final BiomeCache biomeCocoaCache;

    public BiomeProviderCocoa(WorldInfo info) {
        super(info);
        this.biomeCocoaCache = new BiomeCache(this);
        this.spawnBiomes = Lists.newArrayList(CocoaBiomes.TIRAMISU_PLAIN, CocoaBiomes.BROWNIE_HILL,
                CocoaBiomes.SCHWAREZWAELDER, CocoaBiomes.OPERA_PLATEAU);
        if (info.getTerrainType() == WorldType.CUSTOMIZED && !info.getGeneratorOptions().isEmpty()) {
            this.settings = ChunkGeneratorSettings.Factory.jsonToFactory(info.getGeneratorOptions()).build();
        }
        GenLayer[] agenlayer = GenLayer.initializeAllBiomeGenerators(info.getSeed(),
                WorldType.parseWorldType("cocoa_world"), this.settings);
        agenlayer = getModdedBiomeGenerators(WorldType.parseWorldType("cocoa_world"), info.getSeed(), agenlayer);
        this.genCocoaBiomes = agenlayer[0];
        this.biomeIndexLayerCocoa = agenlayer[1];
    }

    public List<Biome> getBiomesToSpawnIn() {
        return this.spawnBiomes;
    }

    public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed) {
        IntCache.resetIntCache();
        int i = x - radius >> 2;
        int j = z - radius >> 2;
        int k = x + radius >> 2;
        int l = z + radius >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genCocoaBiomes.getInts(i, j, i1, j1);

        try {
            for (int k1 = 0; k1 < i1 * j1; ++k1) {
                // 修改
                Biome biome = BiomeProviderCocoa.getBiome(aint[k1]);

                if (!allowed.contains(biome)) {
                    return false;
                }
            }

            return true;
        } catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
            crashreportcategory.addCrashSection("Layer", this.genCocoaBiomes.toString());
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
            crashreportcategory.addCrashSection("allowed", allowed);
            throw new ReportedException(crashreport);
        }
    }

    @Nullable
    public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
        IntCache.resetIntCache();
        int i = x - range >> 2;
        int j = z - range >> 2;
        int k = x + range >> 2;
        int l = z + range >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genCocoaBiomes.getInts(i, j, i1, j1);
        BlockPos blockpos = null;
        int k1 = 0;

        for (int l1 = 0; l1 < i1 * j1; ++l1) {
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            // 修改
            Biome biome = BiomeProviderCocoa.getBiome(aint[l1]);

            if (biomes.contains(biome) && (blockpos == null || random.nextInt(k1 + 1) == 0)) {
                blockpos = new BlockPos(i2, 0, j2);
                ++k1;
            }
        }

        return blockpos;
    }

    public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height) {
        IntCache.resetIntCache();

        if (biomes == null || biomes.length < width * height) {
            biomes = new Biome[width * height];
        }

        int[] aint = this.genCocoaBiomes.getInts(x, z, width, height);

        try {
            for (int i = 0; i < width * height; ++i) {
                // 修改
                biomes[i] = BiomeProviderCocoa.getBiome(aint[i], Biomes.DEFAULT);
            }
            return biomes;
        } catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
            crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(biomes.length));
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("w", Integer.valueOf(width));
            crashreportcategory.addCrashSection("h", Integer.valueOf(height));
            throw new ReportedException(crashreport);
        }
    }

    public Biome[] getBiomes(@Nullable Biome[] oldBiomeList, int x, int z, int width, int depth) {
        return this.getBiomes(oldBiomeList, x, z, width, depth, true);
    }

    /**
     * Gets a list of biomes for the specified blocks.
     */
    public Biome[] getBiomes(@Nullable Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag) {
        IntCache.resetIntCache();

        if (listToReuse == null || listToReuse.length < width * length) {
            listToReuse = new Biome[width * length];
        }

        if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (z & 15) == 0) {
            Biome[] abiome = this.biomeCocoaCache.getCachedBiomes(x, z);
            System.arraycopy(abiome, 0, listToReuse, 0, width * length);
            return listToReuse;
        } else {
            int[] aint = this.biomeIndexLayerCocoa.getInts(x, z, width, length);

            for (int i = 0; i < width * length; ++i) {
                // 修改
                listToReuse[i] = BiomeProviderCocoa.getBiome(aint[i], Biomes.DEFAULT);
            }
            return listToReuse;
        }
    }

    public static Biome getBiome(int id) {
        return getBiome(id, (Biome) null);
    }

    public static Biome getBiome(int biomeId, Biome fallback) {
        // 这东西比较难写，目前思路还是把几个常见的原版群系给分配到对应的自己的群系
        // 剩下的群系随机分配给各个群系
        Biome biome = Biome.getBiome(biomeId, fallback);
        if (biome != Biomes.RIVER && biome != Biomes.FROZEN_RIVER && biome != Biomes.OCEAN && biome != Biomes.DEEP_OCEAN
                && biome != Biomes.FROZEN_OCEAN) {
            // 如果是平原或者冰原沙漠沼泽森林则分配给提拉米苏平原
            if (biome == Biomes.PLAINS || biome == Biomes.ICE_PLAINS || biome == Biomes.DESERT ||
                    biome == Biomes.SWAMPLAND || biome == Biomes.FOREST) {
                return CocoaBiomes.TIRAMISU_PLAIN;
            }
            // 如果是山地则分配给布朗尼山地
            if (biome == Biomes.BIRCH_FOREST_HILLS || biome == Biomes.COLD_TAIGA_HILLS || biome == Biomes.DESERT_HILLS
                    || biome == Biomes.FOREST_HILLS || biome == Biomes.EXTREME_HILLS) {
                return CocoaBiomes.BROWNIE_HILL;
            }
            // 如果是高原则分配给欧培拉高原
            if (biome == Biomes.SAVANNA_PLATEAU) {
                return CocoaBiomes.OPERA_PLATEAU;
            }
            // 如果是丛林和黑森林群系则分配给可可黑森林
            if (biome == Biomes.JUNGLE || biome == Biomes.ROOFED_FOREST) {
                return CocoaBiomes.SCHWAREZWAELDER;
            }
            // 剩下的群系采用随机分配的方式，降低黑森林群系的生成概率
            int i = new Random(biomeId).nextInt(10);
            if (i < 3) {
                return CocoaBiomes.TIRAMISU_PLAIN;
            } else if (i < 6) {
                return CocoaBiomes.BROWNIE_HILL;
            } else if (i == 6) {
                return CocoaBiomes.SCHWAREZWAELDER;
            } else if (i < 10) {
                return CocoaBiomes.OPERA_PLATEAU;
            }
        } else if (biome == Biomes.RIVER || biome == Biomes.FROZEN_RIVER) {
            return CocoaBiomes.COCOA_RIVER;
        }
        return CocoaBiomes.COCOA_OCEAN;
    }

}
