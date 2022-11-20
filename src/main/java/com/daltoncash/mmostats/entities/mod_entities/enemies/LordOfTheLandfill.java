package com.daltoncash.mmostats.entities.mod_entities.enemies;

import com.daltoncash.mmostats.common.handler.Sounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
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

public class LordOfTheLandfill extends Monster implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);
	
	
	public LordOfTheLandfill(EntityType<? extends Monster> p_33002_, Level p_33003_) {
		super(p_33002_, p_33003_);
	}

	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D)
				.add(Attributes.ATTACK_DAMAGE, 1.0f)
				.add(Attributes.ATTACK_SPEED, 1.0f)
				.add(Attributes.ATTACK_KNOCKBACK, 0.1f)
				.add(Attributes.FOLLOW_RANGE, 35.0d)
				.add(Attributes.ARMOR, 3)
				.add(Attributes.MOVEMENT_SPEED, 0.22f).build();
	}

	protected void registerGoals() {
	    this.goalSelector.addGoal(1, new FloatGoal(this));
	   	this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
	   	this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	   	this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	   	this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	   	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public boolean doHurtTarget(Entity p_32257_) {
	      if (super.doHurtTarget(p_32257_)) {
	         if (p_32257_ instanceof LivingEntity) {
	            int i = 0;
	            if (this.level.getDifficulty() == Difficulty.NORMAL) {
	               i = 7;
	            } else if (this.level.getDifficulty() == Difficulty.HARD) {
	               i = 15;
	            }

	            if (i > 0) {
	               ((LivingEntity)p_32257_).addEffect(new MobEffectInstance(MobEffects.POISON, i * 10, 3), this);
	            }
	         }

	         return true;
	      } else {
	         return false;
	      }
	   }
	
	public SoundEvent getAmbientSound() {
		return Sounds.lordofthelandfill.get();
	}
	
	protected SoundEvent getStepSound() {
		return SoundEvents.ZOMBIE_STEP;
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<LordOfTheLandfill>(this, "moving", 0, this::movingAnimation));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	 private <E extends IAnimatable> PlayState movingAnimation(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.lordofthelandfill.walk", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.lordofthelandfill.idle", true));
		return PlayState.CONTINUE;	
	 } 
}