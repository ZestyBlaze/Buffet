package net.zestyblaze.buffet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.zestyblaze.buffet.block.BuffetBlocks;
import net.zestyblaze.buffet.food.BuffetMeals;
import net.zestyblaze.buffet.init.BlockInit;
import net.zestyblaze.buffet.init.EffectInit;
import net.zestyblaze.buffet.init.ItemInit;
import net.zestyblaze.buffet.item.BuffetTools;
import net.zestyblaze.buffet.item.knives.Knives;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Buffet implements ModInitializer {

	public static final String MOD_ID = "buffet";
	
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static final ItemGroup BUFFET_TOOLS = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "buffet_tools"),
			() -> new ItemStack(BuffetTools.PAN)
	);

	public static final ItemGroup BUFFET_KNIVES = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "buffet_knives"),
			() -> new ItemStack(Knives.IRON_KNIFE)
	);

	public static final ItemGroup BUFFET_BLOCKS = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "buffet_blocks"),
			() -> new ItemStack(BuffetBlocks.STOVE)
	);

	public static final ItemGroup BUFFET_MEALS = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "buffet_meals"),
			() -> new ItemStack(BuffetMeals.CHORUS_SOUP)
	);

	@Override
	public void onInitialize() {
		ItemInit.register();
		BlockInit.register();
        EffectInit.register();
	}
}
