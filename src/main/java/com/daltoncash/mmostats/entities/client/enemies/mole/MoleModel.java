package com.daltoncash.mmostats.entities.client.enemies.mole;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Mole;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MoleModel extends AnimatedGeoModel<Mole>{

	@Override
	public ResourceLocation getAnimationResource(Mole animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/mole.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Mole object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/mole.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Mole object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/mole.png");
	}

}