package com.cy4.alienexpansion.core.world.biome;

import com.cy4.alienexpansion.core.world.feature.AlienBaseFeature;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AlienExpansionVoidBiome extends Biome {
    public AlienExpansionVoidBiome(Builder props) {
        super(props);
        this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
        new AlienBaseFeature(NoFeatureConfig::deserialize)
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(1))));
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
