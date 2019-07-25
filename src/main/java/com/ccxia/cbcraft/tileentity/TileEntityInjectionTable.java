package com.ccxia.cbcraft.tileentity;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.inventory.ContainerInjectionTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

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
