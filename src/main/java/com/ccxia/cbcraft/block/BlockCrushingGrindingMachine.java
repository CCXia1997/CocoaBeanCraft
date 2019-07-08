package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.inventory.ContainerCrushingGrindingMachine;
import com.ccxia.cbcraft.inventory.GuiLoader;
import com.ccxia.cbcraft.tileentity.TileEntityCrushingGrindingMachine;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BlockCrushingGrindingMachine extends Block {

	public BlockCrushingGrindingMachine() {
		super(Material.ROCK);
		this.setUnlocalizedName(CbCraft.MODID + ".crushingGrindingMachine");
		this.setRegistryName("crushing_grinding_machine");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(3.5F);
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	// 不起作用
	public void breakBlock1(World worldIn, BlockPos pos, IBlockState state) {
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

	public static class InterfaceCraftingTable implements IInteractionObject {
		private final World world;
		private final BlockPos position;

		public InterfaceCraftingTable(World worldIn, BlockPos pos) {
			this.world = worldIn;
			this.position = pos;
		}

		/**
		 * Get the name of this object. For players this returns their username
		 */
		public String getName() {
			return "crushing_grinding_machine";
		}

		/**
		 * Returns true if this thing is named
		 */
		public boolean hasCustomName() {
			return false;
		}

		/**
		 * Get the formatted ChatComponent that will be used for the sender's username
		 * in chat
		 */
		public ITextComponent getDisplayName() {
			return new TextComponentTranslation(Blocks.CRAFTING_TABLE.getUnlocalizedName() + ".name", new Object[0]);
		}

		public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
			return new ContainerCrushingGrindingMachine(playerInventory, this.world, this.position);
		}

		public String getGuiID() {
			return "cbcraft:crushing_grinding_machine";
		}
	}
}
