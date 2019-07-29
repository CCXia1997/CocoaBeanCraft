package com.ccxia.cbcraft.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityInjectionTable extends TileEntity implements ITickable {
    public int tickCount;

    public TileEntityInjectionTable() {
    }

    //这里只负责为旋转计数，真正的操作在渲染类里
    @Override
    public void update() {
        ++this.tickCount;
    }
}
