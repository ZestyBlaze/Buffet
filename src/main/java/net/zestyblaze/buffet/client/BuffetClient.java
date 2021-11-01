package net.zestyblaze.buffet.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.zestyblaze.buffet.block.StrawberryCropBlock;
import net.zestyblaze.buffet.init.ClientInit;

public class BuffetClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientInit.register();
    }
}
