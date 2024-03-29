package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingExpProvider;
import com.daltoncash.mmostats.events.ModStats;
import com.daltoncash.mmostats.events.SkillEvents.SkillForgeEvents;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ChoppingExpDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainChoppingExpC2SPacket {
	
	public GainChoppingExpC2SPacket() {

	}
	public GainChoppingExpC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerChoppingExpProvider.PLAYER_CHOPPING_EXP).ifPresent(choppingExp -> {
				choppingExp.addChoppingExp(Math.round(SkillForgeEvents.expToAdd * ModStats.getChoppingModifier()));
				ModMessages.sendToPlayer(new ChoppingExpDataSyncS2CPacket(choppingExp.getChoppingExp()), player);
			});
		});
		return true;
	}
}
