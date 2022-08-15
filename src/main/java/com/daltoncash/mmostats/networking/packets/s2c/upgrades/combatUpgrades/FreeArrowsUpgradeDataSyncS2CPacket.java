package com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class FreeArrowsUpgradeDataSyncS2CPacket {
	private final boolean isUpgraded;

	public FreeArrowsUpgradeDataSyncS2CPacket(boolean isUpgraded) {
		this.isUpgraded = isUpgraded;
	}

	public FreeArrowsUpgradeDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.isUpgraded = buf.readBoolean();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeBoolean(isUpgraded);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setUpgradedFreeArrows(isUpgraded);
		});
		return true;
	}
}
