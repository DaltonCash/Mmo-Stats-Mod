package com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SweetSpotSwordsUpgradeDataSyncS2CPacket {
	private final int isUpgraded;

	public SweetSpotSwordsUpgradeDataSyncS2CPacket(int isUpgraded) {
		this.isUpgraded = isUpgraded;
	}

	public SweetSpotSwordsUpgradeDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.isUpgraded = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(isUpgraded);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setUpgradedSweetSpotSwords(isUpgraded);
		});
		return true;
	}
}
