package com.ccxia.cbcraft.tileentity;

import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.inventory.crafting.RecipesInjection;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityInjectionTable extends TileEntity implements ITickable {
	public int tickCount;
	// 0表示普通，1表示进阶
	private int level;

	public TileEntityInjectionTable() {
	}

	// 这里只负责为旋转计数，真正的操作在渲染类里
	@Override
	public void update() {
		++this.tickCount;
		// 设置成跟信标一样4s判断一下等级
		if (this.world.getTotalWorldTime() % 80L == 0L) {
			this.calcuteLevel();
		}
	}

	// 判断一下注魔台的等级，返回值表示等级是否发生了改变
	public void calcuteLevel() {
		int oldLevel = this.level;
		int x1 = this.pos.getX();
		int y1 = this.pos.getY();
		int z1 = this.pos.getZ();
		for (int i = x1 - 1; i <= x1 + 1; i++) {
			for (int j = z1 - 1; j <= z1 + 1; j++) {
				if (this.world.getBlockState(new BlockPos(i, y1 - 1, j)).getBlock() != ModBlocks.COCOA_SPAR_BLOCK) {
					this.level = 0;
					return;
					// return this.level == oldLevel;
				}
			}
		}
		this.level = 1;
		// return this.level == oldLevel;
	}

	public int getLevel() {
		return this.level;
	}
}
