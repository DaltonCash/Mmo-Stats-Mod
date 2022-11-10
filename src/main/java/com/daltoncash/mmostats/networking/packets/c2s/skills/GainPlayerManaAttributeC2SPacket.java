package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.playerlevel.stats.mana.PlayerManaAttributeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerManaAttributeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainPlayerManaAttributeC2SPacket {

	public GainPlayerManaAttributeC2SPacket() {

	}

	public GainPlayerManaAttributeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerManaAttributeProvider.MANA_LEVEL).ifPresent(playerManaAttribute -> {
				playerManaAttribute.addPlayerManaAttribute(1);
				ModMessages.sendToPlayer(new PlayerManaAttributeDataSyncS2CPacket(playerManaAttribute.getPlayerManaAttribute()), player);
			});
		});
		return true;
	}
}
