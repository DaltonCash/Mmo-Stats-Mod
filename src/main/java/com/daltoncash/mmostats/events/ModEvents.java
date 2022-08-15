package com.daltoncash.mmostats.events;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryExp;
import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryExpProvider;
import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryLevel;
import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryLevelProvider;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingExp;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingExpProvider;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingLevel;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingLevelProvider;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatExp;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatExpProvider;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatLevel;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatLevelProvider;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingExp;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingExpProvider;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingLevel;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingLevelProvider;
import com.daltoncash.mmostats.capabilities.mana.PlayerMana;
import com.daltoncash.mmostats.capabilities.mana.PlayerManaProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningExp;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningExpProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningLevel;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningLevelProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.JunkBlocksDropExpUpgrade;
import com.daltoncash.mmostats.capabilities.mining.upgrades.JunkBlocksDropExpUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NightVisionUpgrade;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NightVisionUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NoJunkBlocksUpgrade;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NoJunkBlocksUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.ObsidianBreakerUpgrade;
import com.daltoncash.mmostats.capabilities.mining.upgrades.ObsidianBreakerUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.AncientDebrisMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.AncientDebrisMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.CoalMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.CoalMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.CopperMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.CopperMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.DiamondMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.DiamondMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.EmeraldMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.EmeraldMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.GlowstoneMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.GlowstoneMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.GoldMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.GoldMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.IronMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.IronMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.LapisMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.LapisMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.NetherGoldMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.NetherGoldMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.QuartzMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.QuartzMinedProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.RedstoneMined;
import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.RedstoneMinedProvider;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsExp;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsExpProvider;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsLevel;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.ManaDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ArcheryExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ArcheryLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ChoppingExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ChoppingLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.CombatExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.CombatLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.FarmingExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.FarmingLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.SwordsExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.SwordsLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.JunkBlocksDropExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NightVisionDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NoJunkBlocksDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.ObsidianBreakerDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.AncientDebrisMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.CoalMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.CopperMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.DiamondMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.EmeraldMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.GlowstoneMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.GoldMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.IronMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.LapisMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.NetherGoldMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.QuartzMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.RedstoneMinedDataSyncS2CPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID)
public class ModEvents {

