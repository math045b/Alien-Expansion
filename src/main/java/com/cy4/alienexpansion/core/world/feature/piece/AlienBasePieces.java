package com.cy4.alienexpansion.core.world.feature.piece;

import com.cy4.alienexpansion.AlienExpansionMod;

import net.minecraft.util.ResourceLocation;

public class AlienBasePieces {
	// BOOLEAN ARRAY IS THE CONNECTION IN EACH DIRECTION:
	// Pos 0: North
	// Pos 1: South
	// Pos 2: East
	// Pos 3: West
	// Pos 4: Up
	// Pos 5: Down
	public static final AlienBasePieceTemplate ARTIFACT_ROOM = new AlienBasePieceTemplate(
			new boolean[] { true, true, true, true, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.artifact_room"));
	
	public static final AlienBasePieceTemplate CORRIDOR_NORTH_SOUTH = new AlienBasePieceTemplate(
			new boolean[] { true, true, false, false, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.corridor.north_south"));
	
	public static final AlienBasePieceTemplate CORRIDOR_EAST_WEST = new AlienBasePieceTemplate(
			new boolean[] { false, false, true, true, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.corridor.east_west"));
	
	public static final AlienBasePieceTemplate CORRIDOR_UP_DOWN = new AlienBasePieceTemplate(
			new boolean[] { false, false, false, false, true, true },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.corridor.up_down"));
}