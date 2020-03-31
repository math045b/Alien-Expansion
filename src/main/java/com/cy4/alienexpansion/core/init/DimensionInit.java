package com.cy4.alienexpansion.core.init;

import com.cy4.alienexpansion.AlienExpansionMod;
import com.cy4.alienexpansion.core.world.dimension.AlienExpansionChunkGenerator;
import com.cy4.alienexpansion.core.world.dimension.AlienExpansionModDimension;

import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = AlienExpansionMod.MOD_ID, bus = Bus.MOD)
public class DimensionInit {
	@ObjectHolder("alienexpansion:alienexpansion")
	public static final ModDimension ALIEN_EXPANSION_DIM = null;

	@SubscribeEvent
	public static void onDimensionRegistryEvent(RegistryEvent.Register<ModDimension> event) {
		event.getRegistry().register(new AlienExpansionModDimension().setRegistryName("alienexpansion:alienexpansion"));
	}
	
	@SubscribeEvent
	public void onChunkRegistryEvent(RegistryEvent.Register<ChunkGeneratorType<?, ?>> event) {
		event.getRegistry().register(new ChunkGeneratorType<>(AlienExpansionChunkGenerator::new, false, GenerationSettings::new).setRegistryName("alienexpansion:alienexpansion_chunk"));
    }
}
