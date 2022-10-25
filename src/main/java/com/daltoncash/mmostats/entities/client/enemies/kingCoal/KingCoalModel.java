package com.daltoncash.mmostats.entities.client.enemies.kingCoal;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.KingCoal;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KingCoalModel extends AnimatedGeoModel<KingCoal>{

	@Override
	public ResourceLocation getAnimationResource(KingCoal animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/kingcoal.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KingCoal object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/kingcoal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KingCoal object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/kingcoal.png");
	}

}