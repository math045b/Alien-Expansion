package com.cy4.alienexpansion.common.tile;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.cy4.alienexpansion.AlienExpansionMod;
import com.cy4.alienexpansion.core.init.TileInit;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class DisplayCaseTileEntity extends TileEntity implements ITickableTileEntity {
	private ItemStackHandler handler;

	public DisplayCaseTileEntity(TileEntityType<?> tetype) {
		super(tetype);
	}

	public DisplayCaseTileEntity() {
		this(TileInit.DISPLAY_CASE.get());
	}

	@Override
	public void read(CompoundNBT tag) {
		getHandler().deserializeNBT(tag.getCompound("inv"));
		super.read(tag);
	}

	@Override
	public CompoundNBT write(CompoundNBT tag) {
		tag.put("inv", getHandler().serializeNBT());
		return super.write(tag);
	}

	private ItemStackHandler getHandler() {
		if (handler == null)
			handler = new ItemStackHandler(1) {
				@Nonnull
				@Override
				public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
					inventoryChanged();
					return super.insertItem(slot, stack, simulate);
				}

				@Override
				public ItemStack extractItem(int slot, int amount, boolean simulate) {
					inventoryChanged();
					return super.extractItem(slot, amount, simulate);
				}
			};
		return handler;
	}

	@SuppressWarnings("unchecked")
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return LazyOptional.of(() -> (T) getHandler());
		return super.getCapability(cap, side);
	}

	public ItemStack getInventory() {
		return getHandler().getStackInSlot(0);
	}

	private void inventoryChanged() {
		this.markDirty();
		this.getWorld().notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 8);
	}

	@Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		AlienExpansionMod.LOGGER.debug(TileInit.DISPLAY_CASE.get().hashCode());
		return new SUpdateTileEntityPacket(this.pos, TileInit.DISPLAY_CASE.get().hashCode(), this.getUpdateTag());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		super.onDataPacket(net, pkt);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}

	@Override
	public void tick() {}

}
