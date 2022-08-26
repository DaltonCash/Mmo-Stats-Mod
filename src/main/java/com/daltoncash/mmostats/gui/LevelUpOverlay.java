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
		int x = width / 2;
		int y = height;
		
		
		int a = ClientForgeEvents.overlayDuration;
		int b = ClientForgeEvents.seconds;
		int c = a/4 * -91;
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, LEVEL_UP);
		if(a > 0) {
			GuiComponent.blit(poseStack, x-45, 0, c, 0,  91, 50, 5005, 50);
		}
			//a/4 * -91
	});
}
