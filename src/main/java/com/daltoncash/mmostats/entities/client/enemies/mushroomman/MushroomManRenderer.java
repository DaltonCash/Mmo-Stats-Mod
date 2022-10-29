package com.daltoncash.mmostats.entities.client.enemies.mushroomman;

import com.daltoncash.mmostats.entities.mod_entities.enemies.MushroomMan;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MushroomManRenderer extends GeoEntityRenderer<MushroomMan> {
	
	MushroomManModel model = new MushroomManModel();
	
    public MushroomManRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MushroomManModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(MushroomMan instance) {
        return model.getTextureResource(instance);
    }

    @Override
    public RenderType getRenderType(MushroomMan animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
