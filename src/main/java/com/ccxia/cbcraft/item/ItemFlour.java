package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import com.ccxia.cbcraft.world.TeleporterCocoa;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemFlour extends Item {
	public ItemFlour() {
		this.setUnlocalizedName(CbCraft.MODID + ".flour");
		this.setRegistryName("flour");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

//	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
//		if (!worldIn.isRemote && worldIn.provider.getDimension() != CbCraft.dimID) {
//			playerIn.getServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) playerIn, CbCraft.dimID,
//					new TeleporterCocoa(playerIn.getServer().getWorld(worldIn.provider.getDimension())));
//		} else if (!worldIn.isRemote) {
//			playerIn.getServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) playerIn, 0,
//					new TeleporterCocoa(playerIn.getServer().getWorld(CbCraft.dimID)));
//		}
//		playerIn.sendMessage(new TextComponentString("" + playerIn.world.provider.getDimension()));
//		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
//	}

}
