package com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.archery.upgrades.UnabatedUpgrade.UnabatedUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.UnabatedUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class UnabatedUpgradeC2SPacket {
	public UnabatedUpgradeC2SPacket() {

	}

	public UnabatedUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(UnabatedUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(true);
				ModMessages.sendToPlayer(new UnabatedUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
		});
		return true;
	}
}
