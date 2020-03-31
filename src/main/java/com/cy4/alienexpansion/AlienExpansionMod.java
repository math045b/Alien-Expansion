package com.cy4.alienexpansion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import com.cy4.alienexpansion.core.init.BlockInit;
import com.cy4.alienexpansion.core.init.ItemInit;
import com.cy4.alienexpansion.core.tab.AlienExpansionTab;
import com.google.common.base.Preconditions;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("alienexpansion")
@Mod.EventBusSubscriber(modid = AlienExpansionMod.MOD_ID, bus = Bus.MOD)
public class AlienExpansionMod {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "alienexpansion";
	public static AlienExpansionMod instance;

	public AlienExpansionMod() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		BlockInit.BLOCKS.register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		modEventBus.addListener(this::doClientStuff);
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(AlienExpansionTab.ALIEN_EXPANSION);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
		LOGGER.debug("Registered BlockItems");
	}

	
	private void setup(final FMLCommonSetupEvent event) {

	}

	private void doClientStuff(final FMLClientSetupEvent event) {

		@Mod.EventBusSubscriber(modid = AlienExpansionMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
		class RegistryEvents {
			
			@Nonnull
			private <T extends IForgeRegistryEntry<T>> T setup(@Nonnull final T entry, @Nonnull final String name) {
				Preconditions.checkNotNull(name, "Name to assign to entry cannot be null!");
				return setup(entry, new ResourceLocation(AlienExpansionMod.MOD_ID, name));
			}

			@Nonnull
			private <T extends IForgeRegistryEntry<T>> T setup(@Nonnull final T entry,
					@Nonnull final ResourceLocation registryName) {
				Preconditions.checkNotNull(entry, "Entry cannot be null!");
				Preconditions.checkNotNull(registryName, "Registry name to assign to entry cannot be null!");
				entry.setRegistryName(registryName);
				return entry;
			}
		}
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {

	}
}