package com.daltoncash.mmostats.events;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.common.handler.Sounds;
import com.daltoncash.mmostats.gui.LevelUpOverlay;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.AdditionalFortuneProcC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.EatFoodWhileFullC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainEffectFromEatingC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.magicAbilities.SpawnNatureMagnetItemC2SPacket;
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
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainArcheryExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainArcheryLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainChoppingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainChoppingLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainCombatExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainCombatLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingExpFromSeededCropsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingExpFromUnseededCropsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainMiningLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerLevelExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetArcheryExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetChoppingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetCombatExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetFarmingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetPlayerLevelExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.SpawnArrowOnPlayerC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.EntityDropsAnArrowC2SPacket;
import com.daltoncash.mmostats.util.KeyBinding;
import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

import org.slf4j.Logger;

public class ClientEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class ClientForgeEvents {
		public static final Logger LOGGER = LogUtils.getLogger();
		public static Entity clientEntity;
		public static BlockEvent.BreakEvent blockevent = null;
		public static int overlayDuration = 0;
		public static int seconds = 0;
		public static int expToSub = 0;
		public static int expToAdd = 0;
		public static int playerLevelExpToSub = 0;
		public static int playerLevelExpToAdd = 0;
		
		public static int bowCooldown = 30;
		public static int dodgeCooldown = 80;
		public static int eatCooldown = 128;
		public static int invulnFrameDuration = 28;
		public static int healAtHalfHealth = 24000;
		public static int applesGiveChopSpeed = 0;
		public static int extendediframes = 0;
		public static int ragnorokDuration = 0;
		public static int ragnorokCooldown = 0;
		//WIP1
		//farming sweet berry bushes:
		//use event RightClickBlock in PlayerInteractEvent in PlayerEvent in Living Event
		//WIP1
		
		//WIP2
		//Could be used to detect what the play was holding when attacking an entity
		//This is to give corresponding Exp for what weapon was held(swords, longsword, etc., but not arrows)
		/*
		@SubscribeEvent
		public static void onSwordHit(AttackEntityEvent event) {
			System.out.println(event.getEntity().getScoreboardName());
		}
		*/
		//WIP2
		
		private static void PlayerLevelCheck(int playerLevelExpBeingAdded) {
			int playerLevel = ClientCapabilityData.getPlayerLevel();
			int playerLevelExp = ClientCapabilityData.getPlayerExp() + playerLevelExpBeingAdded;
			if (playerLevelExp > (playerLevel * 5) + 25) {
				playerLevelExpToSub = (playerLevel * 5) + 25;
				System.out.println("level up: " + (playerLevel + 1));
				ModMessages.sendToServer(new GainPlayerLevelC2SPacket());
				ModMessages.sendToServer(new ResetPlayerLevelExpC2SPacket());
				
			}
		}
		//Provides a cooldown to the onArrowHit to prevent exploits
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (bowCooldown < 30) {
				bowCooldown++;
			}
			if (dodgeCooldown < 80) {
				dodgeCooldown++;
				
			}
			if (eatCooldown < 128) {
				eatCooldown++;
			}
			if (invulnFrameDuration < 28) {
				invulnFrameDuration++;
			}
			if (healAtHalfHealth < 24000) {
				healAtHalfHealth++;
			}
			if (applesGiveChopSpeed > 0) {
				applesGiveChopSpeed--;
			}
			//Unabated
			if(event.player.getMainHandItem().getItem().equals(Items.BOW)) {
				if(event.player.isUsingItem()) {
					event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 20));
					
					
				}
			}
			if(extendediframes > 0) {
				extendediframes--;
			}
			if(ragnorokCooldown == 1) System.out.println("ragnorok ready");
			if (ragnorokCooldown > 0) {
				ragnorokCooldown--;
				
			}
			if (ragnorokDuration > 0) {
				ragnorokDuration--;
			}
			if(overlayDuration > 0) {
				overlayDuration--;
			}
		}
		//Shield Block Drops Arrows
		@SubscribeEvent
		public static void onBlockingArrow(ShieldBlockEvent event) {
			//event.getDamageSource().getDirectEntity().getType()
			ModMessages.sendToServer(new SpawnArrowOnPlayerC2SPacket());
		}
		
		
		//Blocking Damage taken during dodge roll
		@SubscribeEvent
		public static void onPlayerGettingHit(LivingHurtEvent event) {
			if(event.getSource().getEntity() != null) {
				if(event.getSource().getEntity().getType().equals(EntityType.PLAYER)) {
					if(ragnorokDuration > 0) {
						if(event.getSource().getEntity().isAlive()) {
							LivingEntity entity = (LivingEntity) event.getSource().getEntity();
							entity.heal(2);
						}
					}
				}
			}
			
			
			if(event.getEntity().getType().equals(EntityType.PLAYER)) {
				if(invulnFrameDuration < 28) {
					event.setCanceled(true);
					System.out.println("dodge roll");
				}
				if(healAtHalfHealth == 24000) {
					if(event.getEntity().getHealth() <= event.getEntity().getMaxHealth() / 4) {
						event.getEntity().setHealth(event.getEntity().getMaxHealth() / 2);
						healAtHalfHealth = 0;
						System.out.println();
					}
				}
				//Extend IFrames
				if(extendediframes > 0) {
					event.setCanceled(true);
					System.out.println("iframes");
				}
				if(extendediframes == 0) {
					extendediframes = 80;
				}
				//Ragnorok
				
				if(event.getAmount() * (1 - (Math.max(event.getEntity().getArmorValue() / 5,
						event.getEntity().getArmorValue() - ((4 * event.getAmount()) / 8))) / 25) + 1 > event.getEntity().getHealth()) {
					if(ragnorokCooldown == 0) {
						System.out.println("ragnorok used");
						ragnorokDuration = 2400;
						ragnorokCooldown = 3600;
						if(ragnorokDuration > 0) {
							event.setCanceled(true);
						}
					}
				}
			}
			
			
		}
		//Chopping gives axe damage
		@SubscribeEvent
		public static void onAttackingEnemy(AttackEntityEvent event) {
			List<Item> axes = List.of(Items.NETHERITE_AXE, Items.DIAMOND_AXE, Items.GOLDEN_AXE,
					Items.IRON_AXE, Items.STONE_AXE, Items.WOODEN_AXE);
			
			if(event.getEntity().getType().equals(EntityType.PLAYER)) {
				if(axes.contains(event.getEntity().getItemInHand(InteractionHand.MAIN_HAND).getItem())){
					if(event.getTarget().isAlive()) {
						LivingEntity entity = (LivingEntity) event.getTarget();
						entity.setHealth(entity.getHealth() - 2);
					
					}
				}
			}
			
		}
		//Archery: Shotgun
		@SubscribeEvent
		public static void onFiringBow(ArrowLooseEvent event) {
			//ModMessages.sendToServer(new ShotgunArrowsC2SPacket());
			//System.out.println("Spawning item...maybe");
		}
		
		//Combat: Stable Footing
		@SubscribeEvent
		public static void onTakingKnockback(LivingKnockBackEvent event) {
			if(event.getEntity().getType().equals(EntityType.PLAYER)) {
				event.setStrength((event.getOriginalStrength() * 3) / 4);
				
			}
		}
		
		
		
		
		
		
		
		
		
		//-------------------------------------------------------
		//eat when full
		@SubscribeEvent
		public static void onEatingFood(RightClickItem event) {
			if(event.getItemStack().getItem().equals(Items.STICK)) {
				System.out.println("Should be spawning in client events!");
			}
				
			
			if(event.getItemStack().isEdible()) {
				if(event.getEntity().getFoodData().getFoodLevel() >= 20) {
					if(eatCooldown >= 128) {
						event.getEntity().eat(event.getLevel(), event.getItemStack());
						ModMessages.sendToServer(new EatFoodWhileFullC2SPacket());
						eatCooldown = 0;
						if(event.getItemStack().getItem().equals(Items.APPLE)) {
							applesGiveChopSpeed += 2400;
						}
					}
				}
			}
			
			
			//event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0));
			//event.getEntity().setSpeed(10);
			
			
		}
		@SubscribeEvent
		public static void drawBow(ArrowNockEvent event) {
			
		}
		
		//Gain effects from eating
		@SubscribeEvent
		public static void onEatingFood(LivingEntityUseItemEvent.Finish event) {
			if(event.getItem().getItem().isEdible()) {
				ModMessages.sendToServer(new GainEffectFromEatingC2SPacket());
				eatCooldown = 0;
				if(event.getItem().getItem().equals(Items.APPLE)) {
					applesGiveChopSpeed += 2400;
					System.out.println(applesGiveChopSpeed);
				}
			}
			
		}
		
		//Fast Food
		@SubscribeEvent
		public static void onEatingFood(LivingEntityUseItemEvent.Start event) {
			//Fast Food
			if(event.getItem().getItem().isEdible()) {
				event.setDuration(16);
			}
			//Arrow: Quickfire
			if(event.getItem().getItem().equals(Items.BOW)) {
				event.setDuration(71997);
			}
			overlayDuration = 450;
			seconds++;
			System.out.println(seconds);
			
		}
		
		//Event for Arrows and Eggs hitting an entity
		@SubscribeEvent
		public static void onProjectileHit(LivingAttackEvent event) {
			
			if(event.getSource().getEntity() != null) {
				
				if(event.getSource().getEntity().getType().equals(EntityType.PLAYER)) {
					Entity player = event.getSource().getEntity();
					LivingEntity entity = event.getEntity();
					//Egger
					if(event.getSource().getDirectEntity().getType().equals(EntityType.EGG)) {
						entity.setHealth(entity.getHealth() - 2);
					}
					
					if(event.getSource().getDirectEntity().getType().equals(EntityType.ARROW)) {
						
						
						if(entity.getType().equals(EntityType.COW)) {
							
						}
						
						
						//Arrow: Insecurity
						if(entity.getType().equals(EntityType.SKELETON) || entity.getType().equals(EntityType.BLAZE) ||
								entity.getType().equals(EntityType.STRAY) || entity.getType().equals(EntityType.GHAST)) {
							entity.setHealth(Math.max(entity.getHealth() - (event.getAmount()/3), 0));
						}
						
						//Arrow: Sniper
						if(player.distanceTo(entity) > 25) {
							entity.setHealth(Math.max(entity.getHealth() - (event.getAmount()/3), 0));
						}
						
						
						
						
						//Arrow: Headshot
						if(event.getSource().getSourcePosition().y >= event.getEntity().getEyePosition().y - 0.2) {
							System.out.println("Headshot");
							//event.getEntity().setHealth(0);
							event.getEntity().setHealth(Math.max(event.getEntity().getHealth() - (event.getAmount()/3), 0));
						}
						//Archery exp gain
						if(bowCooldown >= 30) {
							int archeryExp = ClientCapabilityData.getPlayerArcheryExp();
							int archeryLevel = ClientCapabilityData.getPlayerArcheryLevel();
							ModMessages.sendToServer(new GainArcheryExpC2SPacket());
							bowCooldown = 0;
							
							// level up if player has sufficient archeryExp
							if (archeryExp > (archeryLevel * 40) + 400) {
								LOGGER.info("{} leveled up to {} in Archery", 
										event.getSource().getEntity().getScoreboardName(), 
										archeryLevel + 1);
								expToSub = (archeryLevel * 40) + 400;
								ModMessages.sendToServer(new GainArcheryLevelC2SPacket());
								ModMessages.sendToServer(new ResetArcheryExpC2SPacket());
								
								playerLevelExpToAdd = (archeryLevel % 25 == 24) ? 
										(((archeryLevel + 1) / 100) + 1) * 5 : ((archeryLevel + 1) / 100) + 1;
								ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
								PlayerLevelCheck(playerLevelExpToAdd);
							}
						}else {
							LOGGER.debug("Player {} is firing too fast!(archeryExp on cooldown)", 
									event.getSource().getEntity().getScoreboardName());
						}
					}
				}
			}
		}
		
		
		//HarvestCheck is an event that triggers when a block is being destroyed.
		//This method removes the drop from "junk blocks" if the appropriate upgrade(NoJunkBlocks)
		//has been upgraded.
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
		
		//LivingDeathEvent is an event that triggers when an entity dies.
		//This method gives the player exp for combat when they kill an entity.
		@SubscribeEvent
		public static void onkill(LivingDeathEvent event) {
			seconds = 0;
			expToAdd = 0;
			if(event.getSource().getEntity() != null) {
				if(event.getSource().getEntity().getType().equals(EntityType.PLAYER)) {
					
					EntityType<?> type = event.getEntity().getType();
					if(ExpYieldList.getCombatEntities().contains(type)) {
						int combatExp = ClientCapabilityData.getPlayerCombatExp();
						int combatLevel = ClientCapabilityData.getPlayerCombatLevel();
						//for passive mobs:
						expToAdd = 5;
						//for neutral mobs:
						if(type.equals(EntityType.BEE) || type.equals(EntityType.DOLPHIN) || 
								type.equals(EntityType.GOAT) || type.equals(EntityType.LLAMA) || 
								type.equals(EntityType.PANDA) || type.equals(EntityType.POLAR_BEAR) ||
								type.equals(EntityType.TRADER_LLAMA) || type.equals(EntityType.WOLF)) {
							expToAdd = 10;
						}
						//for hostile mobs:
						else if(type.equals(EntityType.ENDERMITE) || type.equals(EntityType.SILVERFISH) ||
								type.equals(EntityType.SLIME) || type.equals(EntityType.MAGMA_CUBE)) {
							expToAdd = 15;
						}
						else if(type.equals(EntityType.ZOMBIE) || type.equals(EntityType.HUSK) || 
								type.equals(EntityType.DROWNED) || type.equals(EntityType.PIGLIN) ||
								type.equals(EntityType.ZOMBIFIED_PIGLIN) || type.equals(EntityType.VEX) ||
								type.equals(EntityType.ZOMBIE_VILLAGER)){
							expToAdd = 20;
						}
						else if(type.equals(EntityType.SKELETON) || type.equals(EntityType.STRAY) ||
								type.equals(EntityType.SPIDER) || type.equals(EntityType.VINDICATOR) ||
								type.equals(EntityType.PILLAGER) || type.equals(EntityType.SHULKER) || 
								type.equals(EntityType.WITCH)) {
							expToAdd = 30;
						}
						else if(type.equals(EntityType.CREEPER) || type.equals(EntityType.CAVE_SPIDER) ||
								type.equals(EntityType.WITHER_SKELETON)) {
							expToAdd = 35;
						}
						else if(type.equals(EntityType.ENDERMAN) || type.equals(EntityType.BLAZE) || 
								type.equals(EntityType.PIGLIN_BRUTE)) {
							expToAdd = 50;
						}
						else if(type.equals(EntityType.EVOKER) || type.equals(EntityType.GHAST) || 
								type.equals(EntityType.GUARDIAN) || type.equals(EntityType.HOGLIN) ||
								type.equals(EntityType.ZOGLIN)) {
							expToAdd = 100;
						}
						else if(type.equals(EntityType.IRON_GOLEM) || type.equals(EntityType.PHANTOM)) {
							expToAdd = 200;
						}
						else if(type.equals(EntityType.RAVAGER)) {
							expToAdd = 300;
						}
						else if(type.equals(EntityType.ELDER_GUARDIAN)) {
							expToAdd = 500;
						}
						else if(type.equals(EntityType.WARDEN)) {
							expToAdd = 600;
						}
						else if(type.equals(EntityType.WITHER)) {
							expToAdd = 800;
						}
						else if(type.equals(EntityType.ENDER_DRAGON)) {
							expToAdd = 5000;
						}
						ModMessages.sendToServer(new GainCombatExpC2SPacket());
						
						// level up if player has sufficient combatExp
						if (combatExp > (combatLevel * 40) + 400) {
							LOGGER.info("{} leveled up to {} in Combat", 
									event.getSource().getEntity().getScoreboardName(), 
									combatLevel + 1);
							expToSub = (combatLevel * 40) + 400;
							ModMessages.sendToServer(new GainCombatLevelC2SPacket());
							ModMessages.sendToServer(new ResetCombatExpC2SPacket());
							
							playerLevelExpToAdd = (combatLevel % 25 == 24) ? 
									(((combatLevel + 1) / 100) + 1) * 5 : ((combatLevel + 1) / 100) + 1;
							ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
							PlayerLevelCheck(playerLevelExpToAdd);
						}
						LOGGER.info("{} has killed {}(Player CombatExp: {})", 
								event.getSource().getEntity().getScoreboardName(), 
								type.toShortString(),
								combatExp + expToAdd);
						//Archery: Efficient Marksman
						clientEntity = event.getEntity();
						ModMessages.sendToServer(new EntityDropsAnArrowC2SPacket());
					}
				}
			}
		}
		
		//BreakSpeed is an event that triggers when a block is left-clicked
		//This method doubles the speed of mining deepslate and obsidian
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
			if(!ClientCapabilityData.isUpgradedWellFed()) {
				if(event.getEntity().getFoodData().getFoodLevel() == 20) {
					event.setNewSpeed((float) (event.getNewSpeed() * 1.1));
				}
			}
			if(applesGiveChopSpeed > 0) {
				event.setNewSpeed((float) (event.getNewSpeed() * 1.3));
			}
		}
		
		//BlockEvent.BreakEvent is an event that is triggered when a block is broken
		//This method gives exp to the player when they mine mining blocks,
		//chop chopping blocks, or farm farming blocks.
		@SubscribeEvent
		public static void onBreakBlock(BlockEvent.BreakEvent event) {
			Block block = event.getState().getBlock();
			expToSub = 0;
			expToAdd = 0;
			blockevent = event;
			event.getPlayer().getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
			if(ExpYieldList.getFarmingBlocks().contains(block)) {
				int farmingExp = ClientCapabilityData.getPlayerFarmingExp();
				int farmingLevel = ClientCapabilityData.getPlayerFarmingLevel();
				
				if(block.equals(Blocks.GRASS) || block.equals(Blocks.TALL_GRASS)) {
					expToAdd = 3;
					ModMessages.sendToServer(new GainFarmingExpFromUnseededCropsC2SPacket());
				}
				else if(block.equals(Blocks.WHEAT) || block.equals(Blocks.CARROTS) ||
						block.equals(Blocks.POTATOES) || block.equals(Blocks.BEETROOTS) ||
						block.equals(Blocks.COCOA)) {
					expToAdd = 20;
					ModMessages.sendToServer(new GainFarmingExpFromSeededCropsC2SPacket());
				}
				else if(block.equals(Blocks.PUMPKIN) || block.equals(Blocks.MELON) || 
						block.equals(Blocks.SHROOMLIGHT)){
					expToAdd = 20;
					ModMessages.sendToServer(new GainFarmingExpFromUnseededCropsC2SPacket());
				}
				else if(block.equals(Blocks.CACTUS) || block.equals(Blocks.SUGAR_CANE) ||
						block.equals(Blocks.BAMBOO) || block.equals(Blocks.KELP) ||
						block.equals(Blocks.BROWN_MUSHROOM_BLOCK) || block.equals(Blocks.RED_MUSHROOM_BLOCK) ||
						block.equals(Blocks.MUSHROOM_STEM)) {
					expToAdd = 10;
					ModMessages.sendToServer(new GainFarmingExpFromUnseededCropsC2SPacket());
				}
				else if(block.equals(Blocks.BROWN_MUSHROOM) || block.equals(Blocks.RED_MUSHROOM) || 
						block.equals(Blocks.CRIMSON_FUNGUS) || block.equals(Blocks.WARPED_FUNGUS)) {
					expToAdd = 30;
					ModMessages.sendToServer(new GainFarmingExpFromUnseededCropsC2SPacket());
				}
				if (farmingExp > (farmingLevel * 40) + 400) {
					LOGGER.info("{} leveled up to {} in Farming", 
							event.getPlayer().getScoreboardName(), 
							farmingLevel + 1);
					expToSub = (farmingLevel * 40) + 400;
					ModMessages.sendToServer(new GainFarmingLevelC2SPacket());
					ModMessages.sendToServer(new ResetFarmingExpC2SPacket());
					
					playerLevelExpToAdd = (farmingLevel % 25 == 24) ? 
							(((farmingLevel + 1) / 100) + 1) * 5 : ((farmingLevel + 1) / 100) + 1;
					ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
					PlayerLevelCheck(playerLevelExpToAdd);
				}
				LOGGER.info("{} has farmed {}(Player FarmingExp: {})", 
						event.getPlayer().getScoreboardName(), 
						event.getState().getBlock().asItem(),
						farmingExp + expToAdd);
			}
			else if(ExpYieldList.getChoppingBlocks().contains(block)) {
				int choppingExp = ClientCapabilityData.getPlayerChoppingExp();
				int choppingLevel = ClientCapabilityData.getPlayerChoppingLevel();
				
				if(block.equals(Blocks.OAK_LOG) || block.equals(Blocks.BIRCH_LOG) ||
						block.equals(Blocks.SPRUCE_LOG) || block.equals(Blocks.JUNGLE_LOG) ||
						block.equals(Blocks.ACACIA_LOG) || block.equals(Blocks.MANGROVE_LOG) ||
						block.equals(Blocks.DARK_OAK_LOG) || block.equals(Blocks.CRIMSON_STEM) ||
						block.equals(Blocks.WARPED_STEM)) {
					expToAdd = 50;
				}else if(block.equals(Blocks.OAK_LEAVES) || block.equals(Blocks.BIRCH_LEAVES) ||
						block.equals(Blocks.SPRUCE_LEAVES) || block.equals(Blocks.JUNGLE_LEAVES) ||
						block.equals(Blocks.ACACIA_LEAVES) || block.equals(Blocks.MANGROVE_LEAVES) ||
						block.equals(Blocks.DARK_OAK_LEAVES) || block.equals(Blocks.NETHER_WART_BLOCK) ||
						block.equals(Blocks.WARPED_WART_BLOCK)) {
					expToAdd = 5;
				}
				ModMessages.sendToServer(new GainChoppingExpC2SPacket());
				// level up if player has sufficient choppingExp
				if (choppingExp > (choppingLevel * 40) + 400) {
					LOGGER.info("{} leveled up to {} in Chopping", 
							event.getPlayer().getScoreboardName(), 
							choppingLevel + 1);
					expToSub = (choppingLevel * 40) + 400;
					ModMessages.sendToServer(new GainChoppingLevelC2SPacket());
					ModMessages.sendToServer(new ResetChoppingExpC2SPacket());
					
					playerLevelExpToAdd = (choppingLevel % 25 == 24) ? 
							(((choppingLevel + 1) / 100) + 1) * 5 : ((choppingLevel + 1) / 100) + 1;
					ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
					PlayerLevelCheck(playerLevelExpToAdd);
				}
				LOGGER.info("{} has chopped {}(Player ChoppingExp: {})", 
						event.getPlayer().getScoreboardName(), 
						event.getState().getBlock().asItem(),
						choppingExp + expToAdd);
			}
			
			// Checks if the block being destroyed is part of the accepted list
			else if (ExpYieldList.getMiningBlocks().contains(block)) {
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
				}
				// end ores/stones
				else if (block.equals(Blocks.OBSIDIAN) || block.equals(Blocks.CRYING_OBSIDIAN)) {
					expToAdd = 20;
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
				
				// level up if player has sufficient miningExp
				if (miningExp > (miningLevel * 40) + 400) {
					LOGGER.info("{} leveled up to {} in Mining", 
							event.getPlayer().getScoreboardName(), 
							miningLevel + 1);
					expToSub = (miningLevel * 40) + 400;
					ModMessages.sendToServer(new GainMiningLevelC2SPacket());
					ModMessages.sendToServer(new ResetMiningExpC2SPacket());
					
					playerLevelExpToAdd = (miningLevel % 25 == 24) ? 
							(((miningLevel + 1) / 100) + 1) * 5 : ((miningLevel + 1) / 100) + 1;
					ModMessages.sendToServer(new GainPlayerLevelExpC2SPacket());
					PlayerLevelCheck(playerLevelExpToAdd);
					overlayDuration = 1200;
					System.out.println(overlayDuration);
				}
				event.setExpToDrop((int)(event.getExpToDrop() * 
						((Math.log10(ClientCapabilityData.getLapisMined()) + 2) / 2)));
				LOGGER.info("{} has mined {}(Player miningExp: {})", 
						event.getPlayer().getScoreboardName(), 
						event.getState().getBlock().asItem(),
						(miningExp + expToAdd));
			}
		}
		@SuppressWarnings("unused")
		private static class LevelUpSound extends AbstractTickableSoundInstance {
			

			//Minecraft.getInstance().getSoundManager().play(new LevelUpSound());
			protected LevelUpSound() {
				super(Sounds.levelUp, SoundSource.AMBIENT, RandomSource.create());
				this.looping = false;
				LOGGER.info("Sound should be playing...");
			}

			/*
			public static void play() {
				Minecraft.getInstance().getSoundManager().play(new LevelUpSound());
			}
			 */
			@Override
			public void tick() {
				
			}
		}
		

		//This method defines what happens when a modded keybinding is pressed.
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			//Dodge Roll
			if (KeyBinding.NIGHT_VISION_KEY.consumeClick()) {
				if (ClientCapabilityData.isUpgradedNightVision() && dodgeCooldown >= 80) {
					Minecraft.getInstance().player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200));
					ModMessages.sendToServer(new GainNightVisionC2SPacket());
					Player player = Minecraft.getInstance().player;
					double x = player.getDeltaMovement().x;
					double y = player.getDeltaMovement().y;
					double z = player.getDeltaMovement().z;
					if(player.isOnGround()) {
						player.setDeltaMovement(
								(x > 0) ? Math.min(x * 15, 2) : Math.max(x * 15, -2), 
								0.22, 
								(z > 0) ? Math.min(z * 15, 2) : Math.max(z * 15, -2));
					}else {
						player.setDeltaMovement(
								(x > 0) ? Math.min(x * 15, 2) : Math.max(x * 15, -2), 
								y - .5, 
								(z > 0) ? Math.min(z * 15, 2) : Math.max(z * 15, -2));
					}
					
					dodgeCooldown = 0;
					invulnFrameDuration = 0;
				}
			}
			if (KeyBinding.OPEN_UPGRADE_GUI_KEY.consumeClick()) {
				Minecraft.getInstance().setScreen(new UpgradeMenu(Component.literal("Test from events!")));
			}
			if(KeyBinding.X_PLOSIVE_MINER_KEY.consumeClick()) {
				ModMessages.sendToServer(new SpawnTntC2SPacket());
			}

			//testing nature's magnet
			if(KeyBinding.NATURE_MAGNET_KEY.consumeClick()){
				ModMessages.sendToServer(new SpawnNatureMagnetItemC2SPacket());
			}
			
		}
		//This class registers keybindings and gui overlays to the mos bus.
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
				//event.registerAboveAll("mana", ManaOverlay.HUD_MANA);
				event.registerAboveAll("level", LevelUpOverlay.LEVEL_UP_OVERLAY);
				System.out.println("displaying overlay");
			}
		}
	}
}
