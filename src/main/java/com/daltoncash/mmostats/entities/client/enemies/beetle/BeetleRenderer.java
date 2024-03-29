package com.daltoncash.mmostats.entities.client.enemies.beetle;

import com.daltoncash.mmostats.entities.mod_entities.enemies.Beetle;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BeetleRenderer extends GeoEntityRenderer<Beetle> {
	
	BeetleModel model = new BeetleModel();
	
    public BeetleRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BeetleModel());
        this.shadowRadius = 0.7f;
    }

    @Override
    public ResourceLocation getTextureLocation(Beetle instance) {
        return model.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(Beetle animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.6F, 0.6F, 0.6F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}