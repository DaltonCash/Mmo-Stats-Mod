package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ChoppingExpDataSyncS2CPacket {
	private final int choppingExp;

	public ChoppingExpDataSyncS2CPacket(int choppingExp) {
		this.choppingExp = choppingExp;
	}

	public ChoppingExpDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.choppingExp = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(choppingExp);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerChoppingExp(choppingExp);
		});
		return true;
	}
}
