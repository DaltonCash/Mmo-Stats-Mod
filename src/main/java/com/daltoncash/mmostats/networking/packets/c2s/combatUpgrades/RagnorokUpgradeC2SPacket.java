package com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.combat.upgrades.RagnorokUpgrade.RagnorokUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.RagnorokUpgradeDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class RagnorokUpgradeC2SPacket {
	public RagnorokUpgradeC2SPacket() {

	}

	public RagnorokUpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(RagnorokUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setIsUpgraded(true);
				ModMessages.sendToPlayer(new RagnorokUpgradeDataSyncS2CPacket(isUpgraded.getIsUpgraded()), player);
			});
		});
		return true;
	}
}
