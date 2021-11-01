package net.zestyblaze.buffet.util;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.zestyblaze.buffet.Buffet;
import net.zestyblaze.buffet.block.BrickGrillBlock;
import net.zestyblaze.buffet.food.BuffetDrinks;
import net.zestyblaze.buffet.food.BuffetMeals;
import net.zestyblaze.buffet.item.BandageItem;
import net.zestyblaze.buffet.food.BuffetFruits;
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
            () -> new ItemStack(BrickGrillBlock.BRICK_GRILL)
    );

    public static final ItemGroup BUFFET_FRUITS = FabricItemGroupBuilder.build(
            new Identifier(Buffet.MODID, "buffet_fruits"),
            () -> new ItemStack(BuffetFruits.STRAWBERRIES)
    );

    public static final ItemGroup BUFFET_MEALS = FabricItemGroupBuilder.build(
            new Identifier(Buffet.MODID, "buffet_meals"),
            () -> new ItemStack(BuffetMeals.CHORUS_SOUP)
    );

    public static final ItemGroup BUFFET_DRINKS = FabricItemGroupBuilder.build(
            new Identifier(Buffet.MODID, "buffet_drinks"),
            () -> new ItemStack(BuffetDrinks.STRAWBERRY_MILKSHAKE)
    );

    public static final ItemGroup BUFFET_MISC = FabricItemGroupBuilder.build(
            new Identifier(Buffet.MODID, "buffet_misc"),
            () -> new ItemStack(BandageItem.BANDAGE)
    );

}
