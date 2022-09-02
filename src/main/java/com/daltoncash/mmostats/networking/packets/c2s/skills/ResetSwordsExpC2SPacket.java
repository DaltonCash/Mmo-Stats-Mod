package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsExpProvider;
import com.daltoncash.mmostats.events.SkillEvents.SkillForgeEvents;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.SwordsExpDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class ResetSwordsExpC2SPacket {

	public ResetSwordsExpC2SPacket() {

	}

	public ResetSwordsExpC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerSwordsExpProvider.PLAYER_SWORDS_EXP).ifPresent(swordsExp -> {
				swordsExp.subSwordsExp(SkillForgeEvents.expToSub);
				ModMessages.sendToPlayer(new SwordsExpDataSyncS2CPacket(swordsExp.getSwordsExp()), player);
			});
		});
		return true;
	}
}
