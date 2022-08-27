package com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.archery.upgrades.QuickshotUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.QuickshotUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class QuickshotUpgradeC2SPacket {
	public QuickshotUpgradeC2SPacket() {

	}

	public QuickshotUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(QuickshotUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(isUpgraded.getUpgradeLevel() + 1);
				ModMessages.sendToPlayer(new QuickshotUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
		});
		return true;
	}
}
