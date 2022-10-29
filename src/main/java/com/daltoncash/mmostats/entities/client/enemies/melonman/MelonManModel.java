package com.daltoncash.mmostats.entities.client.enemies.melonman;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.MelonMan;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MelonManModel extends AnimatedGeoModel<MelonMan>{

	@Override
	public ResourceLocation getAnimationResource(MelonMan animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/enemies/melonman.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MelonMan object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/enemies/melonman.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MelonMan object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/melonman.png");
	}

}