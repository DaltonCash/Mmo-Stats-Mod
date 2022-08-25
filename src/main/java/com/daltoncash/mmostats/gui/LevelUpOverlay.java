package com.daltoncash.mmostats.gui;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.events.ClientEvents.ClientForgeEvents;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class LevelUpOverlay {
	private static final ResourceLocation LEVEL_UP = new ResourceLocation(MmoStatsMod.MODID,
			"textures/overlay/level_up_spritesheet2.png");

	public static final IGuiOverlay LEVEL_UP_OVERLAY = ((gui, poseStack, partialTick, width, height) -> {
		int x = width;
		int y = height;
		int a = ClientForgeEvents.overlayDuration;
		int b = ClientForgeEvents.seconds;
				
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, LEVEL_UP);
		if(a > 0) {
			GuiComponent.blit(poseStack, 100, 100,a * -92, 0,  50, 50, 5000, 50);
		}
			
	});
}
