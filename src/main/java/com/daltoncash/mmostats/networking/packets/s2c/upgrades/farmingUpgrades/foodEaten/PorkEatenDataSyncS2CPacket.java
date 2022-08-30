package com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PorkEatenDataSyncS2CPacket {
	private final int sum;

	public PorkEatenDataSyncS2CPacket(int sum) {
		this.sum = sum;
	}

	public PorkEatenDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.sum = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(sum);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPorkEaten(sum);
		});
		return true;
	}
}