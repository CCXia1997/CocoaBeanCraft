package com.ccxia.cbcraft.compat.jei;

import com.ccxia.cbcraft.api.recipe.AutoCrushRecipe;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AutoCrushMaker {
    public static List<SimpleRecipe> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        List<SimpleRecipe> recipes = new ArrayList<SimpleRecipe>();

        for (Map.Entry<Object[], ItemStack[]> entry : AutoCrushRecipe.instance().RecipesList.entrySet()) {
            List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
            for (Object obj : entry.getKey()) {
                List<ItemStack> subinputs = stackHelper.toItemStackList(obj);
                inputs.add(subinputs);
            }
            List<List<ItemStack>> outputs = new ArrayList<List<ItemStack>>();
            for (ItemStack obj : entry.getValue()) {
                List<ItemStack> suboutputs = stackHelper.toItemStackList(obj);
                outputs.add(suboutputs);
            }
            SimpleRecipe newrecipe = new SimpleRecipe(inputs, outputs);
            recipes.add(newrecipe);
        }
        return recipes;
    }
}
