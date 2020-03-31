package com.cy4.alienexpansion.core.world.dimension;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.GenerationSettings;

public class AlienExpansionDimension extends Dimension {

	public AlienExpansionDimension(World worldIn, DimensionType typeIn) {
		super(worldIn, typeIn, 0.0f);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		ChunkGeneratorType<GenerationSettings, ?> VOID_CHUNK = null;
		GenerationSettings genSettings = VOID_CHUNK.createSettings();
		genSettings.setDefaultBlock(Blocks.AIR.getDefaultState());
		return new AlienExpansionChunkGenerator(world, BiomeProviderType.FIXED.create(BiomeProviderType.FIXED.func_226840_a_(this.world.getWorldInfo()).setBiome(Biomes.THE_VOID)), genSettings);
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		return null;
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return null;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		int j = 6000;
		float f1 = (j + partialTicks) / 24000.0f - 0.25f;
		if (f1 < 0.0f) {
			f1 += 1.0f;
		}

		if (f1 > 1.0f) {
			f1 -= 1.0f;
		}

		float f2 = f1;
		f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 2.0d);
		f1 = f2 + (f1 - f2) / 3.0f;
		return f1;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		return Vec3d.ZERO;
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW;
	}

	@Override
	public int getActualHeight() {
		return 256;
	}

}
