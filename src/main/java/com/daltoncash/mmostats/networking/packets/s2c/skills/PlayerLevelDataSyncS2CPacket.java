package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PlayerLevelDataSyncS2CPacket {
	private final int playerLevel;

	public PlayerLevelDataSyncS2CPacket(int playerLevel) {
		this.playerLevel = playerLevel;
	}

	public PlayerLevelDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.playerLevel = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(playerLevel);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerLevel(playerLevel);
		});
		return true;
	}
}
