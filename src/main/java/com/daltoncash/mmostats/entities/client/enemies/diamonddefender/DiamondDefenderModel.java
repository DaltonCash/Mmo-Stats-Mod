package com.daltoncash.mmostats.entities.client.enemies.diamonddefender;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.DiamondDefender;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DiamondDefenderModel extends AnimatedGeoModel<DiamondDefender>{

	@Override
	public ResourceLocation getAnimationResource(DiamondDefender animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/diamonddefender.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DiamondDefender object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/diamonddefender.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DiamondDefender object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/diamonddefender.png");
	}

}