package com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.chopping.upgrades.GrannySmithUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.GrannySmithUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class GrannySmithUpgradeC2SPacket {
	public GrannySmithUpgradeC2SPacket() {

	}

	public GrannySmithUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(GrannySmithUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(isUpgraded.getUpgradeLevel() + 1);
				ModMessages.sendToPlayer(new GrannySmithUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
		});
		return true;
	}
}
