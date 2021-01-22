package com.ccxia.cbcraft.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.ccxia.cbcraft.block.BlockFermentationBaker;
import com.ccxia.cbcraft.inventory.ContainerFermentationBaker;
import com.ccxia.cbcraft.item.ModItems;
import com.ccxia.cbcraft.tileentity.crafting.CraftingFermentationBaker;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class TileEntityFermentationBaker extends TileEntity implements ITickable {
    private static final int[] SLOTS_TOP = new int[]{0};
    private static final int[] SLOTS_BOTTOM = new int[]{3};
    private static final int[] SLOTS_SIDES1 = new int[]{1};
    private static final int[] SLOTS_SIDES2 = new int[]{2};

    // 创建4个物品槽位，上方为主料，左右两侧为辅料，后侧（暂且也包括正面）为燃料，下方为成品导出
    protected ItemStackHandler upInventory = new ItemStackHandler();
    protected ItemStackHandler sideInventory = new ItemStackHandler();
    protected ItemStackHandler backInventory = new ItemStackHandler();
    protected ItemStackHandler downInventory = new ItemStackHandler();

    // 描述容器内物品的一个集合
    private NonNullList<ItemStack> ferbakerItemStacks = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);

    private int furnaceBurnTime;
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    // 这个方法用于确定方块的六个面和物品槽位的对应关系
    // 这段代码逻辑写复杂了，要重写
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {
            // return your IItemHandler
            @SuppressWarnings("unchecked")
            EnumFacing blockfacing = (EnumFacing) this.world.getBlockState(this.pos).getValue(BlockHorizontal.FACING);
            if (facing == EnumFacing.UP)
                return (T) upInventory;
            if (facing == EnumFacing.DOWN)
                return (T) downInventory;
            if (blockfacing == EnumFacing.NORTH || blockfacing == EnumFacing.SOUTH) {
                if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH)
                    return (T) backInventory;
                else if (facing == EnumFacing.WEST || facing == EnumFacing.EAST)
                    return (T) sideInventory;
            }
            if (blockfacing == EnumFacing.WEST || blockfacing == EnumFacing.EAST) {
                if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH)
                    return (T) sideInventory;
                else if (facing == EnumFacing.WEST || facing == EnumFacing.EAST)
                    return (T) backInventory;
            }
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void update() {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning()) {
            --this.furnaceBurnTime;
        }

        if (!this.world.isRemote) {
            ItemStack itemstack = this.backInventory.getStackInSlot(0);
            if (this.isBurning()
                    || !itemstack.isEmpty() && !((ItemStack) this.upInventory.getStackInSlot(0)).isEmpty()) {
                if (!this.isBurning() && this.canSmelt()) {
                    this.furnaceBurnTime = getItemBurnTime(itemstack);
                    this.currentItemBurnTime = this.furnaceBurnTime;
                    if (this.isBurning()) {
                        flag1 = true;

                        if (!itemstack.isEmpty()) {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);

                            if (itemstack.isEmpty()) {
                                ItemStack item1 = item.getContainerItem(itemstack);
                                this.backInventory.setStackInSlot(0, item1);
                            }
                        }
                    }
                }
                // 这一部分判定为正式进入烧炼过程
                if (this.isBurning() && this.canSmelt()) {
                    this.totalCookTime = this.getCookTime(this.upInventory.getStackInSlot(0));
                    ++this.cookTime;
                    // 当烧炼时间到时执行转换操作
                    if (this.cookTime == this.totalCookTime) {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.upInventory.getStackInSlot(0));
                        this.smeltItem();
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            } else if (!this.isBurning() && this.cookTime > 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (flag != this.isBurning()) {
                flag1 = true;
                BlockFermentationBaker.setState(this.isBurning(), this.world, this.pos);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    public int getSizeInventory() {
        return ferbakerItemStacks.size();
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public ItemStackHandler getUpInventory() {
        return this.upInventory;
    }

    public ItemStackHandler getSideInventory() {
        return this.sideInventory;
    }

    public ItemStackHandler getBackInventory() {
        return this.backInventory;
    }

    public ItemStackHandler getDownInventory() {
        return this.downInventory;
    }

    public int getCookTime(ItemStack stack) {
        return 200;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    private boolean canSmelt() {
        // 主料为空直接返回false
        if (upInventory.getStackInSlot(0).isEmpty()) {
            return false;
        }
        List<ItemStack> list = new ArrayList<ItemStack>();
        ItemStack itemStack1 = upInventory.extractItem(0, 1, true);
        ItemStack itemStack2 = sideInventory.extractItem(0, 1, true);
        ItemStack itemStack3 = downInventory.getStackInSlot(0);
        // 辅料如果为空只取主料
        if (itemStack2 == ItemStack.EMPTY) {
            list.add(itemStack1);
        } else {
            list.add(itemStack1);
            list.add(itemStack2);
        }
        ItemStack itemStack4 = CraftingFermentationBaker.instance().getSmeltItems(list);
        if (itemStack4 != ItemStack.EMPTY) {
            if (itemStack3.isEmpty()) {
                return true;
            } else if (!itemStack3.isItemEqual(itemStack4)) {
                return false;
            } else if (itemStack3.getCount() + itemStack4.getCount() <= this.getInventoryStackLimit()
                    && itemStack3.getCount() + itemStack4.getCount() <= itemStack3.getMaxStackSize()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemStack1 = upInventory.extractItem(0, 1, true);
            ItemStack itemStack2 = sideInventory.extractItem(0, 1, true);
            List<ItemStack> list = new ArrayList<ItemStack>();
            list.add(itemStack1);
            list.add(itemStack2);
            ItemStack itemStack3 = CraftingFermentationBaker.instance().getSmeltItems(list);
            if (itemStack3 != ItemStack.EMPTY) {
                upInventory.extractItem(0, 1, false);
                sideInventory.extractItem(0, 1, false);
                downInventory.insertItem(0, itemStack3.copy(), false);
                return;
            }
            list.clear();
            list.add(itemStack1);
            ItemStack itemStack4 = CraftingFermentationBaker.instance().getSmeltItems(list);
            if (itemStack4 != ItemStack.EMPTY) {
                upInventory.extractItem(0, 1, false);
                downInventory.insertItem(0, itemStack4.copy(), false);
                // 脱脂奶->奶酪返还空桶
                if (itemStack1.isItemEqual(new ItemStack(ModItems.SKIM_MILK))) {
                    upInventory.insertItem(0, new ItemStack(Items.BUCKET), false);
                }
                return;
            }
        }
    }

    public static int getItemBurnTime(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack);
            if (burnTime >= 0)
                return burnTime;
            Item item = stack.getItem();

            if (item == Item.getItemFromBlock(Blocks.WOODEN_SLAB)) {
                return 150;
            } else if (item == Item.getItemFromBlock(Blocks.WOOL)) {
                return 100;
            } else if (item == Item.getItemFromBlock(Blocks.CARPET)) {
                return 67;
            } else if (item == Item.getItemFromBlock(Blocks.LADDER)) {
                return 300;
            } else if (item == Item.getItemFromBlock(Blocks.WOODEN_BUTTON)) {
                return 100;
            } else if (Block.getBlockFromItem(item).getDefaultState().getMaterial() == Material.WOOD) {
                return 300;
            } else if (item == Item.getItemFromBlock(Blocks.COAL_BLOCK)) {
                return 16000;
            } else if (item instanceof ItemTool && "WOOD".equals(((ItemTool) item).getToolMaterialName())) {
                return 200;
            } else if (item instanceof ItemSword && "WOOD".equals(((ItemSword) item).getToolMaterialName())) {
                return 200;
            } else if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe) item).getMaterialName())) {
                return 200;
            } else if (item == Items.STICK) {
                return 100;
            } else if (item != Items.BOW && item != Items.FISHING_ROD) {
                if (item == Items.SIGN) {
                    return 200;
                } else if (item == Items.COAL) {
                    return 1600;
                } else if (item == Items.LAVA_BUCKET) {
                    return 20000;
                } else if (item != Item.getItemFromBlock(Blocks.SAPLING) && item != Items.BOWL) {
                    if (item == Items.BLAZE_ROD) {
                        return 2400;
                    } else if (item instanceof ItemDoor && item != Items.IRON_DOOR) {
                        return 200;
                    } else {
                        return item instanceof ItemBoat ? 400 : 0;
                    }
                } else {
                    return 100;
                }
            } else {
                return 300;
            }
        }
    }

    public static boolean isItemFuel(ItemStack stack) {
        return getItemBurnTime(stack) > 0;
    }

    public int getTime(int index) {
        switch (index) {
            case 0:
                return this.furnaceBurnTime;
            case 1:
                return this.currentItemBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }


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
        cmp.setTag("SideInventory", this.sideInventory.serializeNBT());
        cmp.setTag("BackInventory", this.backInventory.serializeNBT());
        cmp.setInteger("FurnaceBurnTime", this.furnaceBurnTime);
        cmp.setInteger("CurrentItemBurnTime", this.currentItemBurnTime);
        cmp.setInteger("CookTime", this.cookTime);
        cmp.setInteger("TotalCookTime", this.totalCookTime);
    }

    public void readPacketNBT(NBTTagCompound cmp) {
        this.upInventory.deserializeNBT(cmp.getCompoundTag("UpInventory"));
        this.downInventory.deserializeNBT(cmp.getCompoundTag("DownInventory"));
        this.sideInventory.deserializeNBT(cmp.getCompoundTag("SideInventory"));
        this.backInventory.deserializeNBT(cmp.getCompoundTag("BackInventory"));
        this.furnaceBurnTime = cmp.getInteger("FurnaceBurnTime");
        this.currentItemBurnTime = cmp.getInteger("CurrentItemBurnTime");
        this.cookTime = cmp.getInteger("CookTime");
        this.totalCookTime = cmp.getInteger("TotalCookTime");
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


    /*
     * 以下为实现ISidedInventory中的方法
     *
     * @Override public boolean isEmpty() { for (ItemStack itemstack :
     * this.ferbakerItemStacks) { if (!itemstack.isEmpty()) { return false; } }
     *
     * return true; }
     *
     * @Override public ItemStack getStackInSlot(int index) { return
     * this.ferbakerItemStacks.get(index); }
     *
     * @Override public ItemStack decrStackSize(int index, int count) { return
     * ItemStackHelper.getAndSplit(this.ferbakerItemStacks, index, count); }
     *
     * @Override public ItemStack removeStackFromSlot(int index) { return
     * ItemStackHelper.getAndRemove(this.ferbakerItemStacks, index); }
     *
     * @Override public void setInventorySlotContents(int index, ItemStack stack) {
     *
     * }
     *
     * @Override public boolean isUsableByPlayer(EntityPlayer player) { if
     * (this.world.getTileEntity(this.pos) != this) { return false; } else { return
     * player.getDistanceSq((double) this.pos.getX() + 0.5D, (double)
     * this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D; } }
     *
     * @Override public void openInventory(EntityPlayer player) {
     *
     * }
     *
     * @Override public void closeInventory(EntityPlayer player) {
     *
     * }
     *
     * @Override public boolean isItemValidForSlot(int index, ItemStack stack) { if
     * (index == 3) { return false; } else { return true; } }
     *
     * @Override public int getField(int id) { switch (id) { case 0: return
     * this.furnaceBurnTime; case 1: return this.currentItemBurnTime; case 2: return
     * this.cookTime; case 3: return this.totalCookTime; default: return 0; } }
     *
     * @Override public void setField(int id, int value) { switch (id) { case 0:
     * this.furnaceBurnTime = value; break; case 1: this.currentItemBurnTime =
     * value; break; case 2: this.cookTime = value; break; case 3:
     * this.totalCookTime = value; } }
     *
     * @Override public int getFieldCount() { return 4; }
     *
     * @Override public void clear() { this.ferbakerItemStacks.clear(); }
     *
     * @Override public String getName() { // TODO Auto-generated method stub return
     * null; }
     *
     * @Override public boolean hasCustomName() { // TODO Auto-generated method stub
     * return false; }
     *
     * @Override public int[] getSlotsForFace(EnumFacing side) { if (side ==
     * EnumFacing.UP) { return SLOTS_TOP; } else if (side == EnumFacing.DOWN) {
     * return SLOTS_BOTTOM; } else { EnumFacing blockfacing = (EnumFacing)
     * this.world.getBlockState(this.pos).getValue(BlockHorizontal.FACING); if
     * (blockfacing == side || blockfacing == side.getOpposite()) { return
     * SLOTS_SIDES2; } else { return SLOTS_SIDES1; } } }
     *
     * @Override public boolean canInsertItem(int index, ItemStack itemStackIn,
     * EnumFacing direction) { return this.isItemValidForSlot(index, itemStackIn); }
     *
     * @Override public boolean canExtractItem(int index, ItemStack stack,
     * EnumFacing direction) { if (direction == EnumFacing.DOWN && index == 2) {
     * Item item = stack.getItem();
     *
     * if (item != Items.WATER_BUCKET && item != Items.BUCKET) { return false; } }
     *
     * return true; }
     *
     * public Container createContainer(InventoryPlayer playerInventory,
     * EntityPlayer playerIn) { return new ContainerFermentationBaker(playerIn,
     * this); }
     */
}
