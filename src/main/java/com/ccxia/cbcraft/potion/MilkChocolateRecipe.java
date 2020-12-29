package com.ccxia.cbcraft.potion;

import com.ccxia.cbcraft.item.ModItems;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemLingeringPotion;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.brewing.IBrewingRecipe;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MilkChocolateRecipe implements IBrewingRecipe {
    @Override
    public boolean isInput(@Nonnull ItemStack input) {
        // 判断是否为普通和喷溅药水类型，同时药水等级需为1且药水效果只有1种
        // 同时药水需要保证没有被其他巧克力类型强化过，当然直接检测物品是否存在CustomPotionEffect标签即可
        if (!(input.getItem() instanceof ItemPotion) || (input.getItem() instanceof ItemLingeringPotion)) {
            return false;
        }
        List<PotionEffect> potionEffectList = PotionUtils.getEffectsFromStack(input);
        if (potionEffectList.size() != 1) {
            return false;
        } else if (potionEffectList.get(0).getAmplifier() == 0 &&
                !(input.getTagCompound().hasKey("CustomPotionEffects"))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isIngredient(@Nonnull ItemStack ingredient) {
        return ingredient.getItem() == ModItems.MILK_CHOCOLATE;
    }

    @Nonnull
    @Override
    public ItemStack getOutput(@Nonnull ItemStack input, @Nonnull ItemStack ingredient) {
        if (isInput(input) && isIngredient(ingredient)) {
            PotionEffect oldPotion = PotionUtils.getEffectsFromStack(input).get(0);
            // 药水等级+1，持续时间提升50%
            List<PotionEffect> potion = new ArrayList<>();
            potion.add(new PotionEffect(oldPotion.getPotion(), (int) (oldPotion.getDuration() * 1.5),
                    oldPotion.getAmplifier() + 1, oldPotion.getIsAmbient(), oldPotion.doesShowParticles()));
            // 这边要先复制一份再添加自定义药水的nbt，不然直接就把原先的物品改掉了
            // 其实药水这东西很坑，不好写，Potion和CustomPotionEffect这俩标签得研究研究
            return PotionUtils.addPotionToItemStack(PotionUtils.appendEffects(input.copy(), potion), PotionTypes.WATER).
                    setStackDisplayName(input.getDisplayName() + "-" + I18n.translateToLocal("potion.milkStrength"));
        }
        return ItemStack.EMPTY;
    }
}
