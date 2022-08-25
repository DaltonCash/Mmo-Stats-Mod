package com.daltoncash.mmostats.events;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryExp;
import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryExpProvider;
import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryLevel;
import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryLevelProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.EfficientMarksmanUpgrade;
import com.daltoncash.mmostats.capabilities.archery.upgrades.EfficientMarksmanUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.HunterUpgrade;
import com.daltoncash.mmostats.capabilities.archery.upgrades.HunterUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.InsecurityUpgrade;
import com.daltoncash.mmostats.capabilities.archery.upgrades.InsecurityUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.LeftClickUpgrade;
import com.daltoncash.mmostats.capabilities.archery.upgrades.LeftClickUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.QuickshotUpgrade;
import com.daltoncash.mmostats.capabilities.archery.upgrades.QuickshotUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.SharpshooterUpgrade;
import com.daltoncash.mmostats.capabilities.archery.upgrades.SharpshooterUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.SniperUpgrade;
import com.daltoncash.mmostats.capabilities.archery.upgrades.SniperUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.SweetSpotArcheryUpgrade;
import com.daltoncash.mmostats.capabilities.archery.upgrades.SweetSpotArcheryUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.UnabatedUpgrade;
import com.daltoncash.mmostats.capabilities.archery.upgrades.UnabatedUpgradeProvider;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingExp;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingExpProvider;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingLevel;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingLevelProvider;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.GrannySmithUpgrade;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.GrannySmithUpgradeProvider;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.HardwoodUpgrade;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.HardwoodUpgradeProvider;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.HighGroundUpgrade;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.HighGroundUpgradeProvider;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.StrongArmsUpgrade;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.StrongArmsUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatExp;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatExpProvider;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatLevel;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatLevelProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.DodgeRollUpgrade;
import com.daltoncash.mmostats.capabilities.combat.upgrades.DodgeRollUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.FreeArrowsUpgrade;
import com.daltoncash.mmostats.capabilities.combat.upgrades.FreeArrowsUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.OvercomeUpgrade;
import com.daltoncash.mmostats.capabilities.combat.upgrades.OvercomeUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.RagnorokUpgrade;
import com.daltoncash.mmostats.capabilities.combat.upgrades.RagnorokUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.StableFootingUpgrade;
import com.daltoncash.mmostats.capabilities.combat.upgrades.StableFootingUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.TakeStanceUpgrade;
import com.daltoncash.mmostats.capabilities.combat.upgrades.TakeStanceUpgradeProvider;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingExp;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingExpProvider;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingLevel;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingLevelProvider;
import com.daltoncash.mmostats.capabilities.farming.upgrades.CarnivoreUpgrade;
import com.daltoncash.mmostats.capabilities.farming.upgrades.CarnivoreUpgradeProvider;
import com.daltoncash.mmostats.capabilities.farming.upgrades.EggerUpgrade;
import com.daltoncash.mmostats.capabilities.farming.upgrades.EggerUpgradeProvider;
import com.daltoncash.mmostats.capabilities.farming.upgrades.SugarRushUpgrade;
import com.daltoncash.mmostats.capabilities.farming.upgrades.SugarRushUpgradeProvider;
import com.daltoncash.mmostats.capabilities.farming.upgrades.WellFedUpgrade;
import com.daltoncash.mmostats.capabilities.farming.upgrades.WellFedUpgradeProvider;
import com.daltoncash.mmostats.capabilities.magic.PlayerMagicExp;
import com.daltoncash.mmostats.capabilities.magic.PlayerMagicExpProvider;
import com.daltoncash.mmostats.capabilities.magic.PlayerMagicLevel;
import com.daltoncash.mmostats.capabilities.magic.PlayerMagicLevelProvider;
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
import com.daltoncash.mmostats.capabilities.playerlevel.PlayerLevel;
import com.daltoncash.mmostats.capabilities.playerlevel.PlayerLevelExp;
import com.daltoncash.mmostats.capabilities.playerlevel.PlayerLevelExpProvider;
import com.daltoncash.mmostats.capabilities.playerlevel.PlayerLevelProvider;
import com.daltoncash.mmostats.capabilities.playerlevel.stats.mana.PlayerMana;
import com.daltoncash.mmostats.capabilities.playerlevel.stats.mana.PlayerManaProvider;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsExp;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsExpProvider;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsLevel;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsLevelProvider;
import com.daltoncash.mmostats.capabilities.swords.upgrades.CritasticUpgrade;
import com.daltoncash.mmostats.capabilities.swords.upgrades.CritasticUpgradeProvider;
import com.daltoncash.mmostats.capabilities.swords.upgrades.FleshWoundUpgrade;
import com.daltoncash.mmostats.capabilities.swords.upgrades.FleshWoundUpgradeProvider;
import com.daltoncash.mmostats.capabilities.swords.upgrades.PerfectTimingUpgrade;
import com.daltoncash.mmostats.capabilities.swords.upgrades.PerfectTimingUpgradeProvider;
import com.daltoncash.mmostats.capabilities.swords.upgrades.RightClickUpgrade;
import com.daltoncash.mmostats.capabilities.swords.upgrades.RightClickUpgradeProvider;
import com.daltoncash.mmostats.capabilities.swords.upgrades.ShieldBashUpgrade;
import com.daltoncash.mmostats.capabilities.swords.upgrades.ShieldBashUpgradeProvider;
import com.daltoncash.mmostats.capabilities.swords.upgrades.SweetSpotSwordsUpgrade;
import com.daltoncash.mmostats.capabilities.swords.upgrades.SweetSpotSwordsUpgradeProvider;
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
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerLevelExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.SwordsExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.SwordsLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.magic.MagicExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.magic.MagicLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.EfficientMarksmanUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.HunterUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.InsecurityUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.LeftClickUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.QuickshotUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.SharpshooterUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.SniperUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.SweetSpotArcheryUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.UnabatedUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.GrannySmithUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.HardwoodUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.HighGroundUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.StrongArmsUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.DodgeRollUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.FreeArrowsUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.OvercomeUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.RagnorokUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.StableFootingUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.TakeStanceUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.CarnivoreUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.EggerUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.SugarRushUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.WellFedUpgradeDataSyncS2CPacket;
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
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.CritasticUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.FleshWoundUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.PerfectTimingUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.RightClickUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.ShieldBashUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.SweetSpotSwordsUpgradeDataSyncS2CPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
	//Changes attributes to the modded values on spawn
	@SubscribeEvent
	public static void onCloneAttributes(PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			event.getOriginal().getAttributes();
			
			//Core Skills
			
			event.getEntity().getAttribute(Attributes.MAX_HEALTH).setBaseValue(
					event.getOriginal().getAttributeValue(Attributes.MAX_HEALTH));
			
		}
	}
	//Changes attributes to the modded values on joining world
	@SubscribeEvent
	public static void onPlayerJoinAttributes(EntityJoinLevelEvent event) {
		if (!event.getLevel().isClientSide()) {
			if (event.getEntity() instanceof ServerPlayer player) {
				player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20 + (ClientCapabilityData.getPlayerHealth()) * 2);
				player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(.1 + (ClientCapabilityData.getPlayerAgility() / 20));
			}
		}
	}
	
	@SubscribeEvent
	public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			
			//core skills
			
			if (!event.getObject().getCapability(PlayerLevelProvider.PLAYER_LEVEL).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "playerlevelproperties"),
						new PlayerLevelProvider());
			}
			if (!event.getObject().getCapability(PlayerLevelExpProvider.PLAYER_LEVEL_EXP).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "playerlevelexpproperties"),
						new PlayerLevelExpProvider());
			}
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
			if (!event.getObject().getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "magiclevelproperties"),
						new PlayerMagicLevelProvider());
			}
			if (!event.getObject().getCapability(PlayerMagicExpProvider.PLAYER_MAGIC_EXP).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "magicexpproperties"),
						new PlayerMagicExpProvider());
			}
			
			//Archery Upgrades
			
			if (!event.getObject().getCapability(EfficientMarksmanUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "efficientmarksmanupgradeproperties"),
						new EfficientMarksmanUpgradeProvider());
			}
			if (!event.getObject().getCapability(HunterUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "hunterupgradeproperties"),
						new HunterUpgradeProvider());
			}
			if (!event.getObject().getCapability(InsecurityUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "insecurityupgradeproperties"),
						new InsecurityUpgradeProvider());
			}
			if (!event.getObject().getCapability(LeftClickUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "leftclickupgradeproperties"),
						new LeftClickUpgradeProvider());
			}
			if (!event.getObject().getCapability(QuickshotUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "quickshotupgradeproperties"),
						new QuickshotUpgradeProvider());
			}
			if (!event.getObject().getCapability(SharpshooterUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "sharpshooterupgradeproperties"),
						new SharpshooterUpgradeProvider());
			}
			if (!event.getObject().getCapability(SniperUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "sniperupgradeproperties"),
						new SniperUpgradeProvider());
			}
			if (!event.getObject().getCapability(SweetSpotArcheryUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "sweetspotarcheryupgradeproperties"),
						new SweetSpotArcheryUpgradeProvider());
			}
			if (!event.getObject().getCapability(UnabatedUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "unabatedupgradeproperties"),
						new UnabatedUpgradeProvider());
			}
			
			//Chopping Upgrades
			
			if (!event.getObject().getCapability(GrannySmithUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "grannysmithupgradeproperties"),
						new GrannySmithUpgradeProvider());
			}
			if (!event.getObject().getCapability(HardwoodUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "hardwoodupgradeproperties"),
						new HardwoodUpgradeProvider());
			}
			if (!event.getObject().getCapability(HighGroundUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "highgroundupgradeproperties"),
						new HighGroundUpgradeProvider());
			}
			if (!event.getObject().getCapability(StrongArmsUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "strongarmsupgradeproperties"),
						new StrongArmsUpgradeProvider());
			}
			
			//Combat Upgrades
			
			if (!event.getObject().getCapability(DodgeRollUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "dodgerollupgradeproperties"),
						new DodgeRollUpgradeProvider());
			}
			if (!event.getObject().getCapability(FreeArrowsUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "freearrowsupgradeproperties"),
						new FreeArrowsUpgradeProvider());
			}
			if (!event.getObject().getCapability(OvercomeUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "overcomeupgradeproperties"),
						new OvercomeUpgradeProvider());
			}
			if (!event.getObject().getCapability(RagnorokUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "ragnorokupgradeproperties"),
						new RagnorokUpgradeProvider());
			}
			if (!event.getObject().getCapability(StableFootingUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "stablefootingupgradeproperties"),
						new StableFootingUpgradeProvider());
			}
			if (!event.getObject().getCapability(TakeStanceUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "takestanceupgradeproperties"),
						new TakeStanceUpgradeProvider());
			}
			
			//Farming Upgrades
			
			if (!event.getObject().getCapability(CarnivoreUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "carnivoreupgradeproperties"),
						new CarnivoreUpgradeProvider());
			}
			if (!event.getObject().getCapability(EggerUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "eggerupgradeproperties"),
						new EggerUpgradeProvider());
			}
			if (!event.getObject().getCapability(SugarRushUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "sugarrushupgradeproperties"),
						new SugarRushUpgradeProvider());
			}
			if (!event.getObject().getCapability(WellFedUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "wellfedupgradeproperties"),
						new WellFedUpgradeProvider());
			}
			
			//Mining Upgrades
			
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
			
			//Swords Upgrades
			
			if (!event.getObject().getCapability(CritasticUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "critasticupgradeproperties"),
						new CritasticUpgradeProvider());
			}
			if (!event.getObject().getCapability(FleshWoundUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "fleshwoundupgradeproperties"),
						new FleshWoundUpgradeProvider());
			}
			if (!event.getObject().getCapability(PerfectTimingUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "perfecttimingupgradeproperties"),
						new PerfectTimingUpgradeProvider());
			}
			if (!event.getObject().getCapability(RightClickUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "rightclickupgradeproperties"),
						new RightClickUpgradeProvider());
			}
			if (!event.getObject().getCapability(ShieldBashUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "shieldbashupgradeproperties"),
						new ShieldBashUpgradeProvider());
			}
			if (!event.getObject().getCapability(SweetSpotSwordsUpgradeProvider.IS_UPGRADED).isPresent()) {
				event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "sweetspotupgradeproperties"),
						new SweetSpotSwordsUpgradeProvider());
			}
			
			//Blocks Mined
			
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
			event.getOriginal().reviveCaps();
			
			//Core Skills
			
			event.getOriginal().getCapability(PlayerLevelProvider.PLAYER_LEVEL).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerLevelProvider.PLAYER_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerLevelExpProvider.PLAYER_LEVEL_EXP).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerLevelExpProvider.PLAYER_LEVEL_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			
			event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			
			
			event.getOriginal().getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerArcheryLevelProvider.PLAYER_ARCHERY_LEVEL).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerArcheryLevelProvider.PLAYER_ARCHERY_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerArcheryExpProvider.PLAYER_ARCHERY_EXP).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerArcheryExpProvider.PLAYER_ARCHERY_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerCombatLevelProvider.PLAYER_COMBAT_LEVEL).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerCombatLevelProvider.PLAYER_COMBAT_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerCombatExpProvider.PLAYER_COMBAT_EXP).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerCombatExpProvider.PLAYER_COMBAT_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerChoppingLevelProvider.PLAYER_CHOPPING_LEVEL).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerChoppingLevelProvider.PLAYER_CHOPPING_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerChoppingExpProvider.PLAYER_CHOPPING_EXP).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerChoppingExpProvider.PLAYER_CHOPPING_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerFarmingLevelProvider.PLAYER_FARMING_LEVEL).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerFarmingLevelProvider.PLAYER_FARMING_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerFarmingExpProvider.PLAYER_FARMING_EXP).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerFarmingExpProvider.PLAYER_FARMING_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerSwordsLevelProvider.PLAYER_SWORDS_LEVEL).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerSwordsLevelProvider.PLAYER_SWORDS_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerSwordsExpProvider.PLAYER_SWORDS_EXP).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerSwordsExpProvider.PLAYER_SWORDS_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PlayerMagicExpProvider.PLAYER_MAGIC_EXP).ifPresent(oldStore -> {
				event.getEntity().getCapability(PlayerMagicExpProvider.PLAYER_MAGIC_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});

			//-------------------------Archery----Upgrades-----------------------
			
			event.getOriginal().getCapability(EfficientMarksmanUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(EfficientMarksmanUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(HunterUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(HunterUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(InsecurityUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(InsecurityUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(LeftClickUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(LeftClickUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(QuickshotUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(QuickshotUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(SharpshooterUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(SharpshooterUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(SniperUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(SniperUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(SweetSpotArcheryUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(SweetSpotArcheryUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(UnabatedUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(UnabatedUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			
			//-------------------------Chopping----Upgrades-----------------------
			
			event.getOriginal().getCapability(GrannySmithUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(GrannySmithUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(HardwoodUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(HardwoodUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(HighGroundUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(HighGroundUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(StrongArmsUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(StrongArmsUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			
			//-------------------------Combat----Upgrades-----------------------
			event.getOriginal().getCapability(DodgeRollUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(DodgeRollUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(FreeArrowsUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(FreeArrowsUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(OvercomeUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(OvercomeUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(RagnorokUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(RagnorokUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(StableFootingUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(StableFootingUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(TakeStanceUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(TakeStanceUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			
			//-------------------------Farming----Upgrades-----------------------
			
			event.getOriginal().getCapability(CarnivoreUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(CarnivoreUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(EggerUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(EggerUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(SugarRushUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(SugarRushUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(WellFedUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(WellFedUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			
			//-------------------------Mining----Upgrades-----------------------
			
			event.getOriginal().getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).ifPresent(oldStore -> {
				event.getEntity().getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(NightVisionUpgradeProvider.NIGHT_VISION).ifPresent(oldStore -> {
				event.getEntity().getCapability(NightVisionUpgradeProvider.NIGHT_VISION).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).ifPresent(oldStore -> {
				event.getEntity().getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(ObsidianBreakerUpgradeProvider.OBSIDIAN_BREAKER).ifPresent(oldStore -> {
				event.getEntity().getCapability(ObsidianBreakerUpgradeProvider.OBSIDIAN_BREAKER).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			
			//-------------------------Swords----Upgrades-----------------------
			
			event.getOriginal().getCapability(CritasticUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(CritasticUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(FleshWoundUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(FleshWoundUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(PerfectTimingUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(PerfectTimingUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(RightClickUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(RightClickUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(ShieldBashUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(ShieldBashUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(SweetSpotSwordsUpgradeProvider.IS_UPGRADED).ifPresent(oldStore -> {
				event.getEntity().getCapability(SweetSpotSwordsUpgradeProvider.IS_UPGRADED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			
			//-------------------------Blocks----Mined-----------------------
			
			event.getOriginal().getCapability(AncientDebrisMinedProvider.ANCIENT_DEBRIS_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(AncientDebrisMinedProvider.ANCIENT_DEBRIS_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(CoalMinedProvider.COAL_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(CoalMinedProvider.COAL_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(CopperMinedProvider.COPPER_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(CopperMinedProvider.COPPER_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(DiamondMinedProvider.DIAMOND_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(DiamondMinedProvider.DIAMOND_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(EmeraldMinedProvider.EMERALD_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(EmeraldMinedProvider.EMERALD_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(GlowstoneMinedProvider.GLOWSTONE_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(GlowstoneMinedProvider.GLOWSTONE_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(GoldMinedProvider.GOLD_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(GoldMinedProvider.GOLD_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(IronMinedProvider.IRON_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(IronMinedProvider.IRON_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(LapisMinedProvider.LAPIS_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(LapisMinedProvider.LAPIS_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(NetherGoldMinedProvider.NETHER_GOLD_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(NetherGoldMinedProvider.NETHER_GOLD_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(QuartzMinedProvider.QUARTZ_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(QuartzMinedProvider.QUARTZ_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
			event.getOriginal().getCapability(RedstoneMinedProvider.REDSTONE_MINED).ifPresent(oldStore -> {
				event.getEntity().getCapability(RedstoneMinedProvider.REDSTONE_MINED).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
		}
	}

	// Registers Capabilities to the forge bus
	@SubscribeEvent
	public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
		//Core Skills
		event.register(PlayerLevel.class);
		event.register(PlayerLevelExp.class);
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
		event.register(PlayerMagicLevel.class);
		event.register(PlayerMagicExp.class);
		
		//Archery Upgrades
		event.register(EfficientMarksmanUpgrade.class);
		event.register(HunterUpgrade.class);
		event.register(InsecurityUpgrade.class);
		event.register(LeftClickUpgrade.class);
		event.register(QuickshotUpgrade.class);
		event.register(SharpshooterUpgrade.class);
		event.register(SniperUpgrade.class);
		event.register(SweetSpotArcheryUpgrade.class);
		event.register(UnabatedUpgrade.class);
		
		//Chopping Upgrades
		event.register(GrannySmithUpgrade.class);
		event.register(HardwoodUpgrade.class);
		event.register(HighGroundUpgrade.class);
		event.register(StrongArmsUpgrade.class);
		
		//Combat Upgrades
		event.register(DodgeRollUpgrade.class);
		event.register(FreeArrowsUpgrade.class);
		event.register(OvercomeUpgrade.class);
		event.register(RagnorokUpgrade.class);
		event.register(StableFootingUpgrade.class);
		event.register(TakeStanceUpgrade.class);
		
		//Farming Upgrades
		event.register(CarnivoreUpgrade.class);
		event.register(EggerUpgrade.class);
		event.register(SugarRushUpgrade.class);
		event.register(WellFedUpgrade.class);
		
		//Mining Upgrades
		event.register(JunkBlocksDropExpUpgrade.class);
		event.register(NightVisionUpgrade.class);
		event.register(NoJunkBlocksUpgrade.class);
		event.register(ObsidianBreakerUpgrade.class);
		
		//Swords Upgrades
		event.register(CritasticUpgrade.class);
		event.register(FleshWoundUpgrade.class);
		event.register(PerfectTimingUpgrade.class);
		event.register(RightClickUpgrade.class);
		event.register(ShieldBashUpgrade.class);
		event.register(SweetSpotSwordsUpgrade.class);
		
		//Blocks Mined
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
				
				//Core Skills
				player.getCapability(PlayerLevelProvider.PLAYER_LEVEL).ifPresent(playerLevel -> {
					ModMessages.sendToPlayer(new PlayerLevelDataSyncS2CPacket(playerLevel.getPlayerLevel()), player);
				});
				player.getCapability(PlayerLevelExpProvider.PLAYER_LEVEL_EXP).ifPresent(playerLevelExp -> {
					ModMessages.sendToPlayer(new PlayerLevelExpDataSyncS2CPacket(playerLevelExp.getLevelExp()), player);
				});
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
				player.getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).ifPresent(magicLevel -> {
					ModMessages.sendToPlayer(new MagicLevelDataSyncS2CPacket(magicLevel.getMagicLevel()), player);
				});
				player.getCapability(PlayerMagicExpProvider.PLAYER_MAGIC_EXP).ifPresent(magicExp -> {
					ModMessages.sendToPlayer(new MagicExpDataSyncS2CPacket(magicExp.getMagicExp()), player);
				});
				
				//----Archery--Upgrades------
				player.getCapability(EfficientMarksmanUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new EfficientMarksmanUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(HunterUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new HunterUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(InsecurityUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new InsecurityUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(LeftClickUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new LeftClickUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(QuickshotUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new QuickshotUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(SharpshooterUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new SharpshooterUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(SniperUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new SniperUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(SweetSpotArcheryUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new SweetSpotArcheryUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(UnabatedUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new UnabatedUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				
				//----Chopping--Upgrades------
				player.getCapability(GrannySmithUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new GrannySmithUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(HardwoodUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new HardwoodUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(HighGroundUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new HighGroundUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(StrongArmsUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new StrongArmsUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				
				//----Combat--Upgrades------
				player.getCapability(DodgeRollUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new DodgeRollUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(FreeArrowsUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new FreeArrowsUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(OvercomeUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new OvercomeUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(RagnorokUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new RagnorokUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(StableFootingUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new StableFootingUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(TakeStanceUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new TakeStanceUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				
				//----Farming--Upgrades------
				player.getCapability(CarnivoreUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new CarnivoreUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(EggerUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new EggerUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(SugarRushUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new SugarRushUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(WellFedUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new WellFedUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				
				//----Mining--Upgrades------
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
				
				//----Swords--Upgrades------
				player.getCapability(CritasticUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new CritasticUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(FleshWoundUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new FleshWoundUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(PerfectTimingUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new PerfectTimingUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(RightClickUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new RightClickUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(ShieldBashUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new ShieldBashUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				player.getCapability(SweetSpotSwordsUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
					ModMessages.sendToPlayer(new SweetSpotSwordsUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
				});
				
				//----Blocks--Mined-------
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