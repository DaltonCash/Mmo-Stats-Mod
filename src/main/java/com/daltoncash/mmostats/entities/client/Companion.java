package com.daltoncash.mmostats.entities.client;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.scores.Team;
import net.minecraftforge.client.ExtendedServerListData;
import net.minecraftforge.event.ForgeEventFactory;

public class Companion extends TamableAnimal {
	   
		protected Companion(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		// TODO Auto-generated constructor stub
	}


		public static AttributeSupplier.Builder createAttributes() {
		      return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED,
		    	(double)0.3F).add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.ATTACK_DAMAGE, 0.5D);
		   }

	
	@Override
	protected void registerGoals() {
		  this.goalSelector.addGoal(1, new FloatGoal(this));
	        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));
	        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
	        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
	        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
	        this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());
	     
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
	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		// TODO Auto-generated method stub
		return null;
	}
	

	//end of animations



}
