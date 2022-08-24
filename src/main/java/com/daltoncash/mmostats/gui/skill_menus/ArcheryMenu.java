package com.daltoncash.mmostats.gui.skill_menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.EfficientMarksmanUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.HunterUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.InsecurityUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.LeftClickUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.QuickshotUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.SniperUpgradeC2SPacket;
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
	public Widget ancientDebris;
	//private OptionsList list;
	//protected final Options options;
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/cobble_bg-2.png");
	
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
	
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff3.png");

	private static String upgradeString = "";
	private static final String efficientMarksman = "does something";
	private static final String hunter = "Hunter: \n\nDeal 1.5/2/3x damage to animals. "
			+ "\n\nAlso, animals always drop 1/2/3x their average food drops in addition to normal drops"
			+ "\n\nE.g., at level 1, chickens will drop 1 and 1 raw chicken(2 total) "
			+ "and pigs will drop 2 and 1-3 raw pork\n(3-5 total).";
	private static final String insecurity = "does another thing";
	private static final String leftClick = "ayo this man nutting";
	private static final String quickshot = "quickfire coom";
	private static final String sniper = "pew";
	private static final String sweetSpot = "pewpew";
	private static final String unabated = "pewdiepie";
	
	private static DescriptionPanel upgradeDescription;
	public ArcheryMenu(Component p_96550_) {
		super(p_96550_);
	}
	
	@Override
	public final void init() {
		//H x W display
		addRenderableWidget(new Button(this.width/13 * 6, this.height/13 * 6, 50, 50, 
				Component.literal(this.width + " " + this.height), ArcheryMenu::onPressDoNothing));
		
		//Upgrade Banner-needs to be at bottom when done
				
				
				
				
				
				upgradeDescription = new DescriptionPanel(this.minecraft, (this.width * 57) / 256 , this.height - (this.height * 27) / 64, this.height - ((this.height * 100) / 128));
				this.addRenderableWidget(upgradeDescription);
				
				
				List<String> lines = new ArrayList<>();
				lines.add("Select Upgrade.");
				upgradeDescription.setInfo(lines, null, null);
				
				
		addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture1, 50, 50, ArcheryMenu::onPressToggleEfficientMarksman));
		addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture2, 50, 50, ArcheryMenu::onPressToggleHunter));
		addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture3, 50, 50, ArcheryMenu::onPressToggleInsecurity));
		addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture4, 50, 50, ArcheryMenu::onPressToggleLeftClick));
		addRenderableWidget(new ImageButton((this.width / 18) * 9, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture5, 50, 50, ArcheryMenu::onPressToggleQuickshot));
		addRenderableWidget(new ImageButton((this.width / 18) * 2, (this.height / 6) * 3, 50, 50, 0, 0, 99,
				upgradeTexture6, 50, 50, ArcheryMenu::onPressToggleSniper));
		addRenderableWidget(new ImageButton((this.width / 18) * 4, (this.height / 6) * 3, 50, 50, 0, 0, 99,
				upgradeTexture7, 50, 50, ArcheryMenu::onPressToggleSweetSpot));
		addRenderableWidget(new ImageButton((this.width / 18) * 6, (this.height / 6) * 3, 50, 50, 0, 0, 99,
				upgradeTexture8, 50, 50, ArcheryMenu::onPressToggleUnabated));
		
		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, (this.width * 91) / 256, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 20)/56, (this.height * 50)/49, ArcheryMenu::onPressCancel))
				.active = false;
				
		addRenderableWidget(new Button((this.width * 195) / 256, (this.height * 34) / 40, (this.width * 100) / 840, 20, 
				Component.literal("Upgrade"), ArcheryMenu::onPressDoUpgrade));
		
		
		
	}
	private static void onPressCancel(Button button) {
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
	
	
	
	private static void onPressDoNothing(Button button) {
		
	}
	private static void onPressDoUpgrade(Button button) {
		switch(upgradeString) {
			case efficientMarksman:
				ModMessages.sendToServer(new EfficientMarksmanUpgradeC2SPacket());
				break;
			case hunter:
				ModMessages.sendToServer(new HunterUpgradeC2SPacket());
				break;
			case insecurity:
				ModMessages.sendToServer(new InsecurityUpgradeC2SPacket());
				break;
			case leftClick:
				ModMessages.sendToServer(new LeftClickUpgradeC2SPacket());
				break;
			case quickshot:
				ModMessages.sendToServer(new QuickshotUpgradeC2SPacket());
				break;
			case sniper:
				ModMessages.sendToServer(new SniperUpgradeC2SPacket());
				break;
			case sweetSpot:
				ModMessages.sendToServer(new EfficientMarksmanUpgradeC2SPacket());
				break;
			case unabated:
				ModMessages.sendToServer(new EfficientMarksmanUpgradeC2SPacket());
				break;
		}
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
			DescriptionPanel(Minecraft mcIn, int widthIn, int heightIn, int topIn)
	        {
	            super(mcIn, widthIn, heightIn, topIn, (Minecraft.getInstance().screen.width * 91) / 128);
	        }

	        void setInfo(List<String> lines, ResourceLocation logoPath, Size2i logoDims)
	        {
	            this.logoPath = logoPath;
	            this.logoDims = logoDims;
	            this.lines = resizeContent(lines);
	        }
	        
	        private List<FormattedCharSequence> resizeContent(List<String> lines)
	        {
	            List<FormattedCharSequence> ret = new ArrayList<>();
	            for (String line : lines)
	            {
	                if (line == null)
	                {
	                    ret.add(null);
	                    continue;
	                }

	                Component chat = ForgeHooks.newChatWithLinks(line, false);
	                int maxTextLength = this.width - 40;
	                if (maxTextLength >= 0)
	                {
	                    ret.addAll(Language.getInstance().getVisualOrder(font.getSplitter().splitLines(chat, maxTextLength, Style.EMPTY)));
	                }
	            }
	            return ret;
	        }

	        @Override
	        public int getContentHeight()
	        {
	            int height = 50;
	            height += (lines.size() * font.lineHeight);
	            if (height < this.bottom - this.top - 8)
	                height = this.bottom - this.top - 8;
	            return height;
	        }

	        @Override
	        protected int getScrollAmount()
	        {
	            return font.lineHeight * 3;
	        }

	        @Override
	        protected void drawPanel(PoseStack poseStack, int entryRight, int relativeY, Tesselator tess, int mouseX, int mouseY)
	        {
	            if (logoPath != null) {
	                RenderSystem.setShader(GameRenderer::getPositionTexShader);
	                RenderSystem.enableBlend();
	                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
	                RenderSystem.setShaderTexture(0, logoPath);
	                // Draw the logo image inscribed in a rectangle with width entryWidth (minus some padding) and height 50
	                int headerHeight = 50;
	                ScreenUtils.blitInscribed(poseStack, left + 20, relativeY, width - (20 * 2), headerHeight, logoDims.width, logoDims.height, false, true);
	                relativeY += headerHeight + 20;
	            }

	            for (FormattedCharSequence line : lines)
	            {
	                if (line != null)
	                {
	                    RenderSystem.enableBlend();
	                    ArcheryMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
	                    RenderSystem.disableBlend();
	                }
	                relativeY += font.lineHeight;
	            }

	            final Style component = findTextLine(mouseX, mouseY);
	            if (component!=null) {
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

	            FormattedCharSequence line = lines.get(lineIdx-1);
	            if (line != null)
	            {
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
	 private static void updateCache()
	    {
		 	
	        List<String> lines = new ArrayList<>();
	        
	        lines.add(null);
	        lines.add(upgradeString);
	        upgradeDescription.setInfo(lines, null, null);
	    }
}