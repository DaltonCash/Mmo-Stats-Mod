package com.daltoncash.mmostats.networking.packets.s2c.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class CombatLevelDataSyncS2CPacket {
	private final int combatLevel;

	public CombatLevelDataSyncS2CPacket(int combatLevel) {
		this.combatLevel = combatLevel;
	}

	public CombatLevelDataSyncS2CPacket(FriendlyByteBuf buf) {
		this.combatLevel = buf.readInt();
	}

	public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(combatLevel);
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ClientCapabilityData.setPlayerCombatLevel(combatLevel);
		});
		return true;
	}
}
