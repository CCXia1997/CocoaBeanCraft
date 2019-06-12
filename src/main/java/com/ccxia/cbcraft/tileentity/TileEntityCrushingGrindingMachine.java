package com.ccxia.cbcraft.tileentity;

import java.util.HashMap;
import java.util.Map;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.inventory.ContainerCrushingGrindingMachine;
import com.ccxia.cbcraft.item.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityCrushingGrindingMachine extends TileEntity implements ITickable {
	protected ItemStackHandler upInventory = new ItemStackHandler();
	protected ItemStackHandler downInventory = new ItemStackHandler();

	private NonNullList<ItemStack> crushingItemStacks = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);
	// 研磨的进度时间，用于对应Gui材质中的进度条绘制
	private int loadTime;
	// 研磨的工作名单
	Map<Item, ItemStack> workList = new HashMap<Item, ItemStack>();

	public TileEntityCrushingGrindingMachine() {
		// 1熟可可豆->1可可膏
		workList.put(ModItems.COOKED_COCOA_BEANS, new ItemStack(ModItems.COCOA_PASTE, 1));
		// 1砂砾->1燧石
		workList.put(Item.getItemFromBlock(Blocks.GRAVEL), new ItemStack(Items.FLINT, 1));
		// 1地狱疣块->6地狱疣
		workList.put(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK), new ItemStack(Items.NETHER_WART, 6));
		// 1石英块->2石英
		workList.put(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK), new ItemStack(Items.QUARTZ, 2));
		// 1黏土块->4黏土球
		workList.put(Item.getItemFromBlock(Blocks.CLAY), new ItemStack(Items.CLAY_BALL, 4));
		// 1西瓜块->6西瓜
		workList.put(Item.getItemFromBlock(Blocks.MELON_BLOCK), new ItemStack(Items.MELON, 6));
		// 1岩浆块->2岩浆膏
		workList.put(Item.getItemFromBlock(Blocks.MAGMA), new ItemStack(Items.MAGMA_CREAM, 2));
		// 1烈焰棒->3烈焰粉
		workList.put(Items.BLAZE_ROD, new ItemStack(Items.BLAZE_POWDER, 3));
		// 1骨头->4骨粉
		workList.put(Items.BONE, new ItemStack(Items.DYE, 4, 15));
		// 1小麦->1面粉
		workList.put(Items.WHEAT, new ItemStack(ModItems.FLOUR, 1));
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
			if (canLoad()) {
				Item item = upInventory.extractItem(0, 1, true).getItem();
				// 注意：这边的result一定要是copy一份从Map表中获取的物品栈，绝对不能直接用
				ItemStack result = getResultItem(item).copy();
				if (downInventory.insertItem(0, result, true) == ItemStack.EMPTY) {
					if (this.loadTime == 200) {
						downInventory.insertItem(0, result, false);
						upInventory.extractItem(0, 1, false);
						this.loadTime = 0;
					} else {
						this.loadTime++;
					}
				} else {
					this.loadTime = 0;
				}
			} else {
				this.loadTime = 0;
			}
		}

	}

	public int getSizeInventory() {
		return crushingItemStacks.size();
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		return compound;
	}

	public ItemStackHandler getUpInventory() {
		return this.upInventory;
	}

	public ItemStackHandler getDownInventory() {
		return this.downInventory;
	}

	// 判断物品槽是否有可以加工的物品
	public boolean canLoad() {
		Item item = upInventory.extractItem(0, 1, true).getItem();
		if (workList.containsKey(item)) {
			return true;
		} else {
			return false;
		}
	}

	// 获取对应加工物品的成品
	public ItemStack getResultItem(Item item) {
		return workList.get(item);
	}

	public int getLoadTime() {
		return this.loadTime;
	}

}
