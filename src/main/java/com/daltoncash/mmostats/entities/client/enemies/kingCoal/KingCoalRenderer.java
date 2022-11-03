package com.daltoncash.mmostats.entities.client.enemies.kingCoal;
 
import com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses.KingCoal;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class KingCoalRenderer extends GeoEntityRenderer<KingCoal> {
	
	KingCoalModel model = new KingCoalModel();
	
    public KingCoalRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KingCoalModel());
        this.shadowRadius = 1f;
    }

    @Override
    public ResourceLocation getTextureLocation(KingCoal instance) {
        return model.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(KingCoal animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}