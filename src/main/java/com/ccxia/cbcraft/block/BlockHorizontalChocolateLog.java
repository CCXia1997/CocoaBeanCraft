package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class BlockHorizontalChocolateLog extends BlockLog {
	public BlockHorizontalChocolateLog() {
		super();
		this.setUnlocalizedName(CbCraft.MODID + ".horizontalChocolateLog");
		this.setRegistryName("horizontal_chocolate_log");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		Blocks.FIRE.setFireInfo(this, 5, 5);
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
