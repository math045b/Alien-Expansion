package com.cy4.alienexpansion.common.items;

import com.cy4.alienexpansion.AlienExpansionMod;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ItemPortalTablet extends Item {
	public ItemPortalTablet(Item.Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote) {
			AlienExpansionMod.LOGGER.debug("Portal Item triggeret! Start");
			playerIn.changeDimension(DimensionType.byName(AlienExpansionMod.DIMENSION_TYPE));
			for (int y = -3; y < 3; y++) {
				for (int x = -3; x < 3; x++) {
					for (int z = 0; z < 3; z++) {
						playerIn.world
								.setBlockState(
										new BlockPos(playerIn.getPosition().getX() + x,
												playerIn.getPosition().getY() + y, playerIn.getPosition().getZ() + z),
										Blocks.AIR.getDefaultState());
					}
				}
			}
			AlienExpansionMod.LOGGER.debug("Portal Item triggeret! End");
		}

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
