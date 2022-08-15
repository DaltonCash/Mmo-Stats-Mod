package com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class RedstoneMinedDataSyncS2CPacket {
	private final int total;

	public RedstoneMinedDataSyncS2CPacket(int total) {
		this.total = total;
	}

	public RedstoneMinedDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.total = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(total);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setRedstoneMined(total);
		});
		return true;
	}
}
