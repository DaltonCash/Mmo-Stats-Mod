package com.daltoncash.mmostats.entities.client;

import com.daltoncash.mmostats.entities.client.companion_goals.LookAtPlayer;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BegGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ExtendedServerListData;

public class Companion extends TamableAnimal {

	public Companion(EntityType<? extends TamableAnimal> EntityType, Level level) {
		super(EntityType, level);
	}
	
	@Override
	protected void registerGoals() {

	      this.goalSelector.addGoal(1, new LookAtPlayer(this,  Player.class, 8.0F));
	      //this.goalSelector.addGoal(1, new HeadTiltGoal(this));
	     
	}
	//animations
	public static final AnimationDefinition MOVEHEAD = AnimationDefinition.Builder.withLength(1f).addAnimation
			("undefined", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe
			(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe
			(1f, KeyframeAnimations.degreeVec(-12.45392054358581f, 1.0808891363294606f, -15.117940229032683f), AnimationChannel.Interpolations.LINEAR))).addAnimation
			("undefined", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe
			(1f, KeyframeAnimations.degreeVec(-12.45392054358581f, 1.0808891363294606f, -15.117940229033138f), AnimationChannel.Interpolations.LINEAR))).addAnimation
			("undefined", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe
			(1f, KeyframeAnimations.degreeVec(-12.45392054358581f, 1.0808891363294606f, -15.117940229032683f), AnimationChannel.Interpolations.LINEAR))).build();
	

	//end of animations
	public static AttributeSupplier.Builder createAttributes() {
	      return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.ATTACK_DAMAGE, 0.5D);
	   }

	@Override
	public AgeableMob getBreedOffspring(ServerLevel  level, AgeableMob parent) {
		return EntityInit.COMPANION.get().create(level);
	}


}
