package com.daltoncash.mmostats.events;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//This class contains the methods that "totals" impact, where applicable. This currently includes:
//FarmingTotals, MiningTotals, and ChoppingTotals.
public class TotalsEvents {
	@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, value = Dist.CLIENT)
	public static class TotalsForgeEvents {
		@SubscribeEvent
		public static void onCritalHitGiveTotalsBonus(CriticalHitEvent event) {
			int ironMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getIronMined());
			event.setDamageModifier(1.5f * (0.1f * ironMinedLevel));
		}
		
	}
}
