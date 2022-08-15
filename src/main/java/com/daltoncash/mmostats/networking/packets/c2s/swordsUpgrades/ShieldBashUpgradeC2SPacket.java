package com.daltoncash.mmostats.networking.packets.c2s.swordsUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.swords.upgrades.ShieldBashUpgrade.ShieldBashUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.ShieldBashUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class ShieldBashUpgradeC2SPacket {
	public ShieldBashUpgradeC2SPacket() {

	}

	public ShieldBashUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(ShieldBashUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(true);
				ModMessages.sendToPlayer(new ShieldBashUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
		});
		return true;
	}
}
