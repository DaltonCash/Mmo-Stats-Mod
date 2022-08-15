package com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.chopping.upgrades.HardwoodUpgrade.HardwoodUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.HardwoodUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class HardwoodUpgradeC2SPacket {
	public HardwoodUpgradeC2SPacket() {

	}

	public HardwoodUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(HardwoodUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(true);
				ModMessages.sendToPlayer(new HardwoodUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
		});
		return true;
	}
}
