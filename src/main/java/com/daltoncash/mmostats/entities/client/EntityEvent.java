package com.daltoncash.mmostats.entities.client;

import com.daltoncash.mmostats.MmoStatsMod;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, bus = Bus.MOD)
public class EntityEvent {
	
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(EntityInit.COMPANION.get(), Companion.createAttributes().build());
		
		
	}

}
