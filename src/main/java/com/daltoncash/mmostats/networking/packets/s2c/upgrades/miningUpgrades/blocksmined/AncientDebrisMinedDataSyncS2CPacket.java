package com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class AncientDebrisMinedDataSyncS2CPacket {
	private final int total;

	public AncientDebrisMinedDataSyncS2CPacket(int total) {
		this.total = total;
	}

	public AncientDebrisMinedDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.total = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(total);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setAncientDebrisMined(total);
		});
		return true;
	}
}
