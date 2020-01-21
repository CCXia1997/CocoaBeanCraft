package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHollowChocolateLog extends BlockLog {

	public BlockHollowChocolateLog() {
		super();
		this.setUnlocalizedName(CbCraft.MODID + ".hollowChocolateLog");
		this.setRegistryName("hollow_chocolate_log");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		Blocks.FIRE.setFireInfo(this, 5, 20);
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

//
////	@Override
////	public EnumBlockRenderType getRenderType(IBlockState state) {
////		return EnumBlockRenderType.MODEL;
////	}
//
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public IBlockState getStateFromMeta(int meta) {
		BlockLog.EnumAxis enumfacing$axis = BlockLog.EnumAxis.Y;
		int i = meta & 12;

		if (i == 4) {
			enumfacing$axis = BlockLog.EnumAxis.X;
		} else if (i == 8) {
			enumfacing$axis = BlockLog.EnumAxis.Z;
		}

		return this.getDefaultState().withProperty(LOG_AXIS, enumfacing$axis);
	}

	public int getMetaFromState(IBlockState state) {
		int i = 0;
		BlockLog.EnumAxis enumfacing$axis = (BlockLog.EnumAxis) state.getValue(LOG_AXIS);

		if (enumfacing$axis == BlockLog.EnumAxis.X) {
			i |= 4;
		} else if (enumfacing$axis == BlockLog.EnumAxis.Z) {
			i |= 8;
		}

		return i;
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { LOG_AXIS });
	}
}
