package com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class WellFedUpgradeDataSyncS2CPacket {
	private final boolean isUpgraded;

	public WellFedUpgradeDataSyncS2CPacket(boolean isUpgraded) {
		this.isUpgraded = isUpgraded;
	}

	public WellFedUpgradeDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.isUpgraded = buf.readBoolean();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeBoolean(isUpgraded);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setUpgradedWellFed(isUpgraded);
		});
		return true;
	}
}
