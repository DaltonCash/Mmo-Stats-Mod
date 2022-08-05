package com.daltoncash.mmostats.events;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.mana.PlayerMana;
import com.daltoncash.mmostats.capabilities.mana.PlayerManaProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningExp;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningExpProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningLevel;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.ManaDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.MiningLevelDataSyncS2CPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerManaProvider.PLAYER_MANA).isPresent()) {
                event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "manaproperties"), new PlayerManaProvider());
            }
            if(!event.getObject().getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).isPresent()) {
                event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "mininglevelproperties"), new PlayerMiningLevelProvider());
            }
            if(!event.getObject().getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).isPresent()) {
                event.addCapability(new ResourceLocation(MmoStatsMod.MODID, "miningexpproperties"), new PlayerMiningExpProvider());
            }
        }
    }

    //Dying usually resets Player Capabilities. This method reattaches the Capabilities to the player.
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
            event.getOriginal().getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
            event.getOriginal().getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }
    
    //Registers Capabilities to the Player
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerMana.class);
        event.register(PlayerMiningLevel.class);
        event.register(PlayerMiningExp.class);
    }
    
    //Adds Mana to the Player over time.
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                if(mana.getMana() < 10 && event.player.getRandom().nextFloat() < 0.05f) { // Once Every 10 Seconds on Avg
                    mana.addMana(1);
                    ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), ((ServerPlayer) event.player));
                }
            });
        }
    }
    
    //Applies Capabilities to the player on joining the world.
    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                    ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), player);
                });
                player.getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(miningLevel -> {
                    ModMessages.sendToPlayer(new MiningLevelDataSyncS2CPacket(miningLevel.getMiningLevel()), player);
                });
                player.getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(miningExp -> {
                    ModMessages.sendToPlayer(new MiningExpDataSyncS2CPacket(miningExp.getMiningExp()), player);
                });
            }
        }
    }
}