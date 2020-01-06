package com.ccxia.cbcraft.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldTypeCocoa extends WorldType {
	public WorldTypeCocoa() {
		super("cocoa_world");
	}

	@Override
	public BiomeProvider getBiomeProvider(World world) {
		return new net.minecraft.world.biome.BiomeProvider(world.getWorldInfo());
	}

	@Override
	public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
		return new net.minecraft.world.gen.ChunkGeneratorOverworld(world, world.getSeed(),
				world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
	}

}
