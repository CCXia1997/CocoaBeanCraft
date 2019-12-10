package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockDarkBrick extends Block {
    public BlockDarkBrick() {
        super(Material.ROCK);
        this.setUnlocalizedName(CbCraft.MODID + ".darkChocolateBrick");
        this.setRegistryName("dark_chocolate_brick");
        this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
        this.setHardness(1.0F);
        this.setSoundType(SoundType.STONE);
    }
    
}
