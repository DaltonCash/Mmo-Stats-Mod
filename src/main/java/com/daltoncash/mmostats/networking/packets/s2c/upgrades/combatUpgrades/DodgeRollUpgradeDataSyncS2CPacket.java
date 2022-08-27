package com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class DodgeRollUpgradeDataSyncS2CPacket {
	private final int isUpgraded;

	public DodgeRollUpgradeDataSyncS2CPacket(int isUpgraded) {
		this.isUpgraded = isUpgraded;
	}

	public DodgeRollUpgradeDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.isUpgraded = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(isUpgraded);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setUpgradedDodgeRoll(isUpgraded);
		});
		return true;
	}
}
