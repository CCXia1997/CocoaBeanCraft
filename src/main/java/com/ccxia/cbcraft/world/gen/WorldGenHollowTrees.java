package com.ccxia.cbcraft.world.gen;

import java.util.Random;

import com.ccxia.cbcraft.block.BlockHollowChocolateLog;
import com.ccxia.cbcraft.block.ModBlocks;

import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenHollowTrees extends WorldGenAbstractTree {

	// 配置空心树木的方块朝向
	private static final IBlockState LOG = ModBlocks.HOLLOW_CHOCOLATE_LOG.getDefaultState()
			.withProperty(BlockHollowChocolateLog.LOG_AXIS, BlockLog.EnumAxis.Y);
	private static final IBlockState LEAF = ModBlocks.HOLLOW_CHOCOLATE_LEAVES.getDefaultState()
			.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
	private final boolean useExtraRandomHeight;

	public WorldGenHollowTrees(boolean notify, boolean useExtraRandomHeightIn) {
		super(notify);
		this.useExtraRandomHeight = useExtraRandomHeightIn;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		// 这边可以规定树的高度范围
		int i = rand.nextInt(3) + 5;

		if (this.useExtraRandomHeight) {
			i += rand.nextInt(7);
		}

		boolean flag = true;

		if (position.getY() >= 1 && position.getY() + i + 1 <= 256) {
			for (int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
				int k = 1;

				if (j == position.getY()) {
					k = 0;
				}

				if (j >= position.getY() + 1 + i - 2) {
					k = 2;
				}

				BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

				for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
					for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
						if (j >= 0 && j < worldIn.getHeight()) {
							if (!this.isReplaceable(worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}

			if (!flag) {
				return false;
			} else {
				BlockPos down = position.down();
				IBlockState state = worldIn.getBlockState(down);
				boolean isSoil = state.getBlock() == ModBlocks.TIRAMISU_BLOCK;

				if (isSoil && position.getY() < worldIn.getHeight() - i - 1) {
					state.getBlock().onPlantGrow(state, worldIn, down, position);

					for (int i2 = position.getY() - 3 + i; i2 <= position.getY() + i; ++i2) {
						int k2 = i2 - (position.getY() + i);
						int l2 = 1 - k2 / 2;

						for (int i3 = position.getX() - l2; i3 <= position.getX() + l2; ++i3) {
							int j1 = i3 - position.getX();

							for (int k1 = position.getZ() - l2; k1 <= position.getZ() + l2; ++k1) {
								int l1 = k1 - position.getZ();

								if (Math.abs(j1) != l2 || Math.abs(l1) != l2 || rand.nextInt(2) != 0 && k2 != 0) {
									BlockPos blockpos = new BlockPos(i3, i2, k1);
									IBlockState state2 = worldIn.getBlockState(blockpos);

									if (state2.getBlock().isAir(state2, worldIn, blockpos)
											|| state2.getBlock().isAir(state2, worldIn, blockpos)) {
										this.setBlockAndNotifyAdequately(worldIn, blockpos, LEAF);
									}
								}
							}
						}
					}

					for (int j2 = 0; j2 < i; ++j2) {
						BlockPos upN = position.up(j2);
						IBlockState state2 = worldIn.getBlockState(upN);

						if (state2.getBlock().isAir(state2, worldIn, upN)
								|| state2.getBlock().isLeaves(state2, worldIn, upN)) {
							this.setBlockAndNotifyAdequately(worldIn, position.up(j2), LOG);
						}
					}

					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
}
