package com.daltoncash.mmostats.entities.mod_entities.enemies;

import com.daltoncash.mmostats.common.handler.Sounds;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainArcheryExpC2SPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
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
import net.minecraft.world.level.gameevent.GameEvent;
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
				.add(Attributes.FOLLOW_RANGE, 35.0d)
				.add(Attributes.ARMOR, 10)
				.add(Attributes.MOVEMENT_SPEED, 0.25f).build();
	}

	protected void registerGoals() {
	    this.goalSelector.addGoal(1, new FloatGoal(this));
	   	this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
	   	this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	   	this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	   	this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	   	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	
	 public void kill() {
	      System.out.println("he is killed");
	      System.out.println("he is killed");
	   }
	
	public boolean hurt(DamageSource p_31113_, float p_31114_) {
		this.setHealth(Math.max(0,this.getHealth() -  p_31114_));
		if(this.getHealth() <= 0) {
			if(p_31113_.getEntity().getType().equals(EntityType.PLAYER)) {
				System.out.println(Minecraft.getInstance().getUser().getName());
				System.out.println(p_31113_.getEntity().getName().getString());
				if(Minecraft.getInstance().getUser().getName().equals(p_31113_.getEntity().getName().getString())) {
					System.out.println("bingo");
				}
			}
			
		}
		
	      return true;
	   }
	protected SoundEvent getDeathSound() {
		if(this.isDeadOrDying()) {
			
		}
	    return SoundEvents.ZOMBIE_DEATH;
	}
	public SoundEvent getAmbientSound() {
		return Sounds.divinetrader.get();
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<DivineTrader>(this, "moving", 0, this::movingAnimation));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	 private <E extends IAnimatable> PlayState movingAnimation(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.divinetrader.float", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.divinetrader.idle", true));
		return PlayState.CONTINUE;	
	 } 
}