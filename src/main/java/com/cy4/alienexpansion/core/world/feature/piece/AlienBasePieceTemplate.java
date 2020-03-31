package com.cy4.alienexpansion.core.world.feature.piece;

import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

public class AlienBasePieceTemplate implements IAlienBasePiece {
	public boolean[] connections;
	public ResourceLocation structurefile;
	
	public AlienBasePieceTemplate(boolean[] connections, ResourceLocation structurefile) {
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
	
	public boolean getConnection(Direction dir) {
		if(dir.equals(Direction.NORTH)) return this.connections[0];
		if(dir.equals(Direction.SOUTH)) return this.connections[1];
		if(dir.equals(Direction.EAST)) return this.connections[2];
		if(dir.equals(Direction.WEST)) return this.connections[3];
		if(dir.equals(Direction.UP)) return this.connections[4];
		else return this.connections[5];
	}

}
