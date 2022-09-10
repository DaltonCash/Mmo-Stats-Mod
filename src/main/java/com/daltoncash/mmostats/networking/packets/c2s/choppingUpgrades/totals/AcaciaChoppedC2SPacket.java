package com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.chopping.upgrades.logsChopped.AcaciaChoppedProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.AcaciaChoppedDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class AcaciaChoppedC2SPacket {

	public AcaciaChoppedC2SPacket() {

	}

	public AcaciaChoppedC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(AcaciaChoppedProvider.TOTAL).ifPresent(total -> {
				total.addSum(1);
				ModMessages.sendToPlayer(new AcaciaChoppedDataSyncS2CPacket(total.getSum()), player);
			});
		});
		return true;
	}
}
