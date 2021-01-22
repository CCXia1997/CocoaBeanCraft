package com.ccxia.cbcraft.tileentity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class TileEntityAutoCrushing extends TileEntity implements ITickable {
    // �Ϸ��Ͳ��ԭ�ϣ��·���Ʒ
    protected ItemStackHandler upInventory = new ItemStackHandler();
    // protected ItemStackHandler sideInventory = new ItemStackHandler();
    protected ItemStackHandler downInventory = new ItemStackHandler();

    // �ɿ�������
    // private int cocoaPower;
    // ��ĥʱ��
    private int crushTime;
    // �����б�
    Map<ItemStack, ItemStack> workList = new HashMap<ItemStack, ItemStack>();

    // ��ʼ�������б�
    public TileEntityAutoCrushing() {
        // 1��ɿɶ�->1�ɿɸ�
        workList.put(new ItemStack(ModItems.COOKED_COCOA_BEANS), new ItemStack(ModItems.COCOA_PASTE, 1));
        // 1ɰ��->1��ʯ
        workList.put(new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)), new ItemStack(Items.FLINT, 1));
        // 1�������->6������
        workList.put(new ItemStack(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK)),
                new ItemStack(Items.NETHER_WART, 6));
        // 1ʯӢ��->2ʯӢ
        workList.put(new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK)), new ItemStack(Items.QUARTZ, 2));
        // 1�����->4�����
        workList.put(new ItemStack(Item.getItemFromBlock(Blocks.CLAY)), new ItemStack(Items.CLAY_BALL, 4));
        // 1���Ͽ�->6����
        workList.put(new ItemStack(Item.getItemFromBlock(Blocks.MELON_BLOCK)), new ItemStack(Items.MELON, 6));
        // 1�ҽ���->2�ҽ���
        workList.put(new ItemStack(Item.getItemFromBlock(Blocks.MAGMA)), new ItemStack(Items.MAGMA_CREAM, 2));
        // 1�����->3�����
        workList.put(new ItemStack(Items.BLAZE_ROD), new ItemStack(Items.BLAZE_POWDER, 3));
        // 1��ͷ->4�Ƿ�
        workList.put(new ItemStack(Items.BONE), new ItemStack(Items.DYE, 4, 15));
        // 1С��->1���
        workList.put(new ItemStack(Items.WHEAT), new ItemStack(ModItems.FLOUR, 1));
        // 1����->1�����
        workList.put(new ItemStack(Item.getItemFromBlock(Blocks.DIRT)), new ItemStack(Items.CLAY_BALL));

    }

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
            // �����߼�
            if (!this.getResult(this.upInventory.getStackInSlot(0)).isEmpty()) {
                ItemStack itemStack = this.getResult(this.upInventory.getStackInSlot(0));
                if ((itemStack.isItemEqual(this.downInventory.getStackInSlot(0))
                        && (this.downInventory.getStackInSlot(0).getCount() + itemStack.getCount() <= itemStack
                        .getMaxStackSize()))
                        || (this.downInventory.getStackInSlot(0).isEmpty())) {
                    if (++this.crushTime == 8) {
                        this.upInventory.extractItem(0, 1, false);
                        this.downInventory.insertItem(0, itemStack.copy(), false);
                        this.crushTime = 0;
                        this.markDirty();
                    }
                } else {
                    this.crushTime = 0;
                    this.markDirty();
                }
            } else {
                this.crushTime = 0;
                this.markDirty();
            }
        }
    }

    private ItemStack getResult(ItemStack itemStack) {
        for (Entry<ItemStack, ItemStack> entry : this.workList.entrySet()) {
            if (itemStack.isItemEqual(entry.getKey())) {
                return entry.getValue();
            }
        }
        return ItemStack.EMPTY;
    }

    public int getCrushTime() {
        return this.crushTime;
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
        cmp.setInteger("CrushTime", this.crushTime);
    }

    public void readPacketNBT(NBTTagCompound cmp) {
        this.upInventory.deserializeNBT(cmp.getCompoundTag("UpInventory"));
        this.downInventory.deserializeNBT(cmp.getCompoundTag("DownInventory"));
        this.crushTime = cmp.getInteger("CrushTime");
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
