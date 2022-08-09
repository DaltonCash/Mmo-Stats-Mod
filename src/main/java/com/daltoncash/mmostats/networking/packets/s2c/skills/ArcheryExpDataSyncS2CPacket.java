package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ArcheryExpDataSyncS2CPacket {
	private final int archeryExp;

	public ArcheryExpDataSyncS2CPacket(int archeryExp) {
		this.archeryExp = archeryExp;
	}

	public ArcheryExpDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.archeryExp = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(archeryExp);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerArcheryExp(archeryExp);
		});
		return true;
	}
}
