package com.daltoncash.mmostats.networking.packets.s2c.skills.magic;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class MagicExpDataSyncS2CPacket {
	private final int magicExp;

	public MagicExpDataSyncS2CPacket(int magicExp) {
		this.magicExp = magicExp;
	}

	public MagicExpDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.magicExp = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(magicExp);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerMagicExp(magicExp);
		});
		return true;
	}
}
