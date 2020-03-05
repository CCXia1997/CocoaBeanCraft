package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.BlockCake;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockChocolateCake extends BlockCake {
	public BlockChocolateCake() {
		super();
		this.setUnlocalizedName(CbCraft.MODID + ".chocolateCake");
		this.setRegistryName("chocolate_cake");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.CLOTH);
	}

	private boolean canBlockStay(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			return this.eatCake(worldIn, pos, state, playerIn);
		} else {
			ItemStack itemstack = playerIn.getHeldItem(hand);
			return this.eatCake(worldIn, pos, state, playerIn) || itemstack.isEmpty();
		}
	}

	private boolean eatCake(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (!player.canEat(false)) {
			return false;
		} else {
			player.addStat(StatList.CAKE_SLICES_EATEN);
			player.getFoodStats().addStats(4, 0.25F);
			int i = ((Integer) state.getValue(BITES)).intValue();

			if (i < 6) {
				worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 3);
			} else {
				worldIn.setBlockToAir(pos);
			}
			return true;
		}
	}

	// 放置巧克力方块时判断是否可以生成传送门
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		// 主世界<-->巧克力世界
		if (Math.abs(worldIn.provider.getDimensionType().getId()) != 1
				&& !((BlockPortalCocoa) (ModBlocks.COCOA_PORTAL_BLOCK)).trySpawnPortal(worldIn, pos)) {
			if (!worldIn.getBlockState(pos.down()).isTopSolid()) {
				// worldIn.setBlockToAir(pos);
			} else {
				// worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) +
				// worldIn.rand.nextInt(10));
			}
		}
	}
}
