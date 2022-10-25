package com.daltoncash.mmostats.entities.Ent_Event;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.ModEntityTypes;
import com.daltoncash.mmostats.entities.mod_entities.taming.Companion;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedBee;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedFrog;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedGoat;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedLlama;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedTurtle;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.COMPANION.get(), Companion.setAttributes());
        event.put(ModEntityTypes.TAMEDFROG.get(), TamedFrog.setAttributes());
        event.put(ModEntityTypes.LLAMA.get(), TamedLlama.setAttributes());
        event.put(ModEntityTypes.TURTLE.get(), TamedTurtle.setAttributes());
        event.put(ModEntityTypes.GOAT.get(), TamedGoat.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
    }
}
