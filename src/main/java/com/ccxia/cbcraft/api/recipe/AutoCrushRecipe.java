package com.ccxia.cbcraft.api.recipe;

import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class AutoCrushRecipe {
    public final Map<Object[], ItemStack[]> RecipesList = Maps.newHashMap();
    public static final AutoCrushRecipe RECIPE_BASE = new AutoCrushRecipe();

    public static AutoCrushRecipe instance() {
        return RECIPE_BASE;
    }

    public void addFermentationBakerRecipe(ItemStack[] result, Object[] main) {
        RecipesList.put(main, result);
    }
}
