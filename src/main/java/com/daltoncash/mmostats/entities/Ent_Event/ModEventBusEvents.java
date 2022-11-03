package com.daltoncash.mmostats.entities.Ent_Event;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.ModEntityTypes;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Beetle;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Crab;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Krok;
import com.daltoncash.mmostats.entities.mod_entities.enemies.LordOfTheLandfill;
import com.daltoncash.mmostats.entities.mod_entities.enemies.MelonMan;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Mole;
import com.daltoncash.mmostats.entities.mod_entities.enemies.MushroomMan;
import com.daltoncash.mmostats.entities.mod_entities.enemies.NightBat;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Rat;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Skull;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Urchin;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.Carrot;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.DiamondDefender;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.DivineTrader;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.GoldGolem;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.KingCoal;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.ObsidianObserver;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.RedstoneRunner;
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
    	//Taming Entities:
        event.put(ModEntityTypes.COMPANION.get(), Companion.setAttributes());
        event.put(ModEntityTypes.TAMEDFROG.get(), TamedFrog.setAttributes());
        event.put(ModEntityTypes.LLAMA.get(), TamedLlama.setAttributes());
        event.put(ModEntityTypes.TURTLE.get(), TamedTurtle.setAttributes());
        event.put(ModEntityTypes.GOAT.get(), TamedGoat.setAttributes());
        event.put(ModEntityTypes.BEE.get(), TamedBee.setAttributes());
        //Monster Entities
        event.put(ModEntityTypes.BEETLE.get(), Beetle.setAttributes());
        event.put(ModEntityTypes.CARROT.get(), Carrot.setAttributes());
        event.put(ModEntityTypes.CRAB.get(), Crab.setAttributes());
        event.put(ModEntityTypes.DIAMONDDEFENDER.get(), DiamondDefender.setAttributes());
        event.put(ModEntityTypes.DIVINETRADER.get(), DivineTrader.setAttributes());
        event.put(ModEntityTypes.GOLDGOLEM.get(), GoldGolem.setAttributes());
        event.put(ModEntityTypes.KINGCOAL.get(), KingCoal.setAttributes());
        event.put(ModEntityTypes.KROK.get(), Krok.setAttributes());
        event.put(ModEntityTypes.LORDOFTHELANDFILL.get(), LordOfTheLandfill.setAttributes());
        event.put(ModEntityTypes.MELONMAN.get(), MelonMan.setAttributes());
        event.put(ModEntityTypes.MOLE.get(), Mole.setAttributes());
        event.put(ModEntityTypes.MUSHROOMMAN.get(), MushroomMan.setAttributes());
        event.put(ModEntityTypes.NIGHTBAT.get(), NightBat.setAttributes());
        event.put(ModEntityTypes.OBSIDIANOBSERVER.get(), ObsidianObserver.setAttributes());
        event.put(ModEntityTypes.RAT.get(), Rat.setAttributes());
        event.put(ModEntityTypes.REDSTONERUNNER.get(), RedstoneRunner.setAttributes());
        event.put(ModEntityTypes.SKULL.get(), Skull.setAttributes());
        event.put(ModEntityTypes.URCHIN.get(), Urchin.setAttributes());
        
    }
}
