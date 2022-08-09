package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class FarmingLevelDataSyncS2CPacket {
	private final int farmingLevel;

	public FarmingLevelDataSyncS2CPacket(int farmingLevel) {
		this.farmingLevel = farmingLevel;
	}

	public FarmingLevelDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.farmingLevel = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(farmingLevel);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerFarmingLevel(farmingLevel);
		});
		return true;
	}
}
