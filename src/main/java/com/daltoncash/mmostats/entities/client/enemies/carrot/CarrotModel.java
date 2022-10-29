package com.daltoncash.mmostats.entities.client.enemies.carrot;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Carrot;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CarrotModel extends AnimatedGeoModel<Carrot>{

	@Override
	public ResourceLocation getAnimationResource(Carrot animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/carrot.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Carrot object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/carrot.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Carrot object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/carrot.png");
	}

}