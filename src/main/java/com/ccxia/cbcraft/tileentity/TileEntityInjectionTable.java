package com.ccxia.cbcraft.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntityInjectionTable extends TileEntity implements ITickable {
    public int tickCount;

    //这里只负责为旋转计数，真正的操作在渲染类里
    @Override
    public void update() {
        ++this.tickCount;
    }

    public ITextComponent getDisplayName() {
        return new TextComponentTranslation("container.injection_table", new Object[0]);
    }
}
