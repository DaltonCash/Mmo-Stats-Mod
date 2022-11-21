package com.daltoncash.mmostats.entities.mod_entities.enemies.minibosses;

import java.util.EnumSet;

import com.daltoncash.mmostats.common.handler.Sounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DivineTrader extends Monster implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);
	
	
	public DivineTrader(EntityType<? extends Monster> p_33002_, Level p_33003_) {
		super(p_33002_, p_33003_);
	}

	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0D)
				.add(Attributes.ATTACK_DAMAGE, 20.0f)
				.add(Attributes.ATTACK_SPEED, 0.1f)
				.add(Attributes.ATTACK_KNOCKBACK, 10f)
				.add(Attributes.FOLLOW_RANGE, 20.0d)
				.add(Attributes.ARMOR, 10)
				.add(Attributes.MOVEMENT_SPEED, 0.25f).build();
	}

	protected void registerGoals() {
	    this.goalSelector.addGoal(1, new FloatGoal(this));
	   	this.goalSelector.addGoal(2, new DivineTrader.DivineTraderAttackGoal(this));
	   	this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	   	this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	   	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public SoundEvent getAmbientSound() {
		return Sounds.divinetrader.get();
	}
	
	public SoundEvent getHurtSound(DamageSource p_34327_) {
		return SoundEvents.AMETHYST_BLOCK_CHIME;
	}
	
	protected SoundEvent getDeathSound() {
	    return SoundEvents.AMETHYST_BLOCK_BREAK;
	}
	
	
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<DivineTrader>(this, "moving", 0, this::movingAnimation));
		data.addAnimationController(new AnimationController<DivineTrader>(this, "idle", 0, this::idle));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	private <E extends IAnimatable> PlayState idle(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.divinetrader.idle", true));
		return PlayState.CONTINUE;	
	} 
	
	private <E extends IAnimatable> PlayState movingAnimation(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.divinetrader.float", true));
			return PlayState.CONTINUE;
		}
		return PlayState.CONTINUE;
	} 
	protected boolean shouldDespawnInPeaceful() {
		return false;
	} 
	
	public boolean removeWhenFarAway(double p_21542_) {
	      return false;
	}

	static class DivineTraderAttackGoal extends Goal {
	      private final DivineTrader divineTrader;
	      private int attackStep;
	      private int attackTime;

	      public DivineTraderAttackGoal(DivineTrader p_32247_) {
	         this.divineTrader = p_32247_;
	         this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	      }

	      public boolean canUse() {
	         LivingEntity livingentity = this.divineTrader.getTarget();
	         return livingentity != null && livingentity.isAlive() && this.divineTrader.canAttack(livingentity);
	      }

	      public void start() {
	         this.attackStep = 0;
	      }

	      public void stop() {
	    	  
	      }

	      public boolean requiresUpdateEveryTick() {
	         return true;
	      }

	      public void tick() {
	         --this.attackTime;
	         LivingEntity livingentity = this.divineTrader.getTarget();
	         if (livingentity != null) {
	            boolean flag = this.divineTrader.getSensing().hasLineOfSight(livingentity);
	           

	            double d0 = this.divineTrader.distanceToSqr(livingentity);
	            if (d0 < 4.0D) {
	               if (!flag) {
	                  return;
	               }

	               if (this.attackTime <= 0) {
	                  this.attackTime = 20;
	                  this.divineTrader.doHurtTarget(livingentity);
	               }

	               
	            } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
	               double d1 = livingentity.getX() - this.divineTrader.getX();
	               double d2 = livingentity.getY(0.5D) - this.divineTrader.getY(0.5D);
	               double d3 = livingentity.getZ() - this.divineTrader.getZ();
	               if (this.attackTime <= 0) {
	                  ++this.attackStep;
	                  if (this.attackStep == 1) {
	                     this.attackTime = 4;
	                  } else if (this.attackStep <= 4) {
	                     this.attackTime = 4;
	                  } else {
	                     this.attackTime = 10;
	                     this.attackStep = 0;
	                     
	                  }

	                  if (this.attackStep > 1) {
	                     double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;

	                     for(int i = 0; i < 1; ++i) {
	                    	SmallFireball smallfireball = new SmallFireball(this.divineTrader.level, this.divineTrader, this.divineTrader.getRandom().triangle(d1, 2.297D * d4), d2, this.divineTrader.getRandom().triangle(d3, 2.297D * d4));
	                    	smallfireball.setPos(smallfireball.getX(), this.divineTrader.getY(0.5D) + 0.5D, smallfireball.getZ()); 	
	                    	 
	                        this.divineTrader.level.addFreshEntity(smallfireball);
	                     }
	                  }
	               }

	            } 

	            super.tick();
	         }
	      }

		private double getFollowDistance() {
			return this.divineTrader.getAttributeValue(Attributes.FOLLOW_RANGE);
	    }
	}
}