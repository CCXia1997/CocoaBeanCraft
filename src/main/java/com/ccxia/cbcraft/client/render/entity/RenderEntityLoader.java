package com.ccxia.cbcraft.client.render.entity;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.entity.item.EntityCocoaEnderPearl;
import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CbCraft.MODID)
public class RenderEntityLoader {
	@SubscribeEvent
	public static void bindEntityRender(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCocoaEnderPearl.class,
				manager -> new RenderSnowball(manager, ModItems.COCOA_ENDER_PEARL,
						Minecraft.getMinecraft().getRenderItem()));
	}

}
