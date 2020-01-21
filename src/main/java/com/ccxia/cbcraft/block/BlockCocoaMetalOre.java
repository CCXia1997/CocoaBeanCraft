package com.ccxia.cbcraft.block;

import java.util.Random;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockCocoaMetalOre extends BlockOre {
	public BlockCocoaMetalOre() {
		super();
		this.setUnlocalizedName(CbCraft.MODID + ".cocoaMetalOre");
		this.setRegistryName("cocoa_metal_ore");
		this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
		this.setHardness(3.0F);
		this.setSoundType(SoundType.STONE);
		// ��Ƴ���ԭ�����������ֻ��ʹ��ʯ�������ھ���ܵ�����Ʒ
		this.setHarvestLevel("pickaxe", 1);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	public int quantityDropped(Random random) {
		return 1;
	}

}
