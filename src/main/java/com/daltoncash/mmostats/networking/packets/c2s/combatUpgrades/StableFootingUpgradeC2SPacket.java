package com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.combat.upgrades.StableFootingUpgrade.StableFootingUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.StableFootingUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class StableFootingUpgradeC2SPacket {
	public StableFootingUpgradeC2SPacket() {

	}

	public StableFootingUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(StableFootingUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(true);
				ModMessages.sendToPlayer(new StableFootingUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
		});
		return true;
	}
}
