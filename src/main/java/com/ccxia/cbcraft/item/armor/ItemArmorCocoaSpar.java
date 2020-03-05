package com.ccxia.cbcraft.item.armor;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemArmorCocoaSpar extends ItemArmor {
	// ���;���Ժ���ʯƷ����ͬ���;�Ϊ��ʯƷ�ʵ��;�����
	public static final ItemArmor.ArmorMaterial COCOA_SPAR = EnumHelper.addArmorMaterial("COCOA_SPAR",
			CbCraft.MODID + ":" + "cocoa_spar", 33 * 2, new int[] { 3, 6, 8, 3 }, 10,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

	public ItemArmorCocoaSpar(EntityEquipmentSlot equipmentSlotIn) {
		super(COCOA_SPAR, COCOA_SPAR.ordinal(), equipmentSlotIn);
	}
}
