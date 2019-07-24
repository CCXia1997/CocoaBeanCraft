package com.ccxia.cbcraft.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemPackedMilk extends ItemBucketMilk {
	public ItemPackedMilk() {
		this.setUnlocalizedName(CbCraft.MODID + ".packedMilk");
		this.setRegistryName("packed_milk");
		this.setMaxStackSize(16);
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if (!worldIn.isRemote)
			this.removeAllPotion(stack, entityLiving);
		if (entityLiving instanceof EntityPlayerMP) {
			EntityPlayerMP entityplayermp = (EntityPlayerMP) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(entityplayermp, stack);
			entityplayermp.addStat(StatList.getObjectUseStats(this));
		}

		if (entityLiving instanceof EntityPlayer && !((EntityPlayer) entityLiving).capabilities.isCreativeMode) {
			stack.shrink(1);
		}

		return stack.isEmpty() ? new ItemStack(Items.AIR) : stack;
	}

	public void removeAllPotion(ItemStack stack, EntityLivingBase entityLiving) {
		if (entityLiving.world.isRemote)
			return;
		List<Potion> potionList = new ArrayList<Potion>();
		Iterator<PotionEffect> iterator = entityLiving.getActivePotionMap().values().iterator();
		while (iterator.hasNext()) {
			PotionEffect effect = iterator.next();
			potionList.add(effect.getPotion());
		}
		for (Potion potion : potionList) {
			entityLiving.removePotionEffect(potion);
		}
	}
}
