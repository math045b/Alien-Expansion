package com.cy4.alienexpansion.core.init;

import com.cy4.alienexpansion.core.tab.AlienExpansionTab;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class PropertyInit {
	public static final Item.Properties BASIC_ITEM = new Item.Properties().group(AlienExpansionTab.ALIEN_EXPANSION);
	public static final Block.Properties ALIEN_BLOCK = Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(-1.0F, 3600000.0F).noDrops();
	public static final Block.Properties LIT_ALIEN_BLOCK = Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(-1.0F, 3600000.0F).noDrops().lightValue(15);
}