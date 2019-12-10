package com.ccxia.cbcraft.block;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockCocoaSparOre extends BlockOre {
	public BlockCocoaSparOre() {
		super();
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaSparOre");
		this.setRegistryName("cocoa_spar_ore");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(3.0F);
		this.setSoundType(SoundType.STONE);
		// 设计成与原版钻石矿相近，只能使用钻石镐挖掘才能掉落物品
		this.setHarvestLevel("pickaxe", 3);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.COCOA_SPAR;
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		return MathHelper.getInt(rand, 3, 7);
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this);
	}
}
