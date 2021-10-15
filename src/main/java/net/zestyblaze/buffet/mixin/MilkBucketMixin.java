package net.zestyblaze.buffet.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.MilkBucketItem;
import net.zestyblaze.buffet.init.EffectInit;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Iterator;
import java.util.Map;

@Mixin(MilkBucketItem.class)
public class MilkBucketMixin {
    @Redirect(method = "finishUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;clearStatusEffects()Z"))
    public boolean changeEffects(@NotNull LivingEntity entity) {
        Map<StatusEffect, StatusEffectInstance> map = entity.getActiveStatusEffects();
        boolean changed = false;

        for(Iterator<StatusEffect> iterator = map.keySet().iterator(); iterator.hasNext();) {
            StatusEffect effect = iterator.next();
            StatusEffectInstance instance = map.get(effect);

            if(instance.getEffectType() != EffectInit.Bleeding) {
                iterator.remove();
                ((LivingEntityAccess)entity).removeStatusEffect(instance);
                changed = true;
            }
        }
        return changed;
    }
}
