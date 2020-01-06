package com.ccxia.cbcraft.world;

import com.ccxia.cbcraft.block.ModBlocks;

import it.unimi.dsi.fastutil.objects.ObjectIterator;

import com.ccxia.cbcraft.block.BlockPortalCocoa;

import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterCocoa extends Teleporter {
	public TeleporterCocoa(WorldServer p_i1963_1_) {
		super(p_i1963_1_);
	}

	@Override
	public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
		return false;
	}

	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) {
		// 只允许主世界和巧克力世界的互通
		if (this.world.provider.getDimensionType().getId() != 1
				&& this.world.provider.getDimensionType().getId() != -1) {
			if (!this.placeInExistingPortal(entityIn, rotationYaw)) {
				this.makePortal(entityIn);
				this.placeInExistingPortal(entityIn, rotationYaw);
			}
		} else {
			int i = MathHelper.floor(entityIn.posX);
			int j = MathHelper.floor(entityIn.posY) - 1;
			int k = MathHelper.floor(entityIn.posZ);
			int l = 1;
			int i1 = 0;

			for (int j1 = -2; j1 <= 2; ++j1) {
				for (int k1 = -2; k1 <= 2; ++k1) {
					for (int l1 = -1; l1 < 3; ++l1) {
						int i2 = i + k1 * 1 + j1 * 0;
						int j2 = j + l1;
						int k2 = k + k1 * 0 - j1 * 1;
						boolean flag = l1 < 0;
						this.world.setBlockState(new BlockPos(i2, j2, k2),
								flag ? ModBlocks.INJECTED_WHITE_CHOCOLATE.getDefaultState()
										: Blocks.AIR.getDefaultState());
					}
				}
			}

			entityIn.setLocationAndAngles((double) i, (double) j, (double) k, entityIn.rotationYaw, 0.0F);
			entityIn.motionX = 0.0D;
			entityIn.motionY = 0.0D;
			entityIn.motionZ = 0.0D;
		}
	}

	@Override
	public boolean makePortal(Entity entityIn) {
		return false;
	}

	@Override
	public void removeStalePortalLocations(long worldTime) {

	}
}
