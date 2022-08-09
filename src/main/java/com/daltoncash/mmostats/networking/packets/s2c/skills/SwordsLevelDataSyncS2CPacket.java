package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SwordsLevelDataSyncS2CPacket {
	private final int swordsLevel;

	public SwordsLevelDataSyncS2CPacket(int swordsLevel) {
		this.swordsLevel = swordsLevel;
	}

	public SwordsLevelDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.swordsLevel = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(swordsLevel);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerSwordsLevel(swordsLevel);
		});
		return true;
	}
}
