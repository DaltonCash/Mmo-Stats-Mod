package com.daltoncash.mmostats.gui.skill_menus.totals_menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.skill_menus.ChoppingMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
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

public class ChoppingTotalsMenu extends Screen {
	
	public ChoppingTotalsMenu(Component p_96550_) {
		super(p_96550_);
	}
	
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/cobble_bg-2.png");

	
	
	@Override
	public final void init() {
		
		addRenderableWidget(new Button(10, this.height / 16 * 1, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getOakChopped()) + " Oak"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases % max health by 1% per level. Multiplied by Gold Apples Level.");
	     				ChoppingTotalsMenu.this.renderTooltip(p_169459_, ChoppingTotalsMenu.this.minecraft.font.split(component, Math.max(ChoppingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		addRenderableWidget(new Button(10, this.height / 16 * 2, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getSpruceChopped()) + " Spruce"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				ChoppingTotalsMenu.this.renderTooltip(p_169459_, ChoppingTotalsMenu.this.minecraft.font.split(component, Math.max(ChoppingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				})).active = false;
		addRenderableWidget(new Button(10, this.height / 16 * 3, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getBirchChopped()) + " Birch"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases Farming Exp gain by 1% per level. Multiplied by Bread and Copper levels.");
	     				ChoppingTotalsMenu.this.renderTooltip(p_169459_, ChoppingTotalsMenu.this.minecraft.font.split(component, Math.max(ChoppingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		addRenderableWidget(new Button(10, this.height / 16 * 4, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getJungleChopped()) + " Jungle"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases Chopping Exp gain by 1% per level. Multiplied by Apple level.");
	     				ChoppingTotalsMenu.this.renderTooltip(p_169459_, ChoppingTotalsMenu.this.minecraft.font.split(component, Math.max(ChoppingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		addRenderableWidget(new Button(10, this.height / 16 * 5, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getAcaciaChopped()) + " Acacia"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases Movespeed by .5% per level. Multiplied by Redstone level.");
	     				ChoppingTotalsMenu.this.renderTooltip(p_169459_, ChoppingTotalsMenu.this.minecraft.font.split(component, Math.max(ChoppingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		addRenderableWidget(new Button(10, this.height / 16 * 6, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getDarkOakChopped()) + " Dark Oak"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Reduces % damage taken by entities in an equation as follows: "
	     						+ "\n\n     (Diamond * Potato * Dark Oak) " + "\n   -------------------------  \n" + " ((Diamond * Potato * Dark Oak) + 100)");
	     				ChoppingTotalsMenu.this.renderTooltip(p_169459_, ChoppingTotalsMenu.this.minecraft.font.split(component, Math.max(175, 170)), int1, int2);
	     			}
				}));
		addRenderableWidget(new Button(10, this.height / 16 * 7, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMangroveChopped()) + " Mangrove"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				ChoppingTotalsMenu.this.renderTooltip(p_169459_, ChoppingTotalsMenu.this.minecraft.font.split(component, Math.max(ChoppingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				})).active = false;
		addRenderableWidget(new Button(10, this.height / 16 * 8, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getCrimsonStemChopped()) + " Crimson"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				ChoppingTotalsMenu.this.renderTooltip(p_169459_, ChoppingTotalsMenu.this.minecraft.font.split(component, Math.max(ChoppingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				})).active = false;
		addRenderableWidget(new Button(10, this.height / 16 * 9, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getWarpedStemChopped()) + " Warped"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				ChoppingTotalsMenu.this.renderTooltip(p_169459_, ChoppingTotalsMenu.this.minecraft.font.split(component, Math.max(ChoppingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				})).active = false;
		
		
		DescriptionPanel foodPanel = new DescriptionPanel(this.minecraft, (this.width * 1) / 4 ,
				(this.height * 9) / 10, 25, (this.width * 1) / 4);
		List<String> foodList = List.of("Wood","====",
				"Oak Logs", "Spruce Logs", "Birch Logs", "------------------",
				"Jungle Logs", "Acacia Logs","Dark Oak Logs", "------------------",
				"Mangrove Logs", "Crimson Stems", "Warped Stems");
		
		DescriptionPanel eatenPanel = new DescriptionPanel(this.minecraft, (this.width * 1) / 4 ,
				(this.height * 9) / 10, 25, (this.width * 2) / 4);
		List<String> eatenList = new ArrayList<>();
		eatenList.add("Chopped");
		eatenList.add("=====");
		eatenList.add(ClientCapabilityData.getOakChopped() + "");
		eatenList.add(ClientCapabilityData.getSpruceChopped() + "");
		eatenList.add(ClientCapabilityData.getBirchChopped() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getJungleChopped() + "");
		eatenList.add(ClientCapabilityData.getAcaciaChopped() + "");
		eatenList.add(ClientCapabilityData.getDarkOakChopped() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getMangroveChopped() + "");
		eatenList.add(ClientCapabilityData.getCrimsonStemChopped() + "");
		eatenList.add(ClientCapabilityData.getWarpedStemChopped() + "");
		
		DescriptionPanel toLevelPanel = new DescriptionPanel(this.minecraft, (this.width * 1) / 4 ,
				(this.height * 9) / 10, 25, (this.width * 3) / 4);
		List<String> toLevelList = new ArrayList<>();
		toLevelList.add("To Level");
		toLevelList.add("========");
		
		for(String eaten : eatenList) {
			int i = 32;
			if(eaten != eatenList.get(0) && eaten != eatenList.get(1) && eaten != eatenList.get(5)) {
				while(Integer.parseInt(eaten) >= i) {
					i *= 2;
				}
				toLevelList.add(i + "");
			}else if(eaten == eatenList.get(5)){
				toLevelList.add(eaten);
			}
		}
		
		this.addRenderableWidget(foodPanel);
		this.addRenderableWidget(eatenPanel);
		this.addRenderableWidget(toLevelPanel);
		
		foodPanel.setInfo(foodList, null, null);	
		eatenPanel.setInfo(eatenList, null, null);
		toLevelPanel.setInfo(toLevelList, null, null);
	}
	protected List<String> addLines(List<String> list){
		List<String> newList = new ArrayList<>();
		String whiteSpace1 = "";
		for(int i = 0; i < this.width / 24; i++) whiteSpace1 += "^";
		
		String whiteSpace2 = "";
		for(int i = 0; i < this.width / 43; i++) whiteSpace2 += "^";
		System.out.println(this.width);
		System.out.println(whiteSpace1.length());
		System.out.println(whiteSpace2.length());
		for(int i = 0; i < list.size(); i += 3) {
			newList.add(list.get(i) + whiteSpace1.substring(Math.min(this.width / 24 + 1, list.get(i).length() )) +
					list.get(i + 1) + whiteSpace2.substring(Math.min(this.width / 43 + 1, list.get(i + 1).length() )) +
					list.get(i + 2));
			
		}
		
		
		return newList;
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
		 Minecraft.getInstance().setScreen(new ChoppingMenu(Component.literal("chopping")));
	 }
		class DescriptionPanel extends ScrollPanel {
			private ResourceLocation logoPath;
			private Size2i logoDims = new Size2i(0, 0);
			private List<FormattedCharSequence> lines = Collections.emptyList();

			
			DescriptionPanel(Minecraft mcIn, int widthIn, int heightIn, int topIn, int widthStart) {
				super(mcIn, widthIn, heightIn, topIn, widthStart);
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
					// Draw the logo image inscribed in a rectangle with width entryWidth (minus
					// some padding) and height 50
					int headerHeight = 50;
					ScreenUtils.blitInscribed(poseStack, left + 20, relativeY, width - (20 * 2), headerHeight,
							logoDims.width, logoDims.height, false, true);
					relativeY += headerHeight + 20;
				}

				for (FormattedCharSequence line : lines) {
					if (line != null) {
						RenderSystem.enableBlend();
						ChoppingTotalsMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
						RenderSystem.disableBlend();
					}
					relativeY += font.lineHeight;
				}

				final Style component = findTextLine(mouseX, mouseY);
				if (component != null) {
					ChoppingTotalsMenu.this.renderComponentHoverEffect(poseStack, component, mouseX, mouseY);
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
					ChoppingTotalsMenu.this.handleComponentClicked(component);
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