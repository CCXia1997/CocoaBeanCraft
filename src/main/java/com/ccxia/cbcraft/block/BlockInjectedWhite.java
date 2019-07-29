package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import static net.minecraft.block.material.Material.ROCK;

public class BlockInjectedWhite extends Block {
    public BlockInjectedWhite() {
        super(ROCK);
        this.setUnlocalizedName(CbCraft.MODID + ".injectedWhiteChocolate");
        this.setRegistryName("injected_white_chocolate_block");
        this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
        this.setHardness(1.0F);
        this.setSoundType(SoundType.STONE);
    }
}
