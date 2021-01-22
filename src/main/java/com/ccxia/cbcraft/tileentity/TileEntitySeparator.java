package com.ccxia.cbcraft.tileentity;

import java.util.ArrayList;
import java.util.List;

import com.ccxia.cbcraft.block.BlockFermentationBaker;
import com.ccxia.cbcraft.block.BlockSeparator;
import com.ccxia.cbcraft.tileentity.crafting.CraftingSeparator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

public class TileEntitySeparator extends TileEntity implements ITickable {
	// 分离机的底部成品位置有两个物品槽，输出两种成品
	protected ItemStackHandler upInventory = new ItemStackHandler();
	protected ItemStackHandler sideInventory = new ItemStackHandler();
	protected ItemStackHandler downInventory = new ItemStackHandler(2);

	private NonNullList<ItemStack> separatorItemStacks = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);

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

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability)) {
			// @SuppressWarnings("unchecked")
			if (facing == EnumFacing.UP)
				return (T) upInventory;
			else if (facing == EnumFacing.DOWN)
				return (T) downInventory;
			else
				return (T) sideInventory;
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
			ItemStack itemstack = this.sideInventory.getStackInSlot(0);
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
								this.sideInventory.setStackInSlot(0, item1);
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
				BlockSeparator.setState(this.isBurning(), this.world, this.pos);
			}
		}

		if (flag1) {
			this.markDirty();
		}
	}

	public int getSizeInventory() {
		return separatorItemStacks.size();
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public int getCookTime(ItemStack stack) {
		return 200;
	}

	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}

	private boolean canSmelt() {
		// 原料为空直接返回false
		if (upInventory.getStackInSlot(0).isEmpty()) {
			return false;
		}
		ItemStack itemStack1 = upInventory.extractItem(0, 1, true);
		List<ItemStack> result = CraftingSeparator.instance().getSmeltItems(itemStack1);
		if (result.get(0) == ItemStack.EMPTY) {
			return false;
		} else {
			ItemStack itemStack2 = result.get(0);
			ItemStack itemStack3 = result.get(1);
			ItemStack itemStack4 = downInventory.extractItem(0, 1, true);
			ItemStack itemStack5 = downInventory.extractItem(1, 1, true);
			// 两个成品槽均为空返回true
			// 一个成品槽为空，另一个成品槽种类相同且符合堆叠返回true
			// 两个成品槽物品种类相同且符合堆叠返回true
			// 其余返回false
			if (itemStack4.isEmpty() && itemStack5.isEmpty()) {
				return true;
			} else if (itemStack4.isEmpty() && itemStack3.isItemEqual(itemStack5)
					&& itemStack3.getCount() + itemStack5.getCount() <= this.getInventoryStackLimit()
					&& itemStack3.getCount() + itemStack5.getCount() <= itemStack3.getMaxStackSize()) {
				return true;
			} else if (itemStack5.isEmpty() && itemStack2.isItemEqual(itemStack4)
					&& itemStack2.getCount() + itemStack4.getCount() <= this.getInventoryStackLimit()
					&& itemStack4.getCount() + itemStack4.getCount() <= itemStack4.getMaxStackSize()) {
				return true;
			} else if (itemStack3.isItemEqual(itemStack5)
					&& itemStack3.getCount() + itemStack5.getCount() <= this.getInventoryStackLimit()
					&& itemStack3.getCount() + itemStack5.getCount() <= itemStack3.getMaxStackSize()
					&& itemStack2.isItemEqual(itemStack4)
					&& itemStack2.getCount() + itemStack4.getCount() <= this.getInventoryStackLimit()
					&& itemStack4.getCount() + itemStack4.getCount() <= itemStack4.getMaxStackSize()) {
				return true;
			} else {
				return false;
			}
		}
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack itemStack1 = upInventory.extractItem(0, 1, true);
			List<ItemStack> result = CraftingSeparator.instance().getSmeltItems(itemStack1);
			ItemStack itemStack2 = result.get(0);
			ItemStack itemStack3 = result.get(1);
			if (itemStack2 != ItemStack.EMPTY) {
				upInventory.extractItem(0, 1, false);
				downInventory.insertItem(0, itemStack2.copy(), false);
				downInventory.insertItem(1, itemStack3.copy(), false);
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
		cmp.setInteger("FurnaceBurnTime", this.furnaceBurnTime);
		cmp.setInteger("CurrentItemBurnTime", this.currentItemBurnTime);
		cmp.setInteger("CookTime", this.cookTime);
		cmp.setInteger("TotalCookTime", this.totalCookTime);
	}

	public void readPacketNBT(NBTTagCompound cmp) {
		this.upInventory.deserializeNBT(cmp.getCompoundTag("UpInventory"));
		this.downInventory.deserializeNBT(cmp.getCompoundTag("DownInventory"));
		this.sideInventory.deserializeNBT(cmp.getCompoundTag("SideInventory"));
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

}
