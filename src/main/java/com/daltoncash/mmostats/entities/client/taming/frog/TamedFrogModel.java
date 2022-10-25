package com.daltoncash.mmostats.entities.client.taming.frog;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedFrog;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TamedFrogModel extends AnimatedGeoModel<TamedFrog>{

	@Override
	public ResourceLocation getAnimationResource(TamedFrog animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/frog.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TamedFrog object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/frog.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TamedFrog object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/tamedfrog/green_frog.png");
	}

}