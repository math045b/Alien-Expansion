package com.cy4.alienexpansion.core.init;

import com.cy4.alienexpansion.AlienExpansionMod;
import com.cy4.alienexpansion.core.world.biome.AlienExpansionVoidBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.NoopSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
			AlienExpansionMod.MOD_ID);

	public static final RegistryObject<Biome> ALIEN_EXPANSION_VOID = BIOMES.register("alien_expansion_void",
			() -> new AlienExpansionVoidBiome(new Biome.Builder()
					.surfaceBuilder(new NoopSurfaceBuilder(SurfaceBuilderConfig::deserialize),
							new SurfaceBuilderConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(),
									Blocks.AIR.getDefaultState()))
					.precipitation(Biome.RainType.NONE).category(Biome.Category.NONE).depth(0.1F).scale(0.2F)
					.temperature(0.5F).downfall(0.5F).waterColor(4159204).waterFogColor(329011).parent((String) null)));
	
	public static final BiomeDictionary.Type ALIEN_EXPANSION = BiomeDictionary.Type.getType("ALIEN_EXPANSION");
	
	public static void addBiomeTypes() {
		BiomeDictionary.addTypes(ALIEN_EXPANSION_VOID.get(), ALIEN_EXPANSION);
	}
}
