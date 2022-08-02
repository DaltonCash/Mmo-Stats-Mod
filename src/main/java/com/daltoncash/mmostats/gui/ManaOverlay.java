package com.daltoncash.mmostats.gui;

import com.daltoncash.mmostats.MmoStatsMod;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ManaOverlay {
	 private static final ResourceLocation FILLED_MANA = new ResourceLocation(MmoStatsMod.MODID,
	            "textures/gui/test_image_2.png");
	    private static final ResourceLocation EMPTY_MANA = new ResourceLocation(MmoStatsMod.MODID,
	            "textures/gui/mana_1.png");

	    public static final IGuiOverlay HUD_MANA = ((gui, poseStack, partialTick, width, height) -> {
	        int x = width / 2;
	        int y = height;

	        RenderSystem.setShader(GameRenderer::getPositionTexShader);
	        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
	        RenderSystem.setShaderTexture(0, EMPTY_MANA);
	        for(int i = 0; i < 10; i++) {
	            GuiComponent.blit(poseStack,x - 94 + (i * 9), y - 54,0,0,12,12,
	                    12,12);
	        }

	        RenderSystem.setShaderTexture(0, FILLED_MANA);
	        for(int i = 0; i < 10; i++) {
	            if(ClientManaData.getPlayerMana() > i) {
	                GuiComponent.blit(poseStack,x - 94 + (i * 9),y - 54,0,0,12,12,
	                        12,12);
	            } else {
	                break;
	            }
	        }
	    });
}
