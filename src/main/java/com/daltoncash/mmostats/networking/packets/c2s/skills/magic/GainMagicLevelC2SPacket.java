package com.daltoncash.mmostats.networking.packets.c2s.skills.magic;

import com.daltoncash.mmostats.capabilities.magic.PlayerMagicLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.magic.MagicLevelDataSyncS2CPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GainMagicLevelC2SPacket {
    public GainMagicLevelC2SPacket() {

    }

    public GainMagicLevelC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            player.getCapability(PlayerMagicLevelProvider.PLAYER_MAGIC_LEVEL).ifPresent(MagicLevel -> {
                MagicLevel.addMagicLevel(1);
                ModMessages.sendToPlayer(new MagicLevelDataSyncS2CPacket(MagicLevel.getMagicLevel()), player);
            });
        });
        return true;
    }
}
