package com.daltoncash.mmostats.gui.skill_menus.totals_menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.skill_menus.FarmingMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;

import net.minecraft.ChatFormatting;
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

public class FarmingTotalsMenu extends Screen {
	
	public FarmingTotalsMenu(Component p_96550_) {
		super(p_96550_);
	}
	
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID,
			"textures/gui/cobble_bg-2.png");

	
	
	@Override
	public final void init() {
		
		addRenderableWidget(new Button(10, this.height * 2 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getApplesEaten()) + " Apples"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases Chopping Exp gain by 1%. Muliplied by Copper Level.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 2 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getBeefEaten()) + " Beef"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases flat damage by 1 per level. Additive with Ancient Debris level.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 3 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getBeetrootEaten()) + " Beetroot"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 3 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getBreadEaten()) + " Bread"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases Farming Exp gain by 1%. Multiplied by Copper and Birch levels.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 4 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getCakeEaten()) + " Cake"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 4 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getCarrotsEaten()) + " Carrots"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases Archery Exp gain by 1%. Multiplied by Quartz level.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 5 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getChickenEaten()) + " Chicken"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Decreases % Fall Damage taken by the following equation: "
	     						+ "\n\n     Chicken \n ----------- \n  Chicken + 4");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 5 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getCookiesEaten()) + " Cookies"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases the duration of the Farming upgrade, 'Sugar Rush', by 2 seconds per level.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 6 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getFishEaten()) + " Fish"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 6 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGlowBerriesEaten()) + " Glow Berry"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases Mining Exp gain by 1% per level. Multiplied by Coal level.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 7 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGoldApplesEaten()) + " Gold Apples"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases Max HP by 1% per level. Multiplied by Oak level.").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.OBFUSCATED);
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 7 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGoldenCarrotsEaten()) + " Gold Carrots"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP - should increase arrow dmg");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 8 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getHoneyEaten()) + " Honey Bottles"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 8 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getKelpEaten()) + " Kelp"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Reduces % damage taken by entities in an equation as follows: \"\r\n"
	     						+ "	     						+ \"\\n\\n     (Diamond * Kelp * Dark Oak) \" + \"\\n   -------------------------  \"+ \" ((Diamond * Kelp * Dark Oak) + 100)");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(175, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 9 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMelonEaten()) + " Melon Slices"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Reduces the time it takes to eat foodstuffs. WIP");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 9 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMushroomStewEaten()) + " Mush. Stew"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases the duration of Ragnorok by 50% per level");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 10 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMuttonEaten()) + " Mutton"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 10 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPoisonousPotatoEaten()) + " Poi. Potato"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 11 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPorkEaten()) + " Pork"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases efficiency of Archery Upgrade, 'Hunter'. increases the amount of meat an animal drops by +1 per level.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 11 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPotatoEaten()) + " Potato"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Reduces amount of knockback taken by the following equation:\n4 / (4 + Potato).");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 12 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPufferfishEaten()) + " Pufferfish"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("WIP");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 12 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getRabbitEaten()) + " Rabbit"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Upon reaching level 1 Rabbit, gain jump boost for 3 minutes on eating food. Strength of jump boost increases by 2 per level. Can go above vanilla values...");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 13 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPumpkinPieEaten()) + " Pumpkin Pie"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Reduces damage taken by 1 half-heart per level.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 13 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPufferfishEaten()) + " Raw Meat"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Increases Combat Exp gain by 1% per level. Multiplied by Iron level.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(10, this.height * 14 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getRottenFleshEaten()) + " Rotten Flesh"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("At level 1 Rotten Flesh, begin healing 5% max hp per 250 ticks. Higher levels decrease the time between heals by the following equation:"
	     						+ "\n1250 / (4 + Rotten Flesh)");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		addRenderableWidget(new Button(140, this.height * 14 / 16, 120, 20, 
				Component.literal("Level " + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getSpiderEyeEaten()) + " Spider Eyes"), 
				button -> {}, new Button.OnTooltip() {
	     			public void onTooltip(Button p_169458_, PoseStack p_169459_, int int1, int int2) {
	     				Component component = Component.literal("Upon reaching level 1 Spider Eye, apply poison on-hit for 2 seconds. Each level increases poison duration by 2 seconds.");
	     				FarmingTotalsMenu.this.renderTooltip(p_169459_, FarmingTotalsMenu.this.minecraft.font.split(component, Math.max(FarmingTotalsMenu.this.width / 2 - 43, 170)), int1, int2);
	     			}
				}));
		
		
		
		DescriptionPanel foodPanel = new DescriptionPanel(this.minecraft, (this.width * 1) / 5 ,
				(this.height * 9) / 10, 25, (this.width * 2) / 5);
		List<String> foodList = List.of("Food","====", 
				"Apples", "Beef", "Beetroot", "------------------",
				"Bread", "Cake","Carrots", "------------------", 
				"Chicken", "Cookies", "Fish", "------------------", 
				"Glow Berries", "Gold Apples", "Golden Carrots","------------------", 
				"Honey Bottles", "Kelp", "Melon Slices", "------------------",
				"Mushroom Stew", "Mutton", "Poisonous Potatoes","------------------", 
				"Pork", "Potatoes", "Pufferfish", "------------------", 
				"Pumpkin Pie", "Rabbit", "Raw Meats", "------------------", 
				"Rotten Flesh", "Spider Eyes");
		
		DescriptionPanel eatenPanel = new DescriptionPanel(this.minecraft, (this.width * 1) / 5 ,
				(this.height * 9) / 10, 25, (this.width * 3) / 5);
		List<String> eatenList = new ArrayList<>();
		eatenList.add("Eaten");
		eatenList.add("=====");
		eatenList.add(ClientCapabilityData.getApplesEaten() + "");
		eatenList.add(ClientCapabilityData.getBeefEaten() + "");
		eatenList.add(ClientCapabilityData.getBeetrootEaten() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getBreadEaten() + "");
		eatenList.add(ClientCapabilityData.getCakeEaten() + "");
		eatenList.add(ClientCapabilityData.getCarrotsEaten() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getChickenEaten() + "");
		eatenList.add(ClientCapabilityData.getCookiesEaten() + "");
		eatenList.add(ClientCapabilityData.getFishEaten() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getGlowBerriesEaten() + "");
		eatenList.add(ClientCapabilityData.getGoldApplesEaten() + "");
		eatenList.add(ClientCapabilityData.getGoldenCarrotsEaten() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getHoneyEaten() + "");
		eatenList.add(ClientCapabilityData.getKelpEaten() + "");
		eatenList.add(ClientCapabilityData.getMelonEaten() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getMushroomStewEaten() + "");
		eatenList.add(ClientCapabilityData.getMuttonEaten() + "");
		eatenList.add(ClientCapabilityData.getPoisonousPotatoEaten() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getPorkEaten() + "");
		eatenList.add(ClientCapabilityData.getPotatoEaten() + "");
		eatenList.add(ClientCapabilityData.getPufferfishEaten() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getPumpkinPieEaten() + "");
		eatenList.add(ClientCapabilityData.getRabbitEaten() + "");
		eatenList.add(ClientCapabilityData.getRawFoodEaten() + "");
		eatenList.add("------------------");
		eatenList.add(ClientCapabilityData.getRottenFleshEaten() + "");
		eatenList.add(ClientCapabilityData.getSpiderEyeEaten() + "");
		
		DescriptionPanel toLevelPanel = new DescriptionPanel(this.minecraft, (this.width * 1) / 5 ,
				(this.height * 9) / 10, 25, (this.width * 4) / 5);
		List<String> toLevelList = new ArrayList<>();
		toLevelList.add("To Level");
		toLevelList.add("========");
		
		for(String eaten : eatenList) {
			int i = 64;
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
		 Minecraft.getInstance().setScreen(new FarmingMenu(Component.literal("farming")));
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