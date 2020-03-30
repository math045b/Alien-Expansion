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
}