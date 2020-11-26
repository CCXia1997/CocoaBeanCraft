package com.ccxia.cbcraft.block;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.world.gen.WorldGenVerticalTrees;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.EnumPlantType;

public class BlockVerticalChocolateSapling extends BlockBush implements IGrowable {
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D,
			0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);

	public BlockVerticalChocolateSapling() {
		super();
		this.setUnlocalizedName(CbCraft.MODID + ".verticalChocolateSapling");
		this.setRegistryName("vertical_chocolate_sapling");
		this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setSoundType(SoundType.PLANT);
		this.setHardness(0.0F);
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return rand.nextFloat() < 0.45;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		if (((Integer) state.getValue(STAGE)).intValue() == 0) {
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		} else {
			WorldGenerator treeGenerator = new WorldGenVerticalTrees(false);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
			if (!treeGenerator.generate(worldIn, rand, pos)) {

				worldIn.setBlockState(pos, state, 4);

			}
		}
	}

	@Override
	protected boolean canSustainBush(IBlockState state) {
		Block block = state.getBlock();
		return block == ModBlocks.BROWNIE_BLOCK || block == Blocks.GRASS || block == Blocks.DIRT
				|| block.getMaterial(state) == Material.GROUND;
	}

	@Override
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
		BlockPos down = pos.down();
		IBlockState soil = world.getBlockState(down);
		return soil.getBlock().canSustainPlant(soil, world, down, EnumFacing.UP, this);
	}

	@Override
	public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, rand);

			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
				this.grow(worldIn, rand, pos, state);
			}
		}
	}

	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE, Integer.valueOf(meta));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		return ((Integer) state.getValue(STAGE)).intValue();
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE });
	}

}
