package com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.chopping.upgrades.logsChopped.OakChoppedProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.OakChoppedDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class OakChoppedC2SPacket {

	public OakChoppedC2SPacket() {

	}

	public OakChoppedC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(OakChoppedProvider.TOTAL).ifPresent(total -> {
				total.addSum(1);
				ModMessages.sendToPlayer(new OakChoppedDataSyncS2CPacket(total.getSum()), player);
			});
		});
		return true;
	}
}
