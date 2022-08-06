package com.daltoncash.mmostats.networking.packets.s2c;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ManaDataSyncS2CPacket {
	private final int mana;

	public ManaDataSyncS2CPacket(int mana) {
		this.mana = mana;
	}

	public ManaDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.mana = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(mana);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerMana(mana);
		});
		return true;
	}
}
