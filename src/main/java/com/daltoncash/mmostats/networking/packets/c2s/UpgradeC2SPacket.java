package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

import org.lwjgl.system.windows.MSG;

import com.daltoncash.mmostats.capabilities.UpgradeCapability;
import com.daltoncash.mmostats.capabilities.mining.upgrades.JunkBlocksDropExpUpgradeProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.UpgradeS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.miningUpgrades.NoJunkBlocksDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.network.NetworkEvent;

public class UpgradeC2SPacket {
	private Capability<?> cap = JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP;
	private UpgradeS2CPacket s2cPacket;
	private MSG msg = getMSG();
	//s2cPacket(((UpgradeCapability) isUpgraded).getIsUpgraded())
	public UpgradeC2SPacket(Capability<?> cap, UpgradeS2CPacket s2cPacket) {
		this.cap = cap;
		this.setS2cPacket(s2cPacket);
	}

	private MSG getMSG() {
		return msg;
	}

	public UpgradeC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(cap).ifPresent(isUpgraded -> {
				((UpgradeCapability) isUpgraded).setIsUpgraded(true);
				ModMessages.sendToPlayer(msg, player);
			});
		});
		return true;
	}

	public void setS2cPacket(UpgradeS2CPacket s2cPacket) {
		this.s2cPacket = s2cPacket;
	}
}
