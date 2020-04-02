package com.cy4.alienexpansion.client.tesr;

import com.cy4.alienexpansion.AlienExpansionMod;
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
import net.minecraft.util.NonNullList;

@SuppressWarnings("deprecation")
public class DisplayCaseTileEntityRenderer extends TileEntityRenderer<DisplayCaseTileEntity>{

	public DisplayCaseTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}
	
	@Override
	public void render(DisplayCaseTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		NonNullList<ItemStack> nonnulllist = tileEntityIn.getInventory();
		for(int i = 0; i < nonnulllist.size(); ++i) {
	         ItemStack itemstack = nonnulllist.get(i);
	         AlienExpansionMod.LOGGER.debug(itemstack);
	         if (itemstack != ItemStack.EMPTY) {
	            matrixStackIn.push();
	            matrixStackIn.translate(0.5D, 0.44921875D, 0.5D);
	            float f = -Direction.byHorizontalIndex((i + Direction.NORTH.getHorizontalIndex()) % 4).getHorizontalAngle();
	            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
	            matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
	            matrixStackIn.translate(-0.3125D, -0.3125D, 0.0D);
	            matrixStackIn.scale(0.375F, 0.375F, 0.375F);
	            Minecraft.getInstance().getItemRenderer().renderItem(itemstack, ItemCameraTransforms.TransformType.FIXED, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
	            matrixStackIn.pop();
	         }
	      }
	}
}
