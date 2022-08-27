package com.daltoncash.mmostats.networking.packets.c2s.swordsUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.swords.upgrades.PerfectTimingUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.PerfectTimingUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class PerfectTimingUpgradeC2SPacket {
	public PerfectTimingUpgradeC2SPacket() {

	}

	public PerfectTimingUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PerfectTimingUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(isUpgraded.getUpgradeLevel() + 1);
				ModMessages.sendToPlayer(new PerfectTimingUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
		});
		return true;
	}
}
