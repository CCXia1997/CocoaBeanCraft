package com.ccxia.cbcraft.inventory.crafting;

import com.ccxia.cbcraft.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.ccxia.cbcraft.block.ModBlocks;

public class RecipesInjection {
    private Map<ItemStack, ItemStack> injectionRecipes = new HashMap(8);
    private Map<ItemStack, Integer> injectionCosts = new HashMap(8);
    public static final RecipesInjection INJECTION_MANAGER = new RecipesInjection();

    private RecipesInjection() {
        add(new ItemStack(ModBlocks.DARK_CHOCOLATE_BLOCK), 1, new ItemStack(ModBlocks.INJECTED_DARK_CHOCOLATE));
        add(new ItemStack(ModBlocks.MILK_CHOCOLATE_BLOCK), 1, new ItemStack(ModBlocks.INJECTED_MILK_CHOCOLATE));
        add(new ItemStack(ModBlocks.WHITE_CHOCOLATE_BLOCK), 1, new ItemStack(ModBlocks.INJECTED_WHITE_CHOCOLATE));
        add(new ItemStack(ModBlocks.CRUSHING_GRINDING_MACHINE), 20, new ItemStack(ModBlocks.AUTO_CRUSHING_GRINDING_MACHINE));
        add(new ItemStack(Blocks.ANVIL, 1, 1), 10, new ItemStack(Blocks.ANVIL));
        add(new ItemStack(Blocks.ANVIL, 1, 2), 20, new ItemStack(Blocks.ANVIL));
        add(new ItemStack(Blocks.CRAFTING_TABLE), 30, new ItemStack(ModItems.PRESSING_MACHINE_CORE));
        add(new ItemStack(Items.EMERALD), 1, new ItemStack(ModItems.PURPLE_GEM));
    }

    private void add(final ItemStack input, int cost, ItemStack output) {
        injectionRecipes.put(input, output);
        injectionCosts.put(input, cost);
    }

    public int getCost(ItemStack input) {
        return injectionCosts.entrySet().stream()
                .filter(e -> ItemStack.areItemsEqual(e.getKey(), input)).findFirst()
                .map(Map.Entry::getValue).orElse(-1);
    }

    public Optional<ItemStack> getOutput(ItemStack input) {
        return injectionRecipes.entrySet().stream()
                .filter(e -> ItemStack.areItemsEqual(e.getKey(), input)).findFirst()
                .map(Map.Entry::getValue).map(ItemStack::copy);
    }
}
