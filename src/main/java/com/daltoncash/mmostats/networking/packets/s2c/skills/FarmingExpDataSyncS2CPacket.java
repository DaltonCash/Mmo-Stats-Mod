package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class FarmingExpDataSyncS2CPacket {
	private final int farmingExp;

	public FarmingExpDataSyncS2CPacket(int farmingExp) {
		this.farmingExp = farmingExp;
	}

	public FarmingExpDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.farmingExp = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(farmingExp);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerFarmingExp(farmingExp);
		});
		return true;
	}
}
