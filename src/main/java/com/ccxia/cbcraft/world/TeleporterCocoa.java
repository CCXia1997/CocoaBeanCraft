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
		int i = MathHelper.floor(entityIn.posX);
		int k = MathHelper.floor(entityIn.posZ);
		if (this.world.provider.getDimensionType().getId() != 1
				&& this.world.provider.getDimensionType().getId() != -1) {
			entityIn.setLocationAndAngles((double) i, this.world.getTopSolidOrLiquidBlock(new BlockPos(i, 0, k)).getY(),
					(double) k, entityIn.rotationYaw, 0.0F);
		}
		entityIn.motionX = 0.0D;
		entityIn.motionY = 0.0D;
		entityIn.motionZ = 0.0D;
	}

	@Override
	public boolean makePortal(Entity entityIn) {
		return false;
	}

	@Override
	public void removeStalePortalLocations(long worldTime) {
		if (worldTime % 100L == 0L) {
			long i = worldTime - 300L;
			ObjectIterator<TeleporterCocoa.PortalPosition> objectiterator = this.destinationCoordinateCache.values()
					.iterator();

			while (objectiterator.hasNext()) {
				TeleporterCocoa.PortalPosition teleporter$portalposition = (TeleporterCocoa.PortalPosition) objectiterator
						.next();

				if (teleporter$portalposition == null || teleporter$portalposition.lastUpdateTime < i) {
					objectiterator.remove();
				}
			}
		}
	}
}
