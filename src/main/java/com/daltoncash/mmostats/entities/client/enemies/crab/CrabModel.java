package com.daltoncash.mmostats.entities.client.enemies.crab;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Crab;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrabModel extends AnimatedGeoModel<Crab>{

	@Override
	public ResourceLocation getAnimationResource(Crab animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/crab.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Crab object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/crab.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Crab object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/crab.png");
	}

}