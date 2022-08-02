package com.daltoncash.mmostats.gui;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.MyCapabilityImplementation;
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
public class UpgradeMenu extends Screen{
	static MyCapabilityImplementation cap = new MyCapabilityImplementation();
	private final ResourceLocation texture1 = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/test_image.png");
	private final ResourceLocation bgtexture = new ResourceLocation(MmoStatsMod.MODID, "textures/gui/bgimage-1.png");

	static int clickCounter = 0;
	
	public UpgradeMenu(Component p_96550_) {super(p_96550_);}
	
	 
	public final void hello() {
		
	}
	@Override
	public final void init() {
		
		addRenderableWidget(new Button(10,10,10,10, Component.literal("tst"), UpgradeMenu::onPress));
		addRenderableWidget(new ImageButton(0, 0, 256, 256, 0, 0, 0, texture1, 100, 100, UpgradeMenu::onPress));
		
	}
	
	

	@SuppressWarnings("resource")
	private static void onPress(Button button) {
		clickCounter++;
		clickCounter++;
		cap.setHLT(cap.getHLT() + 1);
		Minecraft.getInstance().player.sendSystemMessage(Component.literal( "" + cap.getHLT()));
		Minecraft.getInstance().player.sendSystemMessage(Component.literal("you have clicked " + clickCounter + " times!"));
		
	}
    protected void renderBackground(PoseStack poseStack, float pPartialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, bgtexture);
        this.blit(poseStack,0,0,50,50, this.width, this.height);
    }
	public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
		renderBackground(p_96562_,1.0f, p_96563_, p_96564_);
	     for(Widget widget : this.renderables) {
	        widget.render(p_96562_, p_96563_, p_96564_, p_96565_);
	     }
	}
	@Override
	public boolean isPauseScreen() {
		return true;
	}
	      /*
	@Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
    }
	*/
	
	
}