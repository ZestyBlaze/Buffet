package net.zestyblaze.buffet.food;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.zestyblaze.buffet.Buffet;

public class BuffetMeals {

    public static final Item CHORUS_SOUP = new ChorusSoupItem(new FabricItemSettings()
            .group(Buffet.BUFFET_MEALS)
            .food(new FoodComponent.Builder()
                    .hunger(8)
                    .saturationModifier(8.4f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 2, false, false), 1.0F)
                    .build()
            )
    );

    public static class ChorusSoupItem extends ChorusFruitItem {
        public ChorusSoupItem(Settings settings) {
            super(settings);
        }

        @Override
        public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
            ItemStack itemStack = super.finishUsing(stack, world, user);
            if (!world.isClient) {
                double d = user.getX();
                double e = user.getY();
                double f = user.getZ();

                for (int i = 0; i < 16; ++i) {
                    double g = user.getX() + (user.getRandom().nextDouble() - 0.5D) * 16.0D;
                    double h = MathHelper.clamp(user.getY() + (double) (user.getRandom().nextInt(16) - 8), world.getBottomY(), world.getBottomY() + world.getLogicalHeight() - 1);
                    double j = user.getZ() + (user.getRandom().nextDouble() - 0.5D) * 16.0D;
                    if (user.hasVehicle()) {
                        user.stopRiding();
                    }

                    if (user.teleport(g, h, j, true)) {
                        SoundEvent soundEvent = user instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                        world.playSound(null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        user.playSound(soundEvent, 1.0F, 1.0F);
                        break;
                    }
                }

                if (user instanceof PlayerEntity) {
                    ((PlayerEntity) user).getItemCooldownManager().set(this, 20);
                }

                if(stack.isEmpty()){
                    return new ItemStack(Items.BOWL);
                } else {
                    if(user instanceof PlayerEntity player && !((PlayerEntity) user).getAbilities().creativeMode){
                        ItemStack bowl = new ItemStack(Items.BOWL);
                        if(!player.getInventory().insertStack(bowl)){
                            player.dropItem(bowl, false);
                        }
                    }
                }
            }

            return itemStack;
        }
    }

}
