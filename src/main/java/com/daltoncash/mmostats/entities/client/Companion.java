package com.daltoncash.mmostats.entities.client;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Companion extends TamableAnimal {

	public Companion(EntityType<? extends TamableAnimal> EntityType, Level level) {
		super(EntityType, level);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
	      this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
	      this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
	      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
	      this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
	      this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
	      this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	      this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
	      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
	      this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
	      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
	      this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
	      this.targetSelector.addGoal(6, new NonTameRandomTargetGoal<>(this, Turtle.class, false, Turtle.BABY_ON_LAND_SELECTOR));
	      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, AbstractSkeleton.class, false));
	}
	
	public static AttributeSupplier.Builder createAttributes() {
	      return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.ATTACK_DAMAGE, 0.5D);
	   }

	@Override
	public AgeableMob getBreedOffspring(ServerLevel  level, AgeableMob parent) {
		return EntityInit.COMPANION.get().create(level);
	}
		

}
