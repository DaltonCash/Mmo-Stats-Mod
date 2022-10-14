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
	private int buttonW = this.width / 8;
	private int buttonH = this.height / 5;
	private Button miningButton;
	private Button archeryButton;
	private Button choppingButton;
	private Button combatButton;
	private Button farmingButton;
	@Override
	public final void init() {
		addWidgets();
	}

	private void addWidgets() {
		buttonW = this.width / 8;
		buttonH = this.height / 5;
		
		addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
				UpgradeMenu::onPressDoNothing));
		
		addRenderableWidget(new Button(20, 200, 100, 100,
				Component.literal("reset capabilities: " + ClientCapabilityData.getPlayerMiningLevel()),
				UpgradeMenu::onPressReset));
		
		miningButton = addRenderableWidget(new ImageButton((this.width * 1) / 7, (this.height * 1) / 6, buttonW, buttonH, 0, 0, buttonH - 1,
				MINING_TEXTURE, buttonW, buttonH, UpgradeMenu::onPressMining));
		
		archeryButton = addRenderableWidget(new ImageButton((this.width * 2) / 7, (this.height * 3) / 6, buttonW, buttonH, 0, 0, buttonH - 1,
				ARCHERY_TEXTURE, buttonW, buttonH, UpgradeMenu::onPressArchery));
		
		choppingButton = addRenderableWidget(new ImageButton((this.width * 3) / 7, (this.height * 1) / 6, buttonW, buttonH, 0, 0, buttonH - 1,
				CHOPPING_TEXTURE, buttonW, buttonH, UpgradeMenu::onPressChopping));
		
		combatButton = addRenderableWidget(new ImageButton((this.width * 4) / 7, (this.height * 3) / 6, buttonW, buttonH, 0, 0, buttonH - 1,
				COMBAT_TEXTURE, buttonW, buttonH, UpgradeMenu::onPressCombat));
		
		farmingButton = addRenderableWidget(new ImageButton((this.width * 5) / 7, (this.height * 1) / 6, buttonW, buttonH, 0, 0, buttonH - 1,
				FARMING_TEXTURE, buttonW, buttonH, UpgradeMenu::onPressFarming));
	}

	private static void onPressDoNothing(Button button) {
		
	}
	
	private static void onPressReset(Button button) {
		ModMessages.sendToServer(new ResetCapabilityDataC2SPacket());
	}

	private static void onPressMining(Button button) {
		Minecraft.getInstance().setScreen(new MiningMenu(Component.literal("mining")));
	}
	
	private static void onPressArchery(Button button) {
		Minecraft.getInstance().setScreen(new ArcheryMenu(Component.literal("archery")));
	}
	
	private static void onPressChopping(Button button) {
		Minecraft.getInstance().setScreen(new ChoppingMenu(Component.literal("chopping")));
	}
	
	private static void onPressCombat(Button button) {
		Minecraft.getInstance().setScreen(new CombatMenu(Component.literal("combat")));
	}
	
	private static void onPressFarming(Button button) {
		Minecraft.getInstance().setScreen(new FarmingMenu(Component.literal("farming")));
	}

	protected void renderBackground(PoseStack poseStack, float pPartialTick, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, bgtexture);
		this.blit(poseStack, 0, 0, 00, 00, this.width, this.height);
	}

	public void render(PoseStack poseStack, int p1, int p2, float p3) {
		renderBackground(poseStack, 1.0f, p1, p2);
		for (Widget widget : this.renderables) {
			widget.render(poseStack, p1, p2, p3);
		}
		int bubbleOffsetW = (buttonW * 3) / 4;
		int bubbleOffsetH = (buttonH * 3) / 4;
		//Mining Exp Bubble
				renderExpBubble(poseStack, p1, p2, p3, 
				ClientCapabilityData.getPlayerMiningExp(), 
				ClientCapabilityData.getPlayerMiningLevel(),
				miningButton.x + bubbleOffsetW,
				miningButton.y + bubbleOffsetH);
		//Chopping Exp Bubble
		renderExpBubble(poseStack, p1, p2, p3, 
				ClientCapabilityData.getPlayerChoppingExp(), 
				ClientCapabilityData.getPlayerChoppingLevel(),
				choppingButton.x + bubbleOffsetW,
				choppingButton.y + bubbleOffsetH);
		//Farming Exp Bubble
		renderExpBubble(poseStack, p1, p2, p3, 
				ClientCapabilityData.getPlayerFarmingExp(), 
				ClientCapabilityData.getPlayerFarmingLevel(),
				farmingButton.x + bubbleOffsetW,
				farmingButton.y + bubbleOffsetH);
		//Combat Exp Bubble
		renderExpBubble(poseStack, p1, p2, p3, 
				ClientCapabilityData.getPlayerCombatExp(), 
				ClientCapabilityData.getPlayerCombatLevel(),
				combatButton.x + bubbleOffsetW,
				combatButton.y + bubbleOffsetH);
		//Archery Exp Bubble
		renderExpBubble(poseStack, p1, p2, p3, 
				ClientCapabilityData.getPlayerArcheryExp(), 
				ClientCapabilityData.getPlayerArcheryLevel(),
				archeryButton.x + bubbleOffsetW,
				archeryButton.y + bubbleOffsetH);
		
		
	}
	
	private void renderExpBubble(PoseStack poseStack, int p1, int p2, float p3,
			int skillExp, int skillLevel, int x, int y) {
		
		int w = this.width / 45;
		int h = this.height / 30;
		int a = (skillExp * 30) / ((skillLevel * 40) + 400);
		if(a > 30) a = 30;
		
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, SKILL_EXP);
		GuiComponent.blit(new PoseStack(), x, y + ((h * (30 - a)) / 30), 0, 
				h - ((h * a) / 30), w, (h * a) / 30, w, h);
		int b = 0;
		if((h * (30 - a)) % 30 > 0) b = 1;
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, SKILL_BUBBLE);
		GuiComponent.blit(new PoseStack(), x, y - b , 0, 0,  w, h, w, h);
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}
}