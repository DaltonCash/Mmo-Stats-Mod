package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PlayerManaAttributeDataSyncS2CPacket {
	private final int mana;

	public PlayerManaAttributeDataSyncS2CPacket(int mana) {
		this.mana = mana;
	}

	public PlayerManaAttributeDataSyncS2CPacket(FriendlyByteBuf buf) {
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
