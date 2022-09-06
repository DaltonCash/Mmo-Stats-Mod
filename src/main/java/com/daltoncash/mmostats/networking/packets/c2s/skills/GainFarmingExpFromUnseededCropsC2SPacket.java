package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingExpProvider;
import com.daltoncash.mmostats.events.SkillEvents.SkillForgeEvents;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.FarmingExpDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GainFarmingExpFromUnseededCropsC2SPacket {

	public GainFarmingExpFromUnseededCropsC2SPacket() {

	}

	public GainFarmingExpFromUnseededCropsC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
				player.getCapability(PlayerFarmingExpProvider.PLAYER_FARMING_EXP).ifPresent(farmingExp -> {
					int copperTotalsLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getCopperMined());
					//WIP
					int birchTotalsLevel = ClientCapabilityData.getTotalsLevel(1);
					int breadTotalsLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getBreadEaten());
					
					farmingExp.addFarmingExp(Math.round(SkillForgeEvents.expToAdd * (1 + ((copperTotalsLevel * birchTotalsLevel * breadTotalsLevel) / 100f))));
					ModMessages.sendToPlayer(new FarmingExpDataSyncS2CPacket(farmingExp.getFarmingExp()), player);
				});
		});
		return true;
	}
}
