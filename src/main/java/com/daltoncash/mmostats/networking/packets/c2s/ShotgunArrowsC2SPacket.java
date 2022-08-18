package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.network.NetworkEvent;

public class ShotgunArrowsC2SPacket {
	 public ShotgunArrowsC2SPacket() {

	 }

	 public ShotgunArrowsC2SPacket(FriendlyByteBuf buf) {

	 }

	 public void toBytes(FriendlyByteBuf buf) {

	 }

	 public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	     NetworkEvent.Context context = supplier.get();
	     context.enqueueWork(() -> {
	         // HERE WE ARE ON THE SERVER!
	         ServerPlayer player = context.getSender();
	         ServerLevel level = player.getLevel();
	         double x = player.getLookAngle().x;
	         double y = player.getLookAngle().y;
	         double z = player.getLookAngle().z;
	         EntityType.ARROW.spawn(level, null, null, player.blockPosition().offset(0, player.getEyeHeight(), 0),
	                 MobSpawnType.COMMAND, true, false).setDeltaMovement(
	                		 (x - 0.2), 
	                		 y * 2, 
	                		 z);
	         
	         
	         
	     });

	     return true;
	 }
}
