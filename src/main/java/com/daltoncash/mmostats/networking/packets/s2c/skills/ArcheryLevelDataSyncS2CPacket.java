package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ArcheryLevelDataSyncS2CPacket {
	private final int archeryLevel;

	public ArcheryLevelDataSyncS2CPacket(int archeryLevel) {
		this.archeryLevel = archeryLevel;
	}

	public ArcheryLevelDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.archeryLevel = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(archeryLevel);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerArcheryLevel(archeryLevel);
		});
		return true;
	}
}
