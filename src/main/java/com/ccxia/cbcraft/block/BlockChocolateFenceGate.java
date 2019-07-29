package com.ccxia.cbcraft.block;

import com.ccxia.cbcraft.creativetab.CreativeTabsCbCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockChocolateFenceGate extends BlockFenceGate {
    private final MapColor mapColor;
    private final Material material;

    public BlockChocolateFenceGate(Block modelBlock) {
        super(BlockPlanks.EnumType.OAK);
        this.mapColor = modelBlock.getDefaultState().getMaterial().getMaterialMapColor();
        this.material = modelBlock.getDefaultState().getMaterial();
        this.setCreativeTab(CreativeTabsCbCraft.tabCbCraft);
        this.setHardness(1.0F);
        this.setSoundType(SoundType.STONE);
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return this.mapColor;
    }

    @Override
    public Material getMaterial(IBlockState state) {
        return this.material;
    }
}
