package net.zestyblaze.buffet.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.zestyblaze.buffet.Buffet;
import net.zestyblaze.buffet.init.EffectInit;
import net.zestyblaze.buffet.util.CustomKnifeBuilder;
import org.jetbrains.annotations.NotNull;

public class BuffetKnives {

    public static CustomKnifeBuilder WOODEN = new CustomKnifeBuilder.KnifeBuilder("wooden")
            .setDamage(1.0f)
            .setDurability(29)
            .setRepairItem(Ingredient.fromTag(ItemTags.PLANKS))
            .build();

    public static CustomKnifeBuilder STONE = new CustomKnifeBuilder.KnifeBuilder("stone")
            .setDamage(2.0f)
            .setDurability(66)
            .setRepairItem(Ingredient.ofItems(Items.COBBLESTONE))
            .build();

    public static CustomKnifeBuilder IRON = new CustomKnifeBuilder.KnifeBuilder("iron")
            .setDamage(3.0f)
            .setDurability(125)
            .setRepairItem(Ingredient.ofItems(Items.IRON_INGOT))
            .build();

    public static CustomKnifeBuilder GOLDEN = new CustomKnifeBuilder.KnifeBuilder("golden")
            .setDamage(1.0f)
            .setDurability(16)
            .setRepairItem(Ingredient.ofItems(Items.GOLD_INGOT))
            .build();

    public static CustomKnifeBuilder DIAMOND = new CustomKnifeBuilder.KnifeBuilder("diamond")
            .setDamage(4.0f)
            .setDurability(780)
            .setRepairItem(Ingredient.ofItems(Items.DIAMOND))
            .build();

    public static CustomKnifeBuilder NETHERITE = new CustomKnifeBuilder.KnifeBuilder("netherite")
            .setDamage(5.0f)
            .setDurability(1015)
            .setRepairItem(Ingredient.ofItems(Items.NETHERITE_INGOT))
            .build();

    public static ToolItem WOODEN_KNIFE = new KnifeItem(WOODEN, 0, -1.6f, new Item.Settings().group(Buffet.BUFFET_KNIVES));
    public static ToolItem STONE_KNIFE = new KnifeItem(STONE, 0, -1.6f, new Item.Settings().group(Buffet.BUFFET_KNIVES));
    public static ToolItem IRON_KNIFE = new KnifeItem(IRON, 0, -1.6f, new Item.Settings().group(Buffet.BUFFET_KNIVES));
    public static ToolItem GOLDEN_KNIFE = new KnifeItem(GOLDEN, 0, -1.6f, new Item.Settings().group(Buffet.BUFFET_KNIVES));
    public static ToolItem DIAMOND_KNIFE = new KnifeItem(DIAMOND, 0, -1.6f, new Item.Settings().group(Buffet.BUFFET_KNIVES));
    public static ToolItem NETHERITE_KNIFE = new KnifeItem(NETHERITE, 0, -1.6f, new Item.Settings().group(Buffet.BUFFET_KNIVES));


    public static class KnifeItem extends SwordItem {
        public KnifeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
            super(toolMaterial, attackDamage, attackSpeed, settings);
        }

        @Override
        public boolean postHit(@NotNull ItemStack stack, @NotNull LivingEntity target, LivingEntity attacker) {
            stack.damage(1, attacker, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
            target.addStatusEffect(new StatusEffectInstance(EffectInit.Bleeding, 100, 0, false, false));
            return true;
        }
    }
}
