package com.daltoncash.mmostats.entities.client.enemies.goldgolem;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.GoldGolem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoldGolemModel extends AnimatedGeoModel<GoldGolem>{

	@Override
	public ResourceLocation getAnimationResource(GoldGolem animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/goldgolem.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoldGolem object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/goldgolem.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoldGolem object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/goldgolem.png");
	}

}