package com.daltoncash.mmostats.events;


import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.ManaOverlay;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.GainMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.UseManaC2SPacket;
import com.daltoncash.mmostats.util.KeyBinding;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class ClientForgeEvents {
		
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onBreakBlock(BlockEvent.BreakEvent event) {
			ModMessages.sendToServer(new GainMiningExpC2SPacket());
			Minecraft.getInstance().player.sendSystemMessage(Component.literal("your mining xp: " + ClientCapabilityData.getPlayerMiningExp()));
		}
		
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			if(KeyBinding.GO_FAST_KEY.consumeClick()) {
				Minecraft.getInstance().player.sendSystemMessage(Component.literal("your mana: " + ClientCapabilityData.getPlayerMana()));
				ModMessages.sendToServer(new UseManaC2SPacket());
				
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
