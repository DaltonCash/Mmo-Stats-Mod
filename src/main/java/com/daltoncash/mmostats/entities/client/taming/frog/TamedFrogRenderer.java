package com.daltoncash.mmostats.entities.client.taming.frog;

import com.daltoncash.mmostats.entities.mod_entities.taming.TamedFrog;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TamedFrogRenderer extends GeoEntityRenderer<TamedFrog> {
	
	TamedFrogModel tamedFrogModel = new TamedFrogModel();
	
    public TamedFrogRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TamedFrogModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(TamedFrog instance) {
        return tamedFrogModel.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(TamedFrog animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
