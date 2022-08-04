package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.PlayerMiningExpProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.MiningLevelDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class ResetCapabilityDataC2SPacket {
	public ResetCapabilityDataC2SPacket() {
		 
	 }

	 public ResetCapabilityDataC2SPacket(FriendlyByteBuf buf) {

	 }

	 public void toBytes(FriendlyByteBuf buf) {

	 }

	 public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	     NetworkEvent.Context context = supplier.get();
	     context.enqueueWork(() -> {
	         ServerPlayer player = context.getSender();
	             player.getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(miningExp -> {
	                 miningExp.subMiningExp(100000);
	                 ModMessages.sendToPlayer(new MiningExpDataSyncS2CPacket(miningExp.getMiningExp()), player);
	             });
	             player.getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(miningLevel -> {
	                 miningLevel.subMiningLevel(100);
	                 ModMessages.sendToPlayer(new MiningLevelDataSyncS2CPacket(miningLevel.getMiningLevel()), player);
	             });
	     });
	     return true;
	 }	
}
