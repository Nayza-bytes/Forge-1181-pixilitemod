package net.nayza.pixilitemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties COOKED_SULIM_SEEDS = new  FoodProperties.Builder().nutrition(3).saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 20, 3), 0.4f).build();
}
