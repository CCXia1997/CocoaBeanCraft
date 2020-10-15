package com.ccxia.cbcraft.block;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.inventory.GuiLoader;
import com.ccxia.cbcraft.tileentity.TileEntityAutoCrushing;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BlockAutoCrushing extends BlockContainer {
	private static boolean keepInventory;

	public BlockAutoCrushing() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".autoCrushingGrindingMachine");
		this.setRegistryName("auto_crushing_grinding_machine");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(3.5F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityAutoCrushing();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.AUTO_CRUSHING_GRINDING_MACHINE);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!playerIn.capabilities.allowEdit) {
			return false;
		} else if (!worldIn.isRemote) {
			int id = GuiLoader.GUI_AUTO_CRUSHING;
			playerIn.openGui(CbCraft.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityAutoCrushing te = (TileEntityAutoCrushing) worldIn.getTileEntity(pos);
		IItemHandler up = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
		IItemHandler side = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		IItemHandler down = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
		if (!keepInventory) {
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
			for (int i = down.getSlots() - 1; i >= 0; --i) {
				if (down.getStackInSlot(i) != null) {
					Block.spawnAsEntity(worldIn, pos, down.getStackInSlot(i));
					((IItemHandlerModifiable) down).setStackInSlot(i, ItemStack.EMPTY);
				}
			}
		}
	}
}
