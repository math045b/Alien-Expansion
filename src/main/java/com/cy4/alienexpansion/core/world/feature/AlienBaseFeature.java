package com.cy4.alienexpansion.core.world.feature;

import java.util.Random;
import java.util.function.Function;

import com.cy4.alienexpansion.core.world.feature.piece.AlienBasePieces;
import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;

public class AlienBaseFeature extends Feature<NoFeatureConfig> {
	public AlienBaseFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49873_1_) {
		super(p_i49873_1_);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		placeFeature(AlienBasePieces.PIECES[new Random().nextInt(3)].structurefile, worldIn, pos);
		return true;
	}

	public void placeFeature(ResourceLocation t, IWorld worldIn, BlockPos pos) {
		Random random = worldIn.getRandom();
		Rotation[] arotation = Rotation.values();
		Rotation rotation = arotation[random.nextInt(arotation.length)];
		Template template = ((ServerWorld) worldIn.getWorld()).getSaveHandler().getStructureTemplateManager()
				.getTemplateDefaulted(t);
		template.addBlocksToWorld(worldIn, template.getZeroPositionWithTransform(pos, Mirror.NONE, rotation),
				(new PlacementSettings()).setRotation(rotation)
						.setBoundingBox(
								new MutableBoundingBox((0 - 25600), (0 - 25600), (0 - 25600), 25600, 256, 25600))
						.setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK),
				4);
	}
}