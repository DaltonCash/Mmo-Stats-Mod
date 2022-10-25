package com.daltoncash.mmostats.entities.client.enemies.mole;

import com.daltoncash.mmostats.entities.mod_entities.enemies.Mole;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MoleRenderer extends GeoEntityRenderer<Mole> {
	
	MoleModel tamedBeeModel = new MoleModel();
	
    public MoleRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MoleModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(Mole instance) {
        return tamedBeeModel.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(Mole animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}