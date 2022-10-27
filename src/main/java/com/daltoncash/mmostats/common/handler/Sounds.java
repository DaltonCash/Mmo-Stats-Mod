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
	public static final RegistryObject<SoundEvent> crab = createEvent("crab");
	public static final RegistryObject<SoundEvent> divinetrader = createEvent("divinetrader");
	public static final RegistryObject<SoundEvent> kingcoal = createEvent("kingcoal");
	public static final RegistryObject<SoundEvent> krok = createEvent("krok");
	public static final RegistryObject<SoundEvent> lordofthelandfill = createEvent("lordofthelandfill");
	public static final RegistryObject<SoundEvent> mole = createEvent("squeak");
	public static final RegistryObject<SoundEvent> obsidianobserver = createEvent("obsidianobserver");
	//public static final RegistryObject<SoundEvent> rat = createEvent("squeak");
	public static final RegistryObject<SoundEvent> redstonerunner = createEvent("redstonerunner");
	
	
	private static RegistryObject<SoundEvent> createEvent(String sound) {
		return Sounds.register(sound, () -> new SoundEvent(MmoStatsMod.prefix(sound)));
	}
	
	private Sounds() {}
}
