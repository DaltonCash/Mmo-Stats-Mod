package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryLevelProvider;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ArcheryLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.CombatLevelDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainCombatLevelC2SPacket {

	public GainCombatLevelC2SPacket() {

	}

	public GainCombatLevelC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerCombatLevelProvider.PLAYER_COMBAT_LEVEL).ifPresent(combatLevel -> {
				combatLevel.addCombatLevel(1);
				ModMessages.sendToPlayer(new CombatLevelDataSyncS2CPacket(combatLevel.getCombatLevel()), player);
			});
		});
		return true;
	}
}
