package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemYogurt extends ItemFood {
	public ItemYogurt() {
		super(6, 0.67F, false);
		this.setUnlocalizedName(CbCraft.MODID + ".yogurt");
		this.setRegistryName("yogurt");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		super.onItemUseFinish(stack, worldIn, entityLiving);
		return new ItemStack(Items.BUCKET);
	}
}
