package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockChocolateStairs extends BlockStairs {

    protected BlockChocolateStairs(IBlockState modelState) {
        super(modelState);
        this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
    }
}
