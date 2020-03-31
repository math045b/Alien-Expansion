package com.cy4.alienexpansion.core.world.feature.piece;

import com.cy4.alienexpansion.AlienExpansionMod;

import net.minecraft.util.ResourceLocation;

public class AlienBasePieces {
	public static final AlienBasePieceTemplate CORRIDOR_NORTH_SOUTH = new AlienBasePieceTemplate(0,
			new boolean[] { true, true, false, false, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.corridor.north_south"));

	public static final AlienBasePieceTemplate CORRIDOR_EAST_WEST = new AlienBasePieceTemplate(1,
			new boolean[] { false, false, true, true, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.corridor.east_west"));

	public static final AlienBasePieceTemplate CORRIDOR_UP_DOWN = new AlienBasePieceTemplate(2,
			new boolean[] { false, false, false, false, true, true },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.corridor.up_down"));

	public static final AlienBasePieceTemplate END_NORTH = new AlienBasePieceTemplate(3,
			new boolean[] { true, false, false, false, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.end.north"));

	public static final AlienBasePieceTemplate END_SOUTH = new AlienBasePieceTemplate(4,
			new boolean[] { false, true, false, false, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.end.south"));

	public static final AlienBasePieceTemplate END_EAST = new AlienBasePieceTemplate(5,
			new boolean[] { false, false, true, false, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.end.east"));

	public static final AlienBasePieceTemplate END_WEST = new AlienBasePieceTemplate(6,
			new boolean[] { false, false, false, true, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.end.west"));

	public static final AlienBasePieceTemplate END_UP = new AlienBasePieceTemplate(7,
			new boolean[] { false, false, false, false, true, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.end.up"));

	public static final AlienBasePieceTemplate END_DOWN = new AlienBasePieceTemplate(8,
			new boolean[] { false, false, false, false, false, true },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.end.down"));
	
	public static final AlienBasePieceTemplate ARTIFACT_ROOM = new AlienBasePieceTemplate(9,
			new boolean[] { true, true, true, true, false, false },
			new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.room.artifact_room"));
}