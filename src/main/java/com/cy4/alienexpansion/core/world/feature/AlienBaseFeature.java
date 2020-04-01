package com.cy4.alienexpansion.core.world.feature;

import java.util.Random;
import java.util.function.Function;

import com.cy4.alienexpansion.core.world.feature.piece.AlienBasePieces;
import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.IntegrityProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;

public class AlienBaseFeature extends Feature<NoFeatureConfig> {
	public AlienBaseFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49873_1_) {
		super(p_i49873_1_);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		Random random = worldIn.getRandom();
		Rotation[] arotation = Rotation.values();
		Rotation rotation = arotation[random.nextInt(arotation.length)];
		Template template = ((ServerWorld) worldIn.getWorld()).getSaveHandler().getStructureTemplateManager()
				.getTemplateDefaulted(AlienBasePieces.PIECES[random.nextInt(3)].structurefile);

		PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation)
				// .setBoundingBox defines until where the structure should spawn, for example
				// here it's max 25600 X, 256 Y and 25600 Z
				.setBoundingBox(new MutableBoundingBox((0 - 25600), (0 - 25600), (0 - 25600), 25600, 256, 25600))
				.setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
		// j k l are respectively x y z , and define the width, height and depth of the
		// structure
		BlockPos blockpos1 = template.getZeroPositionWithTransform(pos, Mirror.NONE, rotation);
		IntegrityProcessor integrityprocessor = new IntegrityProcessor(0.9F);
		placementsettings.clearProcessors().addProcessor(integrityprocessor);
		template.addBlocksToWorld(worldIn, blockpos1, placementsettings, 4);
		placementsettings.func_215220_b(integrityprocessor);
		return true;

	}
}