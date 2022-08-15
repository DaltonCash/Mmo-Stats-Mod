package com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.upgrades.JunkBlocksDropExpUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.JunkBlocksDropExpDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class UpgradeJunkBlocksDropExpC2SPacket {
	public UpgradeJunkBlocksDropExpC2SPacket() {

	}

	public UpgradeJunkBlocksDropExpC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(true);
				ModMessages.sendToPlayer(new JunkBlocksDropExpDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
		});
		return true;
	}
}
