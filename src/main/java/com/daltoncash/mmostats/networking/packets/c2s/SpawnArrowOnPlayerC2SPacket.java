package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;

public class SpawnArrowOnPlayerC2SPacket {
	 public SpawnArrowOnPlayerC2SPacket() {

	 }

	 public SpawnArrowOnPlayerC2SPacket(FriendlyByteBuf buf) {

	 }

	 public void toBytes(FriendlyByteBuf buf) {

	 }

	 public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	     NetworkEvent.Context context = supplier.get();
	     context.enqueueWork(() -> {
	         // HERE WE ARE ON THE SERVER!
	         ServerPlayer player = context.getSender();
	         ServerLevel level = player.getLevel();
	         double x = player.position().x;
	         double y = player.position().y;
	         double z = player.position().z;
	         
	         level.addFreshEntity(new ItemEntity(level, x, y + 2, z, new ItemStack(Items.ARROW)));
	         
	     });

	     return true;
	 }
}
