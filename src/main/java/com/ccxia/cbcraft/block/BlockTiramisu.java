package com.ccxia.cbcraft.block;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockTiramisu extends Block {
	public BlockTiramisu() {
		super(Material.GRASS);
		this.setUnlocalizedName(CbCraft.MODID + ".tiramisuBlock");
		this.setRegistryName("tiramisu_block");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(0.6F);
		this.setHarvestLevel("shovel", 0);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
	}

	// 作为空心树木的支撑方块
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			net.minecraftforge.common.IPlantable plantable) {
		IBlockState plant = plantable.getPlant(world, pos.offset(direction));
		net.minecraftforge.common.EnumPlantType plantType = plantable.getPlantType(world, pos.offset(direction));
		//确定上方能种植的植物类型
		if (plant.getBlock() == ModBlocks.HOLLOW_CHOCOLATE_SAPLING) {
			return true;
		} else {
			return false;
		}
	}

	// 特性跟草方块一样，遮挡后退化为可可蛋糕基底，会向四周的可可蛋糕基底蔓延
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			if (worldIn.getLightFromNeighbors(pos.up()) < 4
					&& worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2) {
				worldIn.setBlockState(pos, ModBlocks.COCOA_CAKE_BASE.getDefaultState());
			} else {
				if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
					for (int i = 0; i < 4; ++i) {
						BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

						if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos)) {
							return;
						}

						IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
						IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

						if (iblockstate1.getBlock() == ModBlocks.COCOA_CAKE_BASE
								&& worldIn.getLightFromNeighbors(blockpos.up()) >= 4
								&& iblockstate.getLightOpacity(worldIn, pos.up()) <= 2) {
							worldIn.setBlockState(blockpos, ModBlocks.TIRAMISU_BLOCK.getDefaultState());
						}
					}
				}
			}
		}
	}

}
