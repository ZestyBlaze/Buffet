package net.zestyblaze.buffet.food;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.zestyblaze.buffet.block.StrawberryCropBlock;
import net.zestyblaze.buffet.util.BuffetGroups;

public class BuffetFruits {
    public static final Item STRAWBERRIES = new BlockItem(StrawberryCropBlock.STRAWBERRY_PLANT, new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .hunger(3)
                    .saturationModifier(0.1f)
                    .build()
            )
            .group(BuffetGroups.BUFFET_FRUITS)
    );

}
