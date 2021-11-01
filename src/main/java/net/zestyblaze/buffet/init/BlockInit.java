package net.zestyblaze.buffet.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.buffet.Buffet;
import net.zestyblaze.buffet.block.BrickGrillBlock;
import net.zestyblaze.buffet.block.StrawberryCropBlock;

public class BlockInit {

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(Buffet.MODID, "brick_grill"), BrickGrillBlock.BRICK_GRILL);
        Registry.register(Registry.BLOCK, new Identifier(Buffet.MODID, "strawberry_plant"), StrawberryCropBlock.STRAWBERRY_PLANT);
    }

}
