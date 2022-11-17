package com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses;

import com.daltoncash.mmostats.common.handler.Sounds;

import net.minecraft.sounds.SoundEvent;
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

public class ObsidianObserver extends Monster implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);
	
	
	public ObsidianObserver(EntityType<? extends Monster> p_33002_, Level p_33003_) {
		super(p_33002_, p_33003_);
	}

	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0D).
				add(Attributes.ATTACK_DAMAGE, 4.0f)
				.add(Attributes.ATTACK_KNOCKBACK, 50f)
				.add(Attributes.ARMOR, 20)
				.add(Attributes.ARMOR_TOUGHNESS, 10)
				.add(Attributes.FOLLOW_RANGE, 10)
				.add(Attributes.MOVEMENT_SPEED, 0.14f).build();
	}

	protected void registerGoals() {
	    this.goalSelector.addGoal(1, new FloatGoal(this));
	   	this.goalSelector.addGoal(2, new ObsidianObserver.ObsidianObserverAttackGoal(this));
	   	this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	   	this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	   	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public SoundEvent getAmbientSound() {
		return Sounds.obsidianobserver.get();
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<ObsidianObserver>(this, "moving", 0, this::movingAnimation));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	private <E extends IAnimatable> PlayState movingAnimation(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.obsidianobserver.walk", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.obsidianobserver.idle", true));
		return PlayState.CONTINUE;	
	} 
	 
	protected boolean shouldDespawnInPeaceful() {
		return false;
	} 
	
	public boolean removeWhenFarAway(double p_21542_) {
	      return false;
	}
	static class ObsidianObserverAttackGoal extends MeleeAttackGoal {
	      public ObsidianObserverAttackGoal(ObsidianObserver p_33822_) {
	         super(p_33822_, 1.0D, true);
	      }

	      public boolean canUse() {
	         return super.canUse();
	      }

	      protected double getAttackReachSqr(LivingEntity p_33825_) {
	         return (double)(15.0F + p_33825_.getBbWidth());
	      }
	}
}