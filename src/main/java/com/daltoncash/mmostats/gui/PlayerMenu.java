package com.daltoncash.mmostats.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.events.ModStats;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerAgilityAttributeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerHealthAttributeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerManaAttributeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerUpgradePointsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.SpendPlayerAttributePointsC2SPacket;
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

public class PlayerMenu extends Screen {

	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/cobble_bg-2.png");
	
	private final ResourceLocation PLAYER_LEVEL_BOX = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/upgrade_menu_box.png");
	private final ResourceLocation PLAYER_LEVEL_BIT = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/upgrade_menu_bit.png");
	
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff3.png");
	
	private static int attributePoints = ClientCapabilityData.getPlayerAttributePoints();
	
	private Button health;
	private Button agility;
	private Button mana;
	private Button upgradeMenu;
	private Button upgradesAndAttributes;
	
	public PlayerMenu(Component p_96550_) {
		super(p_96550_);
	}
	
	@Override
	public final void init() {
		addWidgets();
	}

	private void addWidgets() {
		removeWidget(upgradesAndAttributes);
		removeWidget(health);
		removeWidget(agility);
		removeWidget(mana);
		removeWidget(upgradeMenu);
		
		//upgradesAndAttributes = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				//Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()
						//		+ " ==== Attributes Unspent: " + attributePoints),
				//PlayerMenu::onPressDoNothing) );
		
		//addRenderableWidget(new Button(0, 0, 20, 20,
			//	Component.literal("reset capabilities: " + ClientCapabilityData.getPlayerMiningLevel()),
				//PlayerMenu::onPressReset));
		int attributePoints = ClientCapabilityData.getPlayerAttributePoints();
		health = addRenderableWidget(new Button((this.width * 1) / 10, this.height / 30 + 20, 100, 20,
				Component.literal(attributePoints > 0 
						? ("Upgrade Health: " + ClientCapabilityData.getPlayerHealth())
						: ("Health: " + ClientCapabilityData.getPlayerHealth())),
				PlayerMenu::onPressUpgradeHealth,
				new Button.OnTooltip() {
 			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
 				Component component = Component.literal("Increases Max Health by 1 half heart.");
 				PlayerMenu.this.renderTooltip(p_169459_, PlayerMenu.this.minecraft.font.split(component, Math.max(PlayerMenu.this.width / 2 - 43, 170)), int1, int2);
 			}
		}));	
		
