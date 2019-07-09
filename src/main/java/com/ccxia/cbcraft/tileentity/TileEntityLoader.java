package com.ccxia.cbcraft.tileentity;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityLoader {
	public TileEntityLoader(FMLPreInitializationEvent event) {
		registerTileEntity(TileEntityFermentationBaker.class, "FermentationBaker");
		// registerTileEntity(TileEntityCrushingGrindingMachine.class,
		// "CrushingGrindingMachine");
		registerTileEntity(TileEntitySeparator.class, "Separator");
		registerTileEntity(TileEntityAutoCrushing.class, "AutoCrushing");
	}

	public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id) {
		GameRegistry.registerTileEntity(tileEntityClass, CbCraft.MODID + ":" + id);
	}

}
