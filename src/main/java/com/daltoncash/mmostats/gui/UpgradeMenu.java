package com.daltoncash.mmostats.gui;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.ResetCapabilityDataC2SPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
public class UpgradeMenu extends Screen{
	
	//private final ResourceLocation texture1 = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/test_image.png");
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/bgimage-1.png");
	private final ResourceLocation MINING_TEXTURE = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/mining_image.png");
	public static int clickCounter = 0;
	
	public UpgradeMenu(Component p_96550_) {super(p_96550_);}
	
	 
	public final void hello() {
	}
	@Override
	public final void init() {
		
		//addRenderableWidget(new Button(10,10,100,100, Component.literal("" + ClientCapabilityData.getPlayerMiningExp()), UpgradeMenu::onPressMining));
		addRenderableWidget(new Button(20,200,100,100, Component.literal("" + ClientCapabilityData.getPlayerMiningLevel()), UpgradeMenu::onPressMining));
		addRenderableWidget(new ImageButton((this.width / 6) * 1, (this.height / 6) * 1, 100, 100, 0, 0, 0, MINING_TEXTURE, 100, 100, UpgradeMenu::onPressMining));
		
	}
	
	@SuppressWarnings("resource")
	private static void onPressMining(Button button) {
		clickCounter++;
		ModMessages.sendToServer(new ResetCapabilityDataC2SPacket());
		Minecraft.getInstance().player.sendSystemMessage(Component.literal("you have clicked " + clickCounter + " times!"));
		
	}
    protected void renderBackground(PoseStack poseStack, float pPartialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, bgtexture);
        this.blit(poseStack,0,0,50,50, this.width, this.height);
    }
	public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
		renderBackground(p_96562_,1.0f, p_96563_, p_96564_);
	     for(Widget widget : this.renderables) {
	        widget.render(p_96562_, p_96563_, p_96564_, p_96565_);
	     }
	}
	@Override
	public boolean isPauseScreen() {
		return true;
	}
}