package net.zestyblaze.buffet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class BuffetBlocks {

    public static final Block BRICK_GRILL = new Block(FabricBlockSettings.of(
            Material.REPAIR_STATION)
            .strength(2.5f, 2.5f)
            .breakByTool(FabricToolTags.AXES)
            .requiresTool()
    );

}
