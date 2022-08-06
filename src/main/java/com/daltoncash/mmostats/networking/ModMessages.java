package com.daltoncash.mmostats.networking;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.networking.packets.c2s.AdditionalFortuneProcC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainMiningLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.ResetCapabilityDataC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.ResetMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeJunkBlocksDropExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNoJunkBlocksC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeObsidianBreakerC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.s2c.ManaDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.MiningLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.JunkBlocksDropExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.NightVisionDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.NoJunkBlocksDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.ObsidianBreakerDataSyncS2CPacket;

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
        //C2S
        net.messageBuilder(AdditionalFortuneProcC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(AdditionalFortuneProcC2SPacket::new)
				.encoder(AdditionalFortuneProcC2SPacket::toBytes)
				.consumerMainThread(AdditionalFortuneProcC2SPacket::handle)
				.add();
        
        net.messageBuilder(ResetMiningExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetMiningExpC2SPacket::new)
				.encoder(ResetMiningExpC2SPacket::toBytes)
				.consumerMainThread(ResetMiningExpC2SPacket::handle)
				.add();
        
        net.messageBuilder(ResetCapabilityDataC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetCapabilityDataC2SPacket::new)
				.encoder(ResetCapabilityDataC2SPacket::toBytes)
				.consumerMainThread(ResetCapabilityDataC2SPacket::handle)
				.add();
        
        net.messageBuilder(GainMiningLevelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainMiningLevelC2SPacket::new)
				.encoder(GainMiningLevelC2SPacket::toBytes)
				.consumerMainThread(GainMiningLevelC2SPacket::handle)
				.add();
        	
        net.messageBuilder(GainMiningExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
        		.decoder(GainMiningExpC2SPacket::new)
        		.encoder(GainMiningExpC2SPacket::toBytes)
        		.consumerMainThread(GainMiningExpC2SPacket::handle)
        		.add();
        
        net.messageBuilder(GainNightVisionC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(GainNightVisionC2SPacket::new)
                .encoder(GainNightVisionC2SPacket::toBytes)
                .consumerMainThread(GainNightVisionC2SPacket::handle)
                .add();
//--------------S2C----------------------------------------------------
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
//-------------Upgrades---C2S--------------------------------------------
        net.messageBuilder(UpgradeJunkBlocksDropExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(UpgradeJunkBlocksDropExpC2SPacket::new)
				.encoder(UpgradeJunkBlocksDropExpC2SPacket::toBytes)
				.consumerMainThread(UpgradeJunkBlocksDropExpC2SPacket::handle)
				.add();
        net.messageBuilder(UpgradeNightVisionC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(UpgradeNightVisionC2SPacket::new)
				.encoder(UpgradeNightVisionC2SPacket::toBytes)
				.consumerMainThread(UpgradeNightVisionC2SPacket::handle)
				.add();
        net.messageBuilder(UpgradeNoJunkBlocksC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(UpgradeNoJunkBlocksC2SPacket::new)
				.encoder(UpgradeNoJunkBlocksC2SPacket::toBytes)
				.consumerMainThread(UpgradeNoJunkBlocksC2SPacket::handle)
				.add();
        net.messageBuilder(UpgradeObsidianBreakerC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(UpgradeObsidianBreakerC2SPacket::new)
				.encoder(UpgradeObsidianBreakerC2SPacket::toBytes)
				.consumerMainThread(UpgradeObsidianBreakerC2SPacket::handle)
				.add();
//-------------Upgrades---S2C--------------------------------------------
        net.messageBuilder(JunkBlocksDropExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(JunkBlocksDropExpDataSyncS2CPacket::new)
				.encoder(JunkBlocksDropExpDataSyncS2CPacket::toBytes)
				.consumerMainThread(JunkBlocksDropExpDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(NightVisionDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(NightVisionDataSyncS2CPacket::new)
				.encoder(NightVisionDataSyncS2CPacket::toBytes)
				.consumerMainThread(NightVisionDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(NoJunkBlocksDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(NoJunkBlocksDataSyncS2CPacket::new)
				.encoder(NoJunkBlocksDataSyncS2CPacket::toBytes)
				.consumerMainThread(NoJunkBlocksDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(ObsidianBreakerDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(ObsidianBreakerDataSyncS2CPacket::new)
				.encoder(ObsidianBreakerDataSyncS2CPacket::toBytes)
				.consumerMainThread(ObsidianBreakerDataSyncS2CPacket::handle)
				.add();
    }

    public static <MSG> void sendToServer(MSG message) {
         INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
