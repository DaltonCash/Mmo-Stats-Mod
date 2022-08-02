package com.daltoncash.mmostats.networking;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.networking.packets.c2s.GainMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.UseManaC2SPacket;
import com.daltoncash.mmostats.networking.packets.s2c.ManaDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.MiningLevelDataSyncS2CPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(MmoStatsMod.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(GainMiningExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
        		.decoder(GainMiningExpC2SPacket::new)
        		.encoder(GainMiningExpC2SPacket::toBytes)
        		.consumerMainThread(GainMiningExpC2SPacket::handle)
        		.add();
        
        net.messageBuilder(UseManaC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(UseManaC2SPacket::new)
                .encoder(UseManaC2SPacket::toBytes)
                .consumerMainThread(UseManaC2SPacket::handle)
                .add();
//------------------------------------------------------------------
        net.messageBuilder(ManaDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ManaDataSyncS2CPacket::new)
                .encoder(ManaDataSyncS2CPacket::toBytes)
                .consumerMainThread(ManaDataSyncS2CPacket::handle)
                .add();
        net.messageBuilder(MiningLevelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
        		.decoder(MiningLevelDataSyncS2CPacket::new)
        		.encoder(MiningLevelDataSyncS2CPacket::toBytes)
        		.consumerMainThread(MiningLevelDataSyncS2CPacket::handle)
        		.add();
        net.messageBuilder(MiningExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
        		.decoder(MiningExpDataSyncS2CPacket::new)
        		.encoder(MiningExpDataSyncS2CPacket::toBytes)
        		.consumerMainThread(MiningExpDataSyncS2CPacket::handle)
        		.add();
    }

    public static <MSG> void sendToServer(MSG message) {
         INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
