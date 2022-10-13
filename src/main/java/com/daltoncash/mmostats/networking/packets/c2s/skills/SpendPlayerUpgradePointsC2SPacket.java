package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.playerlevel.PlayerUpgradePointsProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerUpgradePointsDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class SpendPlayerUpgradePointsC2SPacket {

	public SpendPlayerUpgradePointsC2SPacket() {

	}

	public SpendPlayerUpgradePointsC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerUpgradePointsProvider.PLAYER_UPGRADE_POINTS).ifPresent(playerUpgradePoints -> {
				playerUpgradePoints.subPlayerUpgradePoints(1);
				System.out.println("Gained an Upgrade Point");
				ModMessages.sendToPlayer(new PlayerUpgradePointsDataSyncS2CPacket(playerUpgradePoints.getPlayerUpgradePoints()), player);
			});
		});
		return true;
	}
}
