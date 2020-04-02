package com.cy4.alienexpansion.common.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DisplayCaseEntity extends ItemFrameEntity {
	public DisplayCaseEntity(EntityType<? extends DisplayCaseEntity> p_i50224_1_, World p_i50224_2_) {
		super(p_i50224_1_, p_i50224_2_);
	}

	public DisplayCaseEntity(World worldIn, BlockPos p_i45852_2_, Direction p_i45852_3_) {
		super(worldIn, p_i45852_2_, p_i45852_3_);
	}

	@Override
	public void onBroken(Entity brokenEntity) {
		for (int i = 0; i < this.world.getPlayers().size(); i++) {
			if (!this.world.getPlayers().get(i).isCreative()) {
				return;
			}
		}
		super.onBroken(brokenEntity);
	}
}
