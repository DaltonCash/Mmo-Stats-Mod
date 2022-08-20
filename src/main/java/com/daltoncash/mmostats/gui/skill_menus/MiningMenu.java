package com.daltoncash.mmostats.gui.skill_menus;


import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeJunkBlocksDropExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNoJunkBlocksC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeObsidianBreakerC2SPacket;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class MiningMenu extends Screen {
	public Widget ancientDebris;
	//private OptionsList list;
	//protected final Options options;
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/test_images/new_test_mining_bg.png");
	private final ResourceLocation upgradeTexture1 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/experience_upgrade_texture.png");
	private final ResourceLocation upgradeTexture2 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/no_junk_blocks_button.png");
	private final ResourceLocation upgradeTexture3 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/night_vision_button_texture.png");
	private final ResourceLocation upgradeTexture4 = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/buttons/crying_obsidian.png");
	private final ResourceLocation descriptionBanner = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/background/descstuff1.png");

	public MiningMenu(Component p_96550_) {
		super(p_96550_);
	}
	
	@Override
	public final void init() {
		
		addRenderableWidget(new Button(this.width/13 * 6, this.height/13 * 6, 50, 50, 
				Component.literal(this.height + " " + this.width), MiningMenu::onPressDoNothing));
		
		addRenderableWidget(new ImageButton((this.width / 6) * 1, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture1, 50, 50, MiningMenu::onPressUpgradeJunk));
		addRenderableWidget(new ImageButton((this.width / 6) * 3, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture2, 50, 50, MiningMenu::onPressUpgradeNoJunk));
		addRenderableWidget(new ImageButton((this.width / 6) * 2, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture3, 50, 50, MiningMenu::onPressUpgradeNightVision));
		addRenderableWidget(new ImageButton((this.width / 6) * 4, (this.height / 6) * 2, 50, 50, 0, 0, 99,
				upgradeTexture4, 50, 50, MiningMenu::onPressUpgradeObsidianBreaker));
		
		
		addRenderableWidget(new ImageButton((this.width * 27) / 42, 0, this.width/10 * 9, this.height, 0, 0, 0,
				descriptionBanner, (this.width * 40)/84, (this.height * 50)/49, MiningMenu::onPressDoNothing));
		
		
		addRenderableWidget(new Button((this.width * 33) /40, (this.height * 35) / 40, (this.width * 100) / 840, 20, 
				Component.literal("Upgrade"), MiningMenu::onPressDoNothing));
		
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
	}
	private static void onPressDoNothing(Button button) {
		
	}
	private static void onPressUpgradeJunk(Button button) {
		ModMessages.sendToServer(new UpgradeJunkBlocksDropExpC2SPacket());
	}

	private static void onPressUpgradeNightVision(Button button) {
		ModMessages.sendToServer(new UpgradeNightVisionC2SPacket());
	}

	private static void onPressUpgradeNoJunk(Button button) {
		ModMessages.sendToServer(new UpgradeNoJunkBlocksC2SPacket());
	}

	private static void onPressUpgradeObsidianBreaker(Button button) {
		ModMessages.sendToServer(new UpgradeObsidianBreakerC2SPacket());
	}
//-------------------------------------------------------------------------
	/*
	public static List<FormattedCharSequence> tooltipAt(OptionsList p_96288_, int p_96289_, int p_96290_) {
	      Optional<AbstractWidget> optional = p_96288_.getMouseOver((double)p_96289_, (double)p_96290_);
	      return (List<FormattedCharSequence>)(optional.isPresent() && optional.get() instanceof TooltipAccessor ? ((TooltipAccessor)optional.get()).getTooltip() : ImmutableList.of());
	   }
	*/
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
		 Minecraft.getInstance().setScreen(new UpgradeMenu(Component.literal("mining")));
	 }
}
