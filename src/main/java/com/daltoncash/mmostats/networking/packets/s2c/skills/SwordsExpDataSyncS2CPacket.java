package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SwordsExpDataSyncS2CPacket {
	private final int swordsExp;

	public SwordsExpDataSyncS2CPacket(int swordsExp) {
		this.swordsExp = swordsExp;
	}

	public SwordsExpDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.swordsExp = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(swordsExp);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerSwordsExp(swordsExp);
		});
		return true;
	}
}
