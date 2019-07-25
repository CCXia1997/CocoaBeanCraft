package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictLoader {
    public OreDictLoader() {
        registerOreDict("blockChocolate",
                ModBlocks.DARK_CHOCOLATE_BLOCK,
                ModBlocks.DARK_CHOCOLATE_BLOCK_CARVED,
                ModBlocks.DARK_CHOCOLATE_BLOCK_PILLAR,
                ModBlocks.DARK_CHOCOLATE_BLOCK_SMOOTH,
                ModBlocks.DARK_MILK_CHOCOLATE_BLOCK,
                ModBlocks.WHITE_CHOCOLATE_BLOCK,
                ModBlocks.WHITE_CHOCOLATE_BLOCK_CARVED,
                ModBlocks.WHITE_CHOCOLATE_BLOCK_PILLAR,
                ModBlocks.WHITE_CHOCOLATE_BLOCK_SMOOTH,
                ModBlocks.WHITE_DARK_CHOCOLATE_BLOCK,
                ModBlocks.MILK_CHOCOLATE_BLOCK,
                ModBlocks.MILK_CHOCOLATE_BLOCK_CARVED,
                ModBlocks.MILK_CHOCOLATE_BLOCK_PILLAR,
                ModBlocks.MILK_CHOCOLATE_BLOCK_SMOOTH,
                ModBlocks.MILK_WHITE_CHOCOLATE_BLOCK);
    }

    private void registerOreDict(String dict, Object... objects) {
        for (Object o : objects) {
            if (o instanceof Item)
                OreDictionary.registerOre(dict, (Item)o);
            else if (o instanceof ItemStack)
                OreDictionary.registerOre(dict, (ItemStack)o);
            else if (o instanceof Block)
                OreDictionary.registerOre(dict, (Block)o);
        }
    }
}
