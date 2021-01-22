package com.ccxia.cbcraft.compat.jei;

import com.ccxia.cbcraft.block.ModBlocks;
import com.ccxia.cbcraft.inventory.*;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEICompat implements IModPlugin {
    @Override
    public void register(IModRegistry registry) {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();

        registry.addRecipes(FermentationBakerRecipeMaker.getRecipes(jeiHelpers), "cbcraft.fermentation_baking_machine");
        registry.addRecipes(CrushMaker.getRecipes(jeiHelpers), "cbcraft.crushing_grinding_machine");
        registry.addRecipes(SeparatorRecipeMaker.getRecipes(jeiHelpers), "cbcraft.separator");
        registry.addRecipes(AutoCrushMaker.getRecipes(jeiHelpers), "cbcraft.auto_crushing_grinding_machine");
        registry.addRecipes(AutoPressingMaker.getRecipes(jeiHelpers), "cbcraft.auto_pressing_machine");
        registry.addRecipes(InjectionTableMaker.getRecipes(jeiHelpers), "cbcraft.injection_table");

        registry.addRecipeClickArea(GuiFermentationBaker.class, 79, 35, 24, 17, "cbcraft.fermentation_baking_machine");
        registry.addRecipeClickArea(GuiCrushingGrindingMachine.class, 76, 19, 25, 17, "cbcraft.crushing_grinding_machine");
        registry.addRecipeClickArea(GuiSeparator.class, 79, 34, 24, 17, "cbcraft.separator");
        registry.addRecipeClickArea(GuiAutoCrushing.class, 76, 19, 25, 17, "cbcraft.auto_crushing_grinding_machine");
        registry.addRecipeClickArea(GuiAutoPressing.class, 76, 19, 25, 17, "cbcraft.auto_pressing_machine");
        registry.addRecipeClickArea(GuiInjectionTable.class, 76, 25, 25, 17, "cbcraft.injection_table");

        recipeTransferRegistry.addRecipeTransferHandler(ContainerFermentationBaker.class, "cbcraft.fermentation_baking_machine", 0, 3, 4, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerCrushingGrindingMachine.class, "cbcraft.crushing_grinding_machine", 1, 2, 2, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerSeparator.class, "cbcraft.separator", 0, 2, 4, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerAutoCrushing.class, "cbcraft.auto_crushing_grinding_machine", 0, 1, 2, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerAutoPressing.class, "cbcraft.auto_pressing_machine", 0, 1, 2, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerInjectionTable.class, "cbcraft.injection_table", 1, 2, 3, 36);

        registry.addRecipeCatalyst(new ItemStack(ModBlocks.FERMENTATION_BAKER), "cbcraft.fermentation_baking_machine");
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.CRUSHING_GRINDING_MACHINE), "cbcraft.crushing_grinding_machine");
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.SEPARATOR), "cbcraft.separator");
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.AUTO_CRUSHING_GRINDING_MACHINE), "cbcraft.auto_crushing_grinding_machine");
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.AUTO_PRESSING_MACHINE), "cbcraft.auto_pressing_machine");
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.INJECTION_TABLE), "cbcraft.injection_table");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new IRecipeCategory[]{
                new CategoryFermentationBaker(registry.getJeiHelpers().getGuiHelper()),
                new CategoryCrush(registry.getJeiHelpers().getGuiHelper()),
                new CategorySeparator(registry.getJeiHelpers().getGuiHelper()),
                new CategoryAutoCrush(registry.getJeiHelpers().getGuiHelper()),
                new CategoryAutoPressing(registry.getJeiHelpers().getGuiHelper()),
                new CategoryInjectionTable(registry.getJeiHelpers().getGuiHelper())
        });
    }
}
