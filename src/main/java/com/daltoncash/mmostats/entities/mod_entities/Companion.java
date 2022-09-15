package com.daltoncash.mmostats.entities.mod_entities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


public class Companion extends TamableAnimal implements IAnimatable{
	 	private AnimationFactory factory = new AnimationFactory(this);

	    public Companion(EntityType<? extends TamableAnimal> entityType, Level level) {
	        super(entityType, level);
	    }
	    
	    public static AttributeSupplier setAttributes() {
	        return Animal.createMobAttributes()
	                .add(Attributes.MAX_HEALTH, 20.0D)
	                .add(Attributes.ATTACK_DAMAGE, 3.0f)
	                .add(Attributes.ATTACK_SPEED, 2.0f)
	                //float underneath this comment must be 0.135 or higher to trigger .isMoving in the "predicate" method
	                .add(Attributes.MOVEMENT_SPEED, 0.135f).build();	 
	    }
	    @Nullable
	    @Override
	    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob P_146744_) {
	    	return null;
	    
	    }
	    
	    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
	        if (event.isMoving()) {
	            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.companion.walk", true));
	            return PlayState.CONTINUE;
	        }
	        else {
	        	event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.companion.idle", true));
	        	return PlayState.CONTINUE;
	        }
	    }
	    
	    protected void registerGoals() {
	        this.goalSelector.addGoal(1, new FloatGoal(this));
	        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));
	        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
	        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
	        this.targetSelector.addGoal(7, (new HurtByTargetGoal(this)).setAlertOthers());
	        //new goals
	        this.goalSelector.addGoal(3, new FollowOwnerGoal((this), 3.0D, 4.0F, 3.99F, false));
	    }

	    @Override
	    public AnimationFactory getFactory() {
	        return this.factory;
	    }

	    protected void playStepSound(BlockPos pos, BlockState blockIn) {
	        this.playSound(SoundEvents.DRIPSTONE_BLOCK_STEP, 0.15F, 1.0F);
	    }

	    protected SoundEvent getAmbientSound() {
	        return SoundEvents.FOX_AMBIENT;
	    }

	    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	        return SoundEvents.ENDERMAN_HURT;
	    }

	    protected SoundEvent getDeathSound() {
	        return SoundEvents.DROWNED_DEATH;
	    }

	    protected float getSoundVolume() {
	        return 1.0F;
	    }

	    @Override
	    public void registerControllers(AnimationData data) {
	        data.addAnimationController(new AnimationController<Companion>(this, "controller",
	                0, this::predicate));
	    }
		
}