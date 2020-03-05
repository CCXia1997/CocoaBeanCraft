package com.ccxia.cbcraft.item.armor;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemArmorCocoaAlloy extends ItemArmor {
	// 耐久同钻石，附魔同金，其余同铁
	public static final ItemArmor.ArmorMaterial COCOA_ALLOY = EnumHelper.addArmorMaterial("COCOA_ALLOY",
			CbCraft.MODID + ":" + "cocoa_alloy", 33, new int[] { 2, 5, 6, 2 }, 25, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
			0.0F);

	public ItemArmorCocoaAlloy(EntityEquipmentSlot equipmentSlotIn) {
		super(COCOA_ALLOY, COCOA_ALLOY.ordinal(), equipmentSlotIn);
	}

}
