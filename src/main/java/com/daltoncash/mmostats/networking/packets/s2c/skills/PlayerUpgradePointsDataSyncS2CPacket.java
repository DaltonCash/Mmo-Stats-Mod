package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PlayerUpgradePointsDataSyncS2CPacket {
	private final int upgradePoints;

	public PlayerUpgradePointsDataSyncS2CPacket(int upgradePoints) {
		this.upgradePoints = upgradePoints;
	}

	public PlayerUpgradePointsDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.upgradePoints = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(upgradePoints);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerUpgradePoints(upgradePoints);
		});
		return true;
	}
}
