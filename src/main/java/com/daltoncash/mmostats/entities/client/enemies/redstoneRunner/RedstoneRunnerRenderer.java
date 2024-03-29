package com.daltoncash.mmostats.entities.client.enemies.redstoneRunner;

import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.RedstoneRunner;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RedstoneRunnerRenderer extends GeoEntityRenderer<RedstoneRunner> {
	
	RedstoneRunnerModel model = new RedstoneRunnerModel();
	
    public RedstoneRunnerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RedstoneRunnerModel());
        this.shadowRadius = 0.7f;
    }

    @Override
    public ResourceLocation getTextureLocation(RedstoneRunner instance) {
        return model.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(RedstoneRunner animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}