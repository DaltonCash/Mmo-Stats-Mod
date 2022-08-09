package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ChoppingLevelDataSyncS2CPacket {
	private final int choppingLevel;

	public ChoppingLevelDataSyncS2CPacket(int choppingLevel) {
		this.choppingLevel = choppingLevel;
	}

	public ChoppingLevelDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.choppingLevel = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(choppingLevel);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerChoppingLevel(choppingLevel);
		});
		return true;
	}
}
