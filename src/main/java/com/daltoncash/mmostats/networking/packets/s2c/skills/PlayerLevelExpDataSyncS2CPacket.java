package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PlayerLevelExpDataSyncS2CPacket {
	private final int playerExp;

	public PlayerLevelExpDataSyncS2CPacket(int playerExp) {
		this.playerExp = playerExp;
	}

	public PlayerLevelExpDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.playerExp = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(playerExp);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerExp(playerExp);
		});
		return true;
	}
}
