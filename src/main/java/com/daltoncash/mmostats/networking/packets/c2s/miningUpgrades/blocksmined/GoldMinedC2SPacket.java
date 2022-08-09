package com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.GoldMinedProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.GoldMinedDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GoldMinedC2SPacket {

	public GoldMinedC2SPacket() {

	}

	public GoldMinedC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(GoldMinedProvider.GOLD_MINED).ifPresent(total -> {
				total.addBlocksMined(1);
				ModMessages.sendToPlayer(new GoldMinedDataSyncS2CPacket(total.getBlocksMined()), player);
			});
		});
		return true;
	}
}
