package com.daltoncash.mmostats.events;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.capabilities.playerlevel.stats.mana.PlayerManaProvider;
import com.daltoncash.mmostats.events.SkillEvents.SkillForgeEvents;
import com.daltoncash.mmostats.gui.LevelUpOverlay;
import com.daltoncash.mmostats.gui.ManaOverlay;
import com.daltoncash.mmostats.gui.UpgradeMenu;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.AdditionalFortuneProcC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.AdditionalFortuneProcForMultiblockC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.EatFoodWhileFullC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainEffectFromEatingC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.taming.SpawnTamedBeeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.taming.SpawnTamedFrogC2SPacket;
import com.daltoncash.mmostats.networking.packets.s2c.ManaDataSyncS2CPacket;
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
import com.mojang.logging.LogUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

public class ClientEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class ClientForgeEvents {
		public static final Logger LOGGER = LogUtils.getLogger();
		public static Entity clientEntity;
		public static BlockEvent.BreakEvent blockevent = null;
		public static boolean noJunkBlocksToggle;

		public static int dodgeCooldown = 80;
		public static int eatCooldown = 128 / ModStats.getEatCooldownReduction();
		public static int invulnFrameDuration = 28;
		public static int healAtHalfHealth = 24000;
		public static int applesGiveChopSpeed = 0;
		public static int extendediframes = 0;
		public static int ragnorokDuration = 0;
		public static int ragnorokCooldown = 0;
		public static BlockPos tamedPosition;
		public static Entity animalToBeTamedAndKilled;

		public static List<Block> multiblockBlockList = new ArrayList<>();
		public static boolean splinteringStrikesToggle = false;
		public static final String miningConfigurationNone = "none";
		public static final String miningConfiguration1x2 = "1x2";
		public static final String miningConfiguration1x4 = "1x4";
		public static final String miningConfiguration3x3 = "3x3";
		public static String miningConfiguration = miningConfigurationNone;
		// WIP1
		// farming sweet berry bushes:
		// use event RightClickBlock in PlayerInteractEvent in PlayerEvent in Living
		// Event
		// WIP1

		// WIP2
		// Could be used to detect what the play was holding when attacking an entity
		// This is to give corresponding Exp for what weapon was held(swords, longsword,
		// etc., but not arrows)
		/*
		 * @SubscribeEvent public static void onSwordHit(AttackEntityEvent event) {
		 * System.out.println(event.getEntity().getScoreboardName()); }
		 */
		// WIP2

		// Provides a cooldown to the onArrowHit to prevent exploits
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

			if (dodgeCooldown < 80)
				dodgeCooldown++;

			if (eatCooldown < 128 / ModStats.getEatCooldownReduction()) {
				eatCooldown++;
			}

			if (invulnFrameDuration < 28)
				invulnFrameDuration++;

			if (healAtHalfHealth < 24000)
				healAtHalfHealth++;

			if (applesGiveChopSpeed > 0)
				applesGiveChopSpeed--;

			if (extendediframes > 0)
				extendediframes--;

			if (ragnorokCooldown > 0)
				ragnorokCooldown--;

			if (ragnorokDuration > 0)
				ragnorokDuration--;

