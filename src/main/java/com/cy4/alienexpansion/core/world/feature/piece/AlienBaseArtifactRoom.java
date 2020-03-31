package com.cy4.alienexpansion.core.world.feature.piece;

import com.cy4.alienexpansion.AlienExpansionMod;

import net.minecraft.util.ResourceLocation;

public class AlienBaseArtifactRoom extends AlienBasePiece {

	public AlienBaseArtifactRoom() {
		super(new boolean[] {false, false, false, false, false, false}, new ResourceLocation(AlienExpansionMod.MOD_ID, "alienbasepiece.artifact_room"));
	}
}