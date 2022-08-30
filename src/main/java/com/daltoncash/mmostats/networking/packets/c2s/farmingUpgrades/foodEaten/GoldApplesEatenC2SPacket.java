package com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.farming.upgrades.foodsEaten.GoldApplesEatenProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.GoldApplesEatenDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GoldApplesEatenC2SPacket {

	public GoldApplesEatenC2SPacket() {

	}

	public GoldApplesEatenC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(GoldApplesEatenProvider.SUM).ifPresent(total -> {
				total.addSum(1);
				ModMessages.sendToPlayer(new GoldApplesEatenDataSyncS2CPacket(total.getSum()), player);
			});
		});
		return true;
	}
}