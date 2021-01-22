package com.ccxia.cbcraft.compat.jei;

import com.ccxia.cbcraft.CbCraft;
import com.ccxia.cbcraft.block.ModBlocks;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CategoryAutoPressing implements IRecipeCategory<IRecipeWrapper> {
    protected final IDrawable background;
    private final IDrawable icon;

    public CategoryAutoPressing(IGuiHelper helper) {
        ResourceLocation backgroundTexture = new ResourceLocation(CbCraft.MODID +
                ":textures/gui/container/auto_pressing_machine.png");
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.AUTO_PRESSING_MACHINE));
        // 这边相当于从gui图片里截取出一部分图案，因为jei显示并不需要整张gui图片
        this.background = helper.createDrawable(backgroundTexture, 41, 17, 94, 22);
    }

    @Override
    public String getUid() {
        return "cbcraft.auto_pressing_machine";
    }

    @Override
    public String getTitle() {
        return I18n.format("jei.cbcraft.category.autoPressing", new Object[0]);
    }

    @Override
    public String getModName() {
        return CbCraft.NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayout arg0, IRecipeWrapper iRecipeWrapper, IIngredients arg2) {
        IGuiItemStackGroup items = arg0.getItemStacks();
        items.init(0, true, 2, 2);
        items.init(1, false, 74, 2);
        items.set(arg2);
    }

    public IDrawable getIcon() {
        return icon;
    }
}
