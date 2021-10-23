package net.zestyblaze.buffet.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.zestyblaze.buffet.block.StrawberryBlock;

public class BuffetFruits {
    public static final Item STRAWBERRIES = new BlockItem(StrawberryBlock.STRAWBERRY_PLANT, new FabricItemSettings()
            .group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).build()));

}
