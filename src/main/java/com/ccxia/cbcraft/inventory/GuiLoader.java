package com.ccxia.cbcraft.inventory;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiLoader implements IGuiHandler {

	public static final int GUI_FERMENTATIONBAKER = 1;
	public static final int GUI_CRUSHINGGRINDINGMACHINE = 2;
	public static final int GUI_SEPARATOR = 3;

	public GuiLoader() {
		NetworkRegistry.INSTANCE.registerGuiHandler(CbCraft.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GUI_FERMENTATIONBAKER:
			return new ContainerFermentationBaker(player, world.getTileEntity(new BlockPos(x, y, z)));
		case GUI_CRUSHINGGRINDINGMACHINE:
			return new ContainerCrushingGrindingMachine(player.inventory, world, new BlockPos(x, y, z));
		case GUI_SEPARATOR:
			return new ContainerSeparator(player, world.getTileEntity(new BlockPos(x, y, z)));
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GUI_FERMENTATIONBAKER:
			return new GuiFermentationBaker(
					new ContainerFermentationBaker(player, world.getTileEntity(new BlockPos(x, y, z))));
		case GUI_CRUSHINGGRINDINGMACHINE:
			return new GuiCrushingGrindingMachine(
					new ContainerCrushingGrindingMachine(player.inventory, world, new BlockPos(x, y, z)));
		case GUI_SEPARATOR:
			return new GuiSeparator(new ContainerSeparator(player, world.getTileEntity(new BlockPos(x, y, z))));
		default:
			return null;
		}
	}

}
