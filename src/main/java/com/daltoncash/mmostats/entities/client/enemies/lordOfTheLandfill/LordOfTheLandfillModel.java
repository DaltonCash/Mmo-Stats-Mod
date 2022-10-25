package com.daltoncash.mmostats.entities.client.enemies.lordOfTheLandfill;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.LordOfTheLandfill;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LordOfTheLandfillModel extends AnimatedGeoModel<LordOfTheLandfill>{

	@Override
	public ResourceLocation getAnimationResource(LordOfTheLandfill animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/lordofthelandfill.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LordOfTheLandfill object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/lordofthelandfill.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LordOfTheLandfill object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/lordofthelandfill.png");
	}

}