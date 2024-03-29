package com.daltoncash.mmostats.events;

import java.util.List;

import org.slf4j.Logger;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.common.handler.Sounds;
import com.daltoncash.mmostats.entities.ModEntityTypes;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.HunterDropsMeatC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.AcaciaChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.BirchChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.CrimsonStemChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.DarkOakChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.JungleChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.MangroveChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.OakChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.SpruceChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.WarpedStemChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combat.DiamondDefenderSlainC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combat.DivineTraderSlainC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combat.KingCoalSlainC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combat.ObsidianObserverSlainC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combat.RedstoneRunnerSlainC2SPacket;
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
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.ObsidianMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.QuartzMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.RedstoneMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainArcheryExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainArcheryLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainChoppingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainChoppingExpFromMultiblockC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainChoppingLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainCombatExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainCombatLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingExpFromSeededCropsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingExpFromUnseededCropsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainMiningExpFromMultiblockC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainMiningLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerAttributePointsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerLevelExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerUpgradePointsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetArcheryExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetChoppingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetCombatExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetFarmingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetPlayerLevelExpC2SPacket;
import com.mojang.logging.LogUtils;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class SkillEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class SkillForgeEvents {
		public static final Logger LOGGER = LogUtils.getLogger();
		public static EntityType<?> clientEntityType;
		public static BlockEvent.BreakEvent blockevent = null;
		private static Player player;
		
		public static int levelUpOverlayDuration = 0;
		public static int skillOverlayDuration = 0;
		public static String skillToDisplay = "";

		public static int expToSub = 0;
		public static int expToAdd = 0;
		public static int expToAddMultiblock = 0;
		public static int playerLevelExpToSub = 0;
		public static int playerLevelExpToAdd = 0;
		public static int bowCooldown = 30;
		
		private static int counter;

		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if(counter < 1600) {
				counter++;
			}else {
				counter = 0;
			}
			if(counter == 0) {
				event.player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(ModStats.getHealth());
				event.player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(ModStats.getMoveSpeed());
				if(event.player.getHealth() > event.player.getMaxHealth()) {
					event.player.setHealth(event.player.getMaxHealth());
				}
			}
			
			if (levelUpOverlayDuration > 0) levelUpOverlayDuration--;
			
			if (skillOverlayDuration > 0) skillOverlayDuration--;
			
			if (bowCooldown < 30) bowCooldown++;
			player = event.player;
		}

		// Checks if the player has enough playerExp to level up
		private static void PlayerLevelCheck(int playerLevelExpBeingAdded) {
			int playerLevel = ClientCapabilityData.getPlayerLevel();
			int playerLevelExp = ClientCapabilityData.getPlayerExp() + playerLevelExpBeingAdded;
			if (playerLevelExp > 25) {
				playerLevelExpToSub = 25;
				LOGGER.info("Gained Attribute Point! Current: " + (ClientCapabilityData.getPlayerAttributePoints() + 1));
				ModMessages.sendToServer(new GainPlayerAttributePointsC2SPacket());
				player.playSound(Sounds.levelUp.get(), 1.0f, 1.0f);
				LOGGER.info("Level up! Current Level: " + (playerLevel + 1));
				ModMessages.sendToServer(new GainPlayerLevelC2SPacket());
				ModMessages.sendToServer(new GainPlayerUpgradePointsC2SPacket());
				ModMessages.sendToServer(new ResetPlayerLevelExpC2SPacket());
				levelUpOverLay();
			}
		}

		// Provides the duration of the LEVEL_UP_OVERLAY for the LevelUpOverlay Class
		private static void levelUpOverLay() {
			levelUpOverlayDuration = 450;
		}

		// Provides the duration of the SKILL_OVERLAY for the LevelUpOverlay Class
		private static void skillOverlay(String skill) {
			skillOverlayDuration = 1000;
			skillToDisplay = skill;
		}

		@SubscribeEvent
		public static void onProjectileHit(LivingAttackEvent event) {

			if (event.getSource().getEntity() != null) {
				if (event.getSource().getEntity().getType().equals(EntityType.PLAYER)) {
					if(event.getSource().getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
						if (event.getSource().getDirectEntity().getType().equals(EntityType.ARROW)) {
							if (bowCooldown >= 30) {
								int archeryExp = ClientCapabilityData.getPlayerArcheryExp();
								int archeryLevel = ClientCapabilityData.getPlayerArcheryLevel();
								ModMessages.sendToServer(new GainArcheryExpC2SPacket());
								bowCooldown = 0;
	
								// level up if player has sufficient archeryExp
								if (archeryExp + (50 * ModStats.getArcheryModifier()) > ModStats.toNextLevelExp(archeryLevel)) {
									LOGGER.info("{} leveled up to {} in Archery",
											event.getSource().getEntity().getScoreboardName(), archeryLevel + 1);
									expToSub = (archeryLevel * 40) + 400;
									ModMessages.sendToServer(new GainArcheryLevelC2SPacket());
									ModMessages.sendToServer(new ResetArcheryExpC2SPacket());
	
									playerLevelExpToAdd = (archeryLevel % 25 == 24) ? (((archeryLevel + 1) / 100) + 1) * 5
											: ((archeryLevel + 1) / 100) + 1;
									ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
									PlayerLevelCheck(playerLevelExpToAdd);
								}
	
								// Makes skill overlay appear on screen.
								skillOverlay("Archery");
								
								
							} else {
								LOGGER.debug("Player {} is firing too fast!(archeryExp on cooldown)",
										event.getSource().getEntity().getScoreboardName());
							}
						}
					}
				}
			}
		}

		
		
		// Gaining Exp for Farming
		@SubscribeEvent
		public static void gainChoppingExpOnBreakingBlock(BlockEvent.BreakEvent event) {
			Block block = event.getState().getBlock();
			if(event.getPlayer().getName().getString().equals(MmoStatsMod.USER.getName())) {
				if (ExpYieldList.getChoppingBlocks().contains(block)) {
					blockevent = event;
					giveChoppingExp(block);
				}
			}
		}
		
		public static void giveChoppingExp(Block block) {
			int choppingExp = ClientCapabilityData.getPlayerChoppingExp();
			int choppingLevel = ClientCapabilityData.getPlayerChoppingLevel();
			expToSub = 0;
			expToAdd = 0;
			
			if (block.equals(Blocks.OAK_LOG) || block.equals(Blocks.BIRCH_LOG) || block.equals(Blocks.SPRUCE_LOG)
					|| block.equals(Blocks.JUNGLE_LOG) || block.equals(Blocks.ACACIA_LOG)
					|| block.equals(Blocks.MANGROVE_LOG) || block.equals(Blocks.DARK_OAK_LOG)
					|| block.equals(Blocks.CRIMSON_STEM) || block.equals(Blocks.WARPED_STEM)) {
				expToAdd = 50;
				addToChoppingTotal(block);
			} else if (block.equals(Blocks.OAK_LEAVES) || block.equals(Blocks.BIRCH_LEAVES)
					|| block.equals(Blocks.SPRUCE_LEAVES) || block.equals(Blocks.JUNGLE_LEAVES)
					|| block.equals(Blocks.ACACIA_LEAVES) || block.equals(Blocks.MANGROVE_LEAVES)
					|| block.equals(Blocks.DARK_OAK_LEAVES) || block.equals(Blocks.NETHER_WART_BLOCK)
					|| block.equals(Blocks.WARPED_WART_BLOCK)) {
				expToAdd = 5;
			}
			ModMessages.sendToServer(new GainChoppingExpC2SPacket());
			// level up if player has sufficient choppingExp
			if (choppingExp + (expToAdd * ModStats.getChoppingModifier()) > ModStats.toNextLevelExp(choppingLevel)) {
				LOGGER.info("{} leveled up to {} in Chopping", MmoStatsMod.USER.getName(),
						choppingLevel + 1);
				expToSub = (choppingLevel * 40) + 400;
				ModMessages.sendToServer(new GainChoppingLevelC2SPacket());
				ModMessages.sendToServer(new ResetChoppingExpC2SPacket());

				playerLevelExpToAdd = (choppingLevel % 25 == 24) ? (((choppingLevel + 1) / 100) + 1) * 5
						: ((choppingLevel + 1) / 100) + 1;
				ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
				PlayerLevelCheck(playerLevelExpToAdd);
			}

			// Makes skill overlay appear on screen.
			skillOverlay("Chopping");

			LOGGER.info("{} has chopped {}(Player ChoppingExp: {})", MmoStatsMod.USER.getName(),
					block.asItem(), choppingExp + expToAdd);
		}
		
		public static void giveChoppingExpMultiblock(List<Block> blocks) {
			
			expToAddMultiblock = 0;
			for(Block block : blocks) {
				expToAddMultiblock += 50;
				addToChoppingTotal(block);
			}
			ModMessages.sendToServer(new GainChoppingExpFromMultiblockC2SPacket());
			skillOverlay("Chopping");
		}
		
		private static void addToChoppingTotal(Block block) {
			if(block.equals(Blocks.OAK_LOG)) {
				ModMessages.sendToServer(new OakChoppedC2SPacket());
			}else if(block.equals(Blocks.BIRCH_LOG)) {
				ModMessages.sendToServer(new BirchChoppedC2SPacket());
			}else if(block.equals(Blocks.SPRUCE_LOG)) {
				ModMessages.sendToServer(new SpruceChoppedC2SPacket());
			}else if(block.equals(Blocks.JUNGLE_LOG)) {
				ModMessages.sendToServer(new JungleChoppedC2SPacket());
			}else if(block.equals(Blocks.ACACIA_LOG)) {
				ModMessages.sendToServer(new AcaciaChoppedC2SPacket());
			}else if(block.equals(Blocks.MANGROVE_LOG)) {
				ModMessages.sendToServer(new MangroveChoppedC2SPacket());
			}else if(block.equals(Blocks.DARK_OAK_LOG)) {
				ModMessages.sendToServer(new DarkOakChoppedC2SPacket());
			}else if(block.equals(Blocks.CRIMSON_STEM)) {
				ModMessages.sendToServer(new CrimsonStemChoppedC2SPacket());
			}else if(block.equals(Blocks.WARPED_STEM)) {
				ModMessages.sendToServer(new WarpedStemChoppedC2SPacket());
			}else {
				LOGGER.info("Unexpected call to addToChoppingTotal method: {}." + block.getName());
			}	
		}

		// LivingDeathEvent is an event that triggers when an entity dies.
		// This method gives the player exp for combat when they kill an entity.
		@SubscribeEvent
		public static void onkill(LivingDeathEvent event) {
			
			if (event.getSource().getEntity() != null) {
				if (event.getSource().getEntity().getType().equals(EntityType.PLAYER)) {
					if(event.getSource().getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
						EntityType<?> type = event.getEntity().getType();
						if (ExpYieldList.getCombatEntities().contains(type)) {
							int combatExp = ClientCapabilityData.getPlayerCombatExp();
							int combatLevel = ClientCapabilityData.getPlayerCombatLevel();
							// for passive mobs:
							expToAdd = 5;
							// for neutral mobs:
							if (type.equals(EntityType.BEE) || type.equals(EntityType.DOLPHIN)
									|| type.equals(EntityType.GOAT) || type.equals(EntityType.LLAMA)
									|| type.equals(EntityType.PANDA) || type.equals(EntityType.POLAR_BEAR)
									|| type.equals(EntityType.TRADER_LLAMA) || type.equals(EntityType.WOLF)
									|| type.equals(ModEntityTypes.CRAB.get())) {
								expToAdd = 10;
							}
							// for hostile mobs:
							else if (type.equals(EntityType.ENDERMITE) || type.equals(EntityType.SILVERFISH)
									|| type.equals(EntityType.SLIME) || type.equals(EntityType.MAGMA_CUBE)) {
								expToAdd = 15;
							} else if (type.equals(EntityType.ZOMBIE) || type.equals(EntityType.HUSK)
									|| type.equals(EntityType.DROWNED) || type.equals(EntityType.PIGLIN)
									|| type.equals(EntityType.ZOMBIFIED_PIGLIN) || type.equals(EntityType.VEX)
									|| type.equals(EntityType.ZOMBIE_VILLAGER)) {
								expToAdd = 20;
							} else if (type.equals(EntityType.SKELETON) || type.equals(EntityType.STRAY)
									|| type.equals(EntityType.SPIDER) || type.equals(EntityType.VINDICATOR)
									|| type.equals(EntityType.PILLAGER) || type.equals(EntityType.SHULKER)
									|| type.equals(EntityType.WITCH)) {
								expToAdd = 30;
							} else if (type.equals(EntityType.CREEPER) || type.equals(EntityType.CAVE_SPIDER)
									|| type.equals(EntityType.WITHER_SKELETON)) {
								expToAdd = 35;
							} else if (type.equals(EntityType.ENDERMAN) || type.equals(EntityType.BLAZE)
									|| type.equals(EntityType.PIGLIN_BRUTE)) {
								expToAdd = 50;
							} else if (type.equals(EntityType.EVOKER) || type.equals(EntityType.GHAST)
									|| type.equals(EntityType.GUARDIAN) || type.equals(EntityType.HOGLIN)
									|| type.equals(EntityType.ZOGLIN)) {
								expToAdd = 100;
							} else if (type.equals(EntityType.IRON_GOLEM) || type.equals(EntityType.PHANTOM)) {
								expToAdd = 200;
							} else if (type.equals(EntityType.RAVAGER)) {
								expToAdd = 300;
							} else if (type.equals(EntityType.ELDER_GUARDIAN) || type.equals(ModEntityTypes.DIVINETRADER.get())
									|| type.equals(ModEntityTypes.KINGCOAL.get()) || type.equals(ModEntityTypes.REDSTONERUNNER.get())
									|| type.equals(ModEntityTypes.OBSIDIANOBSERVER.get())) {
								
								expToAdd = 750;
								if(type.equals(ModEntityTypes.DIVINETRADER.get())) {
									ModMessages.sendToServer(new DivineTraderSlainC2SPacket());
								
								}else if(type.equals(ModEntityTypes.KINGCOAL.get())) {
									ModMessages.sendToServer(new KingCoalSlainC2SPacket());
								}else if(type.equals(ModEntityTypes.REDSTONERUNNER.get())) {
									ModMessages.sendToServer(new RedstoneRunnerSlainC2SPacket());
								}else if(type.equals(ModEntityTypes.OBSIDIANOBSERVER.get())) {
									ModMessages.sendToServer(new ObsidianObserverSlainC2SPacket());
								}
							} else if (type.equals(EntityType.WARDEN) || type.equals(EntityType.WITHER)
									|| type.equals(ModEntityTypes.DIAMONDDEFENDER.get())) {
								expToAdd = 1500;
								if(type.equals(ModEntityTypes.DIAMONDDEFENDER.get())) {
									ModMessages.sendToServer(new DiamondDefenderSlainC2SPacket());
								}
							} else if (type.equals(EntityType.ENDER_DRAGON)) {
								expToAdd = 5000;
							}
							ModMessages.sendToServer(new GainCombatExpC2SPacket());
	
							// level up if player has sufficient combatExp
							if (combatExp + (expToAdd * ModStats.getCombatModifier()) > ModStats.toNextLevelExp(combatLevel)) {
								LOGGER.info("{} leveled up to {} in Combat",
										event.getSource().getEntity().getScoreboardName(), combatLevel + 1);
								expToSub = (combatLevel * 40) + 400;
								ModMessages.sendToServer(new GainCombatLevelC2SPacket());
								ModMessages.sendToServer(new ResetCombatExpC2SPacket());
	
								playerLevelExpToAdd = (combatLevel % 25 == 24) ? (((combatLevel + 1) / 100) + 1) * 5
										: ((combatLevel + 1) / 100) + 1;
								ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
								PlayerLevelCheck(playerLevelExpToAdd);
							}
	
							// Makes skill overlay appear on screen.
							skillOverlay("Combat");
	
							LOGGER.info("{} has killed {}(Player CombatExp: {})",
									event.getSource().getEntity().getScoreboardName(), type.toShortString(),
									combatExp + expToAdd);
							// Archery: Hunter
							clientEntityType = event.getEntity().getType();
							ModMessages.sendToServer(new HunterDropsMeatC2SPacket());
						}
					}
				}
			}
		}

		// Gaining Exp for Farming
		@SubscribeEvent
		public static void gainFarmingExpOnBreakingBlock(BlockEvent.BreakEvent event) {
			Block block = event.getState().getBlock();
			
			if (ExpYieldList.getFarmingBlocks().contains(block)) {
				if(event.getPlayer().getName().getString().equals(MmoStatsMod.USER.getName())) {
					int farmingExp = ClientCapabilityData.getPlayerFarmingExp();
					int farmingLevel = ClientCapabilityData.getPlayerFarmingLevel();
					expToSub = 0;
					expToAdd = 0;
					blockevent = event;
					if (block.equals(Blocks.GRASS) || block.equals(Blocks.TALL_GRASS)) {
						expToAdd = 3;
						ModMessages.sendToServer(new GainFarmingExpFromUnseededCropsC2SPacket());
						
					} else if (block.equals(Blocks.WHEAT) || block.equals(Blocks.CARROTS) || block.equals(Blocks.POTATOES)
							|| block.equals(Blocks.BEETROOTS) || block.equals(Blocks.COCOA)) {
						expToAdd = 20;
						ModMessages.sendToServer(new GainFarmingExpFromSeededCropsC2SPacket());
						
					} else if (block.equals(Blocks.PUMPKIN) || block.equals(Blocks.MELON)
							|| block.equals(Blocks.SHROOMLIGHT)) {
						expToAdd = 20;
						ModMessages.sendToServer(new GainFarmingExpFromUnseededCropsC2SPacket());
						
					} else if (block.equals(Blocks.CACTUS) || block.equals(Blocks.SUGAR_CANE) || block.equals(Blocks.BAMBOO)
							|| block.equals(Blocks.KELP) || block.equals(Blocks.BROWN_MUSHROOM_BLOCK)
							|| block.equals(Blocks.RED_MUSHROOM_BLOCK) || block.equals(Blocks.MUSHROOM_STEM)) {
						expToAdd = 10;
						ModMessages.sendToServer(new GainFarmingExpFromUnseededCropsC2SPacket());
						
					} else if (block.equals(Blocks.BROWN_MUSHROOM) || block.equals(Blocks.RED_MUSHROOM)
							|| block.equals(Blocks.CRIMSON_FUNGUS) || block.equals(Blocks.WARPED_FUNGUS)) {
						expToAdd = 30;
						ModMessages.sendToServer(new GainFarmingExpFromUnseededCropsC2SPacket());
						
					}
					LOGGER.info("{} has farmed {}(Player FarmingExp: {})", event.getPlayer().getScoreboardName(),
							event.getState().getBlock().asItem(), farmingExp + expToAdd);
	
					// Checks if the player has enough farmingExp to LevelUp
					if (farmingExp + (expToAdd * ModStats.getFarmingModifier()) > ModStats.toNextLevelExp(farmingLevel)) {
						LOGGER.info("{} leveled up to {} in Farming", event.getPlayer().getScoreboardName(),
								farmingLevel + 1);
						expToSub = (farmingLevel * 40) + 400;
						ModMessages.sendToServer(new GainFarmingLevelC2SPacket());
						ModMessages.sendToServer(new ResetFarmingExpC2SPacket());
	
						playerLevelExpToAdd = (farmingLevel % 25 == 24) ? (((farmingLevel + 1) / 100) + 1) * 5
								: ((farmingLevel + 1) / 100) + 1;
						ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
						PlayerLevelCheck(playerLevelExpToAdd);
					}
					// Makes skill overlay appear on screen.
					skillOverlay("Farming");
				}
			}
		}

		@SubscribeEvent
		public static void gainMiningExpOnBreakingBlock(BlockEvent.BreakEvent event) {
			Block block = event.getState().getBlock();
			if (ExpYieldList.getMiningBlocks().contains(block)) {
				if(event.getPlayer().getName().getString().equals(MmoStatsMod.USER.getName())) {
					blockevent = event;
					if (ExpYieldList.getStones().contains(block)) {
						if (ClientCapabilityData.isUpgradedJunkBlocksDropExp() > 0) {
							event.setExpToDrop(1);
						}
					}
					giveMiningExp(block);
				}
			}
		}
		
		public static void giveMiningExp(Block block) {
			
			expToSub = 0;
			expToAdd = 0;
			
			// Mining ore gives miningExp according to this table:
			if (ExpYieldList.getStones().contains(block)) {
				expToAdd = 4;
			}

			// overworld ores
			else if (block.equals(Blocks.COAL_ORE) || block.equals(Blocks.DEEPSLATE_COAL_ORE)) {
				expToAdd = 10;
				ModMessages.sendToServer(new CoalMinedC2SPacket());
			} else if (block.equals(Blocks.COPPER_ORE) || block.equals(Blocks.DEEPSLATE_COPPER_ORE)) {
				expToAdd = 50;
				ModMessages.sendToServer(new CopperMinedC2SPacket());
			} else if (block.equals(Blocks.IRON_ORE) || block.equals(Blocks.DEEPSLATE_IRON_ORE)) {
				expToAdd = 50;
				ModMessages.sendToServer(new IronMinedC2SPacket());
			} else if (block.equals(Blocks.GOLD_ORE) || block.equals(Blocks.DEEPSLATE_GOLD_ORE)) {
				expToAdd = 200;
				ModMessages.sendToServer(new GoldMinedC2SPacket());
			} else if (block.equals(Blocks.REDSTONE_ORE) || block.equals(Blocks.DEEPSLATE_REDSTONE_ORE)) {
				expToAdd = 20;
				ModMessages.sendToServer(new RedstoneMinedC2SPacket());
			} else if (block.equals(Blocks.LAPIS_ORE) || block.equals(Blocks.DEEPSLATE_LAPIS_ORE)) {
				expToAdd = 100;
				ModMessages.sendToServer(new LapisMinedC2SPacket());
			} else if (block.equals(Blocks.EMERALD_ORE) || block.equals(Blocks.DEEPSLATE_EMERALD_ORE)) {
				expToAdd = 500;
				ModMessages.sendToServer(new EmeraldMinedC2SPacket());
			} else if (block.equals(Blocks.DIAMOND_ORE) || block.equals(Blocks.DEEPSLATE_DIAMOND_ORE)) {
				expToAdd = 400;
				ModMessages.sendToServer(new DiamondMinedC2SPacket());
			} else if (block.equals(Blocks.ANCIENT_DEBRIS)) {
				expToAdd = 2800;
				ModMessages.sendToServer(new AncientDebrisMinedC2SPacket());
			}else if (block.equals(Blocks.AMETHYST_CLUSTER) || block.equals(Blocks.AMETHYST_BLOCK)
					|| block.equals(Blocks.BUDDING_AMETHYST)) {
				expToAdd = 10;
			}

			// end ores/stones
			else if (block.equals(Blocks.OBSIDIAN) || block.equals(Blocks.CRYING_OBSIDIAN)) {
				expToAdd = 20;
				ModMessages.sendToServer(new ObsidianMinedC2SPacket());
			} else if (block.equals(Blocks.END_STONE)) {
				expToAdd = 4;
			} else if (block.equals(Blocks.END_STONE_BRICKS)) {
				expToAdd = 5;
			}

			// nether ores/stones
			else if (block.equals(Blocks.NETHER_GOLD_ORE)) {
				expToAdd = 100;
				ModMessages.sendToServer(new NetherGoldMinedC2SPacket());
			} else if (block.equals(Blocks.NETHER_QUARTZ_ORE)) {
				expToAdd = 25;
				ModMessages.sendToServer(new QuartzMinedC2SPacket());
			} else if (block.equals(Blocks.NETHERRACK)) {
				expToAdd = 1;
			} else if (block.equals(Blocks.NETHER_BRICKS)) {
				expToAdd = 4;
			} else if (block.equals(Blocks.GLOWSTONE)) {
				expToAdd = 10;
				ModMessages.sendToServer(new GlowstoneMinedC2SPacket());
			}
			ModMessages.sendToServer(new GainMiningExpC2SPacket());
			int miningExp = ClientCapabilityData.getPlayerMiningExp();
			int miningLevel = ClientCapabilityData.getPlayerMiningLevel();
			
			LOGGER.info("{} has mined {}(Player miningExp: {})", MmoStatsMod.USER.getName(),
					block.asItem(), (miningExp + expToAdd));

			// level up if player has sufficient miningExp
			if (miningExp + (expToAdd * ModStats.getMiningModifier()) > ModStats.toNextLevelExp(miningLevel)) {
				LOGGER.info("{} leveled up to {} in Mining", MmoStatsMod.USER.getName(),
						miningLevel + 1);
				expToSub = (miningLevel * 40) + 400;
				ModMessages.sendToServer(new GainMiningLevelC2SPacket());
				ModMessages.sendToServer(new ResetMiningExpC2SPacket());

				playerLevelExpToAdd = (miningLevel % 25 == 24) ? (((miningLevel + 1) / 100) + 1) * 5
						: ((miningLevel + 1) / 100) + 1;
				ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
				PlayerLevelCheck(playerLevelExpToAdd);
			}
			// Makes skill overlay appear on screen.
			skillOverlay("Mining");
		}
		
		public static void giveMiningExpMultiBlock(List<Block> blocks) {
			expToAddMultiblock = 0;
			for(Block block : blocks) {
				// Mining ore gives miningExp according to this table:
				if (ExpYieldList.getStones().contains(block)) {
					expToAddMultiblock += 4;
				}
				
				// overworld ores
				else if (block.equals(Blocks.COAL_ORE) || block.equals(Blocks.DEEPSLATE_COAL_ORE)) {
					expToAddMultiblock += 10;
					ModMessages.sendToServer(new CoalMinedC2SPacket());
				} else if (block.equals(Blocks.COPPER_ORE) || block.equals(Blocks.DEEPSLATE_COPPER_ORE)) {
					expToAddMultiblock += 50;
					ModMessages.sendToServer(new CopperMinedC2SPacket());
				} else if (block.equals(Blocks.IRON_ORE) || block.equals(Blocks.DEEPSLATE_IRON_ORE)) {
					expToAddMultiblock += 50;
					ModMessages.sendToServer(new IronMinedC2SPacket());
				} else if (block.equals(Blocks.GOLD_ORE) || block.equals(Blocks.DEEPSLATE_GOLD_ORE)) {
					expToAddMultiblock += 200;
					ModMessages.sendToServer(new GoldMinedC2SPacket());
				} else if (block.equals(Blocks.REDSTONE_ORE) || block.equals(Blocks.DEEPSLATE_REDSTONE_ORE)) {
					expToAddMultiblock += 20;
					ModMessages.sendToServer(new RedstoneMinedC2SPacket());
				} else if (block.equals(Blocks.LAPIS_ORE) || block.equals(Blocks.DEEPSLATE_LAPIS_ORE)) {
					expToAddMultiblock += 100;
					ModMessages.sendToServer(new LapisMinedC2SPacket());
				} else if (block.equals(Blocks.EMERALD_ORE) || block.equals(Blocks.DEEPSLATE_EMERALD_ORE)) {
					expToAddMultiblock += 500;
					ModMessages.sendToServer(new EmeraldMinedC2SPacket());
				} else if (block.equals(Blocks.DIAMOND_ORE) || block.equals(Blocks.DEEPSLATE_DIAMOND_ORE)) {
					expToAddMultiblock += 400;
					ModMessages.sendToServer(new DiamondMinedC2SPacket());
				} else if (block.equals(Blocks.ANCIENT_DEBRIS)) {
					expToAddMultiblock += 2800;
					ModMessages.sendToServer(new AncientDebrisMinedC2SPacket());
				}
				
				// end ores/stones
				else if (block.equals(Blocks.OBSIDIAN) || block.equals(Blocks.CRYING_OBSIDIAN)) {
					expToAddMultiblock += 20;
					ModMessages.sendToServer(new ObsidianMinedC2SPacket());
				} else if (block.equals(Blocks.END_STONE)) {
					expToAddMultiblock += 4;
				} else if (block.equals(Blocks.END_STONE_BRICKS)) {
					expToAddMultiblock += 5;
				}
				
				// nether ores/stones
				else if (block.equals(Blocks.NETHER_GOLD_ORE)) {
					expToAddMultiblock += 100;
					ModMessages.sendToServer(new NetherGoldMinedC2SPacket());
				} else if (block.equals(Blocks.NETHER_QUARTZ_ORE)) {
					expToAddMultiblock += 25;
					ModMessages.sendToServer(new QuartzMinedC2SPacket());
				} else if (block.equals(Blocks.NETHERRACK)) {
					expToAddMultiblock += 1;
				} else if (block.equals(Blocks.NETHER_BRICKS)) {
					expToAddMultiblock += 4;
				} else if (block.equals(Blocks.GLOWSTONE)) {
					expToAddMultiblock += 10;
					ModMessages.sendToServer(new GlowstoneMinedC2SPacket());
				}
			}
			ModMessages.sendToServer(new GainMiningExpFromMultiblockC2SPacket());
		}
	}
}