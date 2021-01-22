package com.ccxia.cbcraft.api.recipe;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ccxia.cbcraft.item.ModItems;
import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FermentationBakerRecipe {
    public final Map<Object[], ItemStack[]> RecipesList = Maps.newHashMap();
    public static final FermentationBakerRecipe RECIPE_BASE = new FermentationBakerRecipe();

    public FermentationBakerRecipe() {

    }

    public static FermentationBakerRecipe instance() {
        return RECIPE_BASE;
    }

    public void addFermentationBakerRecipe(ItemStack[] result, Object[] main) {
        RecipesList.put(main, result);
    }


}
