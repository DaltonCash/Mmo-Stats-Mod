package com.daltoncash.mmostats.entities.client.enemies.divinetrader;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.DivineTrader;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DivineTraderModel extends AnimatedGeoModel<DivineTrader>{

	@Override
	public ResourceLocation getAnimationResource(DivineTrader animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/divinetrader.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DivineTrader object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/divinetrader.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DivineTrader object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/enemies/divinetrader.png");
	}

}