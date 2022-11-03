package com.daltoncash.mmostats.entities.client.enemies.obsidianobserver;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.ObsidianObserver;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ObsidianObserverModel extends AnimatedGeoModel<ObsidianObserver>{

	@Override
	public ResourceLocation getAnimationResource(ObsidianObserver animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/obsidianobserver.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ObsidianObserver object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/obsidianobserver.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ObsidianObserver object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/obsidianobserver.png");
	}

}