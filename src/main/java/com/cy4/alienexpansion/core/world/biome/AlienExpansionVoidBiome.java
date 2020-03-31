package com.cy4.alienexpansion.core.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AlienExpansionVoidBiome extends Biome {
    public AlienExpansionVoidBiome(Builder props) {
        super(props);
    }
    
    @OnlyIn(Dist.CLIENT)
	public int getFoliageColor() {
		return 203212166;
	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		return 9470285;
	} 
}
