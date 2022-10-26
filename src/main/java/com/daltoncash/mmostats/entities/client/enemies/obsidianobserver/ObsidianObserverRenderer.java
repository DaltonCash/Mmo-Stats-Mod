package com.daltoncash.mmostats.entities.client.enemies.obsidianobserver;

import com.daltoncash.mmostats.entities.mod_entities.enemies.ObsidianObserver;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ObsidianObserverRenderer extends GeoEntityRenderer<ObsidianObserver> {
	
	ObsidianObserverModel model = new ObsidianObserverModel();
	
    public ObsidianObserverRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ObsidianObserverModel());
        this.shadowRadius = 2.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(ObsidianObserver instance) {
        return model.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(ObsidianObserver animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.5F, 1.5F, 1.5F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}