package com.daltoncash.mmostats.networking.packets.s2c.skills.magic;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MagicLevelDataSyncS2CPacket {

    private final int MagicLevel;

    public MagicLevelDataSyncS2CPacket(int MagicLevel) {
        this.MagicLevel = MagicLevel;
    }

    public MagicLevelDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.MagicLevel = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(MagicLevel);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientCapabilityData.setPlayerMagicLevel(MagicLevel);
        });
        return true;
    }
    
}
