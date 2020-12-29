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
        // �ж��Ƿ�Ϊ��ͨ���罦ҩˮ���ͣ�ͬʱҩˮ�ȼ���Ϊ1��ҩˮЧ��ֻ��1��
        // ͬʱҩˮ��Ҫ��֤û�б������ɿ�������ǿ��������Ȼֱ�Ӽ����Ʒ�Ƿ����CustomPotionEffect��ǩ����
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
            // ҩˮ�ȼ�+1������ʱ������50%
            List<PotionEffect> potion = new ArrayList<>();
            potion.add(new PotionEffect(oldPotion.getPotion(), (int) (oldPotion.getDuration() * 1.5),
                    oldPotion.getAmplifier() + 1, oldPotion.getIsAmbient(), oldPotion.doesShowParticles()));
            // ���Ҫ�ȸ���һ��������Զ���ҩˮ��nbt����Ȼֱ�ӾͰ�ԭ�ȵ���Ʒ�ĵ���
            // ��ʵҩˮ�ⶫ���ܿӣ�����д��Potion��CustomPotionEffect������ǩ���о��о�
            return PotionUtils.addPotionToItemStack(PotionUtils.appendEffects(input.copy(), potion), PotionTypes.WATER).
                    setStackDisplayName(input.getDisplayName() + "-" + I18n.translateToLocal("potion.milkStrength"));
        }
        return ItemStack.EMPTY;
    }
}
