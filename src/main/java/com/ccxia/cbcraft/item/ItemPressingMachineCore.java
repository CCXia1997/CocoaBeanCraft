package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import net.minecraft.item.Item;

public class ItemPressingMachineCore extends Item {
	public ItemPressingMachineCore() {
		this.setUnlocalizedName(CbCraft.MODID + ".pressingMachineCore");
		this.setRegistryName("pressing_machine_core");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
	}
}
