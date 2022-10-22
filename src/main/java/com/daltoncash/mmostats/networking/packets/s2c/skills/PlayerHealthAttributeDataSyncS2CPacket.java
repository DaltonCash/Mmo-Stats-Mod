package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PlayerHealthAttributeDataSyncS2CPacket {
	private final int health;

	public PlayerHealthAttributeDataSyncS2CPacket(int health) {
		this.health = health;
	}

	public PlayerHealthAttributeDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.health = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(health);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerHealth(health);
		});
		return true;
	}
}