			// Unabated
			if (event.player.getMainHandItem().getItem().equals(Items.BOW)) {
				if (event.player.isUsingItem()) {
					int unabatedLevel = ClientCapabilityData.isUpgradedUnabated();
					if (unabatedLevel > 0) {
						event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, unabatedLevel * 6));
					}
				}
			}
		}

		// Archery: LeftClick (Shotgun)
		@SubscribeEvent
		public static void onFiringBow(ArrowLooseEvent event) {
			// ModMessages.sendToServer(new ShotgunArrowsC2SPacket());
		}

		// Event for Arrows and Eggs hitting an entity
		@SubscribeEvent
		public static void onProjectileHit(LivingAttackEvent event) {

			if (event.getSource().getEntity() != null) {
				if (event.getSource().getEntity().getType().equals(EntityType.PLAYER)) {
					if (event.getSource().getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {

						Player player = (Player) event.getSource().getEntity();
						LivingEntity entity = event.getEntity();
						// Egger
						if (ClientCapabilityData.isUpgradedEgger() > 0) {
							if (event.getSource().getDirectEntity().getType().equals(EntityType.EGG)) {
								entity.level.explode(null, DamageSource.playerAttack(player),
										(ExplosionDamageCalculator) null, entity.getX(), entity.getEyeY() + 1,
										entity.getZ(), 50f * ClientCapabilityData.isUpgradedEgger(), false,
										Explosion.BlockInteraction.NONE);
							}
						}

						if (event.getSource().getDirectEntity().getType().equals(EntityType.ARROW)) {
							// Archery Passive:
							
							float moddedDamageToAdd = event.getAmount() * ModStats.getArcheryDamage();

							entity.hurt(new DamageSource("Archery skill"), moddedDamageToAdd);

							float totalDamageAfterModded = event.getAmount() + moddedDamageToAdd;

							// Arrow: Insecurity
							if (ClientCapabilityData.isUpgradedInsecurity() > 0) {
								if (entity.getType().equals(EntityType.SKELETON)
										|| entity.getType().equals(EntityType.BLAZE)
										|| entity.getType().equals(EntityType.STRAY)
										|| entity.getType().equals(EntityType.GHAST)) {
									entity.hurt(event.getSource(), (totalDamageAfterModded * ClientCapabilityData.isUpgradedInsecurity()) / 3);
								}
							}

							// Arrow: Sniper
							if (ClientCapabilityData.isUpgradedSniper() > 0) {
								if (player.distanceTo(entity) >= 15) {
									entity.hurt(event.getSource(), (totalDamageAfterModded * ClientCapabilityData.isUpgradedSniper() * (player.distanceTo(entity) / 15)) / 10);
								}
							}

							// Arrow: Headshot
							if (ClientCapabilityData.isUpgradedSweetSpotArchery() > 0) {
								if (event.getSource().getSourcePosition().y >= event.getEntity().getEyePosition().y
										- 0.2) {
									entity.hurt(event.getSource(), (totalDamageAfterModded * ClientCapabilityData.isUpgradedSweetSpotArchery()) / 5);
								}
							}
						}
					}
				}
			}
		}

		// Shield Block Drops Arrows
		@SubscribeEvent
		public static void onBlockingArrow(ShieldBlockEvent event) {
			if (ClientCapabilityData.isUpgradedFreeArrows() > 0) {
				ModMessages.sendToServer(new SpawnArrowOnPlayerC2SPacket());
			}
		}

		// Blocking Damage taken during dodge roll
		@SubscribeEvent
		public static void onPlayerGettingHit(LivingHurtEvent event) {

			if (event.getEntity().getType().equals(EntityType.PLAYER)) {
				if (event.getSource().isFall() || event.getSource().getEntity() != null) {
					event.setAmount(ModStats.getDamageTakenCalculation(event.getAmount()));
				}
				if (ClientCapabilityData.isUpgradedDodgeRoll() > 0) {
					if (invulnFrameDuration < 28) {
						event.setCanceled(true);
					}
				}
				// Hardwood
				if (ClientCapabilityData.isUpgradedHardWood() > 0) {
					if (healAtHalfHealth == 24000) {
						if (event.getEntity().getHealth() <= event.getEntity().getMaxHealth() / 4) {
							event.getEntity().setHealth(event.getEntity().getMaxHealth() / 2);
							healAtHalfHealth = 0;
						}
					}
				}

				// Dodge Roll
				if (ClientCapabilityData.isUpgradedOvercome() > 0) {
					if (extendediframes > 0) {
						event.setCanceled(true);
					}
					if (extendediframes == 0) {
						extendediframes = 80;
					}
				}

				// Ragnorok
				if (ClientCapabilityData.isUpgradedRagnorok() > 0) {
					if (event.getAmount()
							* (1 - (Math.max(event.getEntity().getArmorValue() / 5,
									event.getEntity().getArmorValue() - ((4 * event.getAmount()) / 8))) / 25)
							+ 1 > event.getEntity().getHealth()) {
						if (ragnorokCooldown == 0) {
							ragnorokDuration = ModStats.getRagnorokDuration();
							ragnorokCooldown = 36000;
							if (ragnorokDuration > 0) {
								event.setCanceled(true);
							}
						}
					}
				}
			}
			// SpiderEyeTotals
			if (event.getSource().getEntity() != null) {
				if (event.getSource().getEntity().getType().equals(EntityType.PLAYER)) {
					if (event.getSource().getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
						if (event.getEntity() instanceof LivingEntity) {
							if (ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getSpiderEyeEaten()) > 1) {

								event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, 40
										* ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getSpiderEyeEaten()),
										1));

							}
						}
						// Ragnorok
						if (ragnorokDuration > 0) {
							if (event.getSource().getEntity().isAlive()) {
								LivingEntity entity = (LivingEntity) event.getSource().getEntity();
								entity.heal(2);
							}
						}
					}
				}
				// StrongArms/LumberJacked
				if (event.getSource().getDirectEntity().getType().equals(EntityType.PLAYER)) {
					if (event.getSource().getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
						if (((LivingEntity) event.getSource().getDirectEntity())
								.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof AxeItem) {
							event.setAmount(event.getAmount()
									+ ((event.getAmount() * ClientCapabilityData.isUpgradedStrongArms()) / 3));
						}
						// Final calculation for damage dealt.
						event.setAmount(ModStats.getDamageDealtCalculation(event.getAmount()));
					}
				}
			}
		}

		// Combat: Stable Footing
		@SubscribeEvent
		public static void onTakingKnockback(LivingKnockBackEvent event) {
			if (event.getEntity().getType().equals(EntityType.PLAYER)) {
				if (event.getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
					if (ClientCapabilityData.isUpgradedStableFooting() > 0) {
						event.setStrength(event.getStrength() * 3 / 4);
					}
					event.setStrength(ModStats.getKnockbackCalculation(event.getStrength()));
				}
			}
		}

		// insatiable
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onEatingFoodWhenFull(RightClickItem event) {
			if (event.getItemStack().isEdible()) {
				if (event.getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
					if (event.getEntity().getFoodData().getFoodLevel() >= 20) {
						if (ClientCapabilityData.getIsUpgradedInsatiable() > 0
								&& eatCooldown >= 128 / (ModStats.getEatCooldownReduction())) {
							Item item = event.getItemStack().getItem();
							eatCooldown = 0;
							if (item.equals(Items.APPLE)) {
								ModMessages.sendToServer(new ApplesEatenC2SPacket());
								if (ClientCapabilityData.isUpgradedGrannySmith() > 0) {
									applesGiveChopSpeed += 2400;
								}
							}
							if (item.equals(Items.BEEF) || item.equals(Items.COOKED_BEEF)) {
								ModMessages.sendToServer(new BeefEatenC2SPacket());
							}
							if (item.equals(Items.BEETROOT)) {
								ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							}
							if (item.equals(Items.BEETROOT_SOUP)) {
								ModMessages.sendToServer(new BeetrootEatenC2SPacket());
								ModMessages.sendToServer(new BeetrootEatenC2SPacket());
								ModMessages.sendToServer(new BeetrootEatenC2SPacket());
								ModMessages.sendToServer(new BeetrootEatenC2SPacket());
								ModMessages.sendToServer(new BeetrootEatenC2SPacket());
								ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							}
							if (item.equals(Items.BREAD)) {
								ModMessages.sendToServer(new BreadEatenC2SPacket());
							}
							if (item.equals(Items.CARROT)) {
								ModMessages.sendToServer(new CarrotsEatenC2SPacket());
							}
							if (item.equals(Items.CHICKEN) || item.equals(Items.COOKED_CHICKEN)) {
								ModMessages.sendToServer(new ChickenEatenC2SPacket());
							}
							if (item.equals(Items.COOKIE)) {
								ModMessages.sendToServer(new CookiesEatenC2SPacket());
							}
							if (item.equals(Items.COD) || item.equals(Items.COOKED_COD) || item.equals(Items.SALMON)
									|| item.equals(Items.COOKED_SALMON) || item.equals(Items.TROPICAL_FISH)
									|| item.equals(Items.PUFFERFISH)) {
								ModMessages.sendToServer(new FishEatenC2SPacket());
							}
							if (item.equals(Items.GLOW_BERRIES)) {
								ModMessages.sendToServer(new GlowBerriesEatenC2SPacket());
							}
							if (item.equals(Items.GOLDEN_APPLE)) {
								ModMessages.sendToServer(new GoldApplesEatenC2SPacket());
							}
							if (item.equals(Items.GOLDEN_CARROT)) {
								ModMessages.sendToServer(new GoldenCarrotsEatenC2SPacket());
							}
							if (item.equals(Items.HONEY_BOTTLE)) {
								ModMessages.sendToServer(new HoneyEatenC2SPacket());
							}
							if (item.equals(Items.DRIED_KELP)) {
								ModMessages.sendToServer(new KelpEatenC2SPacket());
							}
							if (item.equals(Items.MELON_SLICE)) {
								ModMessages.sendToServer(new MelonEatenC2SPacket());
							}
							if (item.equals(Items.MUSHROOM_STEW)) {
								ModMessages.sendToServer(new MushroomStewEatenC2SPacket());
							}
							if (item.equals(Items.MUTTON) || item.equals(Items.COOKED_MUTTON)) {
								ModMessages.sendToServer(new MuttonEatenC2SPacket());
							}
							if (item.equals(Items.POISONOUS_POTATO)) {
								ModMessages.sendToServer(new PoisonousPotatoEatenC2SPacket());
								ModMessages.sendToServer(new PotatoEatenC2SPacket());
							}
							if (item.equals(Items.PORKCHOP) || item.equals(Items.COOKED_PORKCHOP)) {
								ModMessages.sendToServer(new PorkEatenC2SPacket());
							}
							if (item.equals(Items.POTATO)) {
								ModMessages.sendToServer(new PotatoEatenC2SPacket());
							}
							if (item.equals(Items.PUFFERFISH)) {
								ModMessages.sendToServer(new PufferfishEatenC2SPacket());
							}
							if (item.equals(Items.PUMPKIN_PIE)) {
								ModMessages.sendToServer(new PumpkinPieEatenC2SPacket());
							}
							if (item.equals(Items.RABBIT) || item.equals(Items.COOKED_RABBIT)) {
								ModMessages.sendToServer(new RabbitEatenC2SPacket());
							}
							if (item.equals(Items.RABBIT_STEW)) {
								ModMessages.sendToServer(new PotatoEatenC2SPacket());
								ModMessages.sendToServer(new CarrotsEatenC2SPacket());
								ModMessages.sendToServer(new RabbitEatenC2SPacket());
							}
							if (item.equals(Items.RABBIT) || item.equals(Items.MUTTON) || item.equals(Items.COD)
									|| item.equals(Items.SALMON) || item.equals(Items.CHICKEN)
									|| item.equals(Items.BEEF) || item.equals(Items.PORKCHOP)) {
								ModMessages.sendToServer(new RawFoodEatenC2SPacket());
							}
							if (item.equals(Items.ROTTEN_FLESH)) {
								ModMessages.sendToServer(new RottenFleshEatenC2SPacket());
							}
							if (item.equals(Items.SPIDER_EYE)) {
								ModMessages.sendToServer(new SpiderEyeEatenC2SPacket());
							}
							//event.getEntity().eat(event.getLevel(), event.getItemStack());
							ModMessages.sendToServer(new EatFoodWhileFullC2SPacket());
						}
					}
				}
			} else if (event.getItemStack().getItem() instanceof AxeItem) {
				if(event.getLevel().isClientSide) {
					if(ClientCapabilityData.getIsUpgradedSplinteringStrikes() > 0) {
						if(splinteringStrikesToggle) {
							splinteringStrikesToggle = false;
							Minecraft.getInstance().player.sendSystemMessage(Component.literal("SplinteringStrikes: Off."));
						}else {
							splinteringStrikesToggle = true;
							Minecraft.getInstance().player.sendSystemMessage(Component.literal("SplinteringStrikes: On."));
						}
					}
				}
			} else if (event.getItemStack().getItem() instanceof PickaxeItem) {
				if(event.getLevel().isClientSide) {
					int lvl = ClientCapabilityData.getIsUpgradedBigSwings();
					if(lvl == 0 && miningConfiguration != miningConfigurationNone) {
						miningConfiguration = miningConfigurationNone;
						Minecraft.getInstance().player.sendSystemMessage(Component.literal("Mining Configuration: none."));	
					}
					switch (miningConfiguration) {
					case miningConfigurationNone:
						if (lvl >= 1) {
						miningConfiguration = miningConfiguration1x2;
						Minecraft.getInstance().player.sendSystemMessage(Component.literal("Mining Configuration: 1x2."));
						}
						break;
					case miningConfiguration1x2:
						if (lvl >= 2) {
							miningConfiguration = miningConfiguration1x4;
							Minecraft.getInstance().player.sendSystemMessage(Component.literal("Mining Configuration: 1x4."));
						}else {
							miningConfiguration = miningConfigurationNone;
							Minecraft.getInstance().player.sendSystemMessage(Component.literal("Mining Configuration: none."));	
						}
						break;
					case miningConfiguration1x4:
						if (lvl >= 3) {
							miningConfiguration = miningConfiguration3x3;
							Minecraft.getInstance().player.sendSystemMessage(Component.literal("Mining Configuration: 3x3."));
						}else {
							miningConfiguration = miningConfigurationNone;
							Minecraft.getInstance().player.sendSystemMessage(Component.literal("Mining Configuration: none."));
						}
						break;
					case miningConfiguration3x3:
						if (dodgeCooldown == 0) {
							miningConfiguration = miningConfigurationNone;
							Minecraft.getInstance().player.sendSystemMessage(Component.literal("Mining Configuration: none."));
						}
						break;
					}
				}
			}
		}

		// Gain effects from eating
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onEatingFoodGainEffectsAndAddToTotals(LivingEntityUseItemEvent.Finish event) {
			if (event.getEntity().level.equals(Minecraft.getInstance().level)) {
				if (event.getItem().getItem().isEdible()) {
					if (event.getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
						Item item = event.getItem().getItem();
						eatCooldown = 0;
						if (item.equals(Items.APPLE)) {
							ModMessages.sendToServer(new ApplesEatenC2SPacket());
							if (ClientCapabilityData.isUpgradedGrannySmith() > 0) {
								applesGiveChopSpeed += 2400;
							}
						}
						if (item.equals(Items.BEEF) || item.equals(Items.COOKED_BEEF)) {
							ModMessages.sendToServer(new BeefEatenC2SPacket());
						}
						if (item.equals(Items.BEETROOT)) {
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
						}
						if (item.equals(Items.BEETROOT_SOUP)) {
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
							ModMessages.sendToServer(new BeetrootEatenC2SPacket());
						}
						if (item.equals(Items.BREAD)) {
							ModMessages.sendToServer(new BreadEatenC2SPacket());
						}
						if (item.equals(Items.CARROT)) {
							ModMessages.sendToServer(new CarrotsEatenC2SPacket());
						}
						if (item.equals(Items.CHICKEN) || item.equals(Items.COOKED_CHICKEN)) {
							ModMessages.sendToServer(new ChickenEatenC2SPacket());
						}
						if (item.equals(Items.COOKIE)) {
							ModMessages.sendToServer(new CookiesEatenC2SPacket());
						}
						if (item.equals(Items.COD) || item.equals(Items.COOKED_COD) || item.equals(Items.SALMON)
								|| item.equals(Items.COOKED_SALMON) || item.equals(Items.TROPICAL_FISH)
								|| item.equals(Items.PUFFERFISH)) {
							ModMessages.sendToServer(new FishEatenC2SPacket());
						}
						if (item.equals(Items.GLOW_BERRIES)) {
							ModMessages.sendToServer(new GlowBerriesEatenC2SPacket());
						}
						if (item.equals(Items.GOLDEN_APPLE)) {
							ModMessages.sendToServer(new GoldApplesEatenC2SPacket());
						}
						if (item.equals(Items.GOLDEN_CARROT)) {
							ModMessages.sendToServer(new GoldenCarrotsEatenC2SPacket());
						}
						if (item.equals(Items.HONEY_BOTTLE)) {
							ModMessages.sendToServer(new HoneyEatenC2SPacket());
						}
						if (item.equals(Items.DRIED_KELP)) {
							ModMessages.sendToServer(new KelpEatenC2SPacket());
						}
						if (item.equals(Items.MELON_SLICE)) {
							ModMessages.sendToServer(new MelonEatenC2SPacket());
						}
						if (item.equals(Items.MUSHROOM_STEW)) {
							ModMessages.sendToServer(new MushroomStewEatenC2SPacket());
						}
						if (item.equals(Items.MUTTON) || item.equals(Items.COOKED_MUTTON)) {
							ModMessages.sendToServer(new MuttonEatenC2SPacket());
						}
						if (item.equals(Items.POISONOUS_POTATO)) {
							ModMessages.sendToServer(new PoisonousPotatoEatenC2SPacket());
							ModMessages.sendToServer(new PotatoEatenC2SPacket());
						}
						if (item.equals(Items.PORKCHOP) || item.equals(Items.COOKED_PORKCHOP)) {
							ModMessages.sendToServer(new PorkEatenC2SPacket());
						}
						if (item.equals(Items.POTATO)) {
							ModMessages.sendToServer(new PotatoEatenC2SPacket());
						}
						if (item.equals(Items.PUFFERFISH)) {
							ModMessages.sendToServer(new PufferfishEatenC2SPacket());
						}
						if (item.equals(Items.PUMPKIN_PIE)) {
							ModMessages.sendToServer(new PumpkinPieEatenC2SPacket());
						}
						if (item.equals(Items.RABBIT) || item.equals(Items.COOKED_RABBIT)) {
							ModMessages.sendToServer(new RabbitEatenC2SPacket());
						}
						if (item.equals(Items.RABBIT_STEW)) {
							ModMessages.sendToServer(new PotatoEatenC2SPacket());
							ModMessages.sendToServer(new CarrotsEatenC2SPacket());
							ModMessages.sendToServer(new RabbitEatenC2SPacket());
						}
						if (item.equals(Items.RABBIT) || item.equals(Items.MUTTON) || item.equals(Items.COD)
								|| item.equals(Items.SALMON) || item.equals(Items.CHICKEN) || item.equals(Items.BEEF)
								|| item.equals(Items.PORKCHOP)) {
							ModMessages.sendToServer(new RawFoodEatenC2SPacket());
						}
						if (item.equals(Items.ROTTEN_FLESH)) {
							ModMessages.sendToServer(new RottenFleshEatenC2SPacket());
						}
						if (item.equals(Items.SPIDER_EYE)) {
							ModMessages.sendToServer(new SpiderEyeEatenC2SPacket());
						}
						ModMessages.sendToServer(new GainEffectFromEatingC2SPacket());
					}
				}
			}
		}

		// Fast Food-WIP
		@SubscribeEvent
		public static void onEatingFood(LivingEntityUseItemEvent.Start event) {
			if (event.getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
				// Fast Food-WIP
				if (event.getItem().getItem().isEdible()) {
						event.setDuration(ModStats.getEatDuration());
				}

				// Arrow: Quickshot
				if (ClientCapabilityData.isUpgradedQuickshot() > 0) {
					if (event.getItem().getItem().equals(Items.BOW)) {
						event.setDuration(71997);
					}
				}
			}
		}

		// HarvestCheck is an event that triggers when a block is being destroyed.
		// This method removes the drop from "junk blocks" if the appropriate
		// upgrade(NoJunkBlocks)
		// has been upgraded.
		@SubscribeEvent
		public static void onHarvest(HarvestCheck event) {
			if (event.getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
				if (ClientCapabilityData.isUpgradedNoJunkBlocks() > 0 && noJunkBlocksToggle) {
					if (ExpYieldList.getStones().contains(event.getTargetBlock().getBlock())) {
						event.setCanHarvest(false);
					}
				}
			}
		}

		// BreakSpeed is an event that triggers when a block is left-clicked
		// This method doubles the speed of mining deepslate and obsidian
		@SubscribeEvent
		public static void onBreaking(BreakSpeed event) {

			if (event.getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
				if (ClientCapabilityData.isUpgradedObsidianBreaker() > 0) {
					if (event.getState().getBlock().equals(Blocks.OBSIDIAN)
							|| event.getState().getBlock().equals(Blocks.CRYING_OBSIDIAN)) {
						event.setNewSpeed((float) (event.getOriginalSpeed() * 2));
					}
				}
				if (event.getState().getBlock().equals(Blocks.DEEPSLATE)) {
					event.setNewSpeed((float) (event.getOriginalSpeed() * 2));
				}
				if (ClientCapabilityData.isUpgradedWellFed() > 0) {

					if (event.getEntity().getFoodData().getFoodLevel() == 20) {
						event.setNewSpeed((float) (event.getNewSpeed() * 1.1));
					}
				}
				if (applesGiveChopSpeed > 0) {
					event.setNewSpeed((float) (event.getNewSpeed() * 1.3));
				}
			}
		}

		//Break a tree with Splintering Strikes ability
		@SubscribeEvent
		public static void onBreakBlockuseWIPTreeAbility(BlockEvent.BreakEvent event) {
			if (event.getPlayer().getName().getString().equals(MmoStatsMod.USER.getName())) {
				int upgradeLVL = ClientCapabilityData.getIsUpgradedSplinteringStrikes();
				if (upgradeLVL > 0 && ExpYieldList.getChoppingLogs().contains(event.getState().getBlock())) {
					
					ItemStack axe = event.getPlayer().getMainHandItem();
					if(splinteringStrikesToggle && (axe.getItem() instanceof AxeItem)) {
						multiblockBlockList = new ArrayList<>();
						
						int logsChopped = (SplinteringStrikesAbilityhelper(event.getPos(), 0, 
								ClientCapabilityData.getPlayerCurrentMana(),
								event.getLevel()));
						
						event.getPlayer().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {															
							mana.subMana((int)(logsChopped * ModStats.getCastCostReduction()));
							ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), ((ServerPlayer) event.getPlayer()));
							
						});
						
						SkillForgeEvents.giveChoppingExpMultiblock(multiblockBlockList);
						onBreakBlockRollForFortuneMultiblock(multiblockBlockList);
						
						axe.setDamageValue
						(axe.getDamageValue() + logsChopped * (upgradeLVL == 1 ?  8 : upgradeLVL == 2 ? 4 : 2));
					}
				}
			}	
		}
		
		
		public static int SplinteringStrikesAbilityhelper(BlockPos blockPos, int manaCost, int currentMana, LevelAccessor level){
			if(manaCost > 0) {
				multiblockBlockList.add(level.getBlockState(blockPos).getBlock());
				level.destroyBlock(blockPos, true);
			}
				
				
				
				if(ExpYieldList.getChoppingLogs().contains(level.getBlockState(blockPos.east()).getBlock())) {
					if(currentMana > manaCost) {
						manaCost = SplinteringStrikesAbilityhelper(blockPos.east(), ++manaCost, currentMana, level);
					}
				}
				if(ExpYieldList.getChoppingLogs().contains(level.getBlockState(blockPos.north()).getBlock())) {
					if(currentMana > manaCost) {
						manaCost = SplinteringStrikesAbilityhelper(blockPos.north(), ++manaCost, currentMana, level);
					}
				}
				if(ExpYieldList.getChoppingLogs().contains(level.getBlockState(blockPos.west()).getBlock())) {
					if(currentMana > manaCost) {
						manaCost = SplinteringStrikesAbilityhelper(blockPos.west(), ++manaCost, currentMana, level);
					}
				}
				if(ExpYieldList.getChoppingLogs().contains(level.getBlockState(blockPos.south()).getBlock())) {
					if(currentMana > manaCost) {
						manaCost = SplinteringStrikesAbilityhelper(blockPos.south(), ++manaCost, currentMana, level);
					}
				}
				if(ExpYieldList.getChoppingLogs().contains(level.getBlockState(blockPos.above()).getBlock())) {
					if(currentMana > manaCost) {
						manaCost = SplinteringStrikesAbilityhelper(blockPos.above(), ++manaCost, currentMana, level);
					}
				}
				
			return manaCost;
		}
		
		// Break multiple blocks with WIP ability
		@SubscribeEvent
		public static void onBreakBlockUseBigSwingsAbility(BlockEvent.BreakEvent event) {
			if (event.getPlayer().getName().getString().equals(MmoStatsMod.USER.getName())) {
				if (ExpYieldList.getMiningBlocks().contains(event.getState().getBlock())) {
					ItemStack pick = event.getPlayer().getMainHandItem();
					if(pick.getItem() instanceof PickaxeItem) {
						int unbreakingLevel = 0;
						Map<Enchantment, Integer> enchants = pick.getAllEnchantments();
						if(enchants.containsKey(Enchantments.UNBREAKING)) {
							unbreakingLevel = enchants.get(Enchantments.UNBREAKING);
						}
						List<Block> blocks = new ArrayList<>();
						int manaSpent = 0;
						
						switch(miningConfiguration) {
							case miningConfiguration1x2:
								
								if(ClientCapabilityData.getPlayerCurrentMana() >= 1 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().below()).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().below()).getBlock());
									event.getLevel().destroyBlock(event.getPos().below(), true);
									
									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								final int manaToSubtract1x2 = manaSpent;
								SkillForgeEvents.giveMiningExpMultiBlock(blocks);
								event.getPlayer().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {															
									mana.subMana(manaToSubtract1x2);
									ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), ((ServerPlayer) event.getPlayer()));
								});
								break;
							case miningConfiguration1x4:
								
								if(ClientCapabilityData.getPlayerCurrentMana() >= 1 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().below()).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().below()).getBlock());
									event.getLevel().destroyBlock(event.getPos().below(), true);
									
									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								if(ClientCapabilityData.getPlayerCurrentMana() >= 1 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().above()).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().above()).getBlock());
									event.getLevel().destroyBlock(event.getPos().above(), true);
									
									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								if(ClientCapabilityData.getPlayerCurrentMana() >= 1 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().above().above()).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().above().above()).getBlock());
									event.getLevel().destroyBlock(event.getPos().above().above(), true);
									
									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								final int manaToSubtract1x4 = manaSpent;
								SkillForgeEvents.giveMiningExpMultiBlock(blocks);
								
								event.getPlayer().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {															
									mana.subMana(manaToSubtract1x4);
									ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), ((ServerPlayer) event.getPlayer()));
								});
								break;
							case miningConfiguration3x3:
								if(ClientCapabilityData.getPlayerCurrentMana() >= 1 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().below()).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().below()).getBlock());
									event.getLevel().destroyBlock(event.getPos().below(), true);
									
									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								if(ClientCapabilityData.getPlayerCurrentMana() >= 2 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().below().relative(Direction.fromYRot(event.getPlayer().yRotO).getClockWise())).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().below().relative(Direction.fromYRot(event.getPlayer().yRotO).getClockWise())).getBlock());
									event.getLevel().destroyBlock(event.getPos().below().relative(Direction.fromYRot(event.getPlayer().yRotO).getClockWise()), true);

									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								if(ClientCapabilityData.getPlayerCurrentMana() >= 3 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().below().relative(Direction.fromYRot(event.getPlayer().yRotO).getCounterClockWise())).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().below().relative(Direction.fromYRot(event.getPlayer().yRotO).getCounterClockWise())).getBlock());
									event.getLevel().destroyBlock(event.getPos().below().relative(Direction.fromYRot(event.getPlayer().yRotO).getCounterClockWise()), true);

									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								if(ClientCapabilityData.getPlayerCurrentMana() >= 4 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().above()).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().above()).getBlock());
									event.getLevel().destroyBlock(event.getPos().above(), true);

									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								if(ClientCapabilityData.getPlayerCurrentMana() >= 5 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().above().relative(Direction.fromYRot(event.getPlayer().yRotO).getClockWise())).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().above().relative(Direction.fromYRot(event.getPlayer().yRotO).getClockWise())).getBlock());
									event.getLevel().destroyBlock(event.getPos().above().relative(Direction.fromYRot(event.getPlayer().yRotO).getClockWise()), true);

									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								if(ClientCapabilityData.getPlayerCurrentMana() >= 6 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().above().relative(Direction.fromYRot(event.getPlayer().yRotO).getCounterClockWise())).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().above().relative(Direction.fromYRot(event.getPlayer().yRotO).getCounterClockWise())).getBlock());
									event.getLevel().destroyBlock(event.getPos().above().relative(Direction.fromYRot(event.getPlayer().yRotO).getCounterClockWise()), true);

									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								if(ClientCapabilityData.getPlayerCurrentMana() >= 7 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().relative(Direction.fromYRot(event.getPlayer().yRotO).getClockWise())).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().relative(Direction.fromYRot(event.getPlayer().yRotO).getClockWise())).getBlock());
									event.getLevel().destroyBlock(event.getPos().relative(Direction.fromYRot(event.getPlayer().yRotO).getClockWise()), true);

									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								if(ClientCapabilityData.getPlayerCurrentMana() >= 8 && ExpYieldList.getMiningBlocks().contains(event.getLevel().getBlockState(event.getPos().relative(Direction.fromYRot(event.getPlayer().yRotO).getCounterClockWise())).getBlock())) {
									blocks.add(event.getLevel().getBlockState(event.getPos().relative(Direction.fromYRot(event.getPlayer().yRotO).getCounterClockWise())).getBlock());
									event.getLevel().destroyBlock(event.getPos().relative(Direction.fromYRot(event.getPlayer().yRotO).getCounterClockWise()), true);

									manaSpent++;
									pick.setDamageValue(pick.getDamageValue() + ModStats.getToolDamage(unbreakingLevel, 1));
								}
								SkillForgeEvents.giveMiningExpMultiBlock(blocks);
								final int manaToSubtract3x3 = manaSpent;
								event.getPlayer().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {															
									mana.subMana(manaToSubtract3x3);
									ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), ((ServerPlayer) event.getPlayer()));
									
								});
								break;
						}
						onBreakBlockRollForFortuneMultiblock(blocks);
					}
				}
			}
		}

		// Check for Passive Ability Double Drops
		@SubscribeEvent
		public static void onBreakBlockRollForFortune(BlockEvent.BreakEvent event) {
			
			if (event.getPlayer().getName().getString().equals(MmoStatsMod.USER.getName())) {
				if (ExpYieldList.getMiningBlocks().contains(event.getState().getBlock())) {

					blockevent = event;
					double rand = Math.random();

					while (ModStats.getMiningFortuneCalculation() >= rand) {
						ModMessages.sendToServer(new AdditionalFortuneProcC2SPacket());
						rand++;
					}
				}
				if (ExpYieldList.getChoppingBlocks().contains(event.getState().getBlock())) {

					blockevent = event;
					double rand = Math.random();

					while (ModStats.getChoppingFortuneCalculation() >= rand) {
						ModMessages.sendToServer(new AdditionalFortuneProcC2SPacket());
						rand++;
					}
				}
			}
		}
		
		
		// Check for Passive Ability Double Drops on multiblocks
				public static void onBreakBlockRollForFortuneMultiblock(List<Block> blocks) {
					multiblockBlockList = new ArrayList<>();
					List<Block> newBlocks = new ArrayList<>();
					
					for(Block block : blocks) {
						if (ExpYieldList.getMiningBlocks().contains(block)) {
							double rand = Math.random();

							while (ModStats.getMiningFortuneCalculation() >= rand) {
								newBlocks.add(block);
								rand++;
							}
						}else if (ExpYieldList.getChoppingBlocks().contains(block)) {

							
							double rand = Math.random();

							while (ModStats.getChoppingFortuneCalculation() >= rand) {
								newBlocks.add(block);
								rand++;
							}
						}
					}
					multiblockBlockList = newBlocks;
					ModMessages.sendToServer(new AdditionalFortuneProcForMultiblockC2SPacket());
				}

		// WIP BELOW----------------------------------------------------------------
		@SubscribeEvent
		public static void onTamingBee(EntityInteract event) {
			if (event.getSide().equals(LogicalSide.CLIENT)) {
				if (event.getEntity().getName().getString().equals(MmoStatsMod.USER.getName())) {
					if (event.getTarget().getType().equals(EntityType.BEE)) {
						if (event.getItemStack().getItem().equals(Items.HONEYCOMB)) {
							tamedPosition = event.getTarget().blockPosition();
							animalToBeTamedAndKilled = event.getTarget();
							ModMessages.sendToServer(new SpawnTamedBeeC2SPacket());
						}
					}
					if (event.getTarget().getType().equals(EntityType.FROG)) {
						if (event.getItemStack().getItem().equals(Items.STICK)) {
							tamedPosition = event.getTarget().blockPosition();
							animalToBeTamedAndKilled = event.getTarget();
							ModMessages.sendToServer(new SpawnTamedFrogC2SPacket());
						}
					}
				}
			}
		}

		@SubscribeEvent
		public static void onSpawningGiveEntitiesCustomName(LivingSpawnEvent event) {

			event.getEntity().setCustomName(
					Component.literal(getDisplayName(event.getEntity().getType().toShortString().toLowerCase()))
							.withStyle(ChatFormatting.GOLD).append(getDisplayHealth(event.getEntity())));
			event.getEntity().setCustomNameVisible(true);

		}

		private static String getDisplayName(String entity) {
			String displayName = "";
			int i = 1;
			for (char ch : entity.toCharArray()) {
				if (i == 1) {
					displayName += Character.toUpperCase(ch);
					i--;
				} else if (ch == '_') {
					i++;
					displayName += ' ';
				} else {
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
			for (int i = 0; i < 10; i++) {
				if (percentHealth > i) {
					healthDisplay += "■";
				} else {
					healthDisplay += "-";
				}
			}
			healthDisplay += "]";
			if (percentHealth > 5) {
				return Component.literal(healthDisplay).withStyle(ChatFormatting.GREEN);
			} else if (percentHealth > 2.5) {
				return Component.literal(healthDisplay).withStyle(ChatFormatting.YELLOW);
			} else {
				return Component.literal(healthDisplay).withStyle(ChatFormatting.RED);
			}

		}

		// This method defines what happens when a modded keybinding is pressed.
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			// Dodge Roll
			if (KeyBinding.DODGE_ROLL_KEY.consumeClick()) {
				if (ClientCapabilityData.isUpgradedNightVision() > 0 && dodgeCooldown >= 80) {
					Player player = Minecraft.getInstance().player;
					double x = player.getDeltaMovement().x;
					double y = player.getDeltaMovement().y;
					double z = player.getDeltaMovement().z;
					if (player.isOnGround()) {
						player.setDeltaMovement((x > 0) ? Math.min(x * 15, 2) : Math.max(x * 15, -2), 0.22,
								(z > 0) ? Math.min(z * 15, 2) : Math.max(z * 15, -2));
					} else {
						player.setDeltaMovement((x > 0) ? Math.min(x * 15, 2) : Math.max(x * 15, -2), y - .5,
								(z > 0) ? Math.min(z * 15, 2) : Math.max(z * 15, -2));
					}

					dodgeCooldown = 0;
					invulnFrameDuration = 0;
				}
			}
			if (KeyBinding.OPEN_UPGRADE_GUI_KEY.consumeClick()) {
				Minecraft.getInstance().setScreen(new UpgradeMenu(Component.literal("Upgrade Menu")));
			}
			if (KeyBinding.TOGGLE_JUNK_KEY.consumeClick()) {
				if (ClientCapabilityData.isUpgradedNoJunkBlocks() > 0) {
					if (noJunkBlocksToggle) {
						noJunkBlocksToggle = false;
						Minecraft.getInstance().player.sendSystemMessage(Component.literal("No Junk Blocks: Off"));
					} else {
						noJunkBlocksToggle = true;
						Minecraft.getInstance().player.sendSystemMessage(Component.literal("No Junk Blocks: On"));
					}
				}
			}
			if (KeyBinding.NIGHT_VISION_KEY.consumeClick()) {
				Minecraft.getInstance().player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200));
				ModMessages.sendToServer(new GainNightVisionC2SPacket());
			}
			// if(KeyBinding.X_PLOSIVE_MINER_KEY.consumeClick()) {
			// ModMessages.sendToServer(new SpawnTntC2SPacket());
			// }

			// testing nature's magnet
			// if(KeyBinding.NATURE_MAGNET_KEY.consumeClick()){
			// ModMessages.sendToServer(new SpawnNatureMagnetItemC2SPacket());
			// }
		}

		// This class registers keybindings and gui overlays to the mod bus.
		@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class ClientModBusEvents {

			@SubscribeEvent
			public static void onKeyRegister(RegisterKeyMappingsEvent event) {
				event.register(KeyBinding.NIGHT_VISION_KEY);
				event.register(KeyBinding.OPEN_UPGRADE_GUI_KEY);
				event.register(KeyBinding.TOGGLE_JUNK_KEY);
				event.register(KeyBinding.DODGE_ROLL_KEY);
			}

			@SubscribeEvent
			public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
				event.registerAboveAll("mana", ManaOverlay.HUD_MANA);
				event.registerAboveAll("level", LevelUpOverlay.LEVEL_UP_OVERLAY);
				event.registerAboveAll("skills", LevelUpOverlay.SKILL_OVERLAY);
			}
		}
	}
}
