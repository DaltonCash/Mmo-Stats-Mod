package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryExpProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ArcheryExpDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainArcheryExpC2SPacket {

	public GainArcheryExpC2SPacket() {

	}

	public GainArcheryExpC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerArcheryExpProvider.PLAYER_ARCHERY_EXP).ifPresent(archeryExp -> {
				int quartzTotalsLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getQuartzMined());
				int goldenCarrotTotalsLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGoldenCarrotsEaten());
				archeryExp.addArcheryExp(Math.round(50 * (1 + (quartzTotalsLevel * goldenCarrotTotalsLevel) / 100f)));
				ModMessages.sendToPlayer(new ArcheryExpDataSyncS2CPacket(archeryExp.getArcheryExp()), player);
			});
		});
		return true;
	}
}
