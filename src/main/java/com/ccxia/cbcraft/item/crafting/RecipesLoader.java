package com.ccxia.cbcraft.item.crafting;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = CbCraft.MODID)
public class RecipesLoader {
	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		event.getRegistry().registerAll(new RecipesDough());
	}

}
