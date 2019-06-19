package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDarkChocolate extends ItemFood {
	public ItemDarkChocolate() {
		super(2, 0.6F, false);
		this.setUnlocalizedName(CbCraft.MODID + ".darkChocolate");
		this.setRegistryName("dark_chocolate");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 600, 0));
		}
		super.onFoodEaten(stack, worldIn, player);
	}
}
