package com.ccxia.cbcraft.block;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.inventory.GuiLoader;
import com.ccxia.cbcraft.tileentity.TileEntityFermentationBaker;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BlockFermentationBaker extends BlockContainer {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	protected BlockFermentationBaker() {
		super(Material.ROCK);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(CbCraft.MODID + ".fermentationBaker");
		this.setRegistryName("fermentation_baking_machine");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(3.5F);
		this.setSoundType(SoundType.STONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityFermentationBaker();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		this.setDefaultFacing(worldIn, pos, state);
	}

	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			IBlockState iblockstate = worldIn.getBlockState(pos.north());
			IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
			IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
			IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
			EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);

			if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock()) {
				enumfacing = EnumFacing.SOUTH;
			} else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock()) {
				enumfacing = EnumFacing.NORTH;
			} else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock()) {
				enumfacing = EnumFacing.EAST;
			} else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock()) {
				enumfacing = EnumFacing.WEST;
			}

			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getFront(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
			enumfacing = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!playerIn.capabilities.allowEdit) {
			return false;
		} else if (!worldIn.isRemote) {
			int id = GuiLoader.GUI_FERMENTATIONBAKER;
			playerIn.openGui(CbCraft.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityFermentationBaker te = (TileEntityFermentationBaker) worldIn.getTileEntity(pos);
		IItemHandler up = te.getUpInventory();
		IItemHandler side = te.getSideInventory();
		IItemHandler back = te.getBackInventory();
		IItemHandler down = te.getDownInventory();
		for (int i = up.getSlots() - 1; i >= 0; --i) {
			if (up.getStackInSlot(i) != null) {
				Block.spawnAsEntity(worldIn, pos, up.getStackInSlot(i));
				((IItemHandlerModifiable) up).setStackInSlot(i, ItemStack.EMPTY);
			}
		}
		for (int i = side.getSlots() - 1; i >= 0; --i) {
			if (side.getStackInSlot(i) != null) {
				Block.spawnAsEntity(worldIn, pos, side.getStackInSlot(i));
				((IItemHandlerModifiable) side).setStackInSlot(i, ItemStack.EMPTY);
			}
		}
		for (int i = back.getSlots() - 1; i >= 0; --i) {
			if (back.getStackInSlot(i) != null) {
				Block.spawnAsEntity(worldIn, pos, back.getStackInSlot(i));
				((IItemHandlerModifiable) back).setStackInSlot(i, ItemStack.EMPTY);
			}
		}
		for (int i = down.getSlots() - 1; i >= 0; --i) {
			if (down.getStackInSlot(i) != null) {
				Block.spawnAsEntity(worldIn, pos, down.getStackInSlot(i));
				((IItemHandlerModifiable) down).setStackInSlot(i, ItemStack.EMPTY);
			}
		}
	}

}
