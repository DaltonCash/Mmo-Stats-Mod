package com.daltoncash.mmostats.entities.client.enemies.diamonddefender;

import com.daltoncash.mmostats.entities.mod_entities.enemies.DiamondDefender;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DiamondDefenderRenderer extends GeoEntityRenderer<DiamondDefender> {
	
	DiamondDefenderModel model = new DiamondDefenderModel();
	
    public DiamondDefenderRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DiamondDefenderModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(DiamondDefender instance) {
        return model.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(DiamondDefender animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.2F, 1.2F, 1.2F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
