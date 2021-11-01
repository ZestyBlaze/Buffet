package net.zestyblaze.buffet.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.zestyblaze.buffet.util.BuffetGroups;

public class BuffetTools {

    public static final Item METAL_PAN = new Item(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_TOOLS)
                    .maxCount(1)
    );

    public static final Item METAL_POT = new Item(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_TOOLS)
                    .maxCount(1)
    );

    public static final Item BAKING_BOWL = new Item(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_TOOLS)
                    .maxCount(1)
    );

    public static final Item WOODEN_SPOON = new Item(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_TOOLS)
                    .maxCount(1)
    );

    public static final Item GLASS = new Item(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_TOOLS)
    );

    public static final Item UNFIRED_PLATE = new Item(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_TOOLS)
    );

    public static final Item UNFIRED_MUG = new Item(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_TOOLS)
    );

    public static final Item PLATE = new Item(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_TOOLS)
    );

    public static final Item MUG = new Item(
            new FabricItemSettings()
                    .group(BuffetGroups.BUFFET_TOOLS)
    );

}
