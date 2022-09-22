package com.daltoncash.mmostats.networking.packets.c2s.taming;

import java.util.function.Supplier;

import com.daltoncash.mmostats.entities.ModEntityTypes;
import com.daltoncash.mmostats.events.ClientEvents.ClientForgeEvents;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraftforge.network.NetworkEvent;

public class SpawnTamedBeeC2SPacket {
	public SpawnTamedBeeC2SPacket() {

	}

	public SpawnTamedBeeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			// HERE WE ARE ON THE SERVER!
			ServerPlayer player = context.getSender();
			ServerLevel level = player.getLevel();
			((TamableAnimal) ModEntityTypes.BEE.get().spawn(level, null, player, ClientForgeEvents.tamedPosition,
					MobSpawnType.COMMAND, true, false)).tame(player);
			ClientForgeEvents.animalToBeTamedAndKilled.remove(RemovalReason.DISCARDED);

		});

		return true;
	}
}
