package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.playerlevel.stats.health.PlayerHealthAttributeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerHealthAttributeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainPlayerHealthAttributeC2SPacket {

	public GainPlayerHealthAttributeC2SPacket() {

	}

	public GainPlayerHealthAttributeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerHealthAttributeProvider.HEALTH_LEVEL).ifPresent(playerHealthAttribute -> {
				playerHealthAttribute.addPlayerHealthAttribute(1);
				ModMessages.sendToPlayer(new PlayerHealthAttributeDataSyncS2CPacket(playerHealthAttribute.getPlayerHealthAttribute()), player);
			});
		});
		return true;
	}
}
