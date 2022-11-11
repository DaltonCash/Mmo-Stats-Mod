package com.daltoncash.mmostats.gui;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.events.ModStats;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ManaOverlay {
	private static final ResourceLocation MANA = new ResourceLocation(MmoStatsMod.MODID,
			"textures/overlay/mana_bottles_4.png");

	public static final IGuiOverlay HUD_MANA = ((gui, poseStack, partialTick, width, height) -> {
		int x = width;
		int y = height;
		
		int mana = ClientCapabilityData.getPlayerCurrentMana();
		int maxManaLevel = ModStats.getMaxMana();
		int manaToDisplay = (maxManaLevel % 10 == 0 ? maxManaLevel / 10 : maxManaLevel / 10 + 1);
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, MANA);
		
		for (int i = 0; i < manaToDisplay; i++) {
			GuiComponent.blit(poseStack, ((x * 265) / 512) + (i * 8), y - 50, mana >= 10 ? 110 : mana * 10, 0, 10, 10, 120, 10);
			mana = Math.max(mana - 10, 0);
		}
		
		
		for (int i = 0; i < manaToDisplay; i++) {
			GuiComponent.blit(poseStack, (x * 265) / 512 + (i * 8), y - 50, 10, 0, 10, 10, 120, 10);
		}
	});
	
}
