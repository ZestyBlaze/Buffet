package net.zestyblaze.buffet.init;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.zestyblaze.buffet.block.StrawberryCropBlock;

public class ClientInit {

    public static void register() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), StrawberryCropBlock.STRAWBERRY_PLANT);
    }

}
