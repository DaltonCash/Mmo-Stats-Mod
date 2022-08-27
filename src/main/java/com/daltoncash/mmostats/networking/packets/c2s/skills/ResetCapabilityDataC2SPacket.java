package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryLevelProvider;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingExpProvider;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingLevelProvider;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatLevelProvider;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingLevelProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningExpProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningLevelProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.JunkBlocksDropExpUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NightVisionUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NoJunkBlocksUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.ObsidianBreakerUpgradeProvider;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ArcheryLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ChoppingExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ChoppingLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.CombatLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.FarmingLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.SwordsLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.JunkBlocksDropExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NightVisionDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NoJunkBlocksDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.ObsidianBreakerDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class ResetCapabilityDataC2SPacket {
	public ResetCapabilityDataC2SPacket() {

	}

	public ResetCapabilityDataC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(miningExp -> {
				miningExp.subMiningExp(100000);
				ModMessages.sendToPlayer(new MiningExpDataSyncS2CPacket(miningExp.getMiningExp()), player);
			});
			player.getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(miningLevel -> {
				miningLevel.subMiningLevel(100);
				ModMessages.sendToPlayer(new MiningLevelDataSyncS2CPacket(miningLevel.getMiningLevel()), player);
			});
			player.getCapability(PlayerArcheryLevelProvider.PLAYER_ARCHERY_LEVEL).ifPresent(archeryLevel -> {
				archeryLevel.subArcheryLevel(100);
				ModMessages.sendToPlayer(new ArcheryLevelDataSyncS2CPacket(archeryLevel.getArcheryLevel()), player);
			});
			player.getCapability(PlayerChoppingLevelProvider.PLAYER_CHOPPING_LEVEL).ifPresent(choppingLevel -> {
				choppingLevel.subChoppingLevel(100);
				ModMessages.sendToPlayer(new ChoppingLevelDataSyncS2CPacket(choppingLevel.getChoppingLevel()), player);
			});
			player.getCapability(PlayerCombatLevelProvider.PLAYER_COMBAT_LEVEL).ifPresent(combatLevel -> {
				combatLevel.subCombatLevel(100);
				ModMessages.sendToPlayer(new CombatLevelDataSyncS2CPacket(combatLevel.getCombatLevel()), player);
			});
			player.getCapability(PlayerFarmingLevelProvider.PLAYER_FARMING_LEVEL).ifPresent(farmingLevel -> {
				farmingLevel.subFarmingLevel(100);
				ModMessages.sendToPlayer(new FarmingLevelDataSyncS2CPacket(farmingLevel.getFarmingLevel()), player);
			});
			player.getCapability(PlayerSwordsLevelProvider.PLAYER_SWORDS_LEVEL).ifPresent(swordsLevel -> {
				swordsLevel.subSwordsLevel(100);
				ModMessages.sendToPlayer(new SwordsLevelDataSyncS2CPacket(swordsLevel.getSwordsLevel()), player);
			});
			player.getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new JunkBlocksDropExpDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(NightVisionUpgradeProvider.NIGHT_VISION).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new NightVisionDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new NoJunkBlocksDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(ObsidianBreakerUpgradeProvider.OBSIDIAN_BREAKER).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new ObsidianBreakerDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(PlayerChoppingExpProvider.PLAYER_CHOPPING_EXP).ifPresent(choppingExp -> {
				choppingExp.subChoppingExp(10000);
				ModMessages.sendToPlayer(new ChoppingExpDataSyncS2CPacket(choppingExp.getChoppingExp()), player);
			});
			
		});
		return true;
	}
}
