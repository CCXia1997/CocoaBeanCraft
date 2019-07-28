package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockChocolateWall extends BlockWall {

    public BlockChocolateWall(Block modelBlock) {
        super(modelBlock);
        this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
        this.setHardness(1.0F);
        this.setSoundType(SoundType.STONE);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this));
    }
}
