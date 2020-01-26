package com.ccxia.cbcraft.item.armor;

import com.ccxia.cbcraft.CbCraft;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemArmorCocoaMetal extends ItemArmor {
	// 耐久跟钻石一样，其余跟铁相同
	public static final ItemArmor.ArmorMaterial COCOA_METAL = EnumHelper.addArmorMaterial("COCOA_METAL",
			CbCraft.MODID + ":" + "cocoa_metal", 33, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
			0.0F);

	public ItemArmorCocoaMetal(EntityEquipmentSlot equipmentSlotIn) {
		super(COCOA_METAL, COCOA_METAL.ordinal(), equipmentSlotIn);
	}

}
