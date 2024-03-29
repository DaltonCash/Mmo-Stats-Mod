package com.daltoncash.mmostats.entities.client.taming.bee;

import com.daltoncash.mmostats.entities.mod_entities.taming.TamedBee;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TamedBeeRenderer extends GeoEntityRenderer<TamedBee> {
	
	TamedBeeModel tamedBeeModel = new TamedBeeModel();
	
    public TamedBeeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TamedBeeModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(TamedBee instance) {
        return tamedBeeModel.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(TamedBee animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
