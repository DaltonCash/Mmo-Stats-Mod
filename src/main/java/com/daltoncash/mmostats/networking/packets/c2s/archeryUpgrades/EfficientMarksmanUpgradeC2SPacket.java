package com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.archery.upgrades.EfficientMarksmanUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.EfficientMarksmanUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class EfficientMarksmanUpgradeC2SPacket {
	public EfficientMarksmanUpgradeC2SPacket() {

	}

	public EfficientMarksmanUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(EfficientMarksmanUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(true);
				ModMessages.sendToPlayer(new EfficientMarksmanUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
		});
		return true;
	}
}
