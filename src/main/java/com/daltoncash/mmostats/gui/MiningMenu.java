package com.daltoncash.mmostats.gui;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeJunkBlocksDropExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNoJunkBlocksC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeObsidianBreakerC2SPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class MiningMenu extends Screen {
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/new_test_mining_bg.png");
	private final ResourceLocation upgradeTexture1 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/experience_upgrade_texture.png");
	private final ResourceLocation upgradeTexture2 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/no_junk_blocks_button.png");
	private final ResourceLocation upgradeTexture3 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/night_vision_button_texture.png");
	private final ResourceLocation upgradeTexture4 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/crying_obsidian.png");
	

	public MiningMenu(Component p_96550_) {
		super(p_96550_);
	}

	@Override
	public final void init() {

		addRenderableWidget(new ImageButton((this.width / 6) * 1, (this.height / 6) * 2, 100, 100, 0, 0, 0,
				upgradeTexture1, 100, 100, MiningMenu::onPressUpgradeJunk));
		addRenderableWidget(new ImageButton((this.width / 6) * 3, (this.height / 6) * 2, 100, 100, 0, 0, 0,
				upgradeTexture2, 100, 100, MiningMenu::onPressUpgradeNoJunk));
		addRenderableWidget(new ImageButton((this.width / 6) * 2, (this.height / 6) * 2, 100, 100, 0, 0, 0,
				upgradeTexture3, 100, 100, MiningMenu::onPressUpgradeNightVision));
		
		addRenderableWidget(new ImageButton((this.width / 6) * 4, (this.height / 6) * 2, 100, 100, 0, 0, 0,
				upgradeTexture4, 100, 100, MiningMenu::onPressUpgradeObsidianBreaker));

	}

	private static void onPressUpgradeJunk(Button button) {
		ModMessages.sendToServer(new UpgradeJunkBlocksDropExpC2SPacket());
	}
	private static void onPressUpgradeNightVision(Button button) {
		ModMessages.sendToServer(new UpgradeNightVisionC2SPacket());
	}
	private static void onPressUpgradeNoJunk(Button button) {
		ModMessages.sendToServer(new UpgradeNoJunkBlocksC2SPacket());
	}
	private static void onPressUpgradeObsidianBreaker(Button button) {
		ModMessages.sendToServer(new UpgradeObsidianBreakerC2SPacket());
	}

	protected void renderBackground(PoseStack poseStack, float pPartialTick, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, bgtexture);
		this.blit(poseStack, 0, 0, 50, 50, this.width, this.height);
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
