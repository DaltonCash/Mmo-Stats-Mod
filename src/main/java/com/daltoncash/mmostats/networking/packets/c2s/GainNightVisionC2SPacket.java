package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.playerlevel.stats.mana.PlayerManaProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.ManaDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.network.NetworkEvent;

public class GainNightVisionC2SPacket {

	public GainNightVisionC2SPacket() {

	}

	public GainNightVisionC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
				mana.subMana(10);
				player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200));
				ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), player);
			});
		});
		return true;
	}
}
