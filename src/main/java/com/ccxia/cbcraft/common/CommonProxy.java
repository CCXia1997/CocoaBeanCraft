package com.ccxia.cbcraft.common;

import com.ccxia.cbcraft.inventory.GuiLoader;
import com.ccxia.cbcraft.item.OreDictLoader;
import com.ccxia.cbcraft.potion.DarkChocolateRecipe;
import com.ccxia.cbcraft.potion.MilkChocolateRecipe;
import com.ccxia.cbcraft.potion.WhiteChocolateRecipe;
import com.ccxia.cbcraft.tileentity.TileEntityLoader;
import com.ccxia.cbcraft.until.CbCraftRecipeRegister;
import com.ccxia.cbcraft.world.WorldTypeCocoa;
import com.ccxia.cbcraft.world.gen.WorldGenCocoaMetalOre;
import com.ccxia.cbcraft.world.gen.WorldGenCocoaSparOre;

import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new TileEntityLoader(event);
	}

	public void init(FMLInitializationEvent event) {
		// 矿脉生成
		GameRegistry.registerWorldGenerator(new WorldGenCocoaSparOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenCocoaMetalOre(), 0);
		// 炼药配方
		BrewingRecipeRegistry.addRecipe(new DarkChocolateRecipe());
		BrewingRecipeRegistry.addRecipe(new MilkChocolateRecipe());
		BrewingRecipeRegistry.addRecipe(new WhiteChocolateRecipe());
		new GuiLoader();
		// jei支持
		CbCraftRecipeRegister.getInstance().Init();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}

}
