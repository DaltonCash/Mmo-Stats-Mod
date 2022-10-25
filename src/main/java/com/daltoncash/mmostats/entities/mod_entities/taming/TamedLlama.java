package com.daltoncash.mmostats.entities.mod_entities.taming;

import java.util.UUID;
import java.util.function.Predicate;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TamedLlama extends TamableAnimal implements IAnimatable, NeutralMob {
	private AnimationFactory factory = new AnimationFactory(this);
	private static final EntityDataAccessor<Boolean> DATA_INTERESTED_ID = SynchedEntityData.defineId(TamedLlama.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData
			.defineId(TamedLlama.class, EntityDataSerializers.INT);
	public static final Predicate<LivingEntity> PREY_SELECTOR = (p_30437_) -> {
		EntityType<?> entitytype = p_30437_.getType();
		return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT || entitytype == EntityType.FOX;
	};
	private float interestedAngle;
	private float interestedAngleO;
	private float shakeAnim;
	private float shakeAnimO;
	private int ticksToYawn;
	private int ticksToItch;
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	@Nullable
	private UUID persistentAngerTarget;

	public TamedLlama(EntityType<? extends TamedLlama> p_30369_, Level p_30370_) {
		super(p_30369_, p_30370_);
		this.setTame(false);
		this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1.0F);
		this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
	}

	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ATTACK_DAMAGE, 3.0f)
				.add(Attributes.ATTACK_SPEED, 2.0f)
				// float underneath this comment must be 0.135 or higher to trigger .isMoving in
				// the "predicate" method
				.add(Attributes.MOVEMENT_SPEED, 0.3f).build();
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.llama.walk", true));
			ticksToYawn = 0;
			return PlayState.CONTINUE;

		}else {

			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.llama.idle", true));
			return PlayState.CONTINUE;
		}
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new TamedLlama.TamedLlamaPanicGoal(1.5D));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(3, new TamedLlama.TamedLlamaAvoidEntityGoal<>(this, Llama.class, 24.0F, 1.5D, 1.5D));
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.6D, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
		this.targetSelector.addGoal(4,
				new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_INTERESTED_ID, false);
		this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
	}

	protected void playStepSound(BlockPos p_30415_, BlockState p_30416_) {
		this.playSound(SoundEvents.WARDEN_STEP, 0.15F, 1.0F);
	}

	public void addAdditionalSaveData(CompoundTag p_30418_) {
		super.addAdditionalSaveData(p_30418_);
		this.addPersistentAngerSaveData(p_30418_);
	}

	public void readAdditionalSaveData(CompoundTag p_30402_) {
		super.readAdditionalSaveData(p_30402_);
		this.readPersistentAngerSaveData(this.level, p_30402_);
	}

	protected SoundEvent getAmbientSound() {
		if (this.isAngry()) {
			return SoundEvents.ENDERMAN_AMBIENT;
		} else if (this.random.nextInt(3) == 0) {
			return this.isTame() && this.getHealth() < 10.0F ? SoundEvents.TNT_PRIMED : SoundEvents.WITCH_CELEBRATE;
		} else {
			return SoundEvents.FOX_AMBIENT;
		}
	}

	protected SoundEvent getHurtSound(DamageSource p_30424_) {
		return SoundEvents.ENDERMAN_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.STRAY_DEATH;
	}

	protected float getSoundVolume() {
		return 0.4F;
	}

	public void aiStep() {
		super.aiStep();

		if (!this.level.isClientSide) {
			this.updatePersistentAnger((ServerLevel) this.level, true);
		}

	}

	public void tick() {
		super.tick();
		if (this.isAlive()) {
			this.interestedAngleO = this.interestedAngle;
			if (this.isInterested()) {
				this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
			} else {
				this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
			}
		}
		if (Math.random() >= .99 && ticksToYawn == 0 && ticksToItch == 0) {
			if (Math.random() > .5) {
				ticksToItch = 50;
			} else {
				ticksToYawn = 90;
			}
		}
		if (ticksToItch > 0) {
			ticksToItch--;
		}
		if (ticksToYawn > 0) {
			ticksToYawn--;
		}
	}

	public void die(DamageSource p_30384_) {
		super.die(p_30384_);
	}

	public float getBodyRollAngle(float p_30433_, float p_30434_) {
		float f = (Mth.lerp(p_30433_, this.shakeAnimO, this.shakeAnim) + p_30434_) / 1.8F;
		if (f < 0.0F) {
			f = 0.0F;
		} else if (f > 1.0F) {
			f = 1.0F;
		}

		return Mth.sin(f * (float) Math.PI) * Mth.sin(f * (float) Math.PI * 11.0F) * 0.15F * (float) Math.PI;
	}

	public float getHeadRollAngle(float p_30449_) {
		return Mth.lerp(p_30449_, this.interestedAngleO, this.interestedAngle) * 0.15F * (float) Math.PI;
	}

	protected float getStandingEyeHeight(Pose p_30409_, EntityDimensions p_30410_) {
		return p_30410_.height * 0.8F;
	}

	public int getMaxHeadXRot() {
		return this.isInSittingPose() ? 20 : super.getMaxHeadXRot();
	}

	public boolean hurt(DamageSource p_30386_, float p_30387_) {
		if (this.isInvulnerableTo(p_30386_)) {
			return false;
		} else {
			Entity entity = p_30386_.getEntity();
			if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) {
				p_30387_ = (p_30387_ + 1.0F) / 2.0F;
			}
			return super.hurt(p_30386_, p_30387_);
		}
	}

	public boolean doHurtTarget(Entity p_30372_) {
		boolean flag = p_30372_.hurt(DamageSource.mobAttack(this),
				(float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
		if (flag) {
			this.doEnchantDamageEffects(this, p_30372_);
		}
		return flag;
	}

	public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
		ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
		if (this.level.isClientSide) {
			boolean flag = this.isOwnedBy(p_30412_) || this.isTame()
					|| itemstack.is(Items.BONE) && !this.isTame() && !this.isAngry();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
					if (!p_30412_.getAbilities().instabuild) {
						itemstack.shrink(1);
					}
					this.heal((float) itemstack.getFoodProperties(this).getNutrition());
					this.gameEvent(GameEvent.EAT, this);
					return InteractionResult.SUCCESS;
				}
			}
			return super.mobInteract(p_30412_, p_30413_);
		}
	}

	public void handleEntityEvent(byte p_30379_) {
		super.handleEntityEvent(p_30379_);
	}

	public boolean isFood(ItemStack p_30440_) {
		Item item = p_30440_.getItem();
		return item.isEdible() && p_30440_.getFoodProperties(this).isMeat();
	}

	public int getMaxSpawnClusterSize() {
		return 8;
	}

	public int getRemainingPersistentAngerTime() {
		return this.entityData.get(DATA_REMAINING_ANGER_TIME);
	}

	public void setRemainingPersistentAngerTime(int p_30404_) {
		this.entityData.set(DATA_REMAINING_ANGER_TIME, p_30404_);
	}

	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	@Nullable
	public UUID getPersistentAngerTarget() {
		return this.persistentAngerTarget;
	}

	public void setPersistentAngerTarget(@Nullable UUID p_30400_) {
		this.persistentAngerTarget = p_30400_;
	}

	public void setIsInterested(boolean p_30445_) {
		this.entityData.set(DATA_INTERESTED_ID, p_30445_);
	}

	public boolean isInterested() {
		return this.entityData.get(DATA_INTERESTED_ID);
	}

	public boolean wantsToAttack(LivingEntity p_30389_, LivingEntity p_30390_) {
		if (!(p_30389_ instanceof Creeper) && !(p_30389_ instanceof Ghast)) {
			if (p_30389_ instanceof TamedLlama) {
				TamedLlama TamedLlama = (TamedLlama) p_30389_;
				return !TamedLlama.isTame() || TamedLlama.getOwner() != p_30390_;
			} else if (p_30389_ instanceof Player && p_30390_ instanceof Player
					&& !((Player) p_30390_).canHarmPlayer((Player) p_30389_)) {
				return false;
			} else if (p_30389_ instanceof AbstractHorse && ((AbstractHorse) p_30389_).isTamed()) {
				return false;
			} else {
				return !(p_30389_ instanceof TamableAnimal) || !((TamableAnimal) p_30389_).isTame();
			}
		} else {
			return false;
		}
	}

	class TamedLlamaAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
		private final TamedLlama TamedLlama;

		public TamedLlamaAvoidEntityGoal(TamedLlama p_30454_, Class<T> p_30455_, float p_30456_, double p_30457_,
				double p_30458_) {
			super(p_30454_, p_30455_, p_30456_, p_30457_, p_30458_);
			this.TamedLlama = p_30454_;
		}

		public boolean canUse() {
			if (super.canUse() && this.toAvoid instanceof Llama) {
				return !this.TamedLlama.isTame() && this.avoidLlama((Llama) this.toAvoid);
			} else {
				return false;
			}
		}

		private boolean avoidLlama(Llama p_30461_) {
			return p_30461_.getStrength() >= TamedLlama.this.random.nextInt(5);
		}

		public void start() {
			TamedLlama.this.setTarget((LivingEntity) null);
			super.start();
		}

		public void tick() {
			TamedLlama.this.setTarget((LivingEntity) null);
			super.tick();
		}
	}

	class TamedLlamaPanicGoal extends PanicGoal {
		public TamedLlamaPanicGoal(double p_203124_) {
			super(TamedLlama.this, p_203124_);
		}

		protected boolean shouldPanic() {
			return this.mob.isFreezing() || this.mob.isOnFire();
		}
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<TamedLlama>(this, "llama_controller", 0, this::predicate));

	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}
}