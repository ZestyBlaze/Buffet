package net.zestyblaze.buffet.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.zestyblaze.buffet.init.EffectInit;
import net.zestyblaze.buffet.util.BuffetGroups;
import org.jetbrains.annotations.NotNull;

public class BandageItem extends Item {

    public static final BandageItem BANDAGE = new BandageItem(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_MISC)
                    .maxCount(16)
    );

    public BandageItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient) {
            if (user.hasStatusEffect(EffectInit.Bleeding)) {
                if(!user.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }
                user.removeStatusEffect(EffectInit.Bleeding);
                user.sendMessage((new TranslatableText("item.buffet.bandage.heal").formatted(Formatting.RED)), true);
            }
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

}
