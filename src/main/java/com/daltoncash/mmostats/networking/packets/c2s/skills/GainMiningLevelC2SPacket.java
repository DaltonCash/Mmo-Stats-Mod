package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.PlayerMiningLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningLevelDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainMiningLevelC2SPacket {

	public GainMiningLevelC2SPacket() {

	}

	public GainMiningLevelC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(miningLevel -> {
				miningLevel.addMiningLevel(1);
				ModMessages.sendToPlayer(new MiningLevelDataSyncS2CPacket(miningLevel.getMiningLevel()), player);
			});
		});
		return true;
	}
}
