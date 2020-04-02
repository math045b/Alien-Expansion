package com.cy4.alienexpansion.core.init;

import com.cy4.alienexpansion.AlienExpansionMod;
import com.cy4.alienexpansion.common.tile.DisplayCaseTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileInit {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, AlienExpansionMod.MOD_ID);

	public static final RegistryObject<TileEntityType<DisplayCaseTileEntity>> DISPLAY_CASE = TILE_ENTITY_TYPES.register(
			"display_case", () -> TileEntityType.Builder.create(DisplayCaseTileEntity::new, BlockInit.DISPLAY_CASE.get()).build(null));
}
