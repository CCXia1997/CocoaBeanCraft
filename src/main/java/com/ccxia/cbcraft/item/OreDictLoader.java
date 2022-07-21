package com.ccxia.cbcraft.item;

import com.ccxia.cbcraft.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.oredict.OreDictionary;

import java.lang.reflect.Modifier;

public class OreDictLoader {
    public OreDictLoader() {
        // 兼容糖果世界
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
        // 兼容潘马斯农场和咖啡工艺
        registerOreDict(
                "foodChocolatebar",
                ModItems.DARK_CHOCOLATE,
                ModItems.MILK_CHOCOLATE,
                ModItems.WHITE_CHOCOLATE
        );
        // 兼容糖果世界
        registerOreDict(
                "foodChocolate",
                ModItems.DARK_CHOCOLATE,
                ModItems.MILK_CHOCOLATE,
                ModItems.WHITE_CHOCOLATE
        );
        // 面粉
        registerOreDict(
                "foodFlour",
                ModItems.FLOUR
        );
        // 可可粉
        registerOreDict(
                "dustCocoa",
                ModItems.COCOA_POWDER
        );
        // 可可粉
        registerOreDict(
                "foodCocoapowder",
                ModItems.COCOA_POWDER
        );
        // 面团
        registerOreDict(
                "foodDough",
                ModItems.DOUGH
        );
        // 盒装牛奶
        registerOreDict(
                "listAllmilk",
                ModItems.PACKED_MILK
        );
        // 奶酪
        registerOreDict(
                "foodCheese",
                ModItems.CHEESE
        );
    }

    private void registerOreDict(String dict, Object... objects) {
        for (Object o : objects) {
            if (o instanceof Item)
                OreDictionary.registerOre(dict, (Item) o);
            else if (o instanceof ItemStack)
                OreDictionary.registerOre(dict, (ItemStack) o);
            else if (o instanceof Block)
                OreDictionary.registerOre(dict, (Block) o);
        }
    }
}
