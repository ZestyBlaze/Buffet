package net.zestyblaze.buffet.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.zestyblaze.buffet.util.CustomDamageSource;

public class BleedingEffect extends StatusEffect {
    public BleedingEffect() {
        super(StatusEffectCategory.HARMFUL, 0x660000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity != null && !entity.isUndead()) {
            entity.damage(CustomDamageSource.BLEEDING, 0.4f);
        }
    }
}
