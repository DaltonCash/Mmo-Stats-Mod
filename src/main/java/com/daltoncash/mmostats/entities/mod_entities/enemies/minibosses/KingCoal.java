package com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses;

import com.daltoncash.mmostats.common.handler.Sounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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

public class KingCoal extends Monster implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);
	
	
	public KingCoal(EntityType<? extends Monster> p_33002_, Level p_33003_) {
		super(p_33002_, p_33003_);
	}

	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0D)
				.add(Attributes.ATTACK_DAMAGE, 6.0f)
				.add(Attributes.ATTACK_SPEED, 50.0f)
				.add(Attributes.ATTACK_KNOCKBACK, 3f)
				.add(Attributes.ARMOR, 10)
				.add(Attributes.ARMOR_TOUGHNESS, 2)
				.add(Attributes.MOVEMENT_SPEED, 0.42f).build();
	}
	
	protected void registerGoals() {
	    this.goalSelector.addGoal(1, new FloatGoal(this));
	   	this.goalSelector.addGoal(2, new KingCoal.KingCoalAttackGoal(this));
	   	this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	   	this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	   	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public SoundEvent getAmbientSound() {
		return Sounds.kingcoal.get();
	}
	
	public SoundEvent getHurtSound(DamageSource p_34327_) {
		return Sounds.kingcoal_hurt.get();
	}
	
	public SoundEvent getDeathSound() {
		return Sounds.kingcoal_death.get();
	}
	
	protected SoundEvent getStepSound() {
		return SoundEvents.ZOMBIE_STEP;
	}
	
	public int getExperienceReward() {
		return super.getExperienceReward() * 10;
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<KingCoal>(this, "moving", 0, this::movingAnimation));
		data.addAnimationController(new AnimationController<KingCoal>(this, "idling", 0, this::angryAnimation));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	private <E extends IAnimatable> PlayState angryAnimation(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.kingcoal.angry", true));
		return PlayState.CONTINUE;	
	} 
	
	private <E extends IAnimatable> PlayState movingAnimation(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.kingcoal.walk", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.kingcoal.idle", true));
		return PlayState.CONTINUE;	
	}
	
	protected boolean shouldDespawnInPeaceful() {
		return false;
	} 
	
	public boolean removeWhenFarAway(double p_21542_) {
	      return false;
	}
	static class KingCoalAttackGoal extends MeleeAttackGoal {
	      public KingCoalAttackGoal(KingCoal p_33822_) {
	         super(p_33822_, 1.0D, true);
	      }

	      public boolean canUse() {
	         return super.canUse();
	      }

	      protected double getAttackReachSqr(LivingEntity p_33825_) {
	         return (double)(10.0F + p_33825_.getBbWidth());
	      }
	}
}