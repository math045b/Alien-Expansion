package com.cy4.alienexpansion.core.init;

import com.cy4.alienexpansion.AlienExpansionMod;
import com.cy4.alienexpansion.common.items.ItemPortalTablet;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AlienExpansionMod.MOD_ID);
	
	public static final RegistryObject<Item> PORTAL_TABLET = ITEMS.register("portal_tablet", () -> new ItemPortalTablet(PropertyInit.BAISC_ITEM));
	
	public static final RegistryObject<Item> PERL = ITEMS.register("pearl", () -> new Item(PropertyInit.BAISC_ITEM));
}