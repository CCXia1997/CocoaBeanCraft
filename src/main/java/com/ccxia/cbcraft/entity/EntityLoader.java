package com.ccxia.cbcraft.entity;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.entity.item.EntityCocoaEnderPearl;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod.EventBusSubscriber(modid = CbCraft.MODID)
public class EntityLoader {
	@SubscribeEvent
	public static void registerEntity(RegistryEvent.Register<EntityEntry> event) {
		event.getRegistry()
				.register(EntityEntryBuilder.create().entity(EntityCocoaEnderPearl.class)
						.id(new ResourceLocation(CbCraft.MODID, "cocoa_ender_pearl"), 104).name("ThrownCocoaEnderpearl")
						.tracker(160, 1, false).build());
	}
}
