package com.cy4.alienexpansion.core.init;

import com.cy4.alienexpansion.AlienExpansionMod;

import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AlienExpansionMod.MOD_ID);
	
	public static final RegistryObject<Block> SIMPLE_RUNE = BLOCKS.register("simple_rune", () -> new Block(PropertyInit.ALIEN_BLOCK));
	public static final RegistryObject<Block> NORMAL_RUNE = BLOCKS.register("normal_rune", () -> new Block(PropertyInit.ALIEN_BLOCK));
	public static final RegistryObject<Block> ADVANCED_RUNE = BLOCKS.register("advanced_rune", () -> new Block(PropertyInit.ALIEN_BLOCK));
	public static final RegistryObject<Block> ALIEN_RUNE = BLOCKS.register("alien_rune", () -> new Block(PropertyInit.ALIEN_BLOCK));
	public static final RegistryObject<Block> ALIEN_RUNE_ACTIVE = BLOCKS.register("alien_rune_active", () -> new Block(PropertyInit.LIT_ALIEN_BLOCK));
	public static final RegistryObject<Block> ALIEN_PILLAR = BLOCKS.register("alien_pillar", () -> new RotatedPillarBlock(PropertyInit.ALIEN_BLOCK));
	public static final RegistryObject<Block> ALIEN_PILLAR_ACTIVE = BLOCKS.register("alien_pillar_active", () -> new RotatedPillarBlock(PropertyInit.LIT_ALIEN_BLOCK));
}