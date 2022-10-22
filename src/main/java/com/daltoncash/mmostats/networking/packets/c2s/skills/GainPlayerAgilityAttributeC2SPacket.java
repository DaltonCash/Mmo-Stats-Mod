package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.playerlevel.stats.agility.PlayerAgilityAttributeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerAgilityAttributeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainPlayerAgilityAttributeC2SPacket {

	public GainPlayerAgilityAttributeC2SPacket() {

	}

	public GainPlayerAgilityAttributeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerAgilityAttributeProvider.AGILITY_LEVEL).ifPresent(playerAgilityAttribute -> {
				playerAgilityAttribute.addPlayerAgilityAttribute(1);
				ModMessages.sendToPlayer(new PlayerAgilityAttributeDataSyncS2CPacket(playerAgilityAttribute.getPlayerAgilityAttribute()), player);
			});
		});
		return true;
	}
}
