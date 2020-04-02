package com.cy4.alienexpansion.common.items;

import com.cy4.alienexpansion.common.entity.item.DisplayCaseEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.IFactory;
import net.minecraft.entity.item.HangingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HangingEntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class ItemDisplayCase extends HangingEntityItem {

	public ItemDisplayCase(Item.Properties builder) {
		super(new EntityType<DisplayCaseEntity>(new IFactory<DisplayCaseEntity>() {

			@Override
			public DisplayCaseEntity create(EntityType<DisplayCaseEntity> p_create_1_, World p_create_2_) {
				return new DisplayCaseEntity(p_create_1_, p_create_2_);
			}
		}, EntityClassification.MISC, false, false, true, false, new EntitySize(0.5F, 0.5F, true)),
				builder.addToolType(ToolType.PICKAXE, 1));
	}

	protected boolean canPlace(PlayerEntity playerIn, Direction directionIn, ItemStack itemStackIn, BlockPos posIn) {
		return !World.isOutsideBuildHeight(posIn) && playerIn.canPlayerEdit(posIn, directionIn, itemStackIn);
	}

	public ActionResultType onItemUse(ItemUseContext context) {
		Direction direction = context.getFace();
		BlockPos blockpos1 = context.getPos().offset(direction);
		PlayerEntity playerentity = context.getPlayer();
		ItemStack itemstack = context.getItem();
		if (playerentity != null && !this.canPlace(playerentity, direction, itemstack, blockpos1))
			return ActionResultType.FAIL;
		else {
			World world = context.getWorld();
			HangingEntity hangingentity;
			hangingentity = new DisplayCaseEntity(world, blockpos1, direction);

			CompoundNBT compoundnbt = itemstack.getTag();
			if (compoundnbt != null)
				EntityType.applyItemNBT(world, playerentity, hangingentity, compoundnbt);
			if (hangingentity.onValidSurface()) {
				if (!world.isRemote) {
					hangingentity.playPlaceSound();
					world.addEntity(hangingentity);
				}
				itemstack.shrink(1);
				return ActionResultType.SUCCESS;
			} else
				return ActionResultType.CONSUME;
		}
	}
}