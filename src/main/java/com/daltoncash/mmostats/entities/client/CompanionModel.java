package com.daltoncash.mmostats.entities.client;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.Companion;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CompanionModel extends AnimatedGeoModel<Companion>{

	@Override
	public ResourceLocation getAnimationResource(Companion animatable) {
		// TODO Auto-generated method stub
		return new ResourceLocation(MmoStatsMod.MODID, "models/entities/animations/companion.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Companion object) {
		// TODO Auto-generated method stub
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/companion/companion.tex.png");
	}

	@Override
	public ResourceLocation getTextureResource(Companion object) {
		// TODO Auto-generated method stub
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/companion/companion.geo.json");
	}

}
