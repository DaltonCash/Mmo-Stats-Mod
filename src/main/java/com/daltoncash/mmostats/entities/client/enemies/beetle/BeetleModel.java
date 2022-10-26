package com.daltoncash.mmostats.entities.client.enemies.beetle;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Beetle;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BeetleModel extends AnimatedGeoModel<Beetle>{

	@Override
	public ResourceLocation getAnimationResource(Beetle animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/beetle.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Beetle object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/beetle.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Beetle object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/beetle.png");
	}

}