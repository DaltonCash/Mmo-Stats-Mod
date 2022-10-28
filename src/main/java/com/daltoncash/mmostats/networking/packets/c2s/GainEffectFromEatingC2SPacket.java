package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.List;
import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;

public class GainEffectFromEatingC2SPacket {

	public GainEffectFromEatingC2SPacket() {

	}

	public GainEffectFromEatingC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			int speedDuration = 40 * (1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getCookiesEaten()));
			int regenDuration = 3;
			
			int regenStrength = 1;
			int speedStrength = 1;
			Item foodInHand = null;
			if(player.getMainHandItem().getItem().isEdible()) {
				foodInHand = player.getMainHandItem().getItem();
			}else {
				foodInHand = player.getOffhandItem().getItem();
			}
			List<Item> meatItems = List.of(Items.COOKED_BEEF, Items.BEEF, Items.COOKED_CHICKEN, 
					Items.CHICKEN, Items.COOKED_COD, Items.COD, Items.COOKED_MUTTON, Items.MUTTON, 
					Items.COOKED_PORKCHOP, Items.PORKCHOP, Items.COOKED_RABBIT, Items.RABBIT, 
					Items.COOKED_SALMON, Items.SALMON, Items.ROTTEN_FLESH, Items.PUFFERFISH, Items.SPIDER_EYE);
			
			List<Item> sugarItems = List.of(Items.GLOW_BERRIES, Items.SWEET_BERRIES, 
					Items.HONEY_BOTTLE, Items.APPLE, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE, 
					Items.COOKIE, Items.BREAD, Items.PUMPKIN_PIE);
			
			if(meatItems.contains(foodInHand)) {
				speedStrength = 1;
				regenStrength = 2;
			}
			if(sugarItems.contains(foodInHand)) {
				speedStrength = 3;
				regenStrength = Math.max(regenStrength, 1);
				
			}
			if(ClientCapabilityData.isUpgradedSugarRush() > 0) {
				player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, speedDuration, speedStrength + ClientCapabilityData.isUpgradedSugarRush()));
			}
			if(ClientCapabilityData.isUpgradedCarnivore() > 0) {
				player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, regenDuration, regenStrength * ClientCapabilityData.isUpgradedCarnivore()));
			}
			
			//if player has upgrade
			if(ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getRabbitEaten()) > 0) {
				player.addEffect(new MobEffectInstance(MobEffects.JUMP, 3600,
						(ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getRabbitEaten()) - 1) * 2));
			}
			
			player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 180, foodInHand.getFoodProperties(new ItemStack(foodInHand), player).getNutrition()/4 - 1));
		});
		return true;
	}
}
