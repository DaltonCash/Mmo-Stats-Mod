package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class CombatExpDataSyncS2CPacket {
	private final int combatExp;

	public CombatExpDataSyncS2CPacket(int combatExp) {
		this.combatExp = combatExp;
	}

	public CombatExpDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.combatExp = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(combatExp);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerCombatExp(combatExp);
		});
		return true;
	}
}
