package com.daltoncash.mmostats.gui.skill_menus;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeJunkBlocksDropExpC2SPacket;
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

public class ArcheryMenu extends Screen {
	public Widget ancientDebris;
	//private OptionsList list;
	//protected final Options options;
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/test_buttons/archery_button.png");
	private final ResourceLocation upgradeTexture1 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/experience_upgrade_texture.png");
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff1.png");

	public ArcheryMenu(Component p_96550_) {
		super(p_96550_);
	}
	
	@Override
	public final void init() {
		
		addRenderableWidget(new Button(this.width/13 * 6, this.height/13 * 6, 50, 50, 
				Component.literal(this.height + " " + this.width), ArcheryMenu::onPressDoNothing));
		
		addRenderableWidget(new ImageButton((this.width / 6) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture1, 50, 50, ArcheryMenu::onPressUpgradeJunk));
		
		
		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, this.width/10 * 9, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 40)/84, (this.height * 50)/49, ArcheryMenu::onPressDoNothing));
		
		
		addRenderableWidget(new Button((this.width * 33) /40, (this.height * 35) / 40, (this.width * 100) / 840, 20, 
				Component.literal("Upgrade"), ArcheryMenu::onPressDoNothing));
		
	}
	private static void onPressDoNothing(Button button) {
		
	}
	private static void onPressUpgradeJunk(Button button) {
		ModMessages.sendToServer(new UpgradeJunkBlocksDropExpC2SPacket());
	}
	protected void renderBackground(PoseStack poseStack, float pPartialTick, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, bgtexture);
		this.blit(poseStack, 0, 0, 0, 0, this.width, this.height);
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
	 public void onClose() {
		 Minecraft.getInstance().setScreen(new UpgradeMenu(Component.literal("mining")));
	 }
}