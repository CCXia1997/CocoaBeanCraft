package com.ccxia.cbcraft.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityInjectionTable extends TileEntity implements ITickable {
    public int tickCount;

    public TileEntityInjectionTable() {
    }

    //����ֻ����Ϊ��ת�����������Ĳ�������Ⱦ����
    @Override
    public void update() {
        ++this.tickCount;
    }
}
