package com.daltoncash.mmostats.entities.client.enemies.mushroomman;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.MushroomMan;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MushroomManModel extends AnimatedGeoModel<MushroomMan>{

	@Override
	public ResourceLocation getAnimationResource(MushroomMan animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/mushroomman.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MushroomMan object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/mushroomman.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MushroomMan object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/mushroomman.png");
	}

}