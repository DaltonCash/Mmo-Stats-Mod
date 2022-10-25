package com.daltoncash.mmostats.entities.client.taming.goat;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedGoat;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TamedGoatModel extends AnimatedGeoModel<TamedGoat>{

	@Override
	public ResourceLocation getAnimationResource(TamedGoat animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/goat.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TamedGoat object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/goat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TamedGoat object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/goat/goat.png");
	}

}