package com.ccxia.cbcraft.inventory;

import com.ccxia.cbcraft.CbCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

import static com.ccxia.cbcraft.block.ModBlocks.INJECTION_TABLE;
import static com.ccxia.cbcraft.inventory.crafting.RecipesInjection.INJECTION_MANAGER;
import static com.ccxia.cbcraft.item.ModItems.COCOA_POWDER;

public class ContainerInjectionTable extends Container {
    private final World world;
    private final BlockPos blockPos;
    private final EntityPlayer player;
    private final IInventory outputSlot;
    private final IInventory inputSlot;
    private final IInventory powderSlot;
    protected int cost;
    protected boolean notEnoughPowder;
    protected boolean notEnoughLevels;

    public ContainerInjectionTable(InventoryPlayer playerInventory, World world, BlockPos blockPos, EntityPlayer player) {
        this.world = world;
        this.blockPos = blockPos;
        this.player = player;

        /** markDirty() 的时候顺便通知一下格子改变了，需要处理一下 **/
        this.powderSlot = new InventoryBasic("Powder", true, 1) {
            @Override
            public void markDirty() {
                super.markDirty();
                ContainerInjectionTable.this.onCraftMatrixChanged(this);
            }
        };
        this.inputSlot = new InventoryBasic("Material", true, 1) {
            @Override
            public void markDirty() {
                super.markDirty();
                ContainerInjectionTable.this.onCraftMatrixChanged(this);
            }

            @Override
            public void setInventorySlotContents(int index, ItemStack stack) {
                try {
                    super.setInventorySlotContents(index, stack);
                } catch (IndexOutOfBoundsException e) {
                    CbCraft.LOGGER.error("IOB: " + e);
                }
            }
        };
        this.outputSlot = new InventoryCraftResult();

        /** index都设成0了，设成0,1,2好像会抛出IndexOutOfBounds **/
        this.addSlotToContainer(new Slot(this.powderSlot, 0, 80, 53) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return ItemStack.areItemsEqual(stack, new ItemStack(COCOA_POWDER));
            }
        });
        this.addSlotToContainer(new Slot(this.inputSlot, 0, 48, 26));
        this.addSlotToContainer(new Slot(this.outputSlot, 0, 111, 26) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }

            @Override
            public boolean canTakeStack(EntityPlayer playerIn) {
                return (playerIn.isCreative() || playerIn.experienceLevel >= ContainerInjectionTable.this.cost) &&
                        ContainerInjectionTable.this.cost > -1 && this.getHasStack();
            }

            @Override
            public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
                if (!thePlayer.isCreative()) {
                    thePlayer.addExperienceLevel(-ContainerInjectionTable.this.cost);
                }
                ContainerInjectionTable.this.powderSlot.decrStackSize(0, cost);
                ContainerInjectionTable.this.inputSlot.decrStackSize(0, cost);
                ContainerInjectionTable.this.world.playSound(
                        (EntityPlayer)null, ContainerInjectionTable.this.blockPos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE,
                        SoundCategory.BLOCKS, 1.0F, ContainerInjectionTable.this.world.rand.nextFloat() * 0.1F + 1.7F);
                return stack;
            }
        });

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        if (this.world.getBlockState(this.blockPos).getBlock() != INJECTION_TABLE) {
            return false;
        } else {
            return playerIn.getDistanceSq((double)this.blockPos.getX() + 0.5D, (double)this.blockPos.getY() + 0.5D, (double)this.blockPos.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        super.onCraftMatrixChanged(inventoryIn);
        if (inventoryIn == this.inputSlot || inventoryIn == this.powderSlot) {
            this.updateInjectionOutput();
        }
    }

    /** 输出栏位的东西就在这里处理了OwO **/
    private void updateInjectionOutput() {
        this.outputSlot.setInventorySlotContents(0, ItemStack.EMPTY);
        this.cost = -1;
        this.notEnoughLevels = notEnoughPowder = false;

        ItemStack inputStack = this.inputSlot.getStackInSlot(0);
        if (inputStack.isEmpty()) return;
        Optional<ItemStack> outputStack = INJECTION_MANAGER.getOutput(inputStack);
        if (!outputStack.isPresent()) return;

        this.cost = INJECTION_MANAGER.getCost(inputStack);
        if (cost > powderSlot.getStackInSlot(0).getCount()) {
            this.notEnoughPowder = true;
            return;
        }
        if (!player.isCreative() && cost > player.experienceLevel) {
            this.notEnoughLevels = true;
            return;
        }

        this.outputSlot.setInventorySlotContents(0, outputStack.get());
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        if (!this.world.isRemote) {
            this.clearContainer(playerIn, this.world, this.inputSlot);
            this.clearContainer(playerIn, this.world, this.powderSlot);
        }
    }


    /** SHIFT 点击物品的时候 **/
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index != 0 && index != 1) {
                if (index >= 3 && index < 39 && !this.mergeItemStack(itemstack1, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
}
