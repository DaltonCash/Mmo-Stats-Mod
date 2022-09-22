package com.daltoncash.mmostats.entities.client.companion;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.Companion;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CompanionModel extends AnimatedGeoModel<Companion>{

	@Override
	public ResourceLocation getAnimationResource(Companion animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/companion.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Companion object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/companionmodel.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Companion object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/companion/companion.tex.png");
	}

}