	// Adds Mana to the Player over time.
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.side == LogicalSide.SERVER) {
			event.player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
				if (mana.getMana() < 10 && event.player.getRandom().nextFloat() < 0.05f) {
																						
					mana.addMana(1);
					ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), ((ServerPlayer) event.player));
				}
			});
		}
	}

	@SubscribeEvent
	public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			//core skills
			
			if (!event.getObject().getCapability(PlayerManaProvider.PLAYER_MANA).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "manaproperties"),
						new PlayerManaProvider());
			}
			if (!event.getObject().getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "mininglevelproperties"),
						new PlayerMiningLevelProvider());
			}
			if (!event.getObject().getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "miningexpproperties"),
						new PlayerMiningExpProvider());
			}
			if (!event.getObject().getCapability(PlayerArcheryLevelProvider.PLAYER_ARCHERY_LEVEL).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "archerylevelproperties"),
						new PlayerArcheryLevelProvider());
			}
			if (!event.getObject().getCapability(PlayerArcheryExpProvider.PLAYER_ARCHERY_EXP).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "archeryexpproperties"),
						new PlayerArcheryExpProvider());
			}
			if (!event.getObject().getCapability(PlayerChoppingLevelProvider.PLAYER_CHOPPING_LEVEL).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "choppinglevelproperties"),
						new PlayerChoppingLevelProvider());
			}
			if (!event.getObject().getCapability(PlayerChoppingExpProvider.PLAYER_CHOPPING_EXP).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "choppingexpproperties"),
						new PlayerChoppingExpProvider());
			}
			if (!event.getObject().getCapability(PlayerCombatLevelProvider.PLAYER_COMBAT_LEVEL).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "combatlevelproperties"),
						new PlayerCombatLevelProvider());
			}
			if (!event.getObject().getCapability(PlayerCombatExpProvider.PLAYER_COMBAT_EXP).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "combatexpproperties"),
						new PlayerCombatExpProvider());
			}
			if (!event.getObject().getCapability(PlayerFarmingLevelProvider.PLAYER_FARMING_LEVEL).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "farminglevelproperties"),
						new PlayerFarmingLevelProvider());
			}
			if (!event.getObject().getCapability(PlayerFarmingExpProvider.PLAYER_FARMING_EXP).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "farmingexpproperties"),
						new PlayerFarmingExpProvider());
			}
			if (!event.getObject().getCapability(PlayerSwordsLevelProvider.PLAYER_SWORDS_LEVEL).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "swordslevelproperties"),
						new PlayerSwordsLevelProvider());
			}
			if (!event.getObject().getCapability(PlayerSwordsExpProvider.PLAYER_SWORDS_EXP).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "swordsexpproperties"),
						new PlayerSwordsExpProvider());
			}
			//mining upgrades
			if (!event.getObject().getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "junkblocksupgradeproperties"),
						new JunkBlocksDropExpUpgradeProvider());
			}
			if (!event.getObject().getCapability(NightVisionUpgradeProvider.NIGHT_VISION).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "nightvisionupgradeproperties"),
						new NightVisionUpgradeProvider());
			}
			if (!event.getObject().getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "nojunkblocksupgradeproperties"),
						new NoJunkBlocksUpgradeProvider());
			}
			if (!event.getObject().getCapability(ObsidianBreakerUpgradeProvider.OBSIDIAN_BREAKER).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "obsidianbreakerupgradeproperties"),
						new ObsidianBreakerUpgradeProvider());
			}
			//blocks mined
			if (!event.getObject().getCapability(AncientDebrisMinedProvider.ANCIENT_DEBRIS_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "ancientdebrismined"),
						new AncientDebrisMinedProvider());
			}
			if (!event.getObject().getCapability(CoalMinedProvider.COAL_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "coalmined"),
						new CoalMinedProvider());
			}
			if (!event.getObject().getCapability(CopperMinedProvider.COPPER_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "coppermined"),
						new CopperMinedProvider());
			}
			if (!event.getObject().getCapability(DiamondMinedProvider.DIAMOND_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "diamondmined"),
						new DiamondMinedProvider());
			}
			if (!event.getObject().getCapability(EmeraldMinedProvider.EMERALD_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "emeraldmined"),
						new EmeraldMinedProvider());
			}
			if (!event.getObject().getCapability(GlowstoneMinedProvider.GLOWSTONE_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "glowstonemined"),
						new GlowstoneMinedProvider());
			}
			if (!event.getObject().getCapability(GoldMinedProvider.GOLD_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "goldmined"),
						new GoldMinedProvider());
			}
			if (!event.getObject().getCapability(IronMinedProvider.IRON_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "ironmined"),
						new IronMinedProvider());
			}
			if (!event.getObject().getCapability(LapisMinedProvider.LAPIS_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "lapismined"),
						new LapisMinedProvider());
			}
			if (!event.getObject().getCapability(NetherGoldMinedProvider.NETHER_GOLD_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "nethergoldmined"),
						new NetherGoldMinedProvider());
			}
			if (!event.getObject().getCapability(QuartzMinedProvider.QUARTZ_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "quartzmined"),
						new QuartzMinedProvider());
			}
			if (!event.getObject().getCapability(RedstoneMinedProvider.REDSTONE_MINED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "redstonemined"),
						new RedstoneMinedProvider());
			}
		}
	}

	// Dying usually resets Player Capabilities. This method reattaches the
	// Capabilities to the player.
	@SubscribeEvent
	public static void onPlayerCloned(PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerArcheryLevelProvider.PLAYER_ARCHERY_LEVEL).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerArcheryLevelProvider.PLAYER_ARCHERY_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerArcheryExpProvider.PLAYER_ARCHERY_EXP).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerArcheryExpProvider.PLAYER_ARCHERY_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerCombatLevelProvider.PLAYER_COMBAT_LEVEL).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerCombatLevelProvider.PLAYER_COMBAT_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerCombatExpProvider.PLAYER_COMBAT_EXP).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerCombatExpProvider.PLAYER_COMBAT_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerChoppingLevelProvider.PLAYER_CHOPPING_LEVEL).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerChoppingLevelProvider.PLAYER_CHOPPING_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerChoppingExpProvider.PLAYER_CHOPPING_EXP).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerChoppingExpProvider.PLAYER_CHOPPING_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerFarmingLevelProvider.PLAYER_FARMING_LEVEL).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerFarmingLevelProvider.PLAYER_FARMING_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerFarmingExpProvider.PLAYER_FARMING_EXP).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerFarmingExpProvider.PLAYER_FARMING_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerSwordsLevelProvider.PLAYER_SWORDS_LEVEL).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerSwordsLevelProvider.PLAYER_SWORDS_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerSwordsExpProvider.PLAYER_SWORDS_EXP).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerSwordsExpProvider.PLAYER_SWORDS_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			//-----------------------------Upgrades-----------------------
			event.getOriginal().getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).ifPresent(oldStore -> {
				event.getOriginal().getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(NightVisionUpgradeProvider.NIGHT_VISION).ifPresent(oldStore -> {
				event.getOriginal().getCapability(NightVisionUpgradeProvider.NIGHT_VISION).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).ifPresent(oldStore -> {
				event.getOriginal().getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(ObsidianBreakerUpgradeProvider.OBSIDIAN_BREAKER).ifPresent(oldStore -> {
				event.getOriginal().getCapability(ObsidianBreakerUpgradeProvider.OBSIDIAN_BREAKER).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(AncientDebrisMinedProvider.ANCIENT_DEBRIS_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(AncientDebrisMinedProvider.ANCIENT_DEBRIS_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(CoalMinedProvider.COAL_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(CoalMinedProvider.COAL_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(CopperMinedProvider.COPPER_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(CopperMinedProvider.COPPER_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(DiamondMinedProvider.DIAMOND_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(DiamondMinedProvider.DIAMOND_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(EmeraldMinedProvider.EMERALD_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(EmeraldMinedProvider.EMERALD_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(GlowstoneMinedProvider.GLOWSTONE_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(GlowstoneMinedProvider.GLOWSTONE_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(GoldMinedProvider.GOLD_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(GoldMinedProvider.GOLD_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(IronMinedProvider.IRON_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(IronMinedProvider.IRON_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(LapisMinedProvider.LAPIS_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(LapisMinedProvider.LAPIS_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(NetherGoldMinedProvider.NETHER_GOLD_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(NetherGoldMinedProvider.NETHER_GOLD_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(QuartzMinedProvider.QUARTZ_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(QuartzMinedProvider.QUARTZ_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(RedstoneMinedProvider.REDSTONE_MINED).ifPresent(oldStore -> {
				event.getOriginal().getCapability(RedstoneMinedProvider.REDSTONE_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
		}
	}

	// Registers Capabilities to the forge bus
	@SubscribeEvent
	public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
		event.register(PlayerMana.class);
		event.register(PlayerMiningLevel.class);
		event.register(PlayerMiningExp.class);
		event.register(PlayerArcheryLevel.class);
		event.register(PlayerArcheryExp.class);
		event.register(PlayerChoppingLevel.class);
		event.register(PlayerChoppingExp.class);
		event.register(PlayerCombatLevel.class);
		event.register(PlayerCombatExp.class);
		event.register(PlayerFarmingLevel.class);
		event.register(PlayerFarmingExp.class);
		event.register(PlayerSwordsLevel.class);
		event.register(PlayerSwordsExp.class);
		
		event.register(JunkBlocksDropExpUpgrade.class);
		event.register(NightVisionUpgrade.class);
		event.register(NoJunkBlocksUpgrade.class);
		event.register(ObsidianBreakerUpgrade.class);
		
		event.register(AncientDebrisMined.class);
		event.register(CoalMined.class);
		event.register(CopperMined.class);
		event.register(DiamondMined.class);
		event.register(EmeraldMined.class);
		event.register(GlowstoneMined.class);
		event.register(GoldMined.class);
		event.register(IronMined.class);
		event.register(LapisMined.class);
		event.register(NetherGoldMined.class);
		event.register(QuartzMined.class);
		event.register(RedstoneMined.class);
	}

	// Applies Capabilities to the player on joining the world.
	@SubscribeEvent
	public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
		if (!event.getLevel().isClientSide()) {
			if (event.getEntity() instanceof ServerPlayer player) {
				
				player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
					ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), player);
				});
				player.getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(miningLevel -> {
					ModMessages.sendToPlayer(new MiningLevelDataSyncS2CPacket(miningLevel.getMiningLevel()), player);
				});
				player.getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(miningExp -> {
					ModMessages.sendToPlayer(new MiningExpDataSyncS2CPacket(miningExp.getMiningExp()), player);
				});
				player.getCapability(PlayerArcheryLevelProvider.PLAYER_ARCHERY_LEVEL).ifPresent(archeryLevel -> {
					ModMessages.sendToPlayer(new ArcheryLevelDataSyncS2CPacket(archeryLevel.getArcheryLevel()), player);
				});
				player.getCapability(PlayerArcheryExpProvider.PLAYER_ARCHERY_EXP).ifPresent(archeryExp -> {
					ModMessages.sendToPlayer(new ArcheryExpDataSyncS2CPacket(archeryExp.getArcheryExp()), player);
				});
				player.getCapability(PlayerChoppingLevelProvider.PLAYER_CHOPPING_LEVEL).ifPresent(choppingLevel -> {
					ModMessages.sendToPlayer(new ChoppingLevelDataSyncS2CPacket(choppingLevel.getChoppingLevel()), player);
				});
				player.getCapability(PlayerChoppingExpProvider.PLAYER_CHOPPING_EXP).ifPresent(choppingExp -> {
					ModMessages.sendToPlayer(new ChoppingExpDataSyncS2CPacket(choppingExp.getChoppingExp()), player);
				});
				player.getCapability(PlayerCombatLevelProvider.PLAYER_COMBAT_LEVEL).ifPresent(combatLevel -> {
					ModMessages.sendToPlayer(new CombatLevelDataSyncS2CPacket(combatLevel.getCombatLevel()), player);
				});
				player.getCapability(PlayerCombatExpProvider.PLAYER_COMBAT_EXP).ifPresent(combatExp -> {
					ModMessages.sendToPlayer(new CombatExpDataSyncS2CPacket(combatExp.getCombatExp()), player);
				});
				player.getCapability(PlayerFarmingLevelProvider.PLAYER_FARMING_LEVEL).ifPresent(farmingLevel -> {
					ModMessages.sendToPlayer(new FarmingLevelDataSyncS2CPacket(farmingLevel.getFarmingLevel()), player);
				});
				player.getCapability(PlayerFarmingExpProvider.PLAYER_FARMING_EXP).ifPresent(farmingExp -> {
					ModMessages.sendToPlayer(new FarmingExpDataSyncS2CPacket(farmingExp.getFarmingExp()), player);
				});
				player.getCapability(PlayerSwordsLevelProvider.PLAYER_SWORDS_LEVEL).ifPresent(swordsLevel -> {
					ModMessages.sendToPlayer(new SwordsLevelDataSyncS2CPacket(swordsLevel.getSwordsLevel()), player);
				});
				player.getCapability(PlayerSwordsExpProvider.PLAYER_SWORDS_EXP).ifPresent(swordsExp -> {
					ModMessages.sendToPlayer(new SwordsExpDataSyncS2CPacket(swordsExp.getSwordsExp()), player);
				});
				//------Upgrades------
				player.getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new JunkBlocksDropExpDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(NightVisionUpgradeProvider.NIGHT_VISION).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new NightVisionDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new NoJunkBlocksDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(ObsidianBreakerUpgradeProvider.OBSIDIAN_BREAKER).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new ObsidianBreakerDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(AncientDebrisMinedProvider.ANCIENT_DEBRIS_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new AncientDebrisMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(CoalMinedProvider.COAL_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new CoalMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(CopperMinedProvider.COPPER_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new CopperMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(DiamondMinedProvider.DIAMOND_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new DiamondMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(EmeraldMinedProvider.EMERALD_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new EmeraldMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(GlowstoneMinedProvider.GLOWSTONE_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new GlowstoneMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(GoldMinedProvider.GOLD_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new GoldMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(IronMinedProvider.IRON_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new IronMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(LapisMinedProvider.LAPIS_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new LapisMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(NetherGoldMinedProvider.NETHER_GOLD_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new NetherGoldMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(QuartzMinedProvider.QUARTZ_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new QuartzMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
				player.getCapability(RedstoneMinedProvider.REDSTONE_MINED).ifPresent(total -> {
					ModMessages.sendToPlayer(new RedstoneMinedDataSyncS2CPacket(total.getBlocksMined()), player);
				});
			}
		}
	}
}