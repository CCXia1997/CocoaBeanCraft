package com.ccxia.cbcraft.item.tool;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemToolCocoaSpar {
	// 耐久为2倍钻石品质，其他属性同钻石品质
	public static final Item.ToolMaterial COCOA_SPAR = EnumHelper.addToolMaterial("COCOA_SPAR", 3, 1561 * 2, 8.0F, 3.0F,
			10);
}
