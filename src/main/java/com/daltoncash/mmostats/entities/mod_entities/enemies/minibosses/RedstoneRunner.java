package com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses;

import com.daltoncash.mmostats.common.handler.Sounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class RedstoneRunner extends Monster implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);
	
	
	public RedstoneRunner(EntityType<? extends Monster> p_33002_, Level p_33003_) {
		super(p_33002_, p_33003_);
	}

	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 150.0D)
				.add(Attributes.ATTACK_DAMAGE, 3.0f)
				.add(Attributes.ATTACK_SPEED, 50.0f)
				.add(Attributes.ATTACK_KNOCKBACK, 10f)
				.add(Attributes.FOLLOW_RANGE, 50f)
				.add(Attributes.MOVEMENT_SPEED, 2f).build();
	}

	protected void registerGoals() {
	    this.goalSelector.addGoal(1, new FloatGoal(this));
	   	this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
	   	this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	   	this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	   	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	
	public SoundEvent getAmbientSound() {
		return Sounds.redstonerunner.get();
	}
	
	public SoundEvent getHurtSound(DamageSource p_34327_) {
		return Sounds.redstonerunner_hurt.get();
	}
	
	public SoundEvent getDeathSound() {
		return Sounds.redstonerunner_death.get();
	}
	
	protected SoundEvent getStepSound() {
		return SoundEvents.LEVER_CLICK;
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<RedstoneRunner>(this, "moving", 0, this::movingAnimation));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	private <E extends IAnimatable> PlayState movingAnimation(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.redstonerunner.walk", true));
			return PlayState.CONTINUE;
		}else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.redstonerunner.alternate", true));
			return PlayState.CONTINUE;	
		}
	} 
	
	protected boolean shouldDespawnInPeaceful() {
		return false;
	} 
	
	public boolean removeWhenFarAway(double p_21542_) {
	      return false;
	}
}