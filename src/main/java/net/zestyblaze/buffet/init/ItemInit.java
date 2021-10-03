package net.zestyblaze.buffet.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.buffet.Buffet;
import net.zestyblaze.buffet.block.BuffetBlocks;
import net.zestyblaze.buffet.food.BuffetMeals;
import net.zestyblaze.buffet.item.BuffetTools;
import net.zestyblaze.buffet.item.knives.Knives;

public class ItemInit {
    public static void register() {
        ///Cooking Tools
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "pan"), BuffetTools.PAN);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "pot"), BuffetTools.POT);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "baking_bowl"), BuffetTools.BAKING_BOWL);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "spoon"), BuffetTools.SPOON);

        ///Meals
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "chorus_soup"), BuffetMeals.CHORUS_SOUP);

        ///Knives
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "wooden_knife"), Knives.WOODEN_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "stone_knife"), Knives.STONE_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "iron_knife"), Knives.IRON_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "golden_knife"), Knives.GOLDEN_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "diamond_knife"), Knives.DIAMOND_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "netherite_knife"), Knives.NETHERITE_KNIFE);

        ///Cooking Blocks
        Registry.register(Registry.ITEM, new Identifier(Buffet.MOD_ID, "stove"), new BlockItem(BuffetBlocks.STOVE, new FabricItemSettings().group(Buffet.BUFFET_BLOCKS)));
    }

}
