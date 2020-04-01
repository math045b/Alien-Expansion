package com.cy4.alienexpansion.core.world.feature.piece;

import net.minecraft.util.ResourceLocation;

public interface IAlienBasePiece {
	//Index 0-5: NORTH, SOUTH, EAST, WEST, UP, DOWN
	public boolean[] connections();
	public ResourceLocation file();
	public int id();
}
