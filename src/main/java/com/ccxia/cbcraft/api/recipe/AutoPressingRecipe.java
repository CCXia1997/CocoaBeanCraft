package com.ccxia.cbcraft.api.recipe;

import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class AutoPressingRecipe {
    public final Map<Object[], ItemStack[]> RecipesList = Maps.newHashMap();
    public static final AutoPressingRecipe RECIPE_BASE = new AutoPressingRecipe();

    public static AutoPressingRecipe instance() {
        return RECIPE_BASE;
    }

    public void addFermentationBakerRecipe(ItemStack[] result, Object[] main) {
        RecipesList.put(main, result);
    }
}
