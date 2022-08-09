package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ArcheryLevelDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainArcheryLevelC2SPacket {

	public GainArcheryLevelC2SPacket() {

	}

	public GainArcheryLevelC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerArcheryLevelProvider.PLAYER_ARCHERY_LEVEL).ifPresent(archeryLevel -> {
				archeryLevel.addArcheryLevel(1);
				ModMessages.sendToPlayer(new ArcheryLevelDataSyncS2CPacket(archeryLevel.getArcheryLevel()), player);
			});
		});
		return true;
	}
}
