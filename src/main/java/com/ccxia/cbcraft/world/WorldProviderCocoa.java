package com.ccxia.cbcraft.world;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.world.biome.BiomeProviderCocoa;
import com.ccxia.cbcraft.world.gen.ChunkGeneratorCocoa;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderCocoa extends WorldProviderSurface {

	protected void init() {
		this.hasSkyLight = true;
		this.biomeProvider = new BiomeProviderCocoa(this.world.getWorldInfo());
	}

	@Override
	public DimensionType getDimensionType() {
		return CbCraft.myDim;
	}

	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorCocoa(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), "cocoa");
	}

}
