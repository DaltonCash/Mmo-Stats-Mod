package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class HealFromRottenFleshTotalC2SPacket {

	public HealFromRottenFleshTotalC2SPacket() {

	}

	public HealFromRottenFleshTotalC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.heal(player.getMaxHealth() / 20);
		});
		return true;
	}
}
