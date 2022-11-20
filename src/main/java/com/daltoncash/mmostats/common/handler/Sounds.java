package com.daltoncash.mmostats.common.handler;


import com.daltoncash.mmostats.MmoStatsMod;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sounds {
	public static final DeferredRegister<SoundEvent> Sounds = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
			MmoStatsMod.MODID);
	
	public static final RegistryObject<SoundEvent> levelUp = createEvent("levelup");
	public static final RegistryObject<SoundEvent> beetle = createEvent("beetle");
	public static final RegistryObject<SoundEvent> beetle_hurt = createEvent("beetle_hurt");
	public static final RegistryObject<SoundEvent> beetle_death = createEvent("beetle_death");
	public static final RegistryObject<SoundEvent> carrot = createEvent("carrot");
	public static final RegistryObject<SoundEvent> carrot_hurt = createEvent("carrot_hurt");
	public static final RegistryObject<SoundEvent> carrot_death = createEvent("carrot_death");
	public static final RegistryObject<SoundEvent> crab = createEvent("crab");
	public static final RegistryObject<SoundEvent> crab_hurt = createEvent("crab_hurt");
	public static final RegistryObject<SoundEvent> crab_death = createEvent("crab_death");
	public static final RegistryObject<SoundEvent> diamonddefender = createEvent("diamonddefender");
	public static final RegistryObject<SoundEvent> diamonddefender_hurt = createEvent("diamonddefender_hurt");
	public static final RegistryObject<SoundEvent> diamonddefender_death = createEvent("diamonddefender_death");
	public static final RegistryObject<SoundEvent> divinetrader = createEvent("divinetrader");
	public static final RegistryObject<SoundEvent> kingcoal = createEvent("kingcoal");
	public static final RegistryObject<SoundEvent> kingcoal_hurt = createEvent("kingcoal_hurt");
	public static final RegistryObject<SoundEvent> kingcoal_death = createEvent("kingcoal_death");
	public static final RegistryObject<SoundEvent> krok = createEvent("krok");
	public static final RegistryObject<SoundEvent> krok_hurt = createEvent("krok_hurt");
	public static final RegistryObject<SoundEvent> krok_death = createEvent("krok_death");
	public static final RegistryObject<SoundEvent> lordofthelandfill = createEvent("lordofthelandfill");
	public static final RegistryObject<SoundEvent> obsidianobserver = createEvent("obsidianobserver");
	public static final RegistryObject<SoundEvent> obsidianobserver_hurt = createEvent("obsidianobserver_hurt");
	public static final RegistryObject<SoundEvent> obsidianobserver_death = createEvent("obsidianobserver_death");
	public static final RegistryObject<SoundEvent> rat = createEvent("squeak");
	public static final RegistryObject<SoundEvent> redstonerunner = createEvent("redstonerunner");
	public static final RegistryObject<SoundEvent> redstonerunner_hurt = createEvent("redstonerunner_hurt");
	public static final RegistryObject<SoundEvent> redstonerunner_death = createEvent("redstonerunner_death");
	
	
	private static RegistryObject<SoundEvent> createEvent(String sound) {
		return Sounds.register(sound, () -> new SoundEvent(MmoStatsMod.prefix(sound)));
	}
	
	private Sounds() {}
}
