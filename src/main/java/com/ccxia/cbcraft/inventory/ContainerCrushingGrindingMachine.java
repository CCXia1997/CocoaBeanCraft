package com.ccxia.cbcraft.inventory;

import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.inventory.crafting.InventoryCrushing;
import com.ccxia.cbcraft.inventory.crafting.InventoryCrushingResult;
import com.ccxia.cbcraft.inventory.crafting.RecipesCrushing;
import com.ccxia.cbcraft.inventory.slot.SlotCrushing;
import com.ccxia.cbcraft.tileentity.TileEntityCrushingGrindingMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCrushingGrindingMachine extends Container {
	public InventoryCrafting craftMatrix = new InventoryCrushing(this, 1, 1);
	public InventoryCrushingResult craftResult = new InventoryCrushingResult();
	private final World world;
	private final BlockPos pos;
	private final EntityPlayer player;

	public ContainerCrushingGrindingMachine(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) {
		this.world = worldIn;
		this.pos = posIn;
		this.player = playerInventory.player;
		this.addSlotToContainer(
				new SlotCrushing(playerInventory.player, this.craftMatrix, this.craftResult, 0, 116, 20));
		this.addSlotToContainer(new Slot(this.craftMatrix, 0, 44, 20));
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 51 + i * 18));
			}
		}

		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 109));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		if (this.world.getBlockState(this.pos).getBlock() != ModBlocks.CRUSHING_GRINDING_MACHINE) {
			return false;
		} else {
			return playerIn.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
					(double) this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	// 关闭页面后应该把里面的物品全部返还给玩家
	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		if (!this.world.isRemote) {
			this.clearContainer(playerIn, this.world, this.craftMatrix);
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index == 0) {
				itemstack1.getItem().onCreated(itemstack1, this.world, playerIn);

				if (!this.mergeItemStack(itemstack1, 2, 38, true)) {
					return ItemStack.EMPTY;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (index >= 2 && index < 29) {
				if (!this.mergeItemStack(itemstack1, 29, 38, false)) {
					return ItemStack.EMPTY;
				}
			} else if (index >= 29 && index < 38) {
				if (!this.mergeItemStack(itemstack1, 2, 29, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 2, 38, false)) {
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

			ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);

			if (index == 0) {
				playerIn.dropItem(itemstack2, false);
			}
		}
		return itemstack;
	}

	public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
		return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
	}

	public void onCraftMatrixChanged(IInventory inventoryIn) {
		this.slotChangedCraftingGrid(this.world, this.player, this.craftMatrix, this.craftResult);
	}

	protected void slotChangedCraftingGrid(World p_192389_1_, EntityPlayer p_192389_2_, InventoryCrafting p_192389_3_,
			InventoryCraftResult p_192389_4_) {
		if (!p_192389_1_.isRemote) {
			EntityPlayerMP entityplayermp = (EntityPlayerMP) p_192389_2_;
			ItemStack itemstack = RecipesCrushing.CRUSHING_MANAGER.getCraftingResult(p_192389_3_);
			p_192389_4_.setInventorySlotContents(0, itemstack.copy());
			entityplayermp.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, itemstack.copy()));
		}
	}

}
