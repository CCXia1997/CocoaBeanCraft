package com.ccxia.cbcraft.block;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockDarkChocolateSlab extends BlockSlab {
	public static final PropertyEnum<BlockDarkChocolateSlab.Variant> VARIANT = PropertyEnum.<BlockDarkChocolateSlab.Variant>create(
			"variant", BlockDarkChocolateSlab.Variant.class);
	public int index;

	public BlockDarkChocolateSlab() {
		super(Material.ROCK, MapColor.MAGENTA);
		IBlockState iblockstate = this.blockState.getBaseState();

		if (!this.isDouble()) {
			iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
		}

		this.setDefaultState(iblockstate.withProperty(VARIANT, BlockDarkChocolateSlab.Variant.DEFAULT));
		this.setHardness(1.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.useNeighborBrightness = !this.isDouble();
		// this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		switch (this.index) {
		case 0:
			return Item.getItemFromBlock(ModBlocks.DARK_CHOCOLATE_SLAB);
		case 1:
			return Item.getItemFromBlock(ModBlocks.DARK_CHOCOLATE_SLAB);
		case 2:
			return Item.getItemFromBlock(ModBlocks.MILK_CHOCOLATE_SLAB);
		case 3:
			return Item.getItemFromBlock(ModBlocks.MILK_CHOCOLATE_SLAB);
		case 4:
			return Item.getItemFromBlock(ModBlocks.WHITE_CHOCOLATE_SLAB);
		case 5:
			return Item.getItemFromBlock(ModBlocks.WHITE_CHOCOLATE_SLAB);
		default:
			return Items.AIR;
		}
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		switch (this.index) {
		case 0:
			return new ItemStack(ModBlocks.DARK_CHOCOLATE_SLAB);
		case 1:
			return new ItemStack(ModBlocks.DARK_CHOCOLATE_SLAB);
		case 2:
			return new ItemStack(ModBlocks.MILK_CHOCOLATE_SLAB);
		case 3:
			return new ItemStack(ModBlocks.MILK_CHOCOLATE_SLAB);
		case 4:
			return new ItemStack(ModBlocks.WHITE_CHOCOLATE_SLAB);
		case 5:
			return new ItemStack(ModBlocks.WHITE_CHOCOLATE_SLAB);
		default:
			return ItemStack.EMPTY;
		}
	}

	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockDarkChocolateSlab.Variant.DEFAULT);

		if (!this.isDouble()) {
			iblockstate = iblockstate.withProperty(HALF,
					(meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
		}

		return iblockstate;
	}

	public int getMetaFromState(IBlockState state) {
		int i = 0;

		if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
			i |= 8;
		}

		return i;
	}

	protected BlockStateContainer createBlockState() {
		return this.isDouble() ? new BlockStateContainer(this, new IProperty[] { VARIANT })
				: new BlockStateContainer(this, new IProperty[] { HALF, VARIANT });
	}

	public String getUnlocalizedName(int meta) {
		return super.getUnlocalizedName();
	}

	public IProperty<?> getVariantProperty() {
		return VARIANT;
	}

	public Comparable<?> getTypeForItem(ItemStack stack) {
		return BlockDarkChocolateSlab.Variant.DEFAULT;
	}

	public Block setIndex(int index) {
		this.index = index;
		return this;
	}

	public static class Double extends BlockDarkChocolateSlab {

		public boolean isDouble() {
			return true;
		}
	}

	public static class Half extends BlockDarkChocolateSlab {

		public boolean isDouble() {
			return false;
		}
	}

	public static enum Variant implements IStringSerializable {
		DEFAULT;

		public String getName() {
			return "default";
		}
	}
}
