package com.daltoncash.mmostats.entities.client.bee;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.TamedBee;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TamedBeeModel extends AnimatedGeoModel<TamedBee>{

	@Override
	public ResourceLocation getAnimationResource(TamedBee animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/bee.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TamedBee object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/bee.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TamedBee object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/bee/bee.png");
	}

}