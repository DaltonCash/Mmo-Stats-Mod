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
import com.daltoncash.mmostats.networking.packets.c2s.GainNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.SpawnArrowOnPlayerC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.ApplesEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.BeefEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.BeetrootEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.BreadEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.CarrotsEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.ChickenEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.CookiesEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.FishEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.GlowBerriesEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.GoldApplesEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.GoldenCarrotsEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.HoneyEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.KelpEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.MelonEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.MushroomStewEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.MuttonEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PoisonousPotatoEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PorkEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PotatoEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PufferfishEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PumpkinPieEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.RabbitEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.RawFoodEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.RottenFleshEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.SpiderEyeEatenC2SPacket;
import com.daltoncash.mmostats.util.KeyBinding;
import com.ibm.icu.text.TimeZoneFormat.Style;
import com.mojang.logging.LogUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.OfferFlowerGoal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RenderNameTagEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.AnimalTameEvent;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

public class ClientEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class ClientForgeEvents {
		public static final Logger LOGGER = LogUtils.getLogger();
		public static Entity clientEntity;
		public static BlockEvent.BreakEvent blockevent = null;
		
		
		public static int dodgeCooldown = 80;
		public static int eatCooldown = 128/(1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMelonEaten()));
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
		
		//Provides a cooldown to the onArrowHit to prevent exploits
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			
			
			if (dodgeCooldown < 80) dodgeCooldown++;
			
			if (eatCooldown < 128/(1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMelonEaten()))) {
				eatCooldown++;
			}
			
			if (invulnFrameDuration < 28) invulnFrameDuration++;
			
			if (healAtHalfHealth < 24000) healAtHalfHealth++;
			
			if (applesGiveChopSpeed > 0) applesGiveChopSpeed--;
			
			if(extendediframes > 0) extendediframes--;
			
			if(ragnorokCooldown == 1) System.out.println("ragnorok ready");
			
			if (ragnorokCooldown > 0) ragnorokCooldown--;
			
			if (ragnorokDuration > 0) ragnorokDuration--;
			
			//Unabated
			if(ClientCapabilityData.isUpgradedUnabated() > 0) {
				if(event.player.getMainHandItem().getItem().equals(Items.BOW)) {
					if(event.player.isUsingItem()) {
						event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 20));
					}
				}
			}
		}
		
		//Archery: LeftClick (Shotgun)
		@SubscribeEvent
		public static void onFiringBow(ArrowLooseEvent event) {
			//ModMessages.sendToServer(new ShotgunArrowsC2SPacket());
		}
		
		//Event for Arrows and Eggs hitting an entity
		@SubscribeEvent
		public static void onProjectileHit(LivingAttackEvent event) {
			if(event.getSource().getEntity() != null) {
				if(event.getSource().getEntity().getType().equals(EntityType.PLAYER)) {
					Entity player = event.getSource().getEntity();
					LivingEntity entity = event.getEntity();
					//Egger
					if(ClientCapabilityData.isUpgradedEgger() > 0) {
						if(event.getSource().getDirectEntity().getType().equals(EntityType.EGG)) {
							entity.setHealth(entity.getHealth() - 2);
						}
					}
					
					if(event.getSource().getDirectEntity().getType().equals(EntityType.ARROW)) {
						
						//Arrow: Insecurity
						if(ClientCapabilityData.isUpgradedInsecurity() > 0) {
							if(entity.getType().equals(EntityType.SKELETON) || entity.getType().equals(EntityType.BLAZE) ||
									entity.getType().equals(EntityType.STRAY) || entity.getType().equals(EntityType.GHAST)) {
								entity.setHealth(Math.max(entity.getHealth() - (event.getAmount()/3), 0));
							}
						}
						
						//Arrow: Sniper
						if(ClientCapabilityData.isUpgradedSniper() > 0) {
							if(player.distanceTo(entity) > 25) {
								entity.setHealth(Math.max(entity.getHealth() - (event.getAmount()/3), 0));
							}
						}
						
						//Arrow: Headshot
						if(ClientCapabilityData.isUpgradedSweetSpotArchery() > 0) {
							if(event.getSource().getSourcePosition().y >= event.getEntity().getEyePosition().y - 0.2) {
								event.getEntity().setHealth(Math.max(event.getEntity().getHealth() - (event.getAmount()/3), 0));
							}
						}
					}
				}
			}
		}
		
		//Shield Block Drops Arrows
		@SubscribeEvent
		public static void onBlockingArrow(ShieldBlockEvent event) {
			if(ClientCapabilityData.isUpgradedFreeArrows() > 0) {
				ModMessages.sendToServer(new SpawnArrowOnPlayerC2SPacket());
			}
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
				int pumpkinPieEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPumpkinPieEaten());
				int kelpEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getKelpEaten());
				event.setAmount((event.getAmount() - pumpkinPieEatenLevel) * (1 - ((kelpEatenLevel * 5) / 100f)));
				if(ClientCapabilityData.isUpgradedDodgeRoll() > 0) {
					if(invulnFrameDuration < 28) {
						event.setCanceled(true);
					}
				}
				
				if(ClientCapabilityData.isUpgradedHardWood() > 0) {
					if(healAtHalfHealth == 24000) {
						if(event.getEntity().getHealth() <= event.getEntity().getMaxHealth() / 4) {
							event.getEntity().setHealth(event.getEntity().getMaxHealth() / 2);
							healAtHalfHealth = 0;
						}
					}
				}
				
				//Extend IFrames
				if(ClientCapabilityData.isUpgradedOvercome() > 0) {
					if(extendediframes > 0) {
						event.setCanceled(true);
					}
					if(extendediframes == 0) {
						extendediframes = 80;
					}
				}
				
				//Ragnorok
				if(ClientCapabilityData.isUpgradedRagnorok() > 0) {
					if(event.getAmount() * (1 - (Math.max(event.getEntity().getArmorValue() / 5,
							event.getEntity().getArmorValue() - ((4 * event.getAmount()) / 8))) / 25) + 1 > event.getEntity().getHealth()) {
						if(ragnorokCooldown == 0) {
							int mushroomStewEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMushroomStewEaten());
							ragnorokDuration = (int) (2400 * (1 + (((mushroomStewEatenLevel) * (mushroomStewEatenLevel)) / 100f)));
							ragnorokCooldown = 36000;
							if(ragnorokDuration > 0) {
								event.setCanceled(true);
							}
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
		
		
		
		//Combat: Stable Footing
		@SubscribeEvent
		public static void onTakingKnockback(LivingKnockBackEvent event) {
			if(ClientCapabilityData.isUpgradedStableFooting() > 0) {
				if(event.getEntity().getType().equals(EntityType.PLAYER)) {
					int potatoesEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPotatoEaten());
					event.setStrength((event.getOriginalStrength() * 3) / (4 + potatoesEatenLevel));
				}
			}
		}
		
		//insatiable-WIP
		@SubscribeEvent
		public static void onEatingFoodWhenFull(RightClickItem event) {
			
			if(event.getItemStack().isEdible()) {
				if(event.getEntity().getFoodData().getFoodLevel() >= 20) {
					if(eatCooldown >= 128/(1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMelonEaten()))) {
						event.getEntity().eat(event.getLevel(), event.getItemStack());
						ModMessages.sendToServer(new EatFoodWhileFullC2SPacket());
						Item item = event.getItemStack().getItem();
						eatCooldown = 0;
						
						if(item.equals(Items.APPLE)) {
							ModMessages.sendToServer(new ApplesEatenC2SPacket());
							if(ClientCapabilityData.isUpgradedGrannySmith() > 0) {
								applesGiveChopSpeed += 2400;
							}
						}
						if(item.equals(Items.BEEF) || item.equals(Items.COOKED_BEEF)) {
							ModMessages.sendToServer(new BeefEatenC2SPacket());
						}
						if(item.equals(Items.BEETROOT)) {
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
						}
						if(item.equals(Items.BEETROOT_SOUP)) {
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
						}
						if(item.equals(Items.BREAD)) {
							ModMessages.sendToServer(new BreadEatenC2SPacket());
						}
						if(item.equals(Items.CARROT)) {
							ModMessages.sendToServer(new CarrotsEatenC2SPacket());
						}
						if(item.equals(Items.CHICKEN) || item.equals(Items.COOKED_CHICKEN)) {
							ModMessages.sendToServer(new ChickenEatenC2SPacket());
						}
						if(item.equals(Items.COOKIE)) {
							ModMessages.sendToServer(new CookiesEatenC2SPacket());
						}
						if(item.equals(Items.COD) || item.equals(Items.COOKED_COD) || 
							item.equals(Items.SALMON) || item.equals(Items.COOKED_SALMON) ||
							item.equals(Items.TROPICAL_FISH) || item.equals(Items.PUFFERFISH)) {
							ModMessages.sendToServer(new FishEatenC2SPacket());
						}
						if(item.equals(Items.GLOW_BERRIES)) {
							ModMessages.sendToServer(new GlowBerriesEatenC2SPacket());
						}
						if(item.equals(Items.GOLDEN_APPLE)) {
							ModMessages.sendToServer(new GoldApplesEatenC2SPacket());
						}
						if(item.equals(Items.GOLDEN_CARROT)) {
							ModMessages.sendToServer(new GoldenCarrotsEatenC2SPacket());
						}
						if(item.equals(Items.HONEY_BOTTLE)) {
							ModMessages.sendToServer(new HoneyEatenC2SPacket());
						}
						if(item.equals(Items.DRIED_KELP)) {
							ModMessages.sendToServer(new KelpEatenC2SPacket());
						}
						if(item.equals(Items.MELON_SLICE)) {
							ModMessages.sendToServer(new MelonEatenC2SPacket());
						}
						if(item.equals(Items.MUSHROOM_STEW)) {
							ModMessages.sendToServer(new MushroomStewEatenC2SPacket());
						}
						if(item.equals(Items.MUTTON) || item.equals(Items.COOKED_MUTTON)) {
							ModMessages.sendToServer(new MuttonEatenC2SPacket());
						}
						if(item.equals(Items.POISONOUS_POTATO)) {
							ModMessages.sendToServer(new PoisonousPotatoEatenC2SPacket());
							ModMessages.sendToServer(new PotatoEatenC2SPacket());
						}
						if(item.equals(Items.PORKCHOP) || item.equals(Items.COOKED_PORKCHOP)) {
							ModMessages.sendToServer(new PorkEatenC2SPacket());
						}
						if(item.equals(Items.POTATO)) {
							ModMessages.sendToServer(new PotatoEatenC2SPacket());
						}
						if(item.equals(Items.PUFFERFISH)) {
							ModMessages.sendToServer(new PufferfishEatenC2SPacket());
						}
						if(item.equals(Items.PUMPKIN_PIE)) {
							ModMessages.sendToServer(new PumpkinPieEatenC2SPacket());
						}
						if(item.equals(Items.RABBIT) || item.equals(Items.COOKED_RABBIT)) {
							ModMessages.sendToServer(new RabbitEatenC2SPacket());
						}
						if(item.equals(Items.RABBIT_STEW)) {
							ModMessages.sendToServer(new PotatoEatenC2SPacket());
							ModMessages.sendToServer(new CarrotsEatenC2SPacket());
							ModMessages.sendToServer(new RabbitEatenC2SPacket());
						}
						if(item.equals(Items.RABBIT) || item.equals(Items.MUTTON) || 
								item.equals(Items.COD) || item.equals(Items.SALMON) ||
								item.equals(Items.CHICKEN) || item.equals(Items.BEEF) ||
								item.equals(Items.PORKCHOP)) {
							ModMessages.sendToServer(new RawFoodEatenC2SPacket());
						}
						if(item.equals(Items.ROTTEN_FLESH)) {
							ModMessages.sendToServer(new RottenFleshEatenC2SPacket());
						}
						if(item.equals(Items.SPIDER_EYE)) {
							ModMessages.sendToServer(new SpiderEyeEatenC2SPacket());
						}
					}
				}
			}
		}
				
		//Gain effects from eating
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onEatingFoodGainEffectsAndAddToTotals(LivingEntityUseItemEvent.Finish event) {
			
			if(event.getEntity().level.equals(Minecraft.getInstance().level)) {
				if(event.getItem().getItem().isEdible()) {
					Item item = event.getItem().getItem();
					eatCooldown = 0;
					
					
					if(item.equals(Items.APPLE)) {
						ModMessages.sendToServer(new ApplesEatenC2SPacket());
						if(ClientCapabilityData.isUpgradedGrannySmith() > 0) {
							applesGiveChopSpeed += 2400;
						}
					}
					if(item.equals(Items.BEEF) || item.equals(Items.COOKED_BEEF)) {
						ModMessages.sendToServer(new BeefEatenC2SPacket());
					}
					if(item.equals(Items.BEETROOT)) {
						ModMessages.sendToServer(new BeetrootEatenC2SPacket());
					}
					if(item.equals(Items.BEETROOT_SOUP)) {
						ModMessages.sendToServer(new BeetrootEatenC2SPacket());
						ModMessages.sendToServer(new BeetrootEatenC2SPacket());
						ModMessages.sendToServer(new BeetrootEatenC2SPacket());
						ModMessages.sendToServer(new BeetrootEatenC2SPacket());
						ModMessages.sendToServer(new BeetrootEatenC2SPacket());
						ModMessages.sendToServer(new BeetrootEatenC2SPacket());
					}
					if(item.equals(Items.BREAD)) {
						ModMessages.sendToServer(new BreadEatenC2SPacket());
					}
					if(item.equals(Items.CARROT)) {
						ModMessages.sendToServer(new CarrotsEatenC2SPacket());
					}
					if(item.equals(Items.CHICKEN) || item.equals(Items.COOKED_CHICKEN)) {
						ModMessages.sendToServer(new ChickenEatenC2SPacket());
					}
					if(item.equals(Items.COOKIE)) {
						ModMessages.sendToServer(new CookiesEatenC2SPacket());
					}
					if(item.equals(Items.COD) || item.equals(Items.COOKED_COD) || 
						item.equals(Items.SALMON) || item.equals(Items.COOKED_SALMON) ||
						item.equals(Items.TROPICAL_FISH) || item.equals(Items.PUFFERFISH)) {
						ModMessages.sendToServer(new FishEatenC2SPacket());
					}
					if(item.equals(Items.GLOW_BERRIES)) {
						ModMessages.sendToServer(new GlowBerriesEatenC2SPacket());
					}
					if(item.equals(Items.GOLDEN_APPLE)) {
						ModMessages.sendToServer(new GoldApplesEatenC2SPacket());
					}
					if(item.equals(Items.GOLDEN_CARROT)) {
						ModMessages.sendToServer(new GoldenCarrotsEatenC2SPacket());
					}
					if(item.equals(Items.HONEY_BOTTLE)) {
						ModMessages.sendToServer(new HoneyEatenC2SPacket());
					}
					if(item.equals(Items.DRIED_KELP)) {
						ModMessages.sendToServer(new KelpEatenC2SPacket());
					}
					if(item.equals(Items.MELON_SLICE)) {
						ModMessages.sendToServer(new MelonEatenC2SPacket());
					}
					if(item.equals(Items.MUSHROOM_STEW)) {
						ModMessages.sendToServer(new MushroomStewEatenC2SPacket());
					}
					if(item.equals(Items.MUTTON) || item.equals(Items.COOKED_MUTTON)) {
						ModMessages.sendToServer(new MuttonEatenC2SPacket());
					}
					if(item.equals(Items.POISONOUS_POTATO)) {
						ModMessages.sendToServer(new PoisonousPotatoEatenC2SPacket());
						ModMessages.sendToServer(new PotatoEatenC2SPacket());
					}
					if(item.equals(Items.PORKCHOP) || item.equals(Items.COOKED_PORKCHOP)) {
						ModMessages.sendToServer(new PorkEatenC2SPacket());
					}
					if(item.equals(Items.POTATO)) {
						ModMessages.sendToServer(new PotatoEatenC2SPacket());
					}
					if(item.equals(Items.PUFFERFISH)) {
						ModMessages.sendToServer(new PufferfishEatenC2SPacket());
					}
					if(item.equals(Items.PUMPKIN_PIE)) {
						ModMessages.sendToServer(new PumpkinPieEatenC2SPacket());
					}
					if(item.equals(Items.RABBIT) || item.equals(Items.COOKED_RABBIT)) {
						ModMessages.sendToServer(new RabbitEatenC2SPacket());
					}
					if(item.equals(Items.RABBIT_STEW)) {
						ModMessages.sendToServer(new PotatoEatenC2SPacket());
						ModMessages.sendToServer(new CarrotsEatenC2SPacket());
						ModMessages.sendToServer(new RabbitEatenC2SPacket());
					}
					if(item.equals(Items.RABBIT) || item.equals(Items.MUTTON) || 
							item.equals(Items.COD) || item.equals(Items.SALMON) ||
							item.equals(Items.CHICKEN) || item.equals(Items.BEEF) ||
							item.equals(Items.PORKCHOP)) {
						ModMessages.sendToServer(new RawFoodEatenC2SPacket());
					}
					if(item.equals(Items.ROTTEN_FLESH)) {
						ModMessages.sendToServer(new RottenFleshEatenC2SPacket());
					}
					if(item.equals(Items.SPIDER_EYE)) {
						ModMessages.sendToServer(new SpiderEyeEatenC2SPacket());
					}
					ModMessages.sendToServer(new GainEffectFromEatingC2SPacket());
				}
			}
		}
		
		//Fast Food-WIP
		@SubscribeEvent
		public static void onEatingFood(LivingEntityUseItemEvent.Start event) {
			
			//Fast Food-WIP
			//eat duration should = (32 / fastfoodlevel) - melonsEaten
			if(event.getItem().getItem().isEdible()) {
				int eatDuration = 32/(1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMelonEaten()));
				event.setDuration(eatDuration);
			}
			
			//Arrow: Quickshot
			if(ClientCapabilityData.isUpgradedQuickshot() > 0) {
				if(event.getItem().getItem().equals(Items.BOW)) {
					event.setDuration(71997);
				}
			}
		}
		

		
		
		//HarvestCheck is an event that triggers when a block is being destroyed.
		//This method removes the drop from "junk blocks" if the appropriate upgrade(NoJunkBlocks)
		//has been upgraded.
		@SubscribeEvent
		public static void onHarvest(HarvestCheck event) {
			if(ClientCapabilityData.isUpgradedNoJunkBlocks() > 0) {
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
		
		
		//BreakSpeed is an event that triggers when a block is left-clicked
		//This method doubles the speed of mining deepslate and obsidian
		@SubscribeEvent
		public static void onBreaking(BreakSpeed event) {
			if(ClientCapabilityData.isUpgradedObsidianBreaker() > 0) {
				if (event.getState().getBlock().equals(Blocks.OBSIDIAN)
						|| event.getState().getBlock().equals(Blocks.CRYING_OBSIDIAN)) {
					event.setNewSpeed((float) (event.getOriginalSpeed() * 2));
				}
			}
			if (event.getState().getBlock().equals(Blocks.DEEPSLATE)) {
				event.setNewSpeed((float) (event.getOriginalSpeed() * 2));
			}
			if(ClientCapabilityData.isUpgradedWellFed() > 0) {
				if(event.getEntity().getFoodData().getFoodLevel() == 20) {
					event.setNewSpeed((float) (event.getNewSpeed() * 1.1));
				}
			}
			if(applesGiveChopSpeed > 0) {
				event.setNewSpeed((float) (event.getNewSpeed() * 1.3));
			}
		}
		// Check for Passive Ability Double Drops
		@SubscribeEvent
		public static void onBreakBlock(BlockEvent.BreakEvent event) {
			if (ExpYieldList.getMiningBlocks().contains(event.getState().getBlock())) {
				blockevent = event;
				int goldMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGoldMined());
				double rand =  Math.random();
				double fortuneChance = (ClientCapabilityData.getPlayerMiningLevel() * (1 + ((goldMinedLevel * goldMinedLevel * goldMinedLevel * goldMinedLevel) / 100f))) / 500.0;
				while(fortuneChance >= rand){
					ModMessages.sendToServer(new AdditionalFortuneProcC2SPacket());
					fortuneChance -= 1;
				}
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
		//WIP BELOW
		@SubscribeEvent
		public static void animaltaming(AnimalTameEvent event) {
			Set<WrappedGoal> goals = event.getAnimal().goalSelector.getAvailableGoals();
			System.out.println(goals.toString());
			for(WrappedGoal goal : goals) {
				System.out.println(goal.getGoal());
			}
			System.out.println(event.getTamer());
		}
		
		@SubscribeEvent
		public static void onbreeding(RenderNameTagEvent event) {
			if(ExpYieldList.getCombatEntities().contains(event.getEntity().getType())){
				event.getEntity().setCustomName(
						Component.literal(getDisplayName(event.getEntity().getType().toShortString().toLowerCase())).withStyle(ChatFormatting.GOLD).append
						(getDisplayHealth(event.getEntity())));
				
			}
			event.getEntity().setCustomNameVisible(true);
		}
		
		private static String getDisplayName(String entity) {
			String displayName = "";
			int i = 1;
			for(char ch : entity.toCharArray()) {
				if(i == 1) {
					displayName += Character.toUpperCase(ch);
					i--;
				}else if(ch == '_') {
					i++;
					displayName += ' ';
				}else {
					displayName += ch;
				}
			}
			
			return displayName;
		}
		
		private static MutableComponent getDisplayHealth(Entity entity) {
			String healthDisplay = "[";
			LivingEntity aliveEntity = (LivingEntity) entity;
			float entityHealth = aliveEntity.getHealth();
			float entityMaxHealth = (float) aliveEntity.getAttribute(Attributes.MAX_HEALTH).getValue();
			float percentHealth = (entityHealth * 10) / entityMaxHealth;
			for(int i = 0; i < 10; i++) {
				if(percentHealth > i) {
					healthDisplay += "■";
				}else {
					healthDisplay += "-";
				}
			}
			healthDisplay += "]";
			if(percentHealth > 5) {
				return Component.literal(healthDisplay).withStyle(ChatFormatting.GREEN);
			}else if(percentHealth > 2.5) {
				return Component.literal(healthDisplay).withStyle(ChatFormatting.YELLOW);
			}else {
				return Component.literal(healthDisplay).withStyle(ChatFormatting.RED);
			}
			
		}

		@SubscribeEvent
		public static void onbreeding(BabyEntitySpawnEvent event) {
			System.out.println(event.getCausedByPlayer());
			if(event.getCausedByPlayer() != null) {
				System.out.println("ayo this working");
				
			}
		}
		//WIP ABOVE
		//This method defines what happens when a modded keybinding is pressed.
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			//Dodge Roll
			if (KeyBinding.NIGHT_VISION_KEY.consumeClick()) {
				if (ClientCapabilityData.isUpgradedNightVision() > 0 && dodgeCooldown >= 80) {
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
				event.registerAboveAll("skills", LevelUpOverlay.SKILL_OVERLAY);
			}
		}
	}
}
