package net.zestyblaze.buffet.food;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.zestyblaze.buffet.item.BuffetTools;
import net.zestyblaze.buffet.util.BuffetGroups;
import org.jetbrains.annotations.NotNull;

public class BuffetDrinks {

    public static final Item STRAWBERRY_MILKSHAKE = new GlassItem(new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .hunger(5)
                    .saturationModifier(2.1F)
                    .build()
            )
            .group(BuffetGroups.BUFFET_DRINKS)
    );

    private static class GlassItem extends Item {
        public GlassItem(Settings settings) {
            super(settings);
        }

        @Override
        public UseAction getUseAction(ItemStack stack) {
            return UseAction.DRINK;
        }

        public SoundEvent getDrinkSound() {
            return SoundEvents.ENTITY_GENERIC_DRINK;
        }

        public SoundEvent getEatSound() {
            return SoundEvents.ENTITY_GENERIC_DRINK;
        }

        @Override
        public @NotNull ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
            super.finishUsing(stack, world, user);
            if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
                serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            }

            if (stack.isEmpty()) {
                return new ItemStack(BuffetTools.GLASS);
            } else {
                if (user instanceof PlayerEntity playerEntity && !((PlayerEntity) user).getAbilities().creativeMode) {
                    ItemStack itemStack = new ItemStack(BuffetTools.GLASS);
                    if (!playerEntity.getInventory().insertStack(itemStack)) {
                        playerEntity.dropItem(itemStack, false);
                    }
                }

                return stack;
            }
        }

    }
}
