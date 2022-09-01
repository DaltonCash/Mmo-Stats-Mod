package com.daltoncash.mmostats.gui.skill_menus.totals_menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.gui.skill_menus.FarmingMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;

import net.minecraft.client.Minecraft;
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

public class FarmingTotalsMenu extends Screen {
	
	public FarmingTotalsMenu(Component p_96550_) {
		super(p_96550_);
	}
	
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/cobble_bg-2.png");

	
	
	@Override
	public final void init() {
		
		DescriptionPanel upgradeDescription = new DescriptionPanel(this.minecraft, (this.width * 6) / 10 ,
				(this.height * 9) / 10, 25);
		this.addRenderableWidget(upgradeDescription);
		List<String> lines = new ArrayList<>();
		lines.add("Food");
		lines.add("Eaten");
		lines.add("To Level");
		lines.add("----");
		lines.add("-----");
		lines.add("--------");
		lines.add("Apple");
		lines.add("1234");
		lines.add("123");
		lines.add("Beef");
		lines.add("0");
		lines.add("64");
		lines.add("Ya_momma");
		lines.add("12345");
		lines.add("1");
		
		upgradeDescription.setInfo(addLines(lines), null, null);	
		
		
		
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
		 Minecraft.getInstance().setScreen(new FarmingMenu(Component.literal("farming")));
	 }
		class DescriptionPanel extends ScrollPanel {
			private ResourceLocation logoPath;
			private Size2i logoDims = new Size2i(0, 0);
			private List<FormattedCharSequence> lines = Collections.emptyList();

			
			DescriptionPanel(Minecraft mcIn, int widthIn, int heightIn, int topIn) {
				super(mcIn, widthIn, heightIn, topIn, (mcIn.getInstance().screen.width * 2) / 10);
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
						FarmingTotalsMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
						RenderSystem.disableBlend();
					}
					relativeY += font.lineHeight;
				}

				final Style component = findTextLine(mouseX, mouseY);
				if (component != null) {
					FarmingTotalsMenu.this.renderComponentHoverEffect(poseStack, component, mouseX, mouseY);
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
					FarmingTotalsMenu.this.handleComponentClicked(component);
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