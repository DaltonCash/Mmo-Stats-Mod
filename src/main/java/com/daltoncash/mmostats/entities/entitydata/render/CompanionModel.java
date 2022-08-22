package com.daltoncash.mmostats.entities.entitydata.render;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.client.Companion;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class CompanionModel<Type extends Companion> extends EntityModel<Type> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MmoStatsMod.MODID, "companion_model.bbmodel"), "main");
	private final ModelPart bb_main;

	public CompanionModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-2.0F, -4.0F, -8.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 13).addBox(-2.0F, -4.0F, 4.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 18).addBox(-2.0F, -3.0F, 5.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -2.0F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 0).addBox(-1.0F, -1.0F, 7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		bb_main.addOrReplaceChild("bb_main_r1", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -6.0F, -6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.2618F, 0.0F, -0.48F));

		bb_main.addOrReplaceChild("bb_main_r2", CubeListBuilder.create().texOffs(4, 3).addBox(-1.0F, -6.0F, -6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.2618F, 0.0F, 0.48F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}