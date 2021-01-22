package com.ccxia.cbcraft.api.recipe;

import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class CrushRecipe {
    public final Map<Object[], ItemStack[]> RecipesList = Maps.newHashMap();
    public static final CrushRecipe RECIPE_BASE = new CrushRecipe();

    public static CrushRecipe instance() {
        return RECIPE_BASE;
    }

    public void addFermentationBakerRecipe(ItemStack[] result, Object[] main) {
        RecipesList.put(main, result);
    }
}
