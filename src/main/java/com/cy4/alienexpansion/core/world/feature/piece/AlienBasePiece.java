package com.cy4.alienexpansion.core.world.feature.piece;

import net.minecraft.util.ResourceLocation;

public class AlienBasePiece implements IAlienBasePiece {
	public boolean[] connections;
	public ResourceLocation structurefile;
	public AlienBasePiece(boolean[] connections, ResourceLocation structurefile) {
		this.connections = connections;
		this.structurefile = structurefile;
	}
	
	@Override
	public boolean[] connections() {
		return this.connections;
	}

	@Override
	public ResourceLocation file() {
		return this.structurefile;
	}
	
	public boolean[] getConnections() {
		return this.connections;
	}

}
