package com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined.NetherGoldMinedProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.blocksmined.NetherGoldMinedDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class NetherGoldMinedC2SPacket {

	public NetherGoldMinedC2SPacket() {

	}

	public NetherGoldMinedC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(NetherGoldMinedProvider.NETHER_GOLD_MINED).ifPresent(total -> {
				total.addBlocksMined(1);
				ModMessages.sendToPlayer(new NetherGoldMinedDataSyncS2CPacket(total.getBlocksMined()), player);
			});
		});
		return true;
	}
}
