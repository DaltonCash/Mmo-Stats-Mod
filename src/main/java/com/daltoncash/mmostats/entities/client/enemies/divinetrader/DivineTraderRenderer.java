package com.daltoncash.mmostats.entities.client.enemies.divinetrader;

import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.DivineTrader;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DivineTraderRenderer extends GeoEntityRenderer<DivineTrader> {
	
	DivineTraderModel model = new DivineTraderModel();
	
    public DivineTraderRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DivineTraderModel());
        this.shadowRadius = 0.9f;
    }

    @Override
    public ResourceLocation getTextureLocation(DivineTrader instance) {
        return model.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(DivineTrader animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}