package com.ccxia.cbcraft.world.biome;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CbCraft.MODID)
public class BiomeLoader {
    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().registerAll(CocoaBiomes.TIRAMISU_PLAIN, CocoaBiomes.BROWNIE_HILL,
                CocoaBiomes.SCHWAREZWAELDER, CocoaBiomes.OPERA_PLATEAU, CocoaBiomes.COCOA_RIVER, CocoaBiomes.COCOA_OCEAN);
    }

}
