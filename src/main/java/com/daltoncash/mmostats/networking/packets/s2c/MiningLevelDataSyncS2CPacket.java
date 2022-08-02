package com.daltoncash.mmostats.networking.packets.s2c;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class MiningLevelDataSyncS2CPacket {
	private final int miningLevel;

    public MiningLevelDataSyncS2CPacket(int miningLevel) {
        this.miningLevel = miningLevel;
    }

    public MiningLevelDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.miningLevel = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(miningLevel);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientCapabilityData.setPlayerMiningLevel(miningLevel);
        });
        return true;
    }
}
