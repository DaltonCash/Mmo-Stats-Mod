package com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.upgrades.NoJunkBlocksUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NoJunkBlocksDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class UpgradeNoJunkBlocksC2SPacket {
	public UpgradeNoJunkBlocksC2SPacket() {

	}

	public UpgradeNoJunkBlocksC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(true);
				ModMessages.sendToPlayer(new NoJunkBlocksDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
		});
		return true;
	}
}
