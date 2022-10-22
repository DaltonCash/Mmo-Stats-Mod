package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.playerlevel.PlayerAttributePointsProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerAttributePointsDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class SpendPlayerAttributePointsC2SPacket {

	public SpendPlayerAttributePointsC2SPacket() {

	}

	public SpendPlayerAttributePointsC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerAttributePointsProvider.PLAYER_ATTRIBUTE_POINTS).ifPresent(playerAttributePoints -> {
				playerAttributePoints.subPlayerAttributePoints(1);
				ModMessages.sendToPlayer(new PlayerAttributePointsDataSyncS2CPacket(playerAttributePoints.getPlayerAttributePoints()), player);
			});
		});
		return true;
	}
}
