package com.ccxia.cbcraft.api.recipe;

import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class InjectionTableRecipe {
    public final Map<Object[], ItemStack[]> RecipesList = Maps.newHashMap();
    public static final InjectionTableRecipe RECIPE_BASE = new InjectionTableRecipe();

    public static InjectionTableRecipe instance() {
        return RECIPE_BASE;
    }

    public void addFermentationBakerRecipe(ItemStack[] result, Object[] main) {
        RecipesList.put(main, result);
    }
}
