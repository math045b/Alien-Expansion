package com.cy4.alienexpansion.client.tesr;

import com.cy4.alienexpansion.common.tile.DisplayCaseTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;

@SuppressWarnings("deprecation")
public class DisplayCaseTileEntityRenderer extends TileEntityRenderer<DisplayCaseTileEntity> {

	public DisplayCaseTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(DisplayCaseTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ItemStack itemstack = tileEntityIn.getInventory();
		if (itemstack != ItemStack.EMPTY) {
			matrixStackIn.push();
			matrixStackIn.translate(0.5D, 0.5D, 0.5D);
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(
					-Direction.byHorizontalIndex((0 + Direction.NORTH.getHorizontalIndex()) % 4).getHorizontalAngle()));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
			matrixStackIn.scale(0.375F, 0.375F, 0.375F);
			Minecraft.getInstance().getItemRenderer().renderItem(itemstack, ItemCameraTransforms.TransformType.FIXED,
					combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
			matrixStackIn.pop();
		}
	}
}
