package com.ccxia.cbcraft.compat.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.ccxia.cbcraft.api.recipe.CrushRecipe;
import com.ccxia.cbcraft.api.recipe.FermentationBakerRecipe;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class FermentationBakerRecipeMaker {
    public static List<SimpleRecipe> getRecipes(IJeiHelpers helpers)
    {
        IStackHelper stackHelper = helpers.getStackHelper();
        List<SimpleRecipe> recipes = new ArrayList<SimpleRecipe>();

        for (Entry<Object[], ItemStack[]> entry : FermentationBakerRecipe.instance().RecipesList.entrySet()) {
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
            SimpleRecipe newrecipe = new SimpleRecipe(inputs,outputs);
            recipes.add(newrecipe);
        }
        return recipes;
    }
}
