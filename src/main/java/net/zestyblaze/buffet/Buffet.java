package net.zestyblaze.buffet;

import net.fabricmc.api.ModInitializer;
import net.zestyblaze.buffet.init.BlockInit;
import net.zestyblaze.buffet.init.EffectInit;
import net.zestyblaze.buffet.init.ItemInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Buffet implements ModInitializer {

	public static final String MODID = "buffet";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Buffet Loading! Thanks for downloading the mod <3");
		ItemInit.register();
		BlockInit.register();
        EffectInit.register();
	}
}
