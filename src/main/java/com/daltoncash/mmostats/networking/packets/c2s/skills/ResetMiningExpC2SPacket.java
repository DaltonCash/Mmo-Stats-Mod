package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.PlayerMiningExpProvider;
import com.daltoncash.mmostats.events.SkillEvents.SkillForgeEvents;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningExpDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class ResetMiningExpC2SPacket {

	public ResetMiningExpC2SPacket() {

	}

	public ResetMiningExpC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(miningExp -> {
				miningExp.subMiningExp(SkillForgeEvents.expToSub);
				ModMessages.sendToPlayer(new MiningExpDataSyncS2CPacket(miningExp.getMiningExp()), player);
			});
		});
		return true;
	}
}
