package com.cy4.alienexpansion.core.world.feature.piece;

import com.cy4.alienexpansion.core.world.feature.AlienBaseUtils;

import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

public class AlienBasePieceTemplate implements IAlienBasePiece {
	public boolean[] connections;
	public int id;
	public ResourceLocation structurefile;
	
	public AlienBasePieceTemplate(int id, boolean[] connections, ResourceLocation structurefile) {
		this.connections = connections;
		this.structurefile = structurefile;
		this.id = id;
	}
	
	@Override
	public boolean[] connections() {
		return this.connections;
	}

	@Override
	public ResourceLocation file() {
		return this.structurefile;
	}
	
	public boolean getConnection(Direction dir) {
		return this.connections[AlienBaseUtils.dirToInt(dir)];
	}

	@Override
	public int id() {
		return this.id;
	}
}
