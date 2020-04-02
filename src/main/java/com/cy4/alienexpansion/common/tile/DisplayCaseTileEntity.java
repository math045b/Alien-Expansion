package com.cy4.alienexpansion.common.tile;

import javax.annotation.Nonnull;

import com.cy4.alienexpansion.AlienExpansionMod;
import com.cy4.alienexpansion.core.init.TileInit;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class DisplayCaseTileEntity extends TileEntity implements ITickableTileEntity{
	public DisplayCaseTileEntity(TileEntityType<?> tetype) {
		super(tetype);
	}
	
	public DisplayCaseTileEntity() {
		this(TileInit.DISPLAY_CASE.get());
	}

	@Override
	public void tick() {
		if(world.isRemote) AlienExpansionMod.LOGGER.debug("tick");
	}
	
	@SuppressWarnings("unchecked")
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return LazyOptional.of(() -> (T) new ItemStackHandler(1));
		return super.getCapability(cap, side);
	}
}
