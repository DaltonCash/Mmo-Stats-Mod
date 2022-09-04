package com.daltoncash.mmostats.events;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//This class contains the methods that "totals" impact, where applicable. This currently includes:
//FarmingTotals, MiningTotals, and ChoppingTotals.
public class TotalsEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class TotalsForgeEvents {
		public static int CalculateTotalsLevel(int total) {
			int i = 64;
			int totalsLevel = 0;
			while (total >= i) {
				i *= 2;
				totalsLevel++;
			}
			return totalsLevel;
		}
		@SubscribeEvent
		public static void onCritalHitGiveTotalsBonus(CriticalHitEvent event) {
			int ironMinedLevel =  CalculateTotalsLevel(ClientCapabilityData.getIronMined());
			event.setDamageModifier(1.5f * (0.1f * ironMinedLevel));
		}
		@SubscribeEvent
		public static void onfurcnces(TickEvent.ClientTickEvent event) {
			//System.out.println(ev);
		}
	}
}
