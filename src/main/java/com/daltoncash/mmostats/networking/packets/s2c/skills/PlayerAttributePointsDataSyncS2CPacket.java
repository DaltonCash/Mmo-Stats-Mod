package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PlayerAttributePointsDataSyncS2CPacket {
	private final int attributePoints;

	public PlayerAttributePointsDataSyncS2CPacket(int attributePoints) {
		this.attributePoints = attributePoints;
	}

	public PlayerAttributePointsDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.attributePoints = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(attributePoints);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerAttributePoints(attributePoints);
		});
		return true;
	}
}
