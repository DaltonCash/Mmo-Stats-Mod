package com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.GlowstoneMinedProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.GlowstoneMinedDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GlowstoneMinedC2SPacket {

	public GlowstoneMinedC2SPacket() {

	}

	public GlowstoneMinedC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(GlowstoneMinedProvider.GLOWSTONE_MINED).ifPresent(total -> {
				total.addBlocksMined(1);
				ModMessages.sendToPlayer(new GlowstoneMinedDataSyncS2CPacket(total.getBlocksMined()), player);
			});
		});
		return true;
	}
}
