package com.cy4.alienexpansion.core.init;

import com.cy4.alienexpansion.AlienExpansionMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AlienExpansionMod.MOD_ID);
	
	public static final RegistryObject<Block> SIMPLE_RUNE = BLOCKS.register("simple_rune", () -> new Block(Block.Properties.create(Material.IRON)));
	public static final RegistryObject<Block> NORMAL_RUNE = BLOCKS.register("normal_rune", () -> new Block(Block.Properties.create(Material.IRON)));
	public static final RegistryObject<Block> ADVANCED_RUNE = BLOCKS.register("advanced_rune", () -> new Block(Block.Properties.create(Material.IRON)));
	public static final RegistryObject<Block> ALIEN_STRUCTURE = BLOCKS.register("alien_structure", () -> new Block(Block.Properties.create(Material.IRON)));
	public static final RegistryObject<Block> ALIEN_STRUCTURE_ACTIVE = BLOCKS.register("alien_structure_active", () -> new Block(Block.Properties.create(Material.IRON)));
}