package com.daltoncash.mmostats.gui.skill_menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.DodgeRollUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.FreeArrowsUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.OvercomeUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.RagnorokUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.TakeStanceUpgradeC2SPacket;
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

public class CombatMenu extends Screen {
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/cobble_bg-2.png");

	//Textures to appear bright if upgraded:
	private final ResourceLocation upgradeTexture1 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/dodge_roll_button.png");
	private final ResourceLocation upgradeTexture2 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/free_arrows_button.png");
	private final ResourceLocation upgradeTexture3 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/overcome_button.png");
	private final ResourceLocation upgradeTexture4 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/ragnorok_button.png");
	private final ResourceLocation upgradeTexture5 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/take_stance_button.png");
	
	//Textures to appear dark if not upgraded:
	private final ResourceLocation upgradeTexture1Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/dodge_roll_button_dark.png");
	private final ResourceLocation upgradeTexture2Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/free_arrows_button_dark.png");
	private final ResourceLocation upgradeTexture3Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/overcome_button_dark.png");
	private final ResourceLocation upgradeTexture4Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/ragnorok_button_dark.png");
	private final ResourceLocation upgradeTexture5Dark = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/combat_buttons/take_stance_button_dark.png");
	
	
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff3.png");

	private static String upgradeString = "";
	private static final String dodgeRoll = "Dodge Roll: \n\nUse 'C' to roll in the direction you are moving in. "
			+ "\nAlso, gain invulnerability frames while rolling.";
	private static final String freeArrows = "Critical Acclaim: \n\nWhen blocking an arrow with shield, gain 33% / 66% / 100% chance to steal the arrow.";
	private static final String overcome = "Overcome: \n\nIncreases duration of i-frames when taking damage(2x / 3x / 4x).";
	private static final String ragnorok = "Ragnorok: \n\nAvoid death when losing more health than available. "
			+ "\n When this effect occurs, gain 2% / 4% / 6% max hp on-hit for 5 seconds. 5 minute cooldown.";
	private static final String takeStance = "Immovable: \n\nTake 10% / 20% / 25% less knockback from entities.";
	
	private static DescriptionPanel upgradeDescription;

	private static int counter = 0;
	private static Button upgradePoints;
	private static Button temp;
	
	public CombatMenu(Component p_96550_) {
		super(p_96550_);
	}

	@Override
	public final void init() {

		//addRenderableWidget(new Button(this.width/13 * 6, this.height/13 * 6, 50, 50, 
				//Component.literal("Combat Totals"), CombatMenu::onPressShowTotals));
		
		upgradePoints = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
				CombatMenu::onPressDoNothing));
		
		if(ClientCapabilityData.isUpgradedDodgeRoll() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1, 50, 50, CombatMenu::onPressUpgradeDodgeRoll));	
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1Dark, 50, 50, CombatMenu::onPressUpgradeDodgeRoll));	
		}
		
		
		if(ClientCapabilityData.isUpgradedFreeArrows() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2, 50, 50, CombatMenu::onPressUpgradeFreeArrows));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2Dark, 50, 50, CombatMenu::onPressUpgradeFreeArrows));
		}
		
		
		if(ClientCapabilityData.isUpgradedOvercome() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3, 50, 50, CombatMenu::onPressUpgradeOvercome));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3Dark, 50, 50, CombatMenu::onPressUpgradeOvercome));
		}
		
		
		if(ClientCapabilityData.isUpgradedRagnorok() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture4, 50, 50, CombatMenu::onPressUpgradeRagnorok));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture4Dark, 50, 50, CombatMenu::onPressUpgradeRagnorok));
		}
		
		
		if(ClientCapabilityData.isUpgradedTakeStance() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 9, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture5, 50, 50, CombatMenu::onPressUpgradeTakeStance));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 9, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture5Dark, 50, 50, CombatMenu::onPressUpgradeTakeStance));
		}
		

		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, (this.width * 91) / 256, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 20) / 56, (this.height * 50) / 49,
				CombatMenu::onPressDoNothing)).active = false;

		addRenderableWidget(new Button((this.width * 195) / 256, (this.height * 34) / 40, (this.width * 100) / 840, 20,
				Component.literal("Upgrade"), CombatMenu::onPressDoUpgrade));

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
					CombatMenu::onPressDoNothing));
		}else {
			temp = addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
					Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
					CombatMenu::onPressDoNothing));
		}
		
		addRenderableWidget(new Button(this.width / 3, this.height / 40, this.width / 3, 20,
				Component.literal("Upgrades Unspent: " + ClientCapabilityData.getPlayerUpgradePoints()),
				CombatMenu::onPressDoNothing));
		
		if(ClientCapabilityData.isUpgradedDodgeRoll() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1, 50, 50, CombatMenu::onPressUpgradeDodgeRoll));	
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture1Dark, 50, 50, CombatMenu::onPressUpgradeDodgeRoll));	
		}
		
		
		if(ClientCapabilityData.isUpgradedFreeArrows() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2, 50, 50, CombatMenu::onPressUpgradeFreeArrows));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture2Dark, 50, 50, CombatMenu::onPressUpgradeFreeArrows));
		}
		
		
		if(ClientCapabilityData.isUpgradedOvercome() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3, 50, 50, CombatMenu::onPressUpgradeOvercome));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 5, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture3Dark, 50, 50, CombatMenu::onPressUpgradeOvercome));
		}
		
		
		if(ClientCapabilityData.isUpgradedRagnorok() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture4, 50, 50, CombatMenu::onPressUpgradeRagnorok));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 7, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture4Dark, 50, 50, CombatMenu::onPressUpgradeRagnorok));
		}
		
		
		if(ClientCapabilityData.isUpgradedTakeStance() > 0) {
			addRenderableWidget(new ImageButton((this.width / 18) * 9, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture5, 50, 50, CombatMenu::onPressUpgradeTakeStance));
		}else {
			addRenderableWidget(new ImageButton((this.width / 18) * 9, (this.height / 6) * 2, 50, 50, 0, 0, 99,
					upgradeTexture5Dark, 50, 50, CombatMenu::onPressUpgradeTakeStance));
		}
	}
	//WIP\/
	//private static void onPressShowTotals(Button button) {
	//	 Minecraft.getInstance().setScreen(new CombatTotalsMenu(Component.literal("combat_totals")));
	//}
	//WIP^
	private static void onPressUpgradeDodgeRoll(Button button) {
		upgradeString = dodgeRoll;
		updateCache();
	}
	
	private static void onPressUpgradeFreeArrows(Button button) {
		upgradeString = freeArrows;
		updateCache();
	}

	private static void onPressUpgradeOvercome(Button button) {
		upgradeString = overcome;
		updateCache();
	}

	private static void onPressUpgradeRagnorok(Button button) {
		upgradeString = ragnorok;
		updateCache();
	}
	private static void onPressUpgradeTakeStance(Button button) {
		upgradeString = takeStance;
		updateCache();
	}

	private static void onPressDoNothing(Button button) {

	}

	private static void onPressDoUpgrade(Button button) {
		if(ClientCapabilityData.getPlayerUpgradePoints() > 0) {
			switch (upgradeString) {
			case dodgeRoll:
				ModMessages.sendToServer(new DodgeRollUpgradeC2SPacket());
				break;
			case freeArrows:
				ModMessages.sendToServer(new FreeArrowsUpgradeC2SPacket());
				break;
			case overcome:
				ModMessages.sendToServer(new OvercomeUpgradeC2SPacket());
				break;
			case ragnorok:
				ModMessages.sendToServer(new RagnorokUpgradeC2SPacket());
				break;
			case takeStance:
				ModMessages.sendToServer(new TakeStanceUpgradeC2SPacket());
				break;
			}
			
			Minecraft.getInstance().setScreen(new CombatMenu(Component.literal("combat")));
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
					CombatMenu.this.font.drawShadow(poseStack, line, left + 20, relativeY, 0xFFFFFF);
					RenderSystem.disableBlend();
				}
				relativeY += font.lineHeight;
			}

			final Style component = findTextLine(mouseX, mouseY);
			if (component != null) {
				CombatMenu.this.renderComponentHoverEffect(poseStack, component, mouseX, mouseY);
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
				CombatMenu.this.handleComponentClicked(component);
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