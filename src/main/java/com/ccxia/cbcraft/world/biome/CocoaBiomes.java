package com.ccxia.cbcraft.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomeHills;

public class CocoaBiomes {
	public static final Biome TIRAMISU_PLAIN = new BiomeTiramisuPlain(false,
			(new Biome.BiomeProperties("Tiramisu Plains").setBaseHeight(0.125F).setHeightVariation(0.05F)
					.setTemperature(0.8F).setRainfall(0.4F)));
	public static final Biome BROWNIE_HILL = new BiomeBrownieHill(BiomeHills.Type.NORMAL,
			(new Biome.BiomeProperties("Brownie Hills")).setBaseHeight(1.0F).setHeightVariation(0.5F)
					.setTemperature(0.2F).setRainfall(0.3F));
	public static final Biome SCHWAREZWAELDER = new BiomeSchwarezwaelder(BiomeForest.Type.ROOFED,
			(new Biome.BiomeProperties("Schwarezwaelder")).setTemperature(0.7F).setRainfall(0.8F));
	public static final Biome OPERA_PLATEAU = new BiomeOpera((new Biome.BiomeProperties("Opera Plateau"))
			.setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(1.0F).setRainfall(0.0F).setRainDisabled());

}
