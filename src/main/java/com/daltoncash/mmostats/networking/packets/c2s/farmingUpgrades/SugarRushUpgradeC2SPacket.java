package com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.farming.upgrades.SugarRushUpgradeProvider;
import com.daltoncash.mmostats.capabilities.playerlevel.PlayerUpgradePointsProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerUpgradePointsDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.SugarRushUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class SugarRushUpgradeC2SPacket {
	public SugarRushUpgradeC2SPacket() {

	}

	public SugarRushUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(SugarRushUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(isUpgraded.getUpgradeLevel() + 1);
				ModMessages.sendToPlayer(new SugarRushUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(PlayerUpgradePointsProvider.PLAYER_UPGRADE_POINTS).ifPresent(upgradePoints -> {
				upgradePoints.subPlayerUpgradePoints(1);
				ModMessages.sendToPlayer(new PlayerUpgradePointsDataSyncS2CPacket(upgradePoints.getPlayerUpgradePoints()), player);
			});
		});
		return true;
	}
}
