package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ChoppingLevelDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainChoppingLevelC2SPacket {

	public GainChoppingLevelC2SPacket() {

	}

	public GainChoppingLevelC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerChoppingLevelProvider.PLAYER_CHOPPING_LEVEL).ifPresent(choppingLevel -> {
				choppingLevel.addChoppingLevel(1);
				ModMessages.sendToPlayer(new ChoppingLevelDataSyncS2CPacket(choppingLevel.getChoppingLevel()), player);
			});
		});
		return true;
	}
}
