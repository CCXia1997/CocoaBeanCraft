package com.ccxia.cbcraft.world.biome;

import net.minecraft.world.biome.BiomeRiver;

public class BiomeCocoaRiver extends BiomeRiver {
    public BiomeCocoaRiver(BiomeProperties properties) {
        super(properties);
        this.setRegistryName("cocoa_river");
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        // һЩ����
        this.decorator.treesPerChunk = 0;
        this.decorator.extraTreeChance = 0;
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 0;
    }
}
