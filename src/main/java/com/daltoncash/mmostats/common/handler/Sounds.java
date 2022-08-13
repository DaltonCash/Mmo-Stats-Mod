package com.daltoncash.mmostats.common.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import com.daltoncash.mmostats.MmoStatsMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class Sounds {
	private static final List<SoundEvent> EVENTS = new ArrayList<>();
	
	public static final SoundEvent levelUp = makeSoundEvent("levelup.mp3");
	
	private static SoundEvent makeSoundEvent(String name) {
		
		SoundEvent event = new SoundEvent(new ResourceLocation(MmoStatsMod.MODID, "sounds/xplat_src_main_resources_assets_botania_sounds_altarcraft.ogg"));
		EVENTS.add(event);
		return event;
	}

	public static void init(BiConsumer<SoundEvent, ResourceLocation> r) {
		for (SoundEvent event : EVENTS) {
			r.accept(event, event.getLocation());
		}
	}

	private Sounds() {}
}
