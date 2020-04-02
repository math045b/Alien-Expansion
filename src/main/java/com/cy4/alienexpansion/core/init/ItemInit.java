package com.cy4.alienexpansion.core.init;

import com.cy4.alienexpansion.AlienExpansionMod;
import com.cy4.alienexpansion.common.items.ItemDisplayCase;
import com.cy4.alienexpansion.common.items.ItemPortalTablet;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AlienExpansionMod.MOD_ID);	
	public static final RegistryObject<Item> PORTAL_TABLET = ITEMS.register("portal_tablet", () -> new ItemPortalTablet(PropertyInit.BASIC_ITEM));	
	public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new Item(PropertyInit.BASIC_ITEM));
	public static final RegistryObject<Item> DISPLAY_CASE = ITEMS.register("display_case", () -> new ItemDisplayCase(PropertyInit.BASIC_ITEM));
}