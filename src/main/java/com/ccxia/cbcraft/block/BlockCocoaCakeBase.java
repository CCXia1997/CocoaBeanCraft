package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BlockCocoaCakeBase extends Block {
	public BlockCocoaCakeBase() {
		super(Material.GROUND);
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaCakeBase");
		this.setRegistryName("cocoa_cake_base");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(0.5F);
		this.setHarvestLevel("shovel", 0);
		this.setSoundType(SoundType.GROUND);
	}

	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			net.minecraftforge.common.IPlantable plantable) {
		IBlockState plant = plantable.getPlant(world, pos.offset(direction));
		net.minecraftforge.common.EnumPlantType plantType = plantable.getPlantType(world, pos.offset(direction));
		if ((plantType == EnumPlantType.Plains && plant.getBlock() == Blocks.SAPLING)
				|| plant.getBlock() == ModBlocks.VERTICAL_CHOCOLATE_SAPLING
				|| plant.getBlock() == ModBlocks.HOLLOW_CHOCOLATE_SAPLING
				|| plant.getBlock() == ModBlocks.HORIZONTAL_CHOCOLATE_SAPLING
				|| plant.getBlock() == ModBlocks.TWILL_CHOCOLATE_SAPLING) {
			return true;
		} else {
			return false;
		}
	}
}
