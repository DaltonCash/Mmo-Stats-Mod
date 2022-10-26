package com.daltoncash.mmostats.entities.client.enemies.redstoneRunner;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.RedstoneRunner;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RedstoneRunnerModel extends AnimatedGeoModel<RedstoneRunner>{

	@Override
	public ResourceLocation getAnimationResource(RedstoneRunner animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/redstonerunner.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedstoneRunner object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/redstonerunner.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedstoneRunner object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/redstonerunner.png");
	}

}