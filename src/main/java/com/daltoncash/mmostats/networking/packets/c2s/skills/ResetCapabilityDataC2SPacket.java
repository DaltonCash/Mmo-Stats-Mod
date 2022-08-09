package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.PlayerMiningExpProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningLevelProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.JunkBlocksDropExpUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NightVisionUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NoJunkBlocksUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.ObsidianBreakerUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.JunkBlocksDropExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.NightVisionDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.NoJunkBlocksDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.ObsidianBreakerDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningLevelDataSyncS2CPacket;

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
			player.getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(false);
				ModMessages.sendToPlayer(new JunkBlocksDropExpDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
			player.getCapability(NightVisionUpgradeProvider.NIGHT_VISION).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(false);
				ModMessages.sendToPlayer(new NightVisionDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
			player.getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(false);
				ModMessages.sendToPlayer(new NoJunkBlocksDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
			player.getCapability(ObsidianBreakerUpgradeProvider.OBSIDIAN_BREAKER).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(false);
				ModMessages.sendToPlayer(new ObsidianBreakerDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
			
		});
		return true;
	}
}
