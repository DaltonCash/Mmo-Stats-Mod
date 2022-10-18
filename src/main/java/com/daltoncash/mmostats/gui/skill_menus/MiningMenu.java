package com.daltoncash.mmostats.gui.skill_menus;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.gui.skill_menus.totals_menus.MiningTotalsMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeJunkBlocksDropExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNoJunkBlocksC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeObsidianBreakerC2SPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ScreenUtils;
import net.minecraftforge.client.gui.widget.ScrollPanel;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.Size2i;

public class MiningMenu extends Screen {
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/cobble_bg-2.png");

	//Textures to appear bright if upgraded:
	private final ResourceLocation upgradeTexture1 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/mining_buttons/crying_obsidian.png");
	private final ResourceLocation upgradeTexture2 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/mining_buttons/experience_upgrade_texture.png");
	private final ResourceLocation upgradeTexture3 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/mining_buttons/night_vision_button_texture.png");
	private final ResourceLocation upgradeTexture4 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/mining_buttons/no_junk_blocks_button.png");
	
	//Textures to appear dark if not upgraded:
	private final ResourceLocation upgradeTexture1Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/mining_buttons/crying_obsidian_dark.png");
	private final ResourceLocation upgradeTexture2Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/mining_buttons/experience_upgrade_texture_dark.png");
	private final ResourceLocation upgradeTexture3Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/mining_buttons/night_vision_button_texture_dark.png");
	private final ResourceLocation upgradeTexture4Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/mining_buttons/no_junk_blocks_button_dark.png");
	
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff3.png");

	private static String upgradeString = "";
	private static final String cryingObsidian = "Obsidian Breaker: \n\nBreak obsidian 2x / 3x / 4x faster.";
	private static final String experienced = "Experienced: \n\nGain 1/2/3 experience orbs when breaking 'junk blocks'"
			+ "\n\nAlways works, even if No Junk Blocks is upgraded";
	private static final String nightVision = "Night vision: \n\nGrants night vision effect for 60/120/180 seconds upon activation.";
	private static final String noJunkBlocks = "No Junk Blocks: \n\nToggled by WIP, cobblestone, andesite, diorite, granite, basalt, and netherrack no longer drop.";
	
	private static DescriptionPanel upgradeDescription;
	
	private static int counter = 0;
	private static Button upgradePoints;
	private static Button temp;

	public MiningMenu(Component p_96550_) {
		super(p_96550_);
	}

	 @OnlyIn(Dist.CLIENT)
	   public interface TooltipSupplierFactory<T> extends Function<Minecraft, OptionInstance.TooltipSupplier<T>> {
	   }
	 
	 protected void renderMousehoverTooltip(PoseStack p_97054_, @Nullable Component p_97055_, int p_97056_, int p_97057_) {
         if (p_97055_ != null) {
            int i = p_97056_ + 12;
            int j = p_97057_ - 12;
            int k = MiningMenu.this.font.width(p_97055_);
            this.fillGradient(p_97054_, i - 3, j - 3, i + k + 3, j + 8 + 3, -1073741824, -1073741824);
            p_97054_.pushPose();
            p_97054_.translate(0.0D, 0.0D, 400.0D);
            MiningMenu.this.font.drawShadow(p_97054_, p_97055_, (float)i, (float)j, -1);
            p_97054_.popPose();
         }
      }
	@Override
	public final void init() {

		addRenderableWidget(new Button(this.width / 5 * 2, this.height / 40 * 35, this.width / 5, 20, 
				Component.literal("Mining Totals"), MiningMenu::onPressShowTotals));
		
		upgradePoints = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
				MiningMenu::onPressDoNothing));
		//WIP
		Button test = addRenderableWidget(new Button(height/2, height/2, height/2, height/2, title, button -> {},new Button.OnTooltip() {
	         public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	        	 Component component = Component.literal("hello!!!");
	            MiningMenu.this.renderTooltip(p_169459_, MiningMenu.this.minecraft.font.split(component, Math.max(MiningMenu.this.width / 2 - 43, 170)), int1, int2);
	         }
		}));
		if(ClientCapabilityData.isUpgradedObsidianBreaker() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1, 50, 50, MiningMenu::onPressUpgradeObsidianBreaker));	
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1Dark, 50, 50, MiningMenu::onPressUpgradeObsidianBreaker));	
		}
		
		
		if(ClientCapabilityData.isUpgradedJunkBlocksDropExp() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2, 50, 50, MiningMenu::onPressUpgradeJunk));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2Dark, 50, 50, MiningMenu::onPressUpgradeJunk));
		}
		
		
		if(ClientCapabilityData.isUpgradedNightVision() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3, 50, 50, MiningMenu::onPressUpgradeNightVision));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3Dark, 50, 50, MiningMenu::onPressUpgradeNightVision));
		}
		
		
		if(ClientCapabilityData.isUpgradedNoJunkBlocks() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture4, 50, 50, MiningMenu::onPressUpgradeNoJunk));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture4Dark, 50, 50, MiningMenu::onPressUpgradeNoJunk));
		}
		

		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, (this.width * 91) / 256, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 20) / 56, (this.height * 50) / 49,
				MiningMenu::onPressDoNothing)).active = false;

		addRenderableWidget(new Button((this.width * 195) / 256, (this.height * 34) / 40, (this.width * 100) / 840, 20,
				Component.literal("Upgrade"), MiningMenu::onPressDoUpgrade));

		upgradeDescription = new DescriptionPanel(this.minecraft, (this.width * 57) / 256,
				this.height - (this.height * 27) / 64, this.height - ((this.height * 100) / 128));
		this.addRenderableWidget(upgradeDescription);
		List<String> lines = new ArrayList<>();
		lines.add("Select Upgrade.");
		upgradeDescription.setInfo(lines, null, null);
	}
	
	
	
	class TooltipButton extends Button{
		public TooltipButton(int p_93728_, int p_93729_, int p_93730_, int p_93731_, Component p_93732_,
				OnPress p_93733_, OnTooltip p_93734_) {
			super(p_93728_, p_93729_, p_93730_, p_93731_, p_93732_, p_93733_, p_93734_);
		}

		public void renderToolTip(PoseStack p_93653_, int p_93654_, int p_93655_) {
			renderComponentTooltip(p_93653_, null, p_93654_, p_93655_);
			System.out.println("yo");
		}
	}
	
	
	
	public void tick() {
		/*
		counter++;
		removeWidget(temp);
		removeWidget(upgradePoints);
		if(counter % 2 == 1) {
			upgradePoints = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
					Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
					MiningMenu::onPressDoNothing));
		}else {
			temp = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
					Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
					MiningMenu::onPressDoNothing));
		}
		*/
		addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
				MiningMenu::onPressDoNothing));
		
		if(ClientCapabilityData.isUpgradedObsidianBreaker() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1, 50, 50, MiningMenu::onPressUpgradeObsidianBreaker));	
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1Dark, 50, 50, MiningMenu::onPressUpgradeObsidianBreaker));	
		}
		
		
		if(ClientCapabilityData.isUpgradedJunkBlocksDropExp() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2, 50, 50, MiningMenu::onPressUpgradeJunk));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2Dark, 50, 50, MiningMenu::onPressUpgradeJunk));
		}
		
		
		if(ClientCapabilityData.isUpgradedNightVision() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3, 50, 50, MiningMenu::onPressUpgradeNightVision));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3Dark, 50, 50, MiningMenu::onPressUpgradeNightVision));
		}
		
		
		if(ClientCapabilityData.isUpgradedNoJunkBlocks() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture4, 50, 50, MiningMenu::onPressUpgradeNoJunk));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture4Dark, 50, 50, MiningMenu::onPressUpgradeNoJunk));
		}
	}
	
	private static void onPressShowTotals(Button button) {
		 Minecraft.getInstance().setScreen(new MiningTotalsMenu(Component.literal("mining_totals")));
	}
	
	private static void onPressUpgradeJunk(Button button) {
		upgradeString = experienced;
		updateCache();
	}

	private static void onPressUpgradeNightVision(Button button) {
		upgradeString = nightVision;
		updateCache();
	}

	private static void onPressUpgradeNoJunk(Button button) {
		upgradeString = noJunkBlocks;
		updateCache();
	}

	private static void onPressUpgradeObsidianBreaker(Button button) {
		upgradeString = cryingObsidian;
		updateCache();
	}

	private static void onPressDoNothing(Button button) {

	}

	private static void onPressDoUpgrade(Button button) {
		if(ClientCapabilityData.getPlayerUpgradePoints() > 0) {
			switch (upgradeString) {
			case experienced:
				ModMessages.sendToServer(new UpgradeJunkBlocksDropExpC2SPacket());
				break;
			case nightVision:
				ModMessages.sendToServer(new UpgradeNightVisionC2SPacket());
				break;
			case noJunkBlocks:
				ModMessages.sendToServer(new UpgradeNoJunkBlocksC2SPacket());
				break;
			case cryingObsidian:
				ModMessages.sendToServer(new UpgradeObsidianBreakerC2SPacket());
				break;
			}
			
			Minecraft.getInstance().setScreen(new MiningMenu(Component.literal("mining")));
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
		upgradePoints.renderToolTip(p_96562_, p_96563_, p_96564_);
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
					MiningMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
					RenderSystem.disableBlend();
				}
				relativeY += font.lineHeight;
			}

			final Style component = findTextLine(mouseX, mouseY);
			if (component != null) {
				MiningMenu.this.renderComponentHoverEffect(poseStack, component, mouseX, mouseY);
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
				MiningMenu.this.handleComponentClicked(component);
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
	/*
	//----------blocks mined buttons---------------
	ancientDebris = addRenderableWidget(new Button(0, this.height / 16 * 1, 100, 20, 
			Component.literal(ClientCapabilityData.getAncientDebrisMined() + " Ancient Debris"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 2, 100, 20, 
			Component.literal(ClientCapabilityData.getCoalMined() + " Coal"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 3, 100, 20, 
			Component.literal(ClientCapabilityData.getCopperMined() + " Copper"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 4, 100, 20, 
			Component.literal(ClientCapabilityData.getDiamondMined() + " Diamond"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 5, 100, 20, 
			Component.literal(ClientCapabilityData.getEmeraldMined() + " Emerald"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 6, 100, 20, 
			Component.literal(ClientCapabilityData.getGlowstoneMined() + " Glowstone"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 7, 100, 20, 
			Component.literal(ClientCapabilityData.getGoldMined() + " Gold"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 8, 100, 20, 
			Component.literal(ClientCapabilityData.getIronMined() + " Iron"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 9, 100, 20, 
			Component.literal(ClientCapabilityData.getLapisMined() + " Lapis"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 10, 100, 20, 
			Component.literal(ClientCapabilityData.getNetherGoldMined() + " Nether Gold"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 11, 100, 20, 
			Component.literal(ClientCapabilityData.getQuartzMined() + " Quartz"), 
			MiningMenu::onPressDoNothing));
	addRenderableWidget(new Button(0, this.height / 16 * 12, 100, 20, 
			Component.literal(ClientCapabilityData.getRedstoneMined() + " Redstone"), 
			MiningMenu::onPressDoNothing));
			*/
//-------------------------------------------------------------------------WIP
	/*
	public static List<FormattedCharSequence> tooltipAt(OptionsList p_96288_, int p_96289_, int p_96290_) {
	      Optional<AbstractWidget> optional = p_96288_.getMouseOver((double)p_96289_, (double)p_96290_);
	      return (List<FormattedCharSequence>)(optional.isPresent() && optional.get() instanceof TooltipAccessor ? ((TooltipAccessor)optional.get()).getTooltip() : ImmutableList.of());
	   }
	*/
//-------------------------------------------------------------------------WIP
}
