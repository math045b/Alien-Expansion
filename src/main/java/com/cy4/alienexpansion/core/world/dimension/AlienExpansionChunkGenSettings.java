package com.cy4.alienexpansion.core.world.dimension;

import net.minecraft.world.gen.GenerationSettings;

public class AlienExpansionChunkGenSettings extends GenerationSettings {

	public int getBiomeSize() {
		return 4;
	}

	public int getRiverSize() {
		return 4;
	}

	public int getBiomeId() {
		return -1;
	}

	public int getBedrockFloorHeight() {
		return 0;
	}
}
