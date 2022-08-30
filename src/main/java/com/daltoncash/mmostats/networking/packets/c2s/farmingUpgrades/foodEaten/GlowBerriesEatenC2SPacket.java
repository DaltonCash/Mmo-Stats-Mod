package com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.farming.upgrades.foodsEaten.GlowBerriesEatenProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.GlowBerriesEatenDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GlowBerriesEatenC2SPacket {

	public GlowBerriesEatenC2SPacket() {

	}

	public GlowBerriesEatenC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(GlowBerriesEatenProvider.SUM).ifPresent(total -> {
				total.addSum(1);
				ModMessages.sendToPlayer(new GlowBerriesEatenDataSyncS2CPacket(total.getSum()), player);
			});
		});
		return true;
	}
}