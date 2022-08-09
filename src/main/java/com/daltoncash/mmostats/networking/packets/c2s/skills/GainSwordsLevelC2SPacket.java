package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.FarmingLevelDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainSwordsLevelC2SPacket {

	public GainSwordsLevelC2SPacket() {

	}

	public GainSwordsLevelC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerSwordsLevelProvider.PLAYER_SWORDS_LEVEL).ifPresent(swordsLevel -> {
				swordsLevel.addSwordsLevel(1);
				ModMessages.sendToPlayer(new FarmingLevelDataSyncS2CPacket(swordsLevel.getSwordsLevel()), player);
			});
		});
		return true;
	}
}
