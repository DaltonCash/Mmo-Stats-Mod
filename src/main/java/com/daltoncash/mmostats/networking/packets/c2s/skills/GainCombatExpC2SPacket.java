package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.combat.PlayerCombatExpProvider;
import com.daltoncash.mmostats.events.ModStats;
import com.daltoncash.mmostats.events.SkillEvents.SkillForgeEvents;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.CombatExpDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainCombatExpC2SPacket {

	public GainCombatExpC2SPacket() {

	}

	public GainCombatExpC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerCombatExpProvider.PLAYER_COMBAT_EXP).ifPresent(combatExp -> {
				
				combatExp.addCombatExp(Math.round(SkillForgeEvents.expToAdd * ModStats.getCombatModifier()));
				ModMessages.sendToPlayer(new CombatExpDataSyncS2CPacket(combatExp.getCombatExp()), player);
			});
		});
		return true;
	}
}
