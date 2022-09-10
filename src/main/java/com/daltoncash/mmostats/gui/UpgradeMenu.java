package com.daltoncash.mmostats.gui;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.skill_menus.ArcheryMenu;
import com.daltoncash.mmostats.gui.skill_menus.ChoppingMenu;
import com.daltoncash.mmostats.gui.skill_menus.CombatMenu;
import com.daltoncash.mmostats.gui.skill_menus.FarmingMenu;
import com.daltoncash.mmostats.gui.skill_menus.MiningMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetCapabilityDataC2SPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
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
	private final ResourceLocation ARCHERY_TEXTURE = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/test_buttons/archery.png");
	private final ResourceLocation CHOPPING_TEXTURE = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/test_buttons/chopping.png");
	private final ResourceLocation COMBAT_TEXTURE = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/test_buttons/combat.png");
	private final ResourceLocation FARMING_TEXTURE = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/test_buttons/farming.png");
	private final ResourceLocation SKILL_BUBBLE = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/skill_exp_bubble.png");
	private final ResourceLocation SKILL_EXP = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/skill_exp_exp.png");

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
		
		//ImageButton mining = 
		addRenderableWidget(new ImageButton((this.width / 7) * 1, (this.height / 6) * 1, this.width / 11, this.height / 8, 0, 0, this.height / 8 - 1,
				MINING_TEXTURE, this.width / 11, this.height / 8, UpgradeMenu::onPressMining));
		
		addRenderableWidget(new ImageButton((this.width / 7) * 2, (this.height / 6) * 1, 100, 100, 0, 0, 99,
				ARCHERY_TEXTURE, 100, 100, UpgradeMenu::onPressArchery));
		
		addRenderableWidget(new ImageButton((this.width / 7) * 3, (this.height / 6) * 1, 100, 100, 0, 0, 99,
				CHOPPING_TEXTURE, 100, 100, UpgradeMenu::onPressChopping));
		
		addRenderableWidget(new ImageButton((this.width / 7) * 4, (this.height / 6) * 1, 100, 100, 0, 0, 99,
				COMBAT_TEXTURE, 100, 100, UpgradeMenu::onPressCombat));
		
		addRenderableWidget(new ImageButton((this.width / 7) * 5, (this.height / 6) * 1, 100, 100, 0, 0, 99,
				FARMING_TEXTURE, 100, 100, UpgradeMenu::onPressFarming));

		float percentEXP = (float) 100 * (ClientCapabilityData.getPlayerMiningExp() / (ClientCapabilityData.getPlayerMiningLevel() * 40 + 400));
		int imageNumber = (int) percentEXP / 5;
		//WIP: REMOVE BELOW
		System.out.println("width: " + this.width);
		System.out.println("height: " + this.height);
		
		int skillLevel = ClientCapabilityData.getPlayerMiningLevel();
		int skillExp = ClientCapabilityData.getPlayerMiningExp();
		int a = (skillLevel * 40) + 400;
		int b = (skillExp * 25) / a;
		System.out.println(b);
		//WIP: REMOVE ABOVE
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
	private static void onPressArchery(Button button) {
		Minecraft.getInstance().setScreen(new ArcheryMenu(Component.literal("mining")));
	}
	private static void onPressChopping(Button button) {
		Minecraft.getInstance().setScreen(new ChoppingMenu(Component.literal("chopping")));
	}
	private static void onPressCombat(Button button) {
		Minecraft.getInstance().setScreen(new CombatMenu(Component.literal("mining")));
	}
	private static void onPressFarming(Button button) {
		Minecraft.getInstance().setScreen(new FarmingMenu(Component.literal("mining")));
	}

	protected void renderBackground(PoseStack poseStack, float pPartialTick, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, bgtexture);
		this.blit(poseStack, 0, 0, 00, 00, this.width, this.height);
	}

	public void render(PoseStack poseStack, int p_96563_, int p_96564_, float p_96565_) {
		renderBackground(poseStack, 1.0f, p_96563_, p_96564_);
		for (Widget widget : this.renderables) {
			widget.render(poseStack, p_96563_, p_96564_, p_96565_);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		int skillLevel = ClientCapabilityData.getPlayerMiningLevel();
		int skillExp = ClientCapabilityData.getPlayerMiningExp();
		int a = (skillLevel * 40) + 400;
		int b = (skillExp * 31) / a;
		int x = this.width / 30;
		int y = this.height / 20;
		
		if(b > 31) {
			b = 31;
		}
		
		
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, SKILL_EXP);
		GuiComponent.blit(poseStack, 200, y + ((y * (31 - b)) / 31) + 1, 0, 
				y - ((y * b) / 31), x, (y * b) / 31, x, y);
			
		
		
		
		
		
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, SKILL_BUBBLE);
		GuiComponent.blit(poseStack, 200, y, 0, 0,  x, y, x, y);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void renderExpBubble(PoseStack poseStack, int p_96563_, int p_96564_, float p_96565_) {
		
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}
}