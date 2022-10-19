package com.daltoncash.mmostats.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.events.ModStats;
import com.daltoncash.mmostats.gui.skill_menus.ArcheryMenu;
import com.daltoncash.mmostats.gui.skill_menus.ChoppingMenu;
import com.daltoncash.mmostats.gui.skill_menus.CombatMenu;
import com.daltoncash.mmostats.gui.skill_menus.FarmingMenu;
import com.daltoncash.mmostats.gui.skill_menus.MiningMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerUpgradePointsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetCapabilityDataC2SPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraftforge.client.gui.ScreenUtils;
import net.minecraftforge.client.gui.widget.ScrollPanel;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.Size2i;

public class UpgradeMenu extends Screen {

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
	
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff3.png");
	
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
		
		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, (this.width * 91) / 256, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 20) / 56, (this.height * 50) / 49,
				UpgradeMenu::onPressDoNothing)).active = false;
		
		DescriptionPanel statlist = new DescriptionPanel(this.minecraft, (this.width * 57) / 256,
				this.height - (this.height * 27) / 64, this.height - ((this.height * 100) / 128));
		this.addRenderableWidget(statlist);
		List<String> lines = new ArrayList<>();
		lines.add("--Stats--");
		lines.add(" ");
		lines.add(" ");
		lines.add("Health: 20 + " + (ModStats.getHealth() - 20));
		lines.add(" ");
		lines.add("Additional Regen: 5% max hp per " + (ModStats.getHealthRegenModifier() / 4) + " ticks");
		lines.add(" ");
		lines.add("Flat Damage Reduction: " + ModStats.getFlatArmorModifier());
		lines.add(" ");
		lines.add("Percent Damage Reduc: " + (ModStats.getArmorModifier() * 100));
		lines.add(" ");
		lines.add("Additional Melee Damage: " + (ModStats.getFlatDamage() - 1));
		lines.add(" ");
		lines.add("Percent Melee Damage: " + (ModStats.getPercentIncreaseDamage()) + "%");
		lines.add(" ");
		lines.add("Critical Strike Multiplier: 1.5 + " + (ModStats.getCritMultiplier() - 1.5 + "%"));
		lines.add(" ");
		lines.add("Additional Movespeed: " + (int)((ModStats.getMoveSpeed() - .1) * 1000) + "%");
		lines.add(" ");
		lines.add("Lucky Modifier: " + ModStats.getLuckyModifier());
		lines.add(" ");
		lines.add("Fall Damage Reduc: " + ModStats.getFallDamageModifier());
		lines.add(" ");
		lines.add("Knockback Reduc: " + ModStats.getKnockbackModifier());
		lines.add(" ");
		lines.add("Experience Orb Boost: " + ModStats.getExpModifier() * 100 + "%");
		lines.add(" ");
		lines.add("    ");
		lines.add("Mining Exp Boost: " + (ModStats.getMiningModifier() - 1) * 100 + "%");
		lines.add(" ");
		lines.add("Chopping Exp Boost: " + (ModStats.getChoppingModifier() - 1) * 100 + "%");
		lines.add(" ");
		lines.add("Farming Exp Boost: " + (ModStats.getFarmingModifier() - 1) * 100 + "%");
		lines.add(" ");
		lines.add("Combat Exp Boost: " + (ModStats.getCombatModifier() - 1) * 100 + "%");
		lines.add(" ");
		lines.add("Archery Exp Boost: " + (ModStats.getArcheryModifier() - 1) * 100 + "%");
		lines.add(" ");
		lines.add("Taming Exp Boost: " + (ModStats.getTamingModifier() - 1) * 100 + "%");
		lines.add(" ");
		lines.add("Chopping Double Drops: " + (ModStats.getChoppingFortuneCalculation()) * 100 + "%");
		lines.add(" ");
		lines.add("Mining Double Drops: " + (ModStats.getMiningFortuneCalculation()) * 100 + "%");
		statlist.setInfo(lines, null, null);
	}

	private static void onPressDoNothing(Button button) {
		ModMessages.sendToServer(new GainPlayerUpgradePointsC2SPacket());
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
	
	class DescriptionPanel extends ScrollPanel {
		private ResourceLocation logoPath;
		private Size2i logoDims = new Size2i(0, 0);
		private List<FormattedCharSequence> lines = Collections.emptyList();

		@SuppressWarnings("resource")
		DescriptionPanel(Minecraft mcIn, int widthIn, int heightIn, int topIn) {
			super(mcIn, widthIn, heightIn, topIn, (Minecraft.getInstance().screen.width * 91) / 128);
		}

		void setInfo(List<String> lines, ResourceLocation logoPath, Size2i logoDims) {
			this.logoPath = logoPath;
			this.logoDims = logoDims;
			this.lines = resizeContent(lines);
		}

		private List<FormattedCharSequence> resizeContent(List<String> lines) {
			List<FormattedCharSequence> ret = new ArrayList<>();
			for (String line : lines) {
				if (line == null) {
					ret.add(null);
					continue;
				}

				Component chat = ForgeHooks.newChatWithLinks(line, false);
				int maxTextLength = this.width - 40;
				if (maxTextLength >= 0) {
					ret.addAll(Language.getInstance()
							.getVisualOrder(font.getSplitter().splitLines(chat, maxTextLength, Style.EMPTY)));
				}
			}
			return ret;
		}

		@Override
		public int getContentHeight() {
			int height = 50;
			height += (lines.size() * font.lineHeight);
			if (height < this.bottom - this.top - 8)
				height = this.bottom - this.top - 8;
			return height;
		}

		@Override
		protected int getScrollAmount() {
			return font.lineHeight * 3;
		}

		@Override
		protected void drawPanel(PoseStack poseStack, int entryRight, int relativeY, Tesselator tess, int mouseX,
				int mouseY) {
			if (logoPath != null) {
				RenderSystem.setShader(GameRenderer::getPositionTexShader);
				RenderSystem.enableBlend();
				RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.setShaderTexture(0, logoPath);
				int headerHeight = 50;
				ScreenUtils.blitInscribed(poseStack, left + 20, relativeY, width - (20 * 2), headerHeight,
						logoDims.width, logoDims.height, false, true);
				relativeY += headerHeight + 20;
			}

			for (FormattedCharSequence line : lines) {
				if (line != null) {
					RenderSystem.enableBlend();
					UpgradeMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
					RenderSystem.disableBlend();
				}
				relativeY += font.lineHeight;
			}

			final Style component = findTextLine(mouseX, mouseY);
			if (component != null) {
				UpgradeMenu.this.renderComponentHoverEffect(poseStack, component, mouseX, mouseY);
			}
		}

		private Style findTextLine(final int mouseX, final int mouseY) {
			if (!isMouseOver(mouseX, mouseY))
				return null;

			double offset = (mouseY - top) + border + scrollDistance + 1;
			if (logoPath != null) {
				offset -= 50;
			}
			if (offset <= 0)
				return null;

			int lineIdx = (int) (offset / font.lineHeight);
			if (lineIdx >= lines.size() || lineIdx < 1)
				return null;

			FormattedCharSequence line = lines.get(lineIdx - 1);
			if (line != null) {
				return font.getSplitter().componentStyleAtWidth(line, mouseX - left - border);
			}
			return null;
		}

		@Override
		public boolean mouseClicked(final double mouseX, final double mouseY, final int button) {
			final Style component = findTextLine((int) mouseX, (int) mouseY);
			if (component != null) {
				UpgradeMenu.this.handleComponentClicked(component);
				return true;
			}
			return super.mouseClicked(mouseX, mouseY, button);
		}

		@Override
		public NarrationPriority narrationPriority() {
			return NarrationPriority.NONE;
		}

		@Override
		public void updateNarration(NarrationElementOutput p_169152_) {
		}
	}
}