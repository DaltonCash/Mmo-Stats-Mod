package com.daltoncash.mmostats.gui.skill_menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.gui.skill_menus.totals_menus.FarmingTotalsMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.CarnivoreUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.EggerUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.SugarRushUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.WellFedUpgradeC2SPacket;
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

public class FarmingMenu extends Screen {
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/cobble_bg-2.png");

	//Textures to appear bright if upgraded:
	private final ResourceLocation upgradeTexture1 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/carnivore_button.png");
	private final ResourceLocation upgradeTexture2 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/egger_button.png");
	private final ResourceLocation upgradeTexture3 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/sugar_rush_button.png");
	private final ResourceLocation upgradeTexture4 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/well_fed_button.png");
	/*
	private final ResourceLocation upgradeTexture5 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/insatiable_button.png");
	private final ResourceLocation upgradeTexture6 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/fast_food_button.png");
			*/
	//Textures to appear dark if not upgraded:
	private final ResourceLocation upgradeTexture1Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/carnivore_button_dark.png");
	private final ResourceLocation upgradeTexture2Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/egger_button_dark.png");
	private final ResourceLocation upgradeTexture3Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/sugar_rush_button_dark.png");
	private final ResourceLocation upgradeTexture4Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/well_fed_button_dark.png");
	/*
	private final ResourceLocation upgradeTexture5Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/insatiable_button_dark.png");
	private final ResourceLocation upgradeTexture6Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/farming_buttons/fast_food_button_dark.png");
	*/
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff3.png");

	private static String upgradeString = "";
	private static final String carnivore = "Carnivore: \n\nWhen eating meat, gain regeneration effect 2/4/6 for 3 seconds."
			+ "\nOtherwise, gain regeneration effect 1/2/3.";
	private static final String egger = "Eggsplosions: \n\nEggs explode on contact with an entity, dealing damage to all entities around."
			+ "\n Explosion radius: 1/2/3 meters.";
	private static final String sugarRush = "Sugar Rush: \n\nWhen eating sweets, gain swiftness effect 3/4/5 for 10 seconds."
			+ "\nOtherwise, gain swiftness effect 1/2/3.";
	private static final String wellFed = "Well Fed: \n\nHaving a full hunger bar grants 10% / 15% / 20% breaking speed.";
	
	private static DescriptionPanel upgradeDescription;
	
	private static int carnivoreLVL = ClientCapabilityData.isUpgradedCarnivore();
	private static int eggerLVL = ClientCapabilityData.isUpgradedEgger();
	private static int sugarRushLVL = ClientCapabilityData.isUpgradedSugarRush();
	private static int wellFedLVL = ClientCapabilityData.isUpgradedWellFed();
	private static int upgradePoints = ClientCapabilityData.getPlayerUpgradePoints();
	
	private static Button upgradePointsButton;
	
	public FarmingMenu(Component p_96550_) {
		super(p_96550_);
	}

	@Override
	public final void init() {

		addRenderableWidget(new Button(this.width/13 * 6, this.height/13 * 6, 50, 50, 
				Component.literal("Farming Totals"), FarmingMenu::onPressShowTotals));
		
		upgradeString = "";
		
		removeWidget(upgradePointsButton);
		
		upgradePointsButton = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
				button -> {}));
		
		
		addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				carnivoreLVL > 0 ? upgradeTexture1 : upgradeTexture1Dark, 50, 50, FarmingMenu::onPressUpgradeCarnivore,
						new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Current Upgrade Level: " + carnivoreLVL);
	     				FarmingMenu.this.renderTooltip(p_169459_, FarmingMenu.this.minecraft.font.split(component, Math.max(FarmingMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				},
				Component.empty()));			
		
		
		
		
		addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				eggerLVL > 0 ? upgradeTexture2 : upgradeTexture2Dark, 50, 50, FarmingMenu::onPressUpgradeEgger,
						new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Current Upgrade Level: " + eggerLVL);
	     				FarmingMenu.this.renderTooltip(p_169459_, FarmingMenu.this.minecraft.font.split(component, Math.max(FarmingMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				},
				Component.empty()));		
		
		
		
		
		addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				sugarRushLVL > 0 ? upgradeTexture3 : upgradeTexture3Dark, 50, 50, FarmingMenu::onPressUpgradeSugarRush,
						new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Current Upgrade Level: " + sugarRushLVL);
	     				FarmingMenu.this.renderTooltip(p_169459_, FarmingMenu.this.minecraft.font.split(component, Math.max(FarmingMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				},
				Component.empty()));		
		
		
		
	
		addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				wellFedLVL > 0 ? upgradeTexture4 : upgradeTexture4Dark, 50, 50, FarmingMenu::onPressUpgradeWellFed,
						new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Current Upgrade Level: " + wellFedLVL);
	     				FarmingMenu.this.renderTooltip(p_169459_, FarmingMenu.this.minecraft.font.split(component, Math.max(FarmingMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				},
				Component.empty()));		
		
		

		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, (this.width * 91) / 256, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 20) / 56, (this.height * 50) / 49,
				button -> {})).active = false;

		addRenderableWidget(new Button((this.width * 195) / 256, (this.height * 34) / 40, (this.width * 100) / 840, 20,
				Component.literal("Upgrade"), FarmingMenu::onPressDoUpgrade));

		removeWidget(upgradeDescription);
		upgradeDescription = new DescriptionPanel(this.minecraft, (this.width * 57) / 256,
				this.height - (this.height * 27) / 64, this.height - ((this.height * 100) / 128));
		this.addRenderableWidget(upgradeDescription);
		List<String> lines = new ArrayList<>();
		lines.add("Select Upgrade.");
		upgradeDescription.setInfo(lines, null, null);
	}
	
	public void tick() {
		if(carnivoreLVL != ClientCapabilityData.isUpgradedCarnivore()   ||
				eggerLVL != ClientCapabilityData.isUpgradedEgger()||
				sugarRushLVL != ClientCapabilityData.isUpgradedSugarRush()  ||
				wellFedLVL != ClientCapabilityData.isUpgradedWellFed()   ||
				upgradePoints != ClientCapabilityData.getPlayerUpgradePoints()) {
				
					carnivoreLVL = ClientCapabilityData.isUpgradedCarnivore();
					eggerLVL = ClientCapabilityData.isUpgradedEgger();
					sugarRushLVL = ClientCapabilityData.isUpgradedSugarRush();
					wellFedLVL = ClientCapabilityData.isUpgradedWellFed();
					upgradePoints = ClientCapabilityData.getPlayerUpgradePoints();
					
					init();
		}
	}
	
	private static void onPressShowTotals(Button button) {
		 Minecraft.getInstance().setScreen(new FarmingTotalsMenu(Component.literal("farming_totals")));
	}
	
	private static void onPressUpgradeCarnivore(Button button) {
		upgradeString = carnivore;
		updateCache();
	}

	private static void onPressUpgradeEgger(Button button) {
		upgradeString = egger;
		updateCache();
	}

	private static void onPressUpgradeSugarRush(Button button) {
		upgradeString = sugarRush;
		updateCache();
	}

	private static void onPressUpgradeWellFed(Button button) {
		upgradeString = wellFed;
		updateCache();
	}

	private static void onPressDoUpgrade(Button button) {
		if(upgradePoints > 0) {
			switch (upgradeString) {
			case carnivore:
				if(ClientCapabilityData.isUpgradedCarnivore() < 3) ModMessages.sendToServer(new CarnivoreUpgradeC2SPacket());
				break;
			case egger:
				if(ClientCapabilityData.isUpgradedEgger() < 3) ModMessages.sendToServer(new EggerUpgradeC2SPacket());
				break;
			case sugarRush:
				if(ClientCapabilityData.isUpgradedSugarRush() < 3) ModMessages.sendToServer(new SugarRushUpgradeC2SPacket());
				break;
			case wellFed:
				if(ClientCapabilityData.isUpgradedWellFed() < 3) ModMessages.sendToServer(new WellFedUpgradeC2SPacket());
				break;
			}
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
					FarmingMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
					RenderSystem.disableBlend();
				}
				relativeY += font.lineHeight;
			}

			final Style component = findTextLine(mouseX, mouseY);
			if (component != null) {
				FarmingMenu.this.renderComponentHoverEffect(poseStack, component, mouseX, mouseY);
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
				FarmingMenu.this.handleComponentClicked(component);
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