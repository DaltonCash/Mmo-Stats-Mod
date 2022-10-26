package com.daltoncash.mmostats.entities.client.enemies.rat;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Rat;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RatModel extends AnimatedGeoModel<Rat>{

	@Override
	public ResourceLocation getAnimationResource(Rat animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/rat.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Rat object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/rat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Rat object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/rat.png");
	}

}