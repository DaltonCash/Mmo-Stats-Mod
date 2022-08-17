package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

import com.daltoncash.mmostats.networking.ModMessages;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.network.NetworkEvent;

public class EatFoodWhileFullC2SPacket {

	public EatFoodWhileFullC2SPacket() {

	}

	public EatFoodWhileFullC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			if(player.getMainHandItem().isEdible()) {
				player.eat(player.level, player.getItemInHand(InteractionHand.MAIN_HAND));
				ModMessages.sendToServer(new GainEffectFromEatingC2SPacket());
			}else if(player.getOffhandItem().isEdible()) {
				player.eat(player.level, player.getItemInHand(InteractionHand.OFF_HAND));
				ModMessages.sendToServer(new GainEffectFromEatingC2SPacket());
			}
			player.getFoodData().setSaturation(
					player.getFoodData().getSaturationLevel() +
					player.getMainHandItem().getFoodProperties(player).getNutrition());
			
		});
		return true;
	}
}
