package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGoldCocoa extends ItemFood {
	public ItemGoldCocoa() {
		super(5, 1.0F, false);
		this.setUnlocalizedName(CbCraft.MODID + ".goldenCocoa");
		this.setRegistryName("golden_cocoa");
		this.setAlwaysEdible();
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			// …À∫¶Œ¸ ’1
			player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1800, 0));
		}
	}
}