		agility = addRenderableWidget(new Button((this.width * 5) / 10, this.height / 30 + 20, 100, 20,
				Component.literal(attributePoints > 0 
						? ("Upgrade Agility: " + ClientCapabilityData.getPlayerAgility())
						: ("Agility: " + ClientCapabilityData.getPlayerAgility())),
				PlayerMenu::onPressUpgradeAgility,
				new Button.OnTooltip() {
 			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
 				Component component = Component.literal("Increases Movespeed.");
 				PlayerMenu.this.renderTooltip(p_169459_, PlayerMenu.this.minecraft.font.split(component, Math.max(PlayerMenu.this.width / 2 - 43, 170)), int1, int2);
 			}
		}));	
		
		mana = addRenderableWidget(new Button((this.width * 3) / 10, this.height / 30 + 20, 100, 20,
				Component.literal(attributePoints > 0 
						? ("Upgrade Mana: " + ClientCapabilityData.getPlayerMana())
						: ("Mana: " + ClientCapabilityData.getPlayerMana())),
				PlayerMenu::onPressUpgradeMana,
				new Button.OnTooltip() {
 			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
 				Component component = Component.literal("Increases Max Mana pool by 5.");
 				PlayerMenu.this.renderTooltip(p_169459_, PlayerMenu.this.minecraft.font.split(component, Math.max(PlayerMenu.this.width / 2 - 43, 170)), int1, int2);
 			}
		}));	
		
		upgradeMenu = addRenderableWidget(new Button((int)((this.width * 4) / 10) / 2 + this.width / 10 - 25, 
				this.height * 3 / 5, 150, 20,
				Component.literal(ClientCapabilityData.getPlayerUpgradePoints() > 0 
						? ("Upgrade Points: " + ClientCapabilityData.getPlayerUpgradePoints())
						: ("Upgrade Menu")),
				PlayerMenu::onPressShowUpgradeMenu));
		
		addRenderableWidget(new Button((int)((this.width * 4) / 10) / 2 + this.width / 10, 0, 100, 20,
				Component.literal(" Player Level: " + ClientCapabilityData.getPlayerLevel()),
				PlayerMenu::onPressUpgradeMana));
		
		
		
		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, (this.width * 91) / 256, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 20) / 56, (this.height * 50) / 49,
				PlayerMenu::onPressDoNothing)).active = false;
		
		DescriptionPanel statlist = new DescriptionPanel(this.minecraft, (this.width * 57) / 256,
				this.height - (this.height * 27) / 64, this.height - ((this.height * 100) / 128));
		this.addRenderableWidget(statlist);
		List<String> lines = new ArrayList<>();
		lines.add("--Stats--");
		lines.add(" ");
		lines.add(" ");
		lines.add("Health: 20 + " + String.format("%2.2f",ModStats.getHealth() - 20));
		lines.add(" ");
		lines.add("Additional Regen: 5% max hp per " + (ModStats.getHealthRegenModifier() / 4) + " ticks");
		lines.add(" ");
		lines.add("Flat Damage Reduction: " + ModStats.getFlatArmorModifier());
		lines.add(" ");
		lines.add("Percent Damage Reduc: " + String.format("%2.2f",(ModStats.getArmorModifier() * 100)) + "%");
		lines.add(" ");
		lines.add("Additional Melee Damage: " + (ModStats.getFlatDamage() - 1));
		lines.add(" ");
		lines.add("Percent Melee Damage: " + String.format("%2.1f",((ModStats.getPercentIncreaseDamage() - 1) * 100.0)) + "%");
		lines.add(" ");
		lines.add("Critical Strike Multiplier: 1.5 + " + (ModStats.getCritMultiplier() - 1.5));
		lines.add(" ");
		lines.add("Additional Movespeed: " + String.format("%2.2f",(ModStats.getMoveSpeed() - .1) * 1000) + "%");
		lines.add(" ");
		lines.add("Lucky Modifier: " + String.format("%2.2f",ModStats.getLuckyModifier()) + "x");
		lines.add(" ");
		lines.add("Fall Damage Reduc: " + String.format("%2.2f",ModStats.getFallDamageModifier() * 100) + "%");
		lines.add(" ");
		lines.add("Knockback Reduc: " + String.format("%2.2f",ModStats.getKnockbackModifier() * 100) + "%");
		lines.add(" ");
		lines.add("Experience Orb Boost: " + String.format("%2.2f",ModStats.getExpModifier() * 100) + "%");
		lines.add(" ");
		lines.add("Mining Exp Boost: " + String.format("%2.2f",(ModStats.getMiningModifier() - 1) * 100.0) + "%");
		lines.add(" ");
		lines.add("Chopping Exp Boost: " + String.format("%2.2f",(ModStats.getChoppingModifier() - 1) * 100.0) + "%");
		lines.add(" ");
		lines.add("Farming Exp Boost: " + String.format("%2.2f",(ModStats.getFarmingModifier() - 1) * 100.0) + "%");
		lines.add(" ");
		lines.add("Combat Exp Boost: " + String.format("%2.2f",(ModStats.getCombatModifier() - 1) * 100.0) + "%");
		lines.add(" ");
		lines.add("Archery Exp Boost: " + String.format("%2.2f",(ModStats.getArcheryModifier() - 1) * 100.0) + "%");
		lines.add(" ");
		//lines.add("Taming Exp Boost: " + (ModStats.getTamingModifier() - 1) * 100.0 + "%");
		//lines.add(" ");
		lines.add("Chopping Double Drops: " + String.format("%2.2f",(ModStats.getChoppingFortuneCalculation()) * 100) + "%");
		lines.add(" ");
		lines.add("Mining Double Drops: " + String.format("%2.2f",(ModStats.getMiningFortuneCalculation()) * 100) + "%");
		statlist.setInfo(lines, null, null);
	}
	
	public void tick() {
		if(attributePoints != ClientCapabilityData.getPlayerAttributePoints()) {
			attributePoints = ClientCapabilityData.getPlayerAttributePoints();
			init();
		}
	}

	private static void onPressDoNothing(Button button) {
		ModMessages.sendToServer(new GainPlayerUpgradePointsC2SPacket());
	}
	
	private static void onPressShowUpgradeMenu(Button button) {
		Minecraft.getInstance().setScreen(new UpgradeMenu(Component.literal("Upgrade Menu")));
	}

	
	
	private static void onPressUpgradeHealth(Button button) {
		if(ClientCapabilityData.getPlayerAttributePoints() > 0) {
			ModMessages.sendToServer(new SpendPlayerAttributePointsC2SPacket());
			ModMessages.sendToServer(new GainPlayerHealthAttributeC2SPacket());
		}
	}
	
	private static void onPressUpgradeAgility(Button button) {
		if(ClientCapabilityData.getPlayerAttributePoints() > 0) {
			ModMessages.sendToServer(new SpendPlayerAttributePointsC2SPacket());
			ModMessages.sendToServer(new GainPlayerAgilityAttributeC2SPacket());
		}
	}
	
	private static void onPressUpgradeMana(Button button) {
		if(ClientCapabilityData.getPlayerAttributePoints() > 0) {
			ModMessages.sendToServer(new SpendPlayerAttributePointsC2SPacket());
			ModMessages.sendToServer(new GainPlayerManaAttributeC2SPacket());
		}
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
		//Player Level Bar
		renderPlayerLevel(poseStack, p1, p2, p3, ClientCapabilityData.getPlayerExp());
	}
	
	private void renderPlayerLevel(PoseStack poseStack, int p1, int p2, float p3, int playerExp) {
		
		int w = ((this.width * 4) / 10 + 100) / 25;
		int h = this.height / 30;
		int x = this.width / 10;
		int y = 20;
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, PLAYER_LEVEL_BIT);
		GuiComponent.blit(new PoseStack(), x, y, 0, 0,  w * playerExp, h, w, h);
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, PLAYER_LEVEL_BOX);
		GuiComponent.blit(new PoseStack(), x, y, 0, 0,  w * 25, h, w, h);
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
					PlayerMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
					RenderSystem.disableBlend();
				}
				relativeY += font.lineHeight;
			}

			final Style component = findTextLine(mouseX, mouseY);
			if (component != null) {
				PlayerMenu.this.renderComponentHoverEffect(poseStack, component, mouseX, mouseY);
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
				PlayerMenu.this.handleComponentClicked(component);
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