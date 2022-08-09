package com.daltoncash.mmostats.networking;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.networking.packets.c2s.AdditionalFortuneProcC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainMiningLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.ResetCapabilityDataC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.ResetMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.SpawnTntC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeJunkBlocksDropExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNoJunkBlocksC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeObsidianBreakerC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.AncientDebrisMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.CoalMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.CopperMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.DiamondMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.EmeraldMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.GlowstoneMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.GoldMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.IronMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.LapisMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.NetherGoldMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.QuartzMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.RedstoneMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.s2c.ManaDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.MiningLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.JunkBlocksDropExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.NightVisionDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.NoJunkBlocksDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.ObsidianBreakerDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.AncientDebrisMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.CoalMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.CopperMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.DiamondMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.EmeraldMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.GlowstoneMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.GoldMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.IronMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.LapisMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.NetherGoldMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.QuartzMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.RedstoneMinedDataSyncS2CPacket;

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
        net.messageBuilder(SpawnTntC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SpawnTntC2SPacket::new)
				.encoder(SpawnTntC2SPacket::toBytes)
				.consumerMainThread(SpawnTntC2SPacket::handle)
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
//---------------Blocks Mined C2S-----------------------------------------------
        net.messageBuilder(AncientDebrisMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(AncientDebrisMinedC2SPacket::new)
				.encoder(AncientDebrisMinedC2SPacket::toBytes)
				.consumerMainThread(AncientDebrisMinedC2SPacket::handle)
				.add();
        net.messageBuilder(CoalMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CoalMinedC2SPacket::new)
				.encoder(CoalMinedC2SPacket::toBytes)
				.consumerMainThread(CoalMinedC2SPacket::handle)
				.add();
        net.messageBuilder(CopperMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CopperMinedC2SPacket::new)
				.encoder(CopperMinedC2SPacket::toBytes)
				.consumerMainThread(CopperMinedC2SPacket::handle)
				.add();
        net.messageBuilder(DiamondMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(DiamondMinedC2SPacket::new)
				.encoder(DiamondMinedC2SPacket::toBytes)
				.consumerMainThread(DiamondMinedC2SPacket::handle)
				.add();
        net.messageBuilder(EmeraldMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(EmeraldMinedC2SPacket::new)
				.encoder(EmeraldMinedC2SPacket::toBytes)
				.consumerMainThread(EmeraldMinedC2SPacket::handle)
				.add();
        net.messageBuilder(GlowstoneMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GlowstoneMinedC2SPacket::new)
				.encoder(GlowstoneMinedC2SPacket::toBytes)
				.consumerMainThread(GlowstoneMinedC2SPacket::handle)
				.add();
        net.messageBuilder(GoldMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
        		.decoder(GoldMinedC2SPacket::new)
        		.encoder(GoldMinedC2SPacket::toBytes)
        		.consumerMainThread(GoldMinedC2SPacket::handle)
        		.add();
        net.messageBuilder(IronMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(IronMinedC2SPacket::new)
				.encoder(IronMinedC2SPacket::toBytes)
				.consumerMainThread(IronMinedC2SPacket::handle)
				.add();
        net.messageBuilder(LapisMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(LapisMinedC2SPacket::new)
				.encoder(LapisMinedC2SPacket::toBytes)
				.consumerMainThread(LapisMinedC2SPacket::handle)
				.add();
        net.messageBuilder(NetherGoldMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(NetherGoldMinedC2SPacket::new)
				.encoder(NetherGoldMinedC2SPacket::toBytes)
				.consumerMainThread(NetherGoldMinedC2SPacket::handle)
				.add();
        net.messageBuilder(QuartzMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(QuartzMinedC2SPacket::new)
				.encoder(QuartzMinedC2SPacket::toBytes)
				.consumerMainThread(QuartzMinedC2SPacket::handle)
				.add();
        net.messageBuilder(RedstoneMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(RedstoneMinedC2SPacket::new)
				.encoder(RedstoneMinedC2SPacket::toBytes)
				.consumerMainThread(RedstoneMinedC2SPacket::handle)
				.add();
//-------------Blocks Mined S2C---------------------------------
        net.messageBuilder(AncientDebrisMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(AncientDebrisMinedDataSyncS2CPacket::new)
				.encoder(AncientDebrisMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(AncientDebrisMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(CoalMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(CoalMinedDataSyncS2CPacket::new)
				.encoder(CoalMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(CoalMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(CopperMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(CopperMinedDataSyncS2CPacket::new)
				.encoder(CopperMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(CopperMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(DiamondMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(DiamondMinedDataSyncS2CPacket::new)
				.encoder(DiamondMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(DiamondMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(EmeraldMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(EmeraldMinedDataSyncS2CPacket::new)
				.encoder(EmeraldMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(EmeraldMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(GlowstoneMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(GlowstoneMinedDataSyncS2CPacket::new)
				.encoder(GlowstoneMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(GlowstoneMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(GoldMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(GoldMinedDataSyncS2CPacket::new)
				.encoder(GoldMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(GoldMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(IronMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(IronMinedDataSyncS2CPacket::new)
				.encoder(IronMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(IronMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(LapisMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(LapisMinedDataSyncS2CPacket::new)
				.encoder(LapisMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(LapisMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(NetherGoldMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(NetherGoldMinedDataSyncS2CPacket::new)
				.encoder(NetherGoldMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(NetherGoldMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(QuartzMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(QuartzMinedDataSyncS2CPacket::new)
				.encoder(QuartzMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(QuartzMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(RedstoneMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(RedstoneMinedDataSyncS2CPacket::new)
				.encoder(RedstoneMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(RedstoneMinedDataSyncS2CPacket::handle)
				.add();
    }

    public static <MSG> void sendToServer(MSG message) {
         INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
