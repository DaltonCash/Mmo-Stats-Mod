package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.playerlevel.PlayerLevelExpProvider;
import com.daltoncash.mmostats.events.SkillEvents.SkillForgeEvents;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerLevelExpDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainPlayerLevelExpC2SPacket {

	public GainPlayerLevelExpC2SPacket() {

	}

	public GainPlayerLevelExpC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerLevelExpProvider.PLAYER_LEVEL_EXP).ifPresent(playerExp -> {
				playerExp.addLevelExp(SkillForgeEvents.playerLevelExpToAdd);
				System.out.println("playerExp Added! in packets");
				ModMessages.sendToPlayer(new PlayerLevelExpDataSyncS2CPacket(playerExp.getLevelExp()), player);
			});
		});
		return true;
	}
}
