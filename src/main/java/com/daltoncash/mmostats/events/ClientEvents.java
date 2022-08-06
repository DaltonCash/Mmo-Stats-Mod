package com.daltoncash.mmostats.events;


import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.ManaOverlay;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.AdditionalFortuneProcC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainMiningLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.ResetMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainNightVisionC2SPacket;
import com.daltoncash.mmostats.util.KeyBinding;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class ClientForgeEvents {
		public static BlockEvent.BreakEvent blockevent = null;
		public static int expToSub = 0;
		public static int expToAdd = 0;
		
		@SubscribeEvent
		public static void onHarvest(HarvestCheck event) {
			if(event.getTargetBlock().getBlock().equals(Blocks.STONE) || 
					event.getTargetBlock().getBlock().equals(Blocks.DIORITE) || 
					event.getTargetBlock().getBlock().equals(Blocks.ANDESITE) ||
					event.getTargetBlock().getBlock().equals(Blocks.GRANITE) ||
					event.getTargetBlock().getBlock().equals(Blocks.DEEPSLATE)) {
				event.setCanHarvest(false);
			}
		}
		
		
		
		
		@SubscribeEvent
		public static void onBreaking(BreakSpeed event) {
			if(event.getState().getBlock().equals(Blocks.OBSIDIAN) || 
					event.getState().getBlock().equals(Blocks.CRYING_OBSIDIAN)) {
				event.setNewSpeed((float) (event.getOriginalSpeed() * 2));
			}else if(event.getState().getBlock().equals(Blocks.DEEPSLATE)){
				event.setNewSpeed((float) (event.getOriginalSpeed() * 2));
			}
			
		}
		
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onBreakBlock(BlockEvent.BreakEvent event) {
			int miningExp = ClientCapabilityData.getPlayerMiningExp();
			int miningLevel = ClientCapabilityData.getPlayerMiningLevel();
			Block block = event.getState().getBlock();
			expToSub = 0; expToAdd = 0; blockevent = event;
			
			//Checks if the block being destroyed is part of the accepted list
			if(ListOfMiningBlocks.getBlocks().contains(block)) {
				
				//Check for Passive Ability Double Drops
				if(miningLevel/500.0 >= Math.random()) {
					ModMessages.sendToServer(new AdditionalFortuneProcC2SPacket());
				}
				
				//Mining ore gives miningExp according to this table:
				if(event.getState().getBlock().equals(Blocks.STONE) || 
						event.getState().getBlock().equals(Blocks.DIORITE) || 
						event.getState().getBlock().equals(Blocks.ANDESITE) ||
						event.getState().getBlock().equals(Blocks.GRANITE) ||
						event.getState().getBlock().equals(Blocks.DEEPSLATE)) {
					expToAdd = 4;
					event.setExpToDrop(event.getExpToDrop() + 1);
					event.getState().getBlock().destroy(event.getLevel(), event.getPos(), event.getState());
				}
				
				//overworld ores
				else if(event.getState().getBlock().equals(Blocks.COAL_ORE)) {expToAdd = 10;}
				else if(event.getState().getBlock().equals(Blocks.DEEPSLATE_COAL_ORE)) {expToAdd = 10;}
				else if(event.getState().getBlock().equals(Blocks.COPPER_ORE)) {expToAdd = 50;}
				else if(event.getState().getBlock().equals(Blocks.DEEPSLATE_COPPER_ORE)) {expToAdd = 50;}
				else if(event.getState().getBlock().equals(Blocks.IRON_ORE)) {expToAdd = 50;}
				else if(event.getState().getBlock().equals(Blocks.DEEPSLATE_IRON_ORE)) {expToAdd = 50;}
				else if(event.getState().getBlock().equals(Blocks.GOLD_ORE)) {expToAdd = 200;}
				else if(event.getState().getBlock().equals(Blocks.DEEPSLATE_GOLD_ORE)) {expToAdd = 200;}
				else if(event.getState().getBlock().equals(Blocks.REDSTONE_ORE)) {expToAdd = 20;}
				else if(event.getState().getBlock().equals(Blocks.DEEPSLATE_REDSTONE_ORE)) {expToAdd = 20;}
				else if(event.getState().getBlock().equals(Blocks.LAPIS_ORE)) {expToAdd = 100;}
				else if(event.getState().getBlock().equals(Blocks.DEEPSLATE_LAPIS_ORE)) {expToAdd = 100;}
				else if(event.getState().getBlock().equals(Blocks.EMERALD_ORE)) {expToAdd = 500;}
				else if(event.getState().getBlock().equals(Blocks.DEEPSLATE_EMERALD_ORE)) {expToAdd = 500;}
				else if(event.getState().getBlock().equals(Blocks.DIAMOND_ORE)) {expToAdd = 400;}
				else if(event.getState().getBlock().equals(Blocks.DEEPSLATE_DIAMOND_ORE)) {expToAdd = 400;}
				else if(event.getState().getBlock().equals(Blocks.ANCIENT_DEBRIS)) {expToAdd = 2800;}
				//end ores/stones
				else if(event.getState().getBlock().equals(Blocks.OBSIDIAN)) {expToAdd = 20;}
				else if(event.getState().getBlock().equals(Blocks.CRYING_OBSIDIAN)) {expToAdd = 20;}
				else if(event.getState().getBlock().equals(Blocks.END_STONE)) {expToAdd = 4;}
				else if(event.getState().getBlock().equals(Blocks.END_STONE_BRICKS)) {expToAdd = 5;}
				//nether ores/stones
				else if(event.getState().getBlock().equals(Blocks.NETHER_GOLD_ORE)) {expToAdd = 100;}
				else if(event.getState().getBlock().equals(Blocks.NETHER_QUARTZ_ORE)) {expToAdd = 25;}
				else if(event.getState().getBlock().equals(Blocks.NETHERRACK)) {expToAdd = 1;}
				else if(event.getState().getBlock().equals(Blocks.NETHER_BRICKS)) {expToAdd = 4;}
				
				ModMessages.sendToServer(new GainMiningExpC2SPacket());
				Minecraft.getInstance().player.sendSystemMessage(Component.literal("your mining Exp: " + ClientCapabilityData.getPlayerMiningExp()));
				
				//level up if player has sufficient miningExp
				if(miningExp > (miningLevel*40) + 400) {
					expToSub = (miningLevel*40) + 400;
					ModMessages.sendToServer(new GainMiningLevelC2SPacket());
					ModMessages.sendToServer(new ResetMiningExpC2SPacket());
					Minecraft.getInstance().player.sendSystemMessage(Component.literal("your mining Level: " + 1 + ClientCapabilityData.getPlayerMiningLevel()));
				}
			}
		}
		
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			if(KeyBinding.NIGHT_VISION_KEY.consumeClick()) {
				if(ClientCapabilityData.getPlayerMana() >= 10) {
					Minecraft.getInstance().player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200));
					ModMessages.sendToServer(new GainNightVisionC2SPacket());
				}else {
					Minecraft.getInstance().player.sendSystemMessage(Component.literal("your mana: " + ClientCapabilityData.getPlayerMana()));
				}
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
				event.register(KeyBinding.NIGHT_VISION_KEY);
				event.register(KeyBinding.OPEN_UPGRADE_GUI_KEY);
			}
			
			@SubscribeEvent
	        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
	            event.registerAboveAll("mana", ManaOverlay.HUD_MANA);
	        }
		}
	}
}
