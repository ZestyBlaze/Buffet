package net.zestyblaze.buffet.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.buffet.Buffet;
import net.zestyblaze.buffet.block.BrickGrillBlock;
import net.zestyblaze.buffet.food.BuffetDrinks;
import net.zestyblaze.buffet.food.BuffetMeals;
import net.zestyblaze.buffet.item.BandageItem;
import net.zestyblaze.buffet.item.BuffetTools;
import net.zestyblaze.buffet.item.BuffetKnives;
import net.zestyblaze.buffet.util.BuffetGroups;

public class ItemInit {
    public static void register() {
        ///Cooking Tools
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "metal_pan"), BuffetTools.METAL_PAN);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "metal_pot"), BuffetTools.METAL_POT);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "baking_bowl"), BuffetTools.BAKING_BOWL);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "wooden_spoon"), BuffetTools.WOODEN_SPOON);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "glass"), BuffetTools.GLASS);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "unfired_plate"), BuffetTools.UNFIRED_PLATE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "unfired_mug"), BuffetTools.UNFIRED_MUG);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "plate"), BuffetTools.PLATE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "mug"), BuffetTools.MUG);

        ///Meals
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "pepperoni_pizza"), BuffetMeals.PEPPERONI_PIZZA);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "chorus_soup"), BuffetMeals.CHORUS_SOUP);

        ///Drinks
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "strawberry_milkshake"), BuffetDrinks.STRAWBERRY_MILKSHAKE);

        ///Knives
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "wooden_knife"), BuffetKnives.WOODEN_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "stone_knife"), BuffetKnives.STONE_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "iron_knife"), BuffetKnives.IRON_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "golden_knife"), BuffetKnives.GOLDEN_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "diamond_knife"), BuffetKnives.DIAMOND_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "netherite_knife"), BuffetKnives.NETHERITE_KNIFE);

        ///Misc Items
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "bandages"), BandageItem.BANDAGE);


        ///Cooking Blocks
        Registry.register(Registry.ITEM, new Identifier(Buffet.MODID, "brick_grill"), new BlockItem(BrickGrillBlock.BRICK_GRILL, new FabricItemSettings().group(BuffetGroups.BUFFET_BLOCKS)));
    }

}
