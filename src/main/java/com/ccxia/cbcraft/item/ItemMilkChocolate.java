package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemMilkChocolate extends ItemFood {
	public ItemMilkChocolate() {
		super(5, 0.6F, false);
		this.setUnlocalizedName(CbCraft.MODID + ".milkChocolate");
		this.setRegistryName("milk_chocolate");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 20, 0));
		}
		super.onFoodEaten(stack, worldIn, player);
	}
}
