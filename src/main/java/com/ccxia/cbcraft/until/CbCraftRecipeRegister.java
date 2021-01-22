package com.ccxia.cbcraft.until;

import com.ccxia.cbcraft.api.recipe.*;
import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemStack;

public class CbCraftRecipeRegister {
    private static final CbCraftRecipeRegister instance = new CbCraftRecipeRegister();

    public static CbCraftRecipeRegister getInstance() {
        return instance;
    }

    public void Init() {
        fermentationBakerRegister();
        crushRegister();
        separatorRegister();
        autoCrushRegister();
        autoPressingRegister();
        injectionTableRegister();
    }

    public void fermentationBakerRegister() {
        // ¿É¿É¶¹->Êì¿É¿É¶¹
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COOKED_COCOA_BEANS, 1)},
                new ItemStack[]{new ItemStack(Item.getItemById(351), 1, 3)}
        );
        // ÍÑÖ¬ÄÌ->ÄÌÀÒ
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.CHEESE)},
                new ItemStack[]{new ItemStack(ModItems.SKIM_MILK)}
        );
        // Å£ÄÌ+ÌÇ->ËáÄÌ
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.YOGURT)},
                new ItemStack[]{new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR)}
        );
        // Ö©ÖëÑÛ+ÌÇ->·¢½ÍÖ©ÖëÑÛ
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.FERMENTED_SPIDER_EYE, 1)},
                new ItemStack[]{new ItemStack(Items.SPIDER_EYE), new ItemStack(Items.SUGAR)}
        );
        // ×ØÄ¢¹½->×ØÄ¢¹½¿é
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM_BLOCK))},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM))}
        );
        // ºìÄ¢¹½->ºìÄ¢¹½¿é
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.RED_MUSHROOM_BLOCK))},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.RED_MUSHROOM))}
        );
        // µØÓüðà->µØÓüðà¿é
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK))},
                new ItemStack[]{new ItemStack(Items.NETHER_WART)}
        );
        // ÃæÍÅ->Ãæ°ü
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.BREAD)},
                new ItemStack[]{new ItemStack(ModItems.DOUGH)}
        );
        // ÃæÍÅ+¿É¿É·Û->¿É¿ÉÃæ°ü
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COCOA_BREAD)},
                new ItemStack[]{new ItemStack(ModItems.DOUGH), new ItemStack(ModItems.COCOA_POWDER)}
        );
        // µ°ÄÌÃæÍÅ->µ°¸â»ùµ×
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModBlocks.CAKE_BASE)},
                new ItemStack[]{new ItemStack(ModItems.EGG_MILK_DOUGH)}
        );
        // µ°ÄÌÃæÍÅ+¿É¿É·Û->¿É¿Éµ°¸â»ùµ×
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModBlocks.COCOA_CAKE_BASE)},
                new ItemStack[]{new ItemStack(ModItems.EGG_MILK_DOUGH), new ItemStack(ModItems.COCOA_POWDER)}
        );
        // ÇúÆæÃæÍÅ->8ÇúÆæ±ý
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.COOKIE, 8)},
                new ItemStack[]{new ItemStack(ModItems.COOKIE_DOUGH)}
        );
    }

    public void crushRegister() {
        // 1Êì¿É¿É¶¹->1¿É¿É¸à
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COCOA_PASTE)},
                new ItemStack[]{new ItemStack(ModItems.COOKED_COCOA_BEANS)}
        );
        // 1É°Àù->1ìÝÊ¯
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.FLINT)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL))}
        );
        // 1µØÓüðà¿é->6µØÓüðà
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.NETHER_WART, 6)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK))}
        );
        // 1Ê¯Ó¢¿é->2Ê¯Ó¢
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.QUARTZ, 2)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK))}
        );
        // 1ð¤ÍÁ¿é->4ð¤ÍÁÇò
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.CLAY_BALL, 4)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.CLAY))}
        );
        // 1Î÷¹Ï¿é->6Î÷¹Ï
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.MELON, 6)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.MELON_BLOCK))}
        );
        // 1ÑÒ½¬¿é->2ÑÒ½¬¸à
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.MAGMA_CREAM, 2)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.MAGMA))}
        );
        // 1ÁÒÑæ°ô->3ÁÒÑæ·Û
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.BLAZE_POWDER, 3)},
                new ItemStack[]{new ItemStack(Items.BLAZE_ROD)}
        );
        // 1¹ÇÍ·->4¹Ç·Û
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.DYE, 4, 15)},
                new ItemStack[]{new ItemStack(Items.BONE)}
        );
        // 1Ð¡Âó->1Ãæ·Û
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.FLOUR, 1)},
                new ItemStack[]{new ItemStack(Items.WHEAT)}
        );
        // 1ÄàÍÁ->1ð¤ÍÁÇò
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.CLAY_BALL)},
                new ItemStack[]{new ItemStack(ItemAir.getItemFromBlock(Blocks.DIRT))}
        );
    }

    public void separatorRegister() {
        // ¿É¿ÉÒº¿é->¿É¿ÉÖ¬+¿É¿É·Û
        SeparatorRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COCOA_BUTTER), new ItemStack(ModItems.COCOA_POWDER)},
                new ItemStack[]{new ItemStack(ModItems.COCOA_LIQUOR)}
        );
        // ÑÒ½¬¸à->Õ³ÒºÇò+ÁÒÑæ·Û
        SeparatorRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.SLIME_BALL), new ItemStack(Items.BLAZE_POWDER)},
                new ItemStack[]{new ItemStack(Items.MAGMA_CREAM)}
        );
        // Å£ÄÌ->ÄÌÓÍ+ÍÑÖ¬ÄÌ
        SeparatorRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.CREAM), new ItemStack(ModItems.SKIM_MILK)},
                new ItemStack[]{new ItemStack(Items.MILK_BUCKET)}
        );
    }

    public void autoCrushRegister() {
        // 1Êì¿É¿É¶¹->1¿É¿É¸à
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COCOA_PASTE)},
                new ItemStack[]{new ItemStack(ModItems.COOKED_COCOA_BEANS)}
        );
        // 1É°Àù->1ìÝÊ¯
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.FLINT)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL))}
        );
        // 1µØÓüðà¿é->6µØÓüðà
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.NETHER_WART, 6)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK))}
        );
        // 1Ê¯Ó¢¿é->2Ê¯Ó¢
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.QUARTZ, 2)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK))}
        );
        // 1ð¤ÍÁ¿é->4ð¤ÍÁÇò
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.CLAY_BALL, 4)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.CLAY))}
        );
        // 1Î÷¹Ï¿é->6Î÷¹Ï
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.MELON, 6)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.MELON_BLOCK))}
        );
        // 1ÑÒ½¬¿é->2ÑÒ½¬¸à
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.MAGMA_CREAM, 2)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.MAGMA))}
        );
        // 1ÁÒÑæ°ô->3ÁÒÑæ·Û
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.BLAZE_POWDER, 3)},
                new ItemStack[]{new ItemStack(Items.BLAZE_ROD)}
        );
        // 1¹ÇÍ·->4¹Ç·Û
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.DYE, 4, 15)},
                new ItemStack[]{new ItemStack(Items.BONE)}
        );
        // 1Ð¡Âó->1Ãæ·Û
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.FLOUR, 1)},
                new ItemStack[]{new ItemStack(Items.WHEAT)}
        );
        // 1ÄàÍÁ->1ð¤ÍÁÇò
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.CLAY_BALL)},
                new ItemStack[]{new ItemStack(ItemAir.getItemFromBlock(Blocks.DIRT))}
        );
    }

    public void autoPressingRegister() {
        // 4Ñ©Çò->1Ñ©
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.SNOW))},
                new ItemStack[]{new ItemStack(Items.SNOWBALL, 4)}
        );
        // 9Ìú¶§->1Ìú¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK))},
                new ItemStack[]{new ItemStack(Items.IRON_INGOT, 9)}
        );
        // 9½ð¶§->1½ð¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.GOLD_BLOCK))},
                new ItemStack[]{new ItemStack(Items.GOLD_INGOT, 9)}
        );
        // 9ÃºÌ¿->1ÃºÌ¿¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.COAL_BLOCK))},
                new ItemStack[]{new ItemStack(Items.COAL, 9)}
        );
        // 9ºìÊ¯->1ºìÊ¯¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_BLOCK))},
                new ItemStack[]{new ItemStack(Items.REDSTONE, 9)}
        );
        // 9Çà¾§Ê¯->1Çà¾§Ê¯¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.LAPIS_BLOCK))},
                new ItemStack[]{new ItemStack(Items.DYE, 9, EnumDyeColor.BLUE.getDyeDamage())}
        );
        // 9ÂÌ±¦Ê¯->1ÂÌ±¦Ê¯¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK))},
                new ItemStack[]{new ItemStack(Items.EMERALD, 9)}
        );
        // 9×êÊ¯->1×êÊ¯¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK))},
                new ItemStack[]{new ItemStack(Items.DIAMOND, 9)}
        );
        // 9Õ³ÒºÇò->1Õ³Òº¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK))},
                new ItemStack[]{new ItemStack(Items.SLIME_BALL, 9)}
        );
        // 4ºÚÇÉ¿ËÁ¦->4ºÚÇÉ¿ËÁ¦¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(ModBlocks.DARK_CHOCOLATE_BLOCK))},
                new ItemStack[]{new ItemStack(ModItems.DARK_CHOCOLATE, 4)}
        );
        // 4×ØÇÉ¿ËÁ¦->4×ØÇÉ¿ËÁ¦¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(ModBlocks.MILK_CHOCOLATE_BLOCK))},
                new ItemStack[]{new ItemStack(ModItems.MILK_CHOCOLATE, 4)}
        );
        // 4°×ÇÉ¿ËÁ¦->4°×ÇÉ¿ËÁ¦¿é
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(ModBlocks.WHITE_CHOCOLATE_BLOCK))},
                new ItemStack[]{new ItemStack(ModItems.WHITE_CHOCOLATE, 4)}
        );
    }

    public void injectionTableRegister() {
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModBlocks.INJECTED_DARK_CHOCOLATE)},
                new ItemStack[]{new ItemStack(ModBlocks.DARK_CHOCOLATE_BLOCK)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModBlocks.INJECTED_MILK_CHOCOLATE)},
                new ItemStack[]{new ItemStack(ModBlocks.MILK_CHOCOLATE_BLOCK)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModBlocks.INJECTED_WHITE_CHOCOLATE)},
                new ItemStack[]{new ItemStack(ModBlocks.WHITE_CHOCOLATE_BLOCK)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModBlocks.AUTO_CRUSHING_GRINDING_MACHINE)},
                new ItemStack[]{new ItemStack(ModBlocks.CRUSHING_GRINDING_MACHINE)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Blocks.ANVIL)},
                new ItemStack[]{new ItemStack(Blocks.ANVIL, 1, 1)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Blocks.ANVIL)},
                new ItemStack[]{new ItemStack(Blocks.ANVIL, 1, 2)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.PRESSING_MACHINE_CORE)},
                new ItemStack[]{new ItemStack(Blocks.CRAFTING_TABLE)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.PURPLE_GEM)},
                new ItemStack[]{new ItemStack(Items.EMERALD)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.INJECTED_IRON_INGOT)},
                new ItemStack[]{new ItemStack(Items.IRON_INGOT)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModBlocks.COCOA_ALTAR)},
                new ItemStack[]{new ItemStack(ModBlocks.INJECTION_TABLE)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.INJECTED_GOLD_INGOT)},
                new ItemStack[]{new ItemStack(Items.GOLD_INGOT)}
        );
        InjectionTableRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.INJECTED_COCOA_SPAR)},
                new ItemStack[]{new ItemStack(ModItems.COCOA_SPAR)}
        );
    }


}
