package com.daltoncash.mmostats.entities.client.enemies.carrot;

import com.daltoncash.mmostats.entities.mod_entities.enemies.Carrot;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CarrotRenderer extends GeoEntityRenderer<Carrot> {
	
	CarrotModel model = new CarrotModel();
	
    public CarrotRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CarrotModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(Carrot instance) {
        return model.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(Carrot animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}