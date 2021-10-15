package net.zestyblaze.buffet.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.world.World;
import net.zestyblaze.buffet.Buffet;
import net.zestyblaze.buffet.init.EffectInit;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;

@Mixin(MilkBucketItem.class)
public class MilkBucketItemMixin {
    @Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
    public void buffetMilkBucketItemChanges(ItemStack stack, @NotNull World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if(!world.isClient) {
            if (user.hasStatusEffect(EffectInit.Bleeding)) {
                if(user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                    cir.setReturnValue(new ItemStack(Items.BUCKET));
                    Iterator<StatusEffectInstance> status = user.getActiveStatusEffects().values().iterator();
                    while(status.hasNext()) {
                        StatusEffectInstance statusEffectInstance = status.next();
                        if(statusEffectInstance.getEffectType() != EffectInit.Bleeding) {
                            user.removeStatusEffect(statusEffectInstance.getEffectType());
                            status.remove();
                        }
                    }
                }
                cir.setReturnValue(stack);
            }
        }
    }
}
