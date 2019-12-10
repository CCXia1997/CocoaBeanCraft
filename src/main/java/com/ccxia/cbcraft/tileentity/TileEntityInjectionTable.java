package com.ccxia.cbcraft.tileentity;

import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.inventory.crafting.RecipesInjection;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityInjectionTable extends TileEntity implements ITickable {
	public int tickCount;
	// 0��ʾ��ͨ��1��ʾ����
	private int level;

	public TileEntityInjectionTable() {
	}

	// ����ֻ����Ϊ��ת�����������Ĳ�������Ⱦ����
	@Override
	public void update() {
		++this.tickCount;
		// ���óɸ��ű�һ��4s�ж�һ�µȼ�
		if (this.world.getTotalWorldTime() % 80L == 0L) {
			this.calcuteLevel();
		}
	}

	// �ж�һ��עħ̨�ĵȼ�������ֵ��ʾ�ȼ��Ƿ����˸ı�
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
