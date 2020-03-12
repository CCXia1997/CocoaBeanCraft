package com.ccxia.cbcraft.item.tool;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemToolInjectedSpar {
	// 耐久为2倍钻石品质，挖掘和附魔为金，其他为钻石
	public static final Item.ToolMaterial INJECTED_COCOA_SPAR = EnumHelper.addToolMaterial("INJECTED_COCOA_SPAR", 3,
			1561 * 2, 12.0F, 3.0F, 22);

}
