package com.daltoncash.mmostats.entities.client;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.Companion;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CompanionRenderer extends GeoEntityRenderer<Companion> {
    public CompanionRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CompanionModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(Companion instance) {
        return new ResourceLocation(MmoStatsMod.MODID, "textures/entities/companion/companion.tex.png");
    }

    @Override
    public RenderType getRenderType(Companion animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}