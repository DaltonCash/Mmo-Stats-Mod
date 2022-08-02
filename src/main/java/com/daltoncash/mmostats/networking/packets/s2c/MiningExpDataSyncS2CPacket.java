package com.daltoncash.mmostats.networking.packets.s2c;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class MiningExpDataSyncS2CPacket {
	private final int miningExp;

    public MiningExpDataSyncS2CPacket(int miningExp) {
        this.miningExp = miningExp;
    }

    public MiningExpDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.miningExp = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(miningExp);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientCapabilityData.setPlayerMiningExp(miningExp);
        });
        return true;
    }
}
