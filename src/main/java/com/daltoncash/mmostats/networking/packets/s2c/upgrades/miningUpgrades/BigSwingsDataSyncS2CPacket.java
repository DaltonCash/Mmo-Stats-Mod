package com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class BigSwingsDataSyncS2CPacket {
	private final int isUpgraded;

	public BigSwingsDataSyncS2CPacket(int isUpgraded) {
		this.isUpgraded = isUpgraded;
	}

	public BigSwingsDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.isUpgraded = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(isUpgraded);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setIsUpgradedBigSwings(isUpgraded);
		});
		return true;
	}
}
