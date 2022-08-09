package com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class DiamondMinedDataSyncS2CPacket {
	private final int total;

	public DiamondMinedDataSyncS2CPacket(int total) {
		this.total = total;
	}

	public DiamondMinedDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.total = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(total);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setDiamondMined(total);
		});
		return true;
	}
}
