package com.daltoncash.mmostats.entities.client;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.TamedTurtle;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TamedTurtleModel extends AnimatedGeoModel<TamedTurtle>{

	@Override
	public ResourceLocation getAnimationResource(TamedTurtle animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/turtle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TamedTurtle object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/turtle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TamedTurtle object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/turtle/turtle.png");
	}

}