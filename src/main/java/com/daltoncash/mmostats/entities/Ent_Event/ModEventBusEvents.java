package com.daltoncash.mmostats.entities.Ent_Event;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.ModEntityTypes;
import com.daltoncash.mmostats.entities.mod_entities.Companion;
import com.daltoncash.mmostats.entities.mod_entities.TamedFrog;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.COMPANION.get(), Companion.setAttributes());
        event.put(ModEntityTypes.TAMEDFROG.get(), TamedFrog.setAttributes());
    }
}
