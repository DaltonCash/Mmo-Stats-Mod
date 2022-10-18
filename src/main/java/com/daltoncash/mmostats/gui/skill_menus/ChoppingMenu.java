package com.daltoncash.mmostats.gui.skill_menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.gui.skill_menus.totals_menus.ChoppingTotalsMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.GrannySmithUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.HardwoodUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.StrongArmsUpgradeC2SPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;

import net.minecraft.client.Minecraft;
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

public class ChoppingMenu extends Screen {
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/cobble_bg-2.png");

	//Textures to appear bright if upgraded:
	private final ResourceLocation upgradeTexture1 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/chopping_buttons/granny_smith_button.png");
	private final ResourceLocation upgradeTexture2 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/chopping_buttons/hardwood_button.png");
	private final ResourceLocation upgradeTexture3 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/chopping_buttons/strong_arms_button.png");
	
	//Textures to appear dark if not upgraded:
	private final ResourceLocation upgradeTexture1Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/chopping_buttons/granny_smith_button_dark.png");
	private final ResourceLocation upgradeTexture2Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/chopping_buttons/hardwood_button_dark.png");
	private final ResourceLocation upgradeTexture3Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/chopping_buttons/strong_arms_button_dark.png");
	
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff3.png");

	private static String upgradeString = "";
	private static final String grannySmith = "GrannySmith: \n\nGain Swiftness(2/3/4) effect for 60 seconds when eating an apple.";
	private static final String hardWood = "Hardwood: \n\nWhen an attack would make you have less than 25% max hp, gain 20%/ 40%/ 60% max hp.";
	private static final String strongArms = "Lumber Jacked: \n\nDeal 10%/ 20%/ 30% more damage with axes.";
	
	private static DescriptionPanel upgradeDescription;
	
	private static int counter = 0;
	private static Button upgradePoints;
	private static Button temp;

	public ChoppingMenu(Component p_96550_) {
		super(p_96550_);
	}

	@Override
	public final void init() {

		addRenderableWidget(new Button(this.width/13 * 6, this.height/13 * 6, 50, 50, 
				Component.literal("Chopping Totals"), ChoppingMenu::onPressShowTotals));
		
		upgradePoints = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
				ChoppingMenu::onPressDoNothing));
		
		if(ClientCapabilityData.isUpgradedGrannySmith() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1, 50, 50, ChoppingMenu::onPressUpgradeGrannySmith));	
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1Dark, 50, 50, ChoppingMenu::onPressUpgradeGrannySmith));	
		}
		
		
		if(ClientCapabilityData.isUpgradedHardWood() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2, 50, 50, ChoppingMenu::onPressUpgradeHardwood));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2Dark, 50, 50, ChoppingMenu::onPressUpgradeHardwood));
		}
		
		
		if(ClientCapabilityData.isUpgradedStrongArms() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3, 50, 50, ChoppingMenu::onPressUpgradeStrongArms));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3Dark, 50, 50, ChoppingMenu::onPressUpgradeStrongArms));
		}
		

		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, (this.width * 91) / 256, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 20) / 56, (this.height * 50) / 49,
				ChoppingMenu::onPressDoNothing)).active = false;

		addRenderableWidget(new Button((this.width * 195) / 256, (this.height * 34) / 40, (this.width * 100) / 840, 20,
				Component.literal("Upgrade"), ChoppingMenu::onPressDoUpgrade));

		upgradeDescription = new DescriptionPanel(this.minecraft, (this.width * 57) / 256,
				this.height - (this.height * 27) / 64, this.height - ((this.height * 100) / 128));
		this.addRenderableWidget(upgradeDescription);
		List<String> lines = new ArrayList<>();
		lines.add("Select Upgrade.");
		upgradeDescription.setInfo(lines, null, null);
	}
	
	public void tick() {
		counter++;
		removeWidget(temp);
		removeWidget(upgradePoints);
		if(counter % 2 == 1) {
			upgradePoints = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
					Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
					ChoppingMenu::onPressDoNothing));
		}else {
			temp = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
					Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
					ChoppingMenu::onPressDoNothing));
		}
		
		addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
				ChoppingMenu::onPressDoNothing));
		
		if(ClientCapabilityData.isUpgradedGrannySmith() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1, 50, 50, ChoppingMenu::onPressUpgradeGrannySmith));	
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1Dark, 50, 50, ChoppingMenu::onPressUpgradeGrannySmith));	
		}
		
		
		if(ClientCapabilityData.isUpgradedHardWood() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2, 50, 50, ChoppingMenu::onPressUpgradeHardwood));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2Dark, 50, 50, ChoppingMenu::onPressUpgradeHardwood));
		}
		
		
		if(ClientCapabilityData.isUpgradedStrongArms() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3, 50, 50, ChoppingMenu::onPressUpgradeStrongArms));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3Dark, 50, 50, ChoppingMenu::onPressUpgradeStrongArms));
		}
	}
	
	private static void onPressShowTotals(Button button) {
		 Minecraft.getInstance().setScreen(new ChoppingTotalsMenu(Component.literal("chopping_totals")));
	}
	
	private static void onPressUpgradeGrannySmith(Button button) {
		upgradeString = grannySmith;
		updateCache();
	}

	private static void onPressUpgradeHardwood(Button button) {
		upgradeString = hardWood;
		updateCache();
	}

	private static void onPressUpgradeStrongArms(Button button) {
		upgradeString = strongArms;
		updateCache();
	}

	private static void onPressDoNothing(Button button) {

	}

	private static void onPressDoUpgrade(Button button) {
		if(ClientCapabilityData.getPlayerUpgradePoints() > 0) {
			switch (upgradeString) {
			case grannySmith:
				ModMessages.sendToServer(new GrannySmithUpgradeC2SPacket());
				break;
			case hardWood:
				ModMessages.sendToServer(new HardwoodUpgradeC2SPacket());
				break;
			case strongArms:
				ModMessages.sendToServer(new StrongArmsUpgradeC2SPacket());
				break;
			}
			
			Minecraft.getInstance().setScreen(new ChoppingMenu(Component.literal("chopping")));
		}
		
		
		
	}

	private static void updateCache() {
		List<String> lines = new ArrayList<>();

		lines.add(null);
		lines.add(upgradeString);
		upgradeDescription.setInfo(lines, null, null);
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
		if (upgradeDescription != null)
			upgradeDescription.render(p_96562_, p_96563_, p_96564_, p_96565_);
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	public void onClose() {
		Minecraft.getInstance().setScreen(new UpgradeMenu(Component.literal("Upgrade Menu")));
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
					ChoppingMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
					RenderSystem.disableBlend();
				}
				relativeY += font.lineHeight;
			}

			final Style component = findTextLine(mouseX, mouseY);
			if (component != null) {
				ChoppingMenu.this.renderComponentHoverEffect(poseStack, component, mouseX, mouseY);
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
				ChoppingMenu.this.handleComponentClicked(component);
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
