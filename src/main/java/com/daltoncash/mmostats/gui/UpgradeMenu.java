package com.daltoncash.mmostats.gui;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.skill_menus.MiningMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetCapabilityDataC2SPacket;
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

public class UpgradeMenu extends Screen {

	// private final ResourceLocation texture1 = new
	// ResourceLocation(MmoStatsMod.MODID, "textures/gui/test_image.png");
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/cobble_bg-2.png");
	private final ResourceLocation MINING_TEXTURE = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/test_images/test_mining_image_3.png");

	//private final ResourceLocation EXP_BAR = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/exp_bar_0.png");

	public UpgradeMenu(Component p_96550_) {
		super(p_96550_);
	}

	@Override
	public final void init() {
		
		// addRenderableWidget(new Button(10,10,100,100, Component.literal("" +
		// ClientCapabilityData.getPlayerMiningExp()), UpgradeMenu::onPressMining));
		addRenderableWidget(new Button(20, 200, 100, 100,
				Component.literal("reset capabilities: " + ClientCapabilityData.getPlayerMiningLevel()),
				UpgradeMenu::onPressReset));
		addRenderableWidget(new ImageButton((this.width / 6) * 1, (this.height / 6) * 1, 100, 100, 0, 0, 0,
				MINING_TEXTURE, 100, 100, UpgradeMenu::onPressMining));

		float percentEXP = (float) 100 * (ClientCapabilityData.getPlayerMiningExp() / (ClientCapabilityData.getPlayerMiningLevel() * 40 + 400));
		int imageNumber = (int) percentEXP / 5;

		renderExpBar(imageNumber);
	}

	private void renderExpBar(int num)
	{
		/*
		String location = "textures/gui/exp_bar_" + num + ".png";
		ResourceLocation Rendered_Texture = new ResourceLocation(MmoStatsMod.MODID, location);
		addRenderableWidget(new ImageButton((this.width / 6) * 1, (this.height / 6) * 1, 100, 100, 0, 0, 0,
				, 100, 100, UpgradeMenu::onPressMining));
		*/
		

	}


	private static void onPressReset(Button button) {
		ModMessages.sendToServer(new ResetCapabilityDataC2SPacket());

	}

	private static void onPressMining(Button button) {
		Minecraft.getInstance().setScreen(new MiningMenu(Component.literal("mining")));
	}

	protected void renderBackground(PoseStack poseStack, float pPartialTick, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, bgtexture);
		this.blit(poseStack, 0, 0, 00, 00, this.width, this.height);
	}

	public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
		renderBackground(p_96562_, 1.0f, p_96563_, p_96564_);
		for (Widget widget : this.renderables) {
			widget.render(p_96562_, p_96563_, p_96564_, p_96565_);
		}
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}
}