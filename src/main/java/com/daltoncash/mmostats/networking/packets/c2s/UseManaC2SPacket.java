package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mana.PlayerManaProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.ManaDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class UseManaC2SPacket {

    public UseManaC2SPacket() {

    }

    public UseManaC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
                player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                    mana.subMana(2);
                    ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), player);
                });
        });
        return true;
    }
}
