package com.ccxia.cbcraft.tileentity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ccxia.cbcraft.item.ModItems;
import com.ccxia.cbcraft.tileentity.crafting.CraftingAutoPressing;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class TileEntityAutoPressing extends TileEntity implements ITickable {

    // 上方和侧边原料，下方成品
    protected ItemStackHandler upInventory = new ItemStackHandler();
    // protected ItemStackHandler sideInventory = new ItemStackHandler();
    protected ItemStackHandler downInventory = new ItemStackHandler();

    // 可可能量条
    // private int cocoaPower;
    // 压合时间
    private int pressTime;

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {
            @SuppressWarnings("unchecked")
            T result = (T) (facing == EnumFacing.DOWN ? downInventory : upInventory);
            return result;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void update() {
        if (!this.world.isRemote) {
            // 工作逻辑
            if (!CraftingAutoPressing.instance().getResult(this.upInventory.getStackInSlot(0)).resultItem.isEmpty()) {
                CraftingAutoPressing.ResultPack result = CraftingAutoPressing.instance()
                        .getResult(this.upInventory.getStackInSlot(0));
                ItemStack itemStack = result.resultItem;
                if ((itemStack.isItemEqual(this.downInventory.getStackInSlot(0))
                        && (this.downInventory.getStackInSlot(0).getCount() + itemStack.getCount() <= itemStack
                        .getMaxStackSize()))
                        || (this.downInventory.getStackInSlot(0).isEmpty())) {
                    if (++this.pressTime == 8) {
                        this.upInventory.extractItem(0, result.itemCost, false);
                        this.downInventory.insertItem(0, itemStack.copy(), false);
                        this.pressTime = 0;
                        this.markDirty();
                    }
                } else {
                    this.pressTime = 0;
                    this.markDirty();
                }
            } else {
                this.pressTime = 0;
                this.markDirty();
            }
        }
    }

    public int getPressTime() {
        return this.pressTime;
    }

    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        return oldState.getBlock() != newState.getBlock();
    }


    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound par1nbtTagCompound) {
        NBTTagCompound ret = super.writeToNBT(par1nbtTagCompound);
        writePacketNBT(ret);
        return ret;
    }

    @Nonnull
    @Override
    public final NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
        super.readFromNBT(par1nbtTagCompound);
        readPacketNBT(par1nbtTagCompound);
    }

    public void writePacketNBT(NBTTagCompound cmp) {
        cmp.setTag("UpInventory", this.upInventory.serializeNBT());
        cmp.setTag("DownInventory", this.downInventory.serializeNBT());
        cmp.setInteger("PressTime", this.pressTime);
    }

    public void readPacketNBT(NBTTagCompound cmp) {
        this.upInventory.deserializeNBT(cmp.getCompoundTag("UpInventory"));
        this.downInventory.deserializeNBT(cmp.getCompoundTag("DownInventory"));
        this.pressTime = cmp.getInteger("PressTime");
    }

    @Override
    public final SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writePacketNBT(tag);
        return new SPacketUpdateTileEntity(pos, -999, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        super.onDataPacket(net, packet);
        readPacketNBT(packet.getNbtCompound());
    }

}
