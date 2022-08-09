package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.FarmingLevelDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainFarmingLevelC2SPacket {

	public GainFarmingLevelC2SPacket() {

	}

	public GainFarmingLevelC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerFarmingLevelProvider.PLAYER_FARMING_LEVEL).ifPresent(farmingLevel -> {
				farmingLevel.addFarmingLevel(1);
				ModMessages.sendToPlayer(new FarmingLevelDataSyncS2CPacket(farmingLevel.getFarmingLevel()), player);
			});
		});
		return true;
	}
}
