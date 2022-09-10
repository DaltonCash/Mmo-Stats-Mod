package com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.chopping.upgrades.logsChopped.WarpedStemChoppedProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.WarpedStemChoppedDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class WarpedStemChoppedC2SPacket {

	public WarpedStemChoppedC2SPacket() {

	}

	public WarpedStemChoppedC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(WarpedStemChoppedProvider.TOTAL).ifPresent(total -> {
				total.addSum(1);
				ModMessages.sendToPlayer(new WarpedStemChoppedDataSyncS2CPacket(total.getSum()), player);
			});
		});
		return true;
	}
}
