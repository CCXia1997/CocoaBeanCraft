package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.inventory.GuiLoader;
import com.ccxia.cbcraft.tileentity.TileEntityCrushingGrindingMachine;

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
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
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
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BlockCrushingGrindingMachine extends BlockContainer {

	public BlockCrushingGrindingMachine() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".crushingGrindingMachine");
		this.setRegistryName("crushing_grinding_machine");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(3.5F);
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityCrushingGrindingMachine();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityCrushingGrindingMachine te = (TileEntityCrushingGrindingMachine) worldIn.getTileEntity(pos);
		IItemHandler up = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
		IItemHandler down = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
		for (int i = up.getSlots() - 1; i >= 0; --i) {
			if (up.getStackInSlot(i) != null) {
				Block.spawnAsEntity(worldIn, pos, up.getStackInSlot(i));
				((IItemHandlerModifiable) up).setStackInSlot(i, ItemStack.EMPTY);
			}
		}
		for (int i = down.getSlots() - 1; i >= 0; --i) {
			if (down.getStackInSlot(i) != null) {
				Block.spawnAsEntity(worldIn, pos, down.getStackInSlot(i));
				((IItemHandlerModifiable) down).setStackInSlot(i, ItemStack.EMPTY);
			}
		}

	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!playerIn.capabilities.allowEdit) {
			return false;
		} else if (!worldIn.isRemote) {
			int id = GuiLoader.GUI_CRUSHINGGRINDINGMACHINE;
			playerIn.openGui(CbCraft.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

}
