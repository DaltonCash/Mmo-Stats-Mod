package com.daltoncash.mmostats.events;


import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.gui.ManaOverlay;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.util.KeyBinding;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class ClientForgeEvents {
		
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			if(KeyBinding.GO_FAST_KEY.consumeClick()) {
				Minecraft.getInstance().player.sendSystemMessage(Component.literal("go fast! " + Minecraft.getInstance().player.getSpeed()));
				Minecraft.getInstance().player.setSpeed(1);
			}else {
				
			}
			if(KeyBinding.OPEN_UPGRADE_GUI_KEY.consumeClick()){
				Minecraft.getInstance().setScreen(new UpgradeMenu(Component.literal("Test from events!")));
			}else {
				
			}
		}
		@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class ClientModBusEvents{
			
			@SubscribeEvent
			public static void onKeyRegister(RegisterKeyMappingsEvent event) {
				event.register(KeyBinding.GO_FAST_KEY);
				event.register(KeyBinding.OPEN_UPGRADE_GUI_KEY);
			}
			
			@SubscribeEvent
	        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
	            event.registerAboveAll("mana", ManaOverlay.HUD_MANA);
	        }
		}
	}
}
