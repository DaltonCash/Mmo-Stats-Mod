package com.daltoncash.mmostats.gui;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.events.SkillEvents.SkillForgeEvents;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class LevelUpOverlay {
	private static final ResourceLocation LEVEL_UP = new ResourceLocation(MmoStatsMod.MODID,
			"textures/overlay/level_up_spritesheet2.png");
	private static final ResourceLocation SKILL_BOX = new ResourceLocation(MmoStatsMod.MODID,
			"textures/overlay/skill_overlay_spritesheet.png");
	private static final ResourceLocation EXP_BIT = new ResourceLocation(MmoStatsMod.MODID,
			"textures/overlay/exp_bit.png");

	public static final IGuiOverlay LEVEL_UP_OVERLAY = ((gui, poseStack, partialTick, width, height) -> {
		int x = width / 2;
		int a = SkillForgeEvents.levelUpOverlayDuration;
		int c = a/2 * -91;
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, LEVEL_UP);
		if(a > 0) {
			GuiComponent.blit(poseStack, x-45, 0, c, 0,  91, 50, 5005, 50);
		}	
	});
	
	public static final IGuiOverlay SKILL_OVERLAY = ((gui, poseStack, partialTick, width, height) -> {
		int x = width;
		int skillExp = 0;
		int skillLevel = 0;
		int a = SkillForgeEvents.skillOverlayDuration;
		
		int c = 0;
		
		switch(SkillForgeEvents.skillToDisplay) {
			case "Farming":
				skillExp = ClientCapabilityData.getPlayerFarmingExp();
				skillLevel = ClientCapabilityData.getPlayerFarmingLevel();
				c = 0;
				break;
			case "Mining":
				skillExp = ClientCapabilityData.getPlayerMiningExp();
				skillLevel = ClientCapabilityData.getPlayerMiningLevel();
				c = 100;
				break;
			case "Chopping":
				skillExp = ClientCapabilityData.getPlayerChoppingExp();
				skillLevel = ClientCapabilityData.getPlayerChoppingLevel();
				c = 200;
				break;
			case "Combat":
				skillExp = ClientCapabilityData.getPlayerCombatExp();
				skillLevel = ClientCapabilityData.getPlayerCombatLevel();
				c = 300;
				break;
			case "Archery": 
				skillExp = ClientCapabilityData.getPlayerArcheryExp();
				skillLevel = ClientCapabilityData.getPlayerArcheryLevel();
				c = 400;
				break;
		}
		int b = (skillExp * 961) / ((skillLevel * 40) + 400);
		
		if(a > 0) {
			for(int i = 0; i < 31; i++) {
				if(b/31 > i) {
					RenderSystem.setShader(GameRenderer::getPositionTexShader);
					RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.5F);
					RenderSystem.setShaderTexture(0, EXP_BIT);
					GuiComponent.blit(poseStack, x-96, 93 - (i * 3), 0, 0,  93, 3, 3, 3);
				}else {
					RenderSystem.setShader(GameRenderer::getPositionTexShader);
					RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.5F);
					RenderSystem.setShaderTexture(0, EXP_BIT);
					GuiComponent.blit(poseStack, x-96, 93 - (b/31 * 3), 0, 0,  ((b % 31) * 3), 3, 3, 3);
				}
			}
		}
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, SKILL_BOX);
		if(a > 0) {
			GuiComponent.blit(poseStack, x-100, 0, c, 0,  100, 100, 500, 100);
		}
	});
}
