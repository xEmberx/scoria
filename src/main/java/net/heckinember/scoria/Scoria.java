package net.heckinember.scoria;

import net.fabricmc.api.ModInitializer;
import net.heckinember.scoria.block.ModBlocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Scoria implements ModInitializer {

	public static final String MOD_ID = "scoria";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
	}
}
