package com.daltoncash.mmostats.entities.client.enemies.krok;

import com.daltoncash.mmostats.entities.mod_entities.enemies.Krok;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class KrokRenderer extends GeoEntityRenderer<Krok> {
	
	KrokModel model = new KrokModel();
	
    public KrokRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KrokModel());
        this.shadowRadius = 0.6f;
    }

    @Override
    public ResourceLocation getTextureLocation(Krok instance) {
        return model.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(Krok animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.2F, 1.2F, 1.2F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}