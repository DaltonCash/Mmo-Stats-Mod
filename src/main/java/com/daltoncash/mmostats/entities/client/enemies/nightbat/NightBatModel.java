package com.daltoncash.mmostats.entities.client.enemies.nightbat;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.NightBat;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NightBatModel extends AnimatedGeoModel<NightBat>{

	@Override
	public ResourceLocation getAnimationResource(NightBat animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/nightbat.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(NightBat object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/nightbat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NightBat object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/nightbat.png");
	}

}