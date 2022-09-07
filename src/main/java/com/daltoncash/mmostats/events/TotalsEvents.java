package com.daltoncash.mmostats.events;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.HealFromRottenFleshTotalC2SPacket;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent.PickupXp;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//This class contains the methods that "totals" impact, where applicable. This currently includes:
//FarmingTotals, MiningTotals, and ChoppingTotals.
public class TotalsEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class TotalsForgeEvents {
		private static float carryExperience = 0;
		private static int regenFromRottenFlesh = 800;
		
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			
			if(regenFromRottenFlesh > 0) {
				if(ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getRottenFleshEaten()) > 0) {
					regenFromRottenFlesh--;
					
				}
			}
			if(regenFromRottenFlesh == 0) {
				event.player.heal(event.player.getMaxHealth() / 20);
				ModMessages.sendToServer(new HealFromRottenFleshTotalC2SPacket());
				
				regenFromRottenFlesh = (1000 * 5) / (4 +
					ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getRottenFleshEaten()));
				
			}
		}
		
		@SubscribeEvent
		public static void onCritalHitGiveTotalsBuff(CriticalHitEvent event) {
			int ironMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getIronMined());
			event.setDamageModifier(1.5f * (0.1f * ironMinedLevel));
		}
		@SubscribeEvent
		public static void onGainingExpGiveTotalsBuff(PickupXp event) {
			int lapisMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getLapisMined());
			carryExperience += event.getOrb().getValue() * (lapisMinedLevel * lapisMinedLevel) / 100f;
			if(carryExperience >= 1) {
				event.getEntity().giveExperiencePoints((int)carryExperience);
				carryExperience = carryExperience % 1;
			}
		}
		@SubscribeEvent
		public static void onTakingFallDamageReduceDamage(LivingFallEvent event) {
			if(event.getEntity().getType().equals(EntityType.PLAYER)) {
				int chickenEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getChickenEaten());
				event.setDamageMultiplier(1 - (chickenEatenLevel * 5));
			}
		}
	}
}
