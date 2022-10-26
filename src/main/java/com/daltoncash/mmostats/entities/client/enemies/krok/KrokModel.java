package com.daltoncash.mmostats.entities.client.enemies.krok;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Krok;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KrokModel extends AnimatedGeoModel<Krok>{

	@Override
	public ResourceLocation getAnimationResource(Krok animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/krok.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Krok object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/krok.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Krok object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/krok.png");
	}

}