package com.daltoncash.mmostats.events;


import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.gui.ManaOverlay;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.AdditionalFortuneProcC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.SpawnTntC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.AncientDebrisMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.CoalMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.CopperMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.DiamondMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.EmeraldMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.GlowstoneMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.GoldMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.IronMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.LapisMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.NetherGoldMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.QuartzMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.RedstoneMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainChoppingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainChoppingLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingExpFromSeededCropsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainMiningLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetChoppingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetMiningExpC2SPacket;
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
			if(ClientCapabilityData.isUpgradedNoJunkBlocks()) {
				if (event.getTargetBlock().getBlock().equals(Blocks.STONE)
						|| event.getTargetBlock().getBlock().equals(Blocks.COBBLESTONE)
						|| event.getTargetBlock().getBlock().equals(Blocks.DIORITE)
						|| event.getTargetBlock().getBlock().equals(Blocks.ANDESITE)
						|| event.getTargetBlock().getBlock().equals(Blocks.GRANITE)
						|| event.getTargetBlock().getBlock().equals(Blocks.DEEPSLATE)
						|| event.getTargetBlock().getBlock().equals(Blocks.COBBLED_DEEPSLATE)) {
					event.setCanHarvest(false);
				}
			}
		}
		
		
		@SubscribeEvent
		public static void onBreaking(BreakSpeed event) {
			if(ClientCapabilityData.isUpgradedObsidianBreaker()) {
				if (event.getState().getBlock().equals(Blocks.OBSIDIAN)
						|| event.getState().getBlock().equals(Blocks.CRYING_OBSIDIAN)) {
					event.setNewSpeed((float) (event.getOriginalSpeed() * 2));
				}
			}
			if (event.getState().getBlock().equals(Blocks.DEEPSLATE)) {
				event.setNewSpeed((float) (event.getOriginalSpeed() * 2));
			}
		}
		
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onBreakBlock(BlockEvent.BreakEvent event) {
			Block block = event.getState().getBlock();
			expToSub = 0;
			expToAdd = 0;
			blockevent = event;
			if(ListOfSkillBlocks.getFarmingBlocks().contains(block)) {
				if(block.equals(Blocks.WHEAT) || block.equals(Blocks.CARROTS) ||
						block.equals(Blocks.POTATOES) || block.equals(Blocks.BEETROOTS)) {
					expToAdd = 1;
					ModMessages.sendToServer(new GainFarmingExpFromSeededCropsC2SPacket());
				}
				Minecraft.getInstance().player.sendSystemMessage(
							Component.literal("your farming Exp: " + ClientCapabilityData.getPlayerFarmingExp()));
			}
			if(ListOfSkillBlocks.getChoppingBlocks().contains(block)) {
				int choppingExp = ClientCapabilityData.getPlayerChoppingExp();
				int choppingLevel = ClientCapabilityData.getPlayerChoppingLevel();
				if(block.equals(Blocks.OAK_LOG) || block.equals(Blocks.BIRCH_LOG) ||
						block.equals(Blocks.SPRUCE_LOG) || block.equals(Blocks.JUNGLE_LOG) ||
						block.equals(Blocks.ACACIA_LOG) || block.equals(Blocks.MANGROVE_LOG) ||
						block.equals(Blocks.DARK_OAK_LOG)) {
					expToAdd = 100;
				}else if(block.equals(Blocks.OAK_LEAVES) || block.equals(Blocks.BIRCH_LEAVES) ||
						block.equals(Blocks.SPRUCE_LEAVES) || block.equals(Blocks.JUNGLE_LEAVES) ||
						block.equals(Blocks.ACACIA_LEAVES) || block.equals(Blocks.MANGROVE_LEAVES) ||
						block.equals(Blocks.DARK_OAK_LEAVES)) {
					expToAdd = 5;
				}
				ModMessages.sendToServer(new GainChoppingExpC2SPacket());
				Minecraft.getInstance().player.sendSystemMessage(
						Component.literal("your chopping Exp: " + ClientCapabilityData.getPlayerChoppingExp()));
				// level up if player has sufficient choppingExp
				if (choppingExp > (choppingLevel * 40) + 400) {
					expToSub = (choppingLevel * 40) + 400;
					ModMessages.sendToServer(new GainChoppingLevelC2SPacket());
					ModMessages.sendToServer(new ResetChoppingExpC2SPacket());
					Minecraft.getInstance().player.sendSystemMessage(
							Component.literal("your chopping Level: " + 1 + ClientCapabilityData.getPlayerChoppingLevel()));
				}
			}
			
			// Checks if the block being destroyed is part of the accepted list
			else if (ListOfSkillBlocks.getMiningBlocks().contains(block)) {
				int miningExp = ClientCapabilityData.getPlayerMiningExp();
				int miningLevel = ClientCapabilityData.getPlayerMiningLevel();
				// Check for Passive Ability Double Drops
				if (miningLevel / 500.0 >= Math.random()) {
					ModMessages.sendToServer(new AdditionalFortuneProcC2SPacket());
				}

				// Mining ore gives miningExp according to this table:
				if (block.equals(Blocks.STONE) || block.equals(Blocks.DIORITE)
						|| block.equals(Blocks.ANDESITE) || block.equals(Blocks.GRANITE)
						|| block.equals(Blocks.DEEPSLATE) || block.equals(Blocks.NETHERRACK)) {
					if(ClientCapabilityData.isUpgradedJunkBlocksDropExp()) {
						event.setExpToDrop(event.getExpToDrop() + 1);
					}
					expToAdd = 4;
				}
				
				// overworld ores
				else if (event.getState().getBlock().equals(Blocks.COAL_ORE)) {
					expToAdd = 10;
					ModMessages.sendToServer(new CoalMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.DEEPSLATE_COAL_ORE)) {
					expToAdd = 10;
					ModMessages.sendToServer(new CoalMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.COPPER_ORE)) {
					expToAdd = 50;
					ModMessages.sendToServer(new CopperMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.DEEPSLATE_COPPER_ORE)) {
					expToAdd = 50;
					ModMessages.sendToServer(new CopperMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.IRON_ORE)) {
					expToAdd = 50;
					ModMessages.sendToServer(new IronMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.DEEPSLATE_IRON_ORE)) {
					expToAdd = 50;
					ModMessages.sendToServer(new IronMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.GOLD_ORE)) {
					expToAdd = 200;
					ModMessages.sendToServer(new GoldMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.DEEPSLATE_GOLD_ORE)) {
					expToAdd = 200;
					ModMessages.sendToServer(new GoldMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.REDSTONE_ORE)) {
					expToAdd = 20;
					ModMessages.sendToServer(new RedstoneMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.DEEPSLATE_REDSTONE_ORE)) {
					expToAdd = 20;
					ModMessages.sendToServer(new RedstoneMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.LAPIS_ORE)) {
					expToAdd = 100;
					ModMessages.sendToServer(new LapisMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.DEEPSLATE_LAPIS_ORE)) {
					expToAdd = 100;
					ModMessages.sendToServer(new LapisMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.EMERALD_ORE)) {
					expToAdd = 500;
					ModMessages.sendToServer(new EmeraldMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.DEEPSLATE_EMERALD_ORE)) {
					expToAdd = 500;
					ModMessages.sendToServer(new EmeraldMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.DIAMOND_ORE)) {
					expToAdd = 400;
					ModMessages.sendToServer(new DiamondMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.DEEPSLATE_DIAMOND_ORE)) {
					expToAdd = 400;
					ModMessages.sendToServer(new DiamondMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.ANCIENT_DEBRIS)) {
					expToAdd = 2800;
					ModMessages.sendToServer(new AncientDebrisMinedC2SPacket());
				}
				// end ores/stones
				else if (event.getState().getBlock().equals(Blocks.OBSIDIAN)) {
					expToAdd = 20;
				} else if (event.getState().getBlock().equals(Blocks.CRYING_OBSIDIAN)) {
					expToAdd = 20;
				} else if (event.getState().getBlock().equals(Blocks.END_STONE)) {
					expToAdd = 4;
				} else if (event.getState().getBlock().equals(Blocks.END_STONE_BRICKS)) {
					expToAdd = 5;
				}
				// nether ores/stones
				else if (event.getState().getBlock().equals(Blocks.NETHER_GOLD_ORE)) {
					expToAdd = 100;
					ModMessages.sendToServer(new NetherGoldMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.NETHER_QUARTZ_ORE)) {
					expToAdd = 25;
					ModMessages.sendToServer(new QuartzMinedC2SPacket());
				} else if (event.getState().getBlock().equals(Blocks.NETHERRACK)) {
					expToAdd = 1;
				} else if (event.getState().getBlock().equals(Blocks.NETHER_BRICKS)) {
					expToAdd = 4;
				} else if (event.getState().getBlock().equals(Blocks.GLOWSTONE)) {
					expToAdd = 10;
					ModMessages.sendToServer(new GlowstoneMinedC2SPacket());
				}

				ModMessages.sendToServer(new GainMiningExpC2SPacket());
				Minecraft.getInstance().player.sendSystemMessage(
						Component.literal("your mining Exp: " + ClientCapabilityData.getPlayerMiningExp()));

				// level up if player has sufficient miningExp
				if (miningExp > (miningLevel * 40) + 400) {
					expToSub = (miningLevel * 40) + 400;
					ModMessages.sendToServer(new GainMiningLevelC2SPacket());
					ModMessages.sendToServer(new ResetMiningExpC2SPacket());
					Minecraft.getInstance().player.sendSystemMessage(
							Component.literal("your mining Level: " + 1 + ClientCapabilityData.getPlayerMiningLevel()));
				}
				event.setExpToDrop((int)(event.getExpToDrop() * 
						((Math.log10(ClientCapabilityData.getLapisMined()) + 2) / 2)));
			}
		}

		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			if (KeyBinding.NIGHT_VISION_KEY.consumeClick()) {
				if (ClientCapabilityData.isUpgradedNightVision() && ClientCapabilityData.getPlayerMana() >= 10) {
					Minecraft.getInstance().player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200));
					ModMessages.sendToServer(new GainNightVisionC2SPacket());
				}
			}
			if (KeyBinding.OPEN_UPGRADE_GUI_KEY.consumeClick()) {
				Minecraft.getInstance().setScreen(new UpgradeMenu(Component.literal("Test from events!")));
			}
			if(KeyBinding.X_PLOSIVE_MINER_KEY.consumeClick()) {
				ModMessages.sendToServer(new SpawnTntC2SPacket());
			}
			
		}

		@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class ClientModBusEvents {

			@SubscribeEvent
			public static void onKeyRegister(RegisterKeyMappingsEvent event) {
				event.register(KeyBinding.NIGHT_VISION_KEY);
				event.register(KeyBinding.OPEN_UPGRADE_GUI_KEY);
				event.register(KeyBinding.X_PLOSIVE_MINER_KEY);
			}

			@SubscribeEvent
			public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
				event.registerAboveAll("mana", ManaOverlay.HUD_MANA);
			}
		}
	}
}
