package com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.upgrades.NightVisionUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NightVisionDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class UpgradeNightVisionC2SPacket {
	public UpgradeNightVisionC2SPacket() {

	}

	public UpgradeNightVisionC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(NightVisionUpgradeProvider.NIGHT_VISION).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(isUpgraded.getUpgradeLevel() + 1);
				ModMessages.sendToPlayer(new NightVisionDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
		});
		return true;
	}
}
