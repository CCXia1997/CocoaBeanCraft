package com.ccxia.cbcraft.item.armor;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemArmorInjectedCocoaSpar extends ItemArmor {
	// 耐久为2倍钻石，附魔同金，其余同钻石
	public static final ItemArmor.ArmorMaterial INJECTED_COCOA_SPAR = EnumHelper.addArmorMaterial("INJECTED_COCOA_SPAR",
			CbCraft.MODID + ":" + "injected_cocoa_spar", 33 * 2, new int[] { 3, 6, 8, 3 }, 25,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

	public ItemArmorInjectedCocoaSpar(EntityEquipmentSlot equipmentSlotIn) {
		super(INJECTED_COCOA_SPAR, INJECTED_COCOA_SPAR.ordinal(), equipmentSlotIn);
	}
}
