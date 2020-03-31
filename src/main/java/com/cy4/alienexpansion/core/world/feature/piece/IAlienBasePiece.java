package com.cy4.alienexpansion.core.world.feature.piece;

import net.minecraft.util.ResourceLocation;

public interface IAlienBasePiece {
	//Defining where it can connect to.
	//Index 0-5: NORTH, SOUTH, EAST, WEST, UP, DOWN
	public boolean[] connections();
	
	//Resource Location for structure file
	public ResourceLocation file();
	
	//ID variable
	public int id();
}
