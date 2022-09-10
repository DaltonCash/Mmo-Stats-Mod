package com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class DarkOakChoppedDataSyncS2CPacket {
	private final int sum;

	public DarkOakChoppedDataSyncS2CPacket(int sum) {
		this.sum = sum;
	}

	public DarkOakChoppedDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.sum = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(sum);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setDarkOakChopped(sum);
		});
		return true;
	}
}
