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
        // �ɿɶ�->��ɿɶ�
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COOKED_COCOA_BEANS, 1)},
                new ItemStack[]{new ItemStack(Item.getItemById(351), 1, 3)}
        );
        // ��֬��->����
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.CHEESE)},
                new ItemStack[]{new ItemStack(ModItems.SKIM_MILK)}
        );
        // ţ��+��->����
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.YOGURT)},
                new ItemStack[]{new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR)}
        );
        // ֩����+��->����֩����
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.FERMENTED_SPIDER_EYE, 1)},
                new ItemStack[]{new ItemStack(Items.SPIDER_EYE), new ItemStack(Items.SUGAR)}
        );
        // ��Ģ��->��Ģ����
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM_BLOCK))},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.BROWN_MUSHROOM))}
        );
        // ��Ģ��->��Ģ����
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.RED_MUSHROOM_BLOCK))},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.RED_MUSHROOM))}
        );
        // ������->�������
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK))},
                new ItemStack[]{new ItemStack(Items.NETHER_WART)}
        );
        // ����->���
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.BREAD)},
                new ItemStack[]{new ItemStack(ModItems.DOUGH)}
        );
        // ����+�ɿɷ�->�ɿ����
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COCOA_BREAD)},
                new ItemStack[]{new ItemStack(ModItems.DOUGH), new ItemStack(ModItems.COCOA_POWDER)}
        );
        // ��������->�������
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModBlocks.CAKE_BASE)},
                new ItemStack[]{new ItemStack(ModItems.EGG_MILK_DOUGH)}
        );
        // ��������+�ɿɷ�->�ɿɵ������
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModBlocks.COCOA_CAKE_BASE)},
                new ItemStack[]{new ItemStack(ModItems.EGG_MILK_DOUGH), new ItemStack(ModItems.COCOA_POWDER)}
        );
        // ��������->8�����
        FermentationBakerRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.COOKIE, 8)},
                new ItemStack[]{new ItemStack(ModItems.COOKIE_DOUGH)}
        );
    }

    public void crushRegister() {
        // 1��ɿɶ�->1�ɿɸ�
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COCOA_PASTE)},
                new ItemStack[]{new ItemStack(ModItems.COOKED_COCOA_BEANS)}
        );
        // 1ɰ��->1��ʯ
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.FLINT)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL))}
        );
        // 1�������->6������
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.NETHER_WART, 6)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK))}
        );
        // 1ʯӢ��->2ʯӢ
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.QUARTZ, 2)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK))}
        );
        // 1�����->4�����
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.CLAY_BALL, 4)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.CLAY))}
        );
        // 1���Ͽ�->6����
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.MELON, 6)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.MELON_BLOCK))}
        );
        // 1�ҽ���->2�ҽ���
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.MAGMA_CREAM, 2)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.MAGMA))}
        );
        // 1�����->3�����
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.BLAZE_POWDER, 3)},
                new ItemStack[]{new ItemStack(Items.BLAZE_ROD)}
        );
        // 1��ͷ->4�Ƿ�
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.DYE, 4, 15)},
                new ItemStack[]{new ItemStack(Items.BONE)}
        );
        // 1С��->1���
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.FLOUR, 1)},
                new ItemStack[]{new ItemStack(Items.WHEAT)}
        );
        // 1����->1�����
        CrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.CLAY_BALL)},
                new ItemStack[]{new ItemStack(ItemAir.getItemFromBlock(Blocks.DIRT))}
        );
    }

    public void separatorRegister() {
        // �ɿ�Һ��->�ɿ�֬+�ɿɷ�
        SeparatorRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COCOA_BUTTER), new ItemStack(ModItems.COCOA_POWDER)},
                new ItemStack[]{new ItemStack(ModItems.COCOA_LIQUOR)}
        );
        // �ҽ���->ճҺ��+�����
        SeparatorRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.SLIME_BALL), new ItemStack(Items.BLAZE_POWDER)},
                new ItemStack[]{new ItemStack(Items.MAGMA_CREAM)}
        );
        // ţ��->����+��֬��
        SeparatorRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.CREAM), new ItemStack(ModItems.SKIM_MILK)},
                new ItemStack[]{new ItemStack(Items.MILK_BUCKET)}
        );
    }

    public void autoCrushRegister() {
        // 1��ɿɶ�->1�ɿɸ�
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.COCOA_PASTE)},
                new ItemStack[]{new ItemStack(ModItems.COOKED_COCOA_BEANS)}
        );
        // 1ɰ��->1��ʯ
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.FLINT)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL))}
        );
        // 1�������->6������
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.NETHER_WART, 6)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.NETHER_WART_BLOCK))}
        );
        // 1ʯӢ��->2ʯӢ
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.QUARTZ, 2)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK))}
        );
        // 1�����->4�����
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.CLAY_BALL, 4)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.CLAY))}
        );
        // 1���Ͽ�->6����
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.MELON, 6)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.MELON_BLOCK))}
        );
        // 1�ҽ���->2�ҽ���
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.MAGMA_CREAM, 2)},
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.MAGMA))}
        );
        // 1�����->3�����
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.BLAZE_POWDER, 3)},
                new ItemStack[]{new ItemStack(Items.BLAZE_ROD)}
        );
        // 1��ͷ->4�Ƿ�
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.DYE, 4, 15)},
                new ItemStack[]{new ItemStack(Items.BONE)}
        );
        // 1С��->1���
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(ModItems.FLOUR, 1)},
                new ItemStack[]{new ItemStack(Items.WHEAT)}
        );
        // 1����->1�����
        AutoCrushRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Items.CLAY_BALL)},
                new ItemStack[]{new ItemStack(ItemAir.getItemFromBlock(Blocks.DIRT))}
        );
    }

    public void autoPressingRegister() {
        // 4ѩ��->1ѩ
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.SNOW))},
                new ItemStack[]{new ItemStack(Items.SNOWBALL, 4)}
        );
        // 9����->1����
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK))},
                new ItemStack[]{new ItemStack(Items.IRON_INGOT, 9)}
        );
        // 9��->1���
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.GOLD_BLOCK))},
                new ItemStack[]{new ItemStack(Items.GOLD_INGOT, 9)}
        );
        // 9ú̿->1ú̿��
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.COAL_BLOCK))},
                new ItemStack[]{new ItemStack(Items.COAL, 9)}
        );
        // 9��ʯ->1��ʯ��
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_BLOCK))},
                new ItemStack[]{new ItemStack(Items.REDSTONE, 9)}
        );
        // 9�ྦྷʯ->1�ྦྷʯ��
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.LAPIS_BLOCK))},
                new ItemStack[]{new ItemStack(Items.DYE, 9, EnumDyeColor.BLUE.getDyeDamage())}
        );
        // 9�̱�ʯ->1�̱�ʯ��
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.EMERALD_BLOCK))},
                new ItemStack[]{new ItemStack(Items.EMERALD, 9)}
        );
        // 9��ʯ->1��ʯ��
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK))},
                new ItemStack[]{new ItemStack(Items.DIAMOND, 9)}
        );
        // 9ճҺ��->1ճҺ��
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK))},
                new ItemStack[]{new ItemStack(Items.SLIME_BALL, 9)}
        );
        // 4���ɿ���->4���ɿ�����
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(ModBlocks.DARK_CHOCOLATE_BLOCK))},
                new ItemStack[]{new ItemStack(ModItems.DARK_CHOCOLATE, 4)}
        );
        // 4���ɿ���->4���ɿ�����
        AutoPressingRecipe.instance().addFermentationBakerRecipe(
                new ItemStack[]{new ItemStack(Item.getItemFromBlock(ModBlocks.MILK_CHOCOLATE_BLOCK))},
                new ItemStack[]{new ItemStack(ModItems.MILK_CHOCOLATE, 4)}
        );
        // 4���ɿ���->4���ɿ�����
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
