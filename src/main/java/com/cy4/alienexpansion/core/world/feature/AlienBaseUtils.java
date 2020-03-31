package com.cy4.alienexpansion.core.world.feature;

import net.minecraft.util.Direction;

public class AlienBaseUtils {
private static final Direction[] directions = new Direction[] {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.UP, Direction.DOWN};
	
	public static final int getConnectorID(Direction dir) {
		return (int)Math.floor(dirToInt(dir) / 2);
	}
	
	public static final int getEndID(Direction dir) {
		return dirToInt(dir) + 3;
	}
	
	public static final int dirToInt(Direction dir) {
		for (int i = 0; i < directions.length; i++)
			if (directions[i] == dir) return i;
		return -1;
	}
}
