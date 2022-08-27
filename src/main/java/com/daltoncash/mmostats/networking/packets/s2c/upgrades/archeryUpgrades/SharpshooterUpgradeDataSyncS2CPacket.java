package com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SharpshooterUpgradeDataSyncS2CPacket{
	private final int isUpgraded;

	public SharpshooterUpgradeDataSyncS2CPacket(int isUpgraded) {
		this.isUpgraded = isUpgraded;
	}

	public SharpshooterUpgradeDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.isUpgraded = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(isUpgraded);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setUpgradedSharpshooter(isUpgraded);
		});
		return true;
	}
}
