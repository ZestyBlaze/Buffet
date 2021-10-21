package net.zestyblaze.buffet.util;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.zestyblaze.buffet.Buffet;
import net.zestyblaze.buffet.block.BuffetBlocks;
import net.zestyblaze.buffet.food.BuffetDrinks;
import net.zestyblaze.buffet.food.BuffetMeals;
import net.zestyblaze.buffet.item.BuffetKnives;
import net.zestyblaze.buffet.item.BuffetTools;

public class BuffetGroups {

    public static final ItemGroup BUFFET_TOOLS = FabricItemGroupBuilder.build(
            new Identifier(Buffet.MODID, "buffet_tools"),
            () -> new ItemStack(BuffetTools.METAL_PAN)
    );

    public static final ItemGroup BUFFET_KNIVES = FabricItemGroupBuilder.build(
            new Identifier(Buffet.MODID, "buffet_knives"),
            () -> new ItemStack(BuffetKnives.IRON_KNIFE)
    );

    public static final ItemGroup BUFFET_BLOCKS = FabricItemGroupBuilder.build(
            new Identifier(Buffet.MODID, "buffet_blocks"),
            () -> new ItemStack(BuffetBlocks.BRICK_GRILL)
    );

    public static final ItemGroup BUFFET_MEALS = FabricItemGroupBuilder.build(
            new Identifier(Buffet.MODID, "buffet_meals"),
            () -> new ItemStack(BuffetMeals.CHORUS_SOUP)
    );

    public static final ItemGroup BUFFET_DRINKS = FabricItemGroupBuilder.build(
            new Identifier(Buffet.MODID, "buffet_drinks"),
            () -> new ItemStack(BuffetDrinks.STRAWBERRY_MILKSHAKE)
    );

}
