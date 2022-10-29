package com.daltoncash.mmostats.entities.client.enemies.skull;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Skull;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SkullModel extends AnimatedGeoModel<Skull>{

	@Override
	public ResourceLocation getAnimationResource(Skull animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/skull.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Skull object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/skull.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Skull object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/skull.png");
	}

}