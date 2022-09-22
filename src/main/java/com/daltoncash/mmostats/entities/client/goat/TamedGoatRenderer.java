package com.daltoncash.mmostats.entities.client.goat;

import com.daltoncash.mmostats.entities.mod_entities.TamedGoat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TamedGoatRenderer extends GeoEntityRenderer<TamedGoat> {
	
	TamedGoatModel tamedGoatModel = new TamedGoatModel();
	
    public TamedGoatRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TamedGoatModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(TamedGoat instance) {
        return tamedGoatModel.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(TamedGoat animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
