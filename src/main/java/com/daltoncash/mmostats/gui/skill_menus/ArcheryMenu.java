package com.daltoncash.mmostats.gui.skill_menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.EfficientMarksmanUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.HunterUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.InsecurityUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.LeftClickUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.QuickshotUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.SniperUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.SweetSpotArcheryUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.UnabatedUpgradeC2SPacket;
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

public class ArcheryMenu extends Screen {
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/cobble_bg-2.png");

	//Textures to appear bright if upgraded:
	private final ResourceLocation upgradeTexture1 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/efficient_marksman_button.png");
	private final ResourceLocation upgradeTexture2 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/hunter_button.png");
	private final ResourceLocation upgradeTexture3 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/insecurity_button.png");
	private final ResourceLocation upgradeTexture4 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/left_click_button.png");
	private final ResourceLocation upgradeTexture5 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/quickshot_button.png");
	private final ResourceLocation upgradeTexture6 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/sniper_button.png");
	private final ResourceLocation upgradeTexture7 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/sweet_spot_button.png");
	private final ResourceLocation upgradeTexture8 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/unabated_button.png");
	
	//Textures to appear dark if not upgraded:
	private final ResourceLocation upgradeTexture1Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/efficient_marksman_button_dark.png");
	private final ResourceLocation upgradeTexture2Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/hunter_button_dark.png");
	private final ResourceLocation upgradeTexture3Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/insecurity_button_dark.png");
	private final ResourceLocation upgradeTexture4Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/left_click_button_dark.png");
	private final ResourceLocation upgradeTexture5Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/quickshot_button_dark.png");
	private final ResourceLocation upgradeTexture6Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/sniper_button_dark.png");
	private final ResourceLocation upgradeTexture7Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/sweet_spot_button_dark.png");
	private final ResourceLocation upgradeTexture8Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/archery_buttons/unabated_button_dark.png");
	
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff3.png");

	private static String upgradeString = "";
	private static final String efficientMarksman = "Efficient Marksman: \n\nEnemies drop 1/2/3 arrow(s) when killed.";
	private static final String hunter = "Hunter: \n\nDeal 1.5/2/3x damage to animals. "
			+ "\n\nAlso, animals always drop 1/2/3x their average food drops in addition to normal drops"
			+ "\n\nE.g., at level 1, chickens will drop 1 and 1 raw chicken(2 total) "
			+ "and pigs will drop 2 and 1-3 raw pork\n(3-5 total).";
	private static final String insecurity = "Insecurity: \n\nDeal 33%/67%/100% more projectile damage to enemies who also fire projectiles";
	private static final String leftClick = "Shotgun Shot: \n\nLeft click to use, fires 8 arrows in a cone in front of you.";
	private static final String quickshot = "Quick Draw: \n\nTake less time to draw an arrow.";
	private static final String sniper = "Sniper: \n\nDeal 10%/ 20%/ 30% more damage to entities for every 15 tiles they are away from your location.";
	private static final String sweetSpot = "Boom, Headshot: \n\nDeal 20%/ 40%/50% more damage to entities when they are shot in the head.";
	private static final String unabated = "Unabated: \n\nGain speed when drawing your bow.";
	
	private static DescriptionPanel upgradeDescription;
	
	private static Button upgradePointsButton;
	
	private static int efficientMarksmanLVL = ClientCapabilityData.isUpgradedEfficientMarksman();
	private static int hunterLVL = ClientCapabilityData.isUpgradedHunter();
	private static int insecurityLVL = ClientCapabilityData.isUpgradedInsecurity();
	private static int shotgunLVL = ClientCapabilityData.isUpgradedLeftClick();
	private static int quickshotLVL = ClientCapabilityData.isUpgradedQuickshot();
	private static int sniperLVL = ClientCapabilityData.isUpgradedSniper();
	private static int sweetSpotLVL = ClientCapabilityData.isUpgradedSweetSpotArchery();
	private static int unabatedLVL = ClientCapabilityData.isUpgradedUnabated();
	private static int upgradePoints = ClientCapabilityData.getPlayerUpgradePoints();

	public ArcheryMenu(Component p_96550_) {
		super(p_96550_);
	}

	@Override
	public final void init() {
		upgradeString = "";
		removeWidget(upgradePointsButton);
		
		upgradePointsButton = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
				button -> {}));
		
		addRenderableWidget(new Button(5, this.height / 16 * 2, 120, 20, 
				Component.literal("Archery Passive: " + ClientCapabilityData.getPlayerArcheryLevel() + "%"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increasing Archery Level increases damage from arrows by 1% per level.");
	     				ArcheryMenu.this.renderTooltip(p_169459_, ArcheryMenu.this.minecraft.font.split(component, Math.max(ArcheryMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		
		addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				efficientMarksmanLVL > 0 ? upgradeTexture1 : upgradeTexture1Dark, 50, 50, ArcheryMenu::onPressToggleEfficientMarksman,
						new Button.OnTooltip() {
		     		public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
		     			Component component = Component.literal("Current Upgrade Level: " + efficientMarksmanLVL);
		     			ArcheryMenu.this.renderTooltip(p_169459_, ArcheryMenu.this.minecraft.font.split(component, Math.max(ArcheryMenu.this.width / 2 - 43, 170)), int1, int2);
		     		}
				},
				Component.empty()));			
			
			
		addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				hunterLVL > 0 ? upgradeTexture2 : upgradeTexture2Dark, 50, 50, ArcheryMenu::onPressToggleHunter,
						new Button.OnTooltip() {
		     		public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
		     			Component component = Component.literal("Current Upgrade Level: " + hunterLVL);
		     			ArcheryMenu.this.renderTooltip(p_169459_, ArcheryMenu.this.minecraft.font.split(component, Math.max(ArcheryMenu.this.width / 2 - 43, 170)), int1, int2);
		     		}
				},
				Component.empty()));		
			
			
		addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				insecurityLVL > 0 ? upgradeTexture3 : upgradeTexture3Dark, 50, 50, ArcheryMenu::onPressToggleInsecurity,
						new Button.OnTooltip() {
		     		public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
		     			Component component = Component.literal("Current Upgrade Level: " + insecurityLVL);
		     			ArcheryMenu.this.renderTooltip(p_169459_, ArcheryMenu.this.minecraft.font.split(component, Math.max(ArcheryMenu.this.width / 2 - 43, 170)), int1, int2);
		     		}
				},
				Component.empty()));		
			
			
		addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				shotgunLVL > 0 ? upgradeTexture4 : upgradeTexture4Dark, 50, 50, ArcheryMenu::onPressToggleLeftClick,
						new Button.OnTooltip() {
		     		public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
		     			Component component = Component.literal("Current Upgrade Level: " + shotgunLVL);
		     			ArcheryMenu.this.renderTooltip(p_169459_, ArcheryMenu.this.minecraft.font.split(component, Math.max(ArcheryMenu.this.width / 2 - 43, 170)), int1, int2);
		     		}
				},
				Component.empty()));		
			
			
		addRenderableWidget(new ImageButton((this.width / 18) * 9, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				quickshotLVL > 0 ? upgradeTexture5 : upgradeTexture5Dark, 50, 50, ArcheryMenu::onPressToggleQuickshot,
						new Button.OnTooltip() {
		     		public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
		     			Component component = Component.literal("Current Upgrade Level: " + quickshotLVL);
		     			ArcheryMenu.this.renderTooltip(p_169459_, ArcheryMenu.this.minecraft.font.split(component, Math.max(ArcheryMenu.this.width / 2 - 43, 170)), int1, int2);
		     		}
				},
				Component.empty()));		
			
			
		addRenderableWidget(new ImageButton((this.width / 18) * 2, (this.height / 6) * 3, 50, 50, 0, 0, 99,
				sniperLVL > 0 ? upgradeTexture6 : upgradeTexture6Dark, 50, 50, ArcheryMenu::onPressToggleSniper,
						new Button.OnTooltip() {
		     		public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
		     			Component component = Component.literal("Current Upgrade Level: " + sniperLVL);
		     			ArcheryMenu.this.renderTooltip(p_169459_, ArcheryMenu.this.minecraft.font.split(component, Math.max(ArcheryMenu.this.width / 2 - 43, 170)), int1, int2);
		     		}
				},
				Component.empty()));		
			
			
		addRenderableWidget(new ImageButton((this.width / 18) * 4, (this.height / 6) * 3, 50, 50, 0, 0, 99,
				sweetSpotLVL > 0 ? upgradeTexture7 : upgradeTexture7Dark, 50, 50, ArcheryMenu::onPressToggleSweetSpot,
						new Button.OnTooltip() {
		     		public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
		     			Component component = Component.literal("Current Upgrade Level: " + sweetSpotLVL);
		     			ArcheryMenu.this.renderTooltip(p_169459_, ArcheryMenu.this.minecraft.font.split(component, Math.max(ArcheryMenu.this.width / 2 - 43, 170)), int1, int2);
		     		}
				},
				Component.empty()));		
			
			
		addRenderableWidget(new ImageButton((this.width / 18) * 6, (this.height / 6) * 3, 50, 50, 0, 0, 99,
				unabatedLVL > 0 ? upgradeTexture8 : upgradeTexture8Dark, 50, 50, ArcheryMenu::onPressToggleUnabated,
						new Button.OnTooltip() {
		     		public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
		     			Component component = Component.literal("Current Upgrade Level: " + unabatedLVL);
		     			ArcheryMenu.this.renderTooltip(p_169459_, ArcheryMenu.this.minecraft.font.split(component, Math.max(ArcheryMenu.this.width / 2 - 43, 170)), int1, int2);
		     		}
				},
				Component.empty()));		
		

		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, (this.width * 91) / 256, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 20) / 56, (this.height * 50) / 49, button -> {})).active = false;

		addRenderableWidget(new Button((this.width * 195) / 256, (this.height * 34) / 40, (this.width * 100) / 840, 20,
				Component.literal("Upgrade"), ArcheryMenu::onPressDoUpgrade));

		removeWidget(upgradeDescription);
		upgradeDescription = new DescriptionPanel(this.minecraft, (this.width * 57) / 256,
				this.height - (this.height * 27) / 64, this.height - ((this.height * 100) / 128));
		this.addRenderableWidget(upgradeDescription);
		List<String> lines = new ArrayList<>();
		lines.add("Select Upgrade.");
		upgradeDescription.setInfo(lines, null, null);
	}
	
	public void tick() {
		if(efficientMarksmanLVL != ClientCapabilityData.isUpgradedEfficientMarksman() 	||
				hunterLVL != ClientCapabilityData.isUpgradedHunter()  					||
				insecurityLVL != ClientCapabilityData.isUpgradedInsecurity()       		||
				shotgunLVL != ClientCapabilityData.isUpgradedLeftClick()      			||
				quickshotLVL != ClientCapabilityData.isUpgradedQuickshot() 				||
				sniperLVL != ClientCapabilityData.isUpgradedSniper()  					||
				sweetSpotLVL != ClientCapabilityData.isUpgradedSweetSpotArchery()       ||
				unabatedLVL != ClientCapabilityData.isUpgradedUnabated()      			||
				upgradePoints != ClientCapabilityData.getPlayerUpgradePoints()) {
				
					efficientMarksmanLVL = ClientCapabilityData.isUpgradedEfficientMarksman();
					hunterLVL = ClientCapabilityData.isUpgradedHunter();
					insecurityLVL = ClientCapabilityData.isUpgradedInsecurity();
					shotgunLVL = ClientCapabilityData.isUpgradedLeftClick();
					quickshotLVL = ClientCapabilityData.isUpgradedQuickshot();
					sniperLVL = ClientCapabilityData.isUpgradedSniper();
					sweetSpotLVL = ClientCapabilityData.isUpgradedSweetSpotArchery();
					unabatedLVL = ClientCapabilityData.isUpgradedUnabated();
					upgradePoints = ClientCapabilityData.getPlayerUpgradePoints();
					
					init();
			}
	}
	
	private static void onPressToggleEfficientMarksman(Button button) {
		upgradeString = efficientMarksman;
		updateCache();
	}

	private static void onPressToggleHunter(Button button) {
		upgradeString = hunter;
		updateCache();
	}

	private static void onPressToggleInsecurity(Button button) {
		upgradeString = insecurity;
		updateCache();
	}

	private static void onPressToggleLeftClick(Button button) {
		upgradeString = leftClick;
		updateCache();
	}

	private static void onPressToggleQuickshot(Button button) {
		upgradeString = quickshot;
		updateCache();
	}

	private static void onPressToggleSniper(Button button) {
		upgradeString = sniper;
		updateCache();
	}

	private static void onPressToggleSweetSpot(Button button) {
		upgradeString = sweetSpot;
		updateCache();
	}

	private static void onPressToggleUnabated(Button button) {
		upgradeString = unabated;
		updateCache();
	}

	private static void onPressDoUpgrade(Button button) {
		if(upgradePoints > 0) {
			switch (upgradeString) {
			case efficientMarksman:
				if(ClientCapabilityData.isUpgradedEfficientMarksman() < 3) ModMessages.sendToServer(new EfficientMarksmanUpgradeC2SPacket());
				break;
			case hunter:
				if(ClientCapabilityData.isUpgradedHunter() < 3) ModMessages.sendToServer(new HunterUpgradeC2SPacket());
				break;
			case insecurity:
				if(ClientCapabilityData.isUpgradedInsecurity() < 3) ModMessages.sendToServer(new InsecurityUpgradeC2SPacket());
				break;
			case leftClick:
				if(ClientCapabilityData.isUpgradedLeftClick() < 1) ModMessages.sendToServer(new LeftClickUpgradeC2SPacket());
				break;
			case quickshot:
				if(ClientCapabilityData.isUpgradedQuickshot() < 3) ModMessages.sendToServer(new QuickshotUpgradeC2SPacket());
				break;
			case sniper:
				if(ClientCapabilityData.isUpgradedSniper() < 3) ModMessages.sendToServer(new SniperUpgradeC2SPacket());
				break;
			case sweetSpot:
				if(ClientCapabilityData.isUpgradedSweetSpotArchery() < 3) ModMessages.sendToServer(new SweetSpotArcheryUpgradeC2SPacket());
				break;
			case unabated:
				if(ClientCapabilityData.isUpgradedUnabated() < 3) ModMessages.sendToServer(new UnabatedUpgradeC2SPacket());
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
		Minecraft.getInstance().setScreen(new UpgradeMenu(Component.literal("mining")));
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
					ArcheryMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
					RenderSystem.disableBlend();
				}
				relativeY += font.lineHeight;
			}

			final Style component = findTextLine(mouseX, mouseY);
			if (component != null) {
				ArcheryMenu.this.renderComponentHoverEffect(poseStack, component, mouseX, mouseY);
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
				ArcheryMenu.this.handleComponentClicked(component);
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