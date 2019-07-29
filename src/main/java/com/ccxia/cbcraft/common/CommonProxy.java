package com.ccxia.cbcraft.common;

import com.ccxia.cbcraft.inventory.GuiLoader;
import com.ccxia.cbcraft.item.OreDictLoader;
import com.ccxia.cbcraft.tileentity.TileEntityLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new TileEntityLoader(event);
	}

	public void init(FMLInitializationEvent event) {
		new GuiLoader();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}

}
