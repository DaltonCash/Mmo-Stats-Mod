package com.daltoncash.mmostats.entities.entitydata.render;


import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.client.Companion;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CompanionRenderer extends MobRenderer<Companion, CompanionModel<Companion>> {
	
	private static final ResourceLocation Texture = new ResourceLocation(MmoStatsMod.MODID, "textures/entities/companion_2.png");

	public CompanionRenderer(EntityRendererProvider.Context context) {
		super(context, new CompanionModel<>(context.bakeLayer(CompanionModel.LAYER_LOCATION)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Companion entity) {
		return Texture;
	}
		
	
}   