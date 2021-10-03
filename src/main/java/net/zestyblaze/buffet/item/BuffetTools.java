package net.zestyblaze.buffet.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.zestyblaze.buffet.Buffet;

public class BuffetTools {

    public static final Item PAN = new Item(
            new FabricItemSettings()
                    .group(Buffet.BUFFET_TOOLS)
                    .maxCount(1)
    );

    public static final Item POT = new Item(
            new FabricItemSettings()
                    .group(Buffet.BUFFET_TOOLS)
                    .maxCount(1)
    );

    public static final Item BAKING_BOWL = new Item(
            new FabricItemSettings()
                    .group(Buffet.BUFFET_TOOLS)
                    .maxCount(1)
    );

    public static final Item SPOON = new Item(
            new FabricItemSettings()
                    .group(Buffet.BUFFET_TOOLS)
                    .maxCount(1)
    );

}
