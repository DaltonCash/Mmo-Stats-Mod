package com.daltoncash.mmostats.entities.client.llama;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.TamedLlama;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TamedLlamaModel extends AnimatedGeoModel<TamedLlama>{

	@Override
	public ResourceLocation getAnimationResource(TamedLlama animatable) {
		return new ResourceLocation(MmoStatsMod.MODID, "animations/llama.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TamedLlama object) {
		return new ResourceLocation(MmoStatsMod.MODID, "geo/llama.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TamedLlama object) {
		return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/llama/llama.png");
	}
}