package com.daltoncash.mmostats.entities.client.enemies.urchin;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Urchin;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UrchinModel extends AnimatedGeoModel<Urchin>{

	@Override
	public ResourceLocation getAnimationResource(Urchin animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/urchin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Urchin object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/urchin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Urchin object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/urchin.png");
	}

}