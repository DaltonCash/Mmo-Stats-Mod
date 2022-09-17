package com.daltoncash.mmostats.entities.client;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.TamedFrog;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TamedFrogModel extends AnimatedGeoModel<TamedFrog>{

	@Override
	public ResourceLocation getAnimationResource(TamedFrog animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/tamed_frog.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TamedFrog object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/tamed_frog.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TamedFrog object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/tamedfrog/green_frog.png");
	}

}