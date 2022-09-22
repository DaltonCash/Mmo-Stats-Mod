package com.daltoncash.mmostats.entities.mod_entities;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jetbrains.annotations.Nullable;

import com.daltoncash.mmostats.entities.ModEntityTypes;
import com.daltoncash.mmostats.events.ClientEvents.ClientForgeEvents;
import com.google.common.collect.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.AirRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TamedBee extends TamableAnimal implements IAnimatable, NeutralMob, FlyingAnimal {
	private AnimationFactory factory = new AnimationFactory(this);
	public static final float FLAP_DEGREES_PER_TICK = 120.32113F;
	public static final int TICKS_PER_FLAP = Mth.ceil(1.4959966F);
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(TamedBee.class,
			EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(TamedBee.class,
			EntityDataSerializers.INT);
	private static final int FLAG_ROLL = 2;
	private static final int FLAG_HAS_STUNG = 4;
	private static final int FLAG_HAS_NECTAR = 8;
	private static final int STING_DEATH_COUNTDOWN = 1200;
	private static final int TICKS_BEFORE_GOING_TO_KNOWN_FLOWER = 2400;
	private static final int TICKS_WITHOUT_NECTAR_BEFORE_GOING_HOME = 3600;
	private static final int MIN_ATTACK_DIST = 4;
	private static final int MAX_CROPS_GROWABLE = 10;
	private static final int POISON_SECONDS_NORMAL = 10;
	private static final int POISON_SECONDS_HARD = 18;
	private static final int TOO_FAR_DISTANCE = 32;
	private static final int HIVE_CLOSE_ENOUGH_DISTANCE = 2;
	private static final int PATHFIND_TO_HIVE_WHEN_CLOSER_THAN = 16;
	private static final int HIVE_SEARCH_DISTANCE = 20;
	public static final String TAG_CROPS_GROWN_SINCE_POLLINATION = "CropsGrownSincePollination";
	public static final String TAG_CANNOT_ENTER_HIVE_TICKS = "CannotEnterHiveTicks";
	public static final String TAG_TICKS_SINCE_POLLINATION = "TicksSincePollination";
	public static final String TAG_HAS_STUNG = "HasStung";
	public static final String TAG_HAS_NECTAR = "HasNectar";
	public static final String TAG_FLOWER_POS = "FlowerPos";
	public static final String TAG_HIVE_POS = "HivePos";
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	@Nullable
	private UUID persistentAngerTarget;
	private float rollAmount;
	private float rollAmountO;
	private int timeSinceSting;
	int ticksWithoutNectarSinceExitingHive;
	private int stayOutOfHiveCountdown;
	private int numCropsGrownSincePollination;
	private static final int COOLDOWN_BEFORE_LOCATING_NEW_HIVE = 200;
	int remainingCooldownBeforeLocatingNewHive;
	private static final int COOLDOWN_BEFORE_LOCATING_NEW_FLOWER = 200;
	int remainingCooldownBeforeLocatingNewFlower = Mth.nextInt(this.random, 20, 60);
	@Nullable
	BlockPos savedFlowerPos;
	@Nullable
	BlockPos hivePos;
	TamedBee.TamedBeePollinateGoal TamedBeePollinateGoal;
	TamedBee.TamedBeeGoToHiveGoal goToHiveGoal;
	private TamedBee.TamedBeeGoToKnownFlowerGoal goToKnownFlowerGoal;
	private int underWaterTicks;

	public TamedBee(EntityType<? extends TamedBee> p_27717_, Level p_27718_) {
	      super(p_27717_, p_27718_);
	      this.moveControl = new FlyingMoveControl(this, 20, true);
	      this.lookControl = new TamedBee.TamedBeeLookControl(this);
	      this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
	      this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
	      this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0F);
	      this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
	      this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
	   }

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_FLAGS_ID, (byte) 0);
		this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
	}

	public float getWalkTargetValue(BlockPos p_27788_, LevelReader p_27789_) {
		return p_27789_.getBlockState(p_27788_).isAir() ? 10.0F : 0.0F;
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new TamedBee.TamedBeeAttackGoal(this, (double) 1.4F, true));
		this.goalSelector.addGoal(1, new TamedBee.TamedBeeEnterHiveGoal());
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(ItemTags.FLOWERS), false));
		this.TamedBeePollinateGoal = new TamedBee.TamedBeePollinateGoal();
		this.goalSelector.addGoal(4, this.TamedBeePollinateGoal);
		this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new TamedBee.TamedBeeLocateHiveGoal());
		this.goToHiveGoal = new TamedBee.TamedBeeGoToHiveGoal();
		this.goalSelector.addGoal(5, this.goToHiveGoal);
		this.goToKnownFlowerGoal = new TamedBee.TamedBeeGoToKnownFlowerGoal();
		this.goalSelector.addGoal(6, this.goToKnownFlowerGoal);
		this.goalSelector.addGoal(7, new TamedBee.TamedBeeGrowCropGoal());
		this.goalSelector.addGoal(8, new TamedBee.TamedBeeWanderGoal());
		this.goalSelector.addGoal(9, new FloatGoal(this));
		this.targetSelector.addGoal(1, (new TamedBee.TamedBeeHurtByOtherGoal(this)).setAlertOthers(new Class[0]));
		this.targetSelector.addGoal(2, new TamedBee.TamedBeeBecomeAngryTargetGoal(this));
		this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
	}

	public void addAdditionalSaveData(CompoundTag p_27823_) {
		super.addAdditionalSaveData(p_27823_);
		if (this.hasHive()) {
			p_27823_.put("HivePos", NbtUtils.writeBlockPos(this.getHivePos()));
		}

		if (this.hasSavedFlowerPos()) {
			p_27823_.put("FlowerPos", NbtUtils.writeBlockPos(this.getSavedFlowerPos()));
		}

		p_27823_.putBoolean("HasNectar", this.hasNectar());
		p_27823_.putBoolean("HasStung", this.hasStung());
		p_27823_.putInt("TicksSincePollination", this.ticksWithoutNectarSinceExitingHive);
		p_27823_.putInt("CannotEnterHiveTicks", this.stayOutOfHiveCountdown);
		p_27823_.putInt("CropsGrownSincePollination", this.numCropsGrownSincePollination);
		this.addPersistentAngerSaveData(p_27823_);
	}

	public void readAdditionalSaveData(CompoundTag p_27793_) {
		this.hivePos = null;
		if (p_27793_.contains("HivePos")) {
			this.hivePos = NbtUtils.readBlockPos(p_27793_.getCompound("HivePos"));
		}

		this.savedFlowerPos = null;
		if (p_27793_.contains("FlowerPos")) {
			this.savedFlowerPos = NbtUtils.readBlockPos(p_27793_.getCompound("FlowerPos"));
		}

		super.readAdditionalSaveData(p_27793_);
		this.setHasNectar(p_27793_.getBoolean("HasNectar"));
		this.setHasStung(p_27793_.getBoolean("HasStung"));
		this.ticksWithoutNectarSinceExitingHive = p_27793_.getInt("TicksSincePollination");
		this.stayOutOfHiveCountdown = p_27793_.getInt("CannotEnterHiveTicks");
		this.numCropsGrownSincePollination = p_27793_.getInt("CropsGrownSincePollination");
		this.readPersistentAngerSaveData(this.level, p_27793_);
	}

	public boolean doHurtTarget(Entity p_27722_) {
		boolean flag = p_27722_.hurt(DamageSource.sting(this),
				(float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
		if (flag) {
			this.doEnchantDamageEffects(this, p_27722_);
			if (p_27722_ instanceof LivingEntity) {
				((LivingEntity) p_27722_).setStingerCount(((LivingEntity) p_27722_).getStingerCount() + 1);
				int i = 0;
				if (this.level.getDifficulty() == Difficulty.NORMAL) {
					i = 10;
				} else if (this.level.getDifficulty() == Difficulty.HARD) {
					i = 18;
				}

				if (i > 0) {
					((LivingEntity) p_27722_).addEffect(new MobEffectInstance(MobEffects.POISON, i * 20, 0), this);
				}
			}

			this.setHasStung(true);
			this.stopBeingAngry();
			this.playSound(SoundEvents.BEE_STING, 1.0F, 1.0F);
		}

		return flag;
	}

	public void tick() {
		super.tick();
		if (this.hasNectar() && this.getCropsGrownSincePollination() < 10 && this.random.nextFloat() < 0.05F) {
			for (int i = 0; i < this.random.nextInt(2) + 1; ++i) {
				this.spawnFluidParticle(this.level, this.getX() - (double) 0.3F, this.getX() + (double) 0.3F,
						this.getZ() - (double) 0.3F, this.getZ() + (double) 0.3F, this.getY(0.5D),
						ParticleTypes.FALLING_NECTAR);
			}
		}

		this.updateRollAmount();
	}

	private void spawnFluidParticle(Level p_27780_, double p_27781_, double p_27782_, double p_27783_, double p_27784_,
			double p_27785_, ParticleOptions p_27786_) {
		p_27780_.addParticle(p_27786_, Mth.lerp(p_27780_.random.nextDouble(), p_27781_, p_27782_), p_27785_,
				Mth.lerp(p_27780_.random.nextDouble(), p_27783_, p_27784_), 0.0D, 0.0D, 0.0D);
	}

	void pathfindRandomlyTowards(BlockPos p_27881_) {
		Vec3 vec3 = Vec3.atBottomCenterOf(p_27881_);
		int i = 0;
		BlockPos blockpos = this.blockPosition();
		int j = (int) vec3.y - blockpos.getY();
		if (j > 2) {
			i = 4;
		} else if (j < -2) {
			i = -4;
		}

		int k = 6;
		int l = 8;
		int i1 = blockpos.distManhattan(p_27881_);
		if (i1 < 15) {
			k = i1 / 2;
			l = i1 / 2;
		}

		Vec3 vec31 = AirRandomPos.getPosTowards(this, k, l, i, vec3, (double) ((float) Math.PI / 10F));
		if (vec31 != null) {
			this.navigation.setMaxVisitedNodesMultiplier(0.5F);
			this.navigation.moveTo(vec31.x, vec31.y, vec31.z, 1.0D);
		}
	}

	@Nullable
	public BlockPos getSavedFlowerPos() {
		return this.savedFlowerPos;
	}

	public boolean hasSavedFlowerPos() {
		return this.savedFlowerPos != null;
	}

	public void setSavedFlowerPos(BlockPos p_27877_) {
		this.savedFlowerPos = p_27877_;
	}

	@VisibleForDebug
	public int getTravellingTicks() {
		return Math.max(this.goToHiveGoal.travellingTicks, this.goToKnownFlowerGoal.travellingTicks);
	}

	@VisibleForDebug
	public List<BlockPos> getBlacklistedHives() {
		return this.goToHiveGoal.blacklistedTargets;
	}

	private boolean isTiredOfLookingForNectar() {
		return this.ticksWithoutNectarSinceExitingHive > 3600;
	}

	boolean wantsToEnterHive() {
		if (this.stayOutOfHiveCountdown <= 0 && !this.TamedBeePollinateGoal.isPollinating() && !this.hasStung()
				&& this.getTarget() == null) {
			boolean flag = this.isTiredOfLookingForNectar() || this.level.isRaining() || this.level.isNight()
					|| this.hasNectar();
			return flag && !this.isHiveNearFire();
		} else {
			return false;
		}
	}

	public void setStayOutOfHiveCountdown(int p_27916_) {
		this.stayOutOfHiveCountdown = p_27916_;
	}

	public float getRollAmount(float p_27936_) {
		return Mth.lerp(p_27936_, this.rollAmountO, this.rollAmount);
	}

	private void updateRollAmount() {
		this.rollAmountO = this.rollAmount;
		if (this.isRolling()) {
			this.rollAmount = Math.min(1.0F, this.rollAmount + 0.2F);
		} else {
			this.rollAmount = Math.max(0.0F, this.rollAmount - 0.24F);
		}

	}

	protected void customServerAiStep() {
		boolean flag = this.hasStung();
		if (this.isInWaterOrBubble()) {
			++this.underWaterTicks;
		} else {
			this.underWaterTicks = 0;
		}

		if (this.underWaterTicks > 20) {
			this.hurt(DamageSource.DROWN, 1.0F);
		}

		if (flag) {
			++this.timeSinceSting;
			if (this.timeSinceSting % 5 == 0
					&& this.random.nextInt(Mth.clamp(1200 - this.timeSinceSting, 1, 1200)) == 0) {
				this.hurt(DamageSource.GENERIC, this.getHealth());
			}
		}

		if (!this.hasNectar()) {
			++this.ticksWithoutNectarSinceExitingHive;
		}

		if (!this.level.isClientSide) {
			this.updatePersistentAnger((ServerLevel) this.level, false);
		}

	}

	public void resetTicksWithoutNectarSinceExitingHive() {
		this.ticksWithoutNectarSinceExitingHive = 0;
	}

	private boolean isHiveNearFire() {
		if (this.hivePos == null) {
			return false;
		} else {
			BlockEntity blockentity = this.level.getBlockEntity(this.hivePos);
			return blockentity instanceof BeehiveBlockEntity && ((BeehiveBlockEntity) blockentity).isFireNearby();
		}
	}

	public int getRemainingPersistentAngerTime() {
		return this.entityData.get(DATA_REMAINING_ANGER_TIME);
	}

	public void setRemainingPersistentAngerTime(int p_27795_) {
		this.entityData.set(DATA_REMAINING_ANGER_TIME, p_27795_);
	}

	@Nullable
	public UUID getPersistentAngerTarget() {
		return this.persistentAngerTarget;
	}

	public void setPersistentAngerTarget(@Nullable UUID p_27791_) {
		this.persistentAngerTarget = p_27791_;
	}

	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	private boolean doesHiveHaveSpace(BlockPos p_27885_) {
		BlockEntity blockentity = this.level.getBlockEntity(p_27885_);
		if (blockentity instanceof BeehiveBlockEntity) {
			return !((BeehiveBlockEntity) blockentity).isFull();
		} else {
			return false;
		}
	}

	@VisibleForDebug
	public boolean hasHive() {
		return this.hivePos != null;
	}

	@Nullable
	@VisibleForDebug
	public BlockPos getHivePos() {
		return this.hivePos;
	}

	@VisibleForDebug
	public GoalSelector getGoalSelector() {
		return this.goalSelector;
	}

	int getCropsGrownSincePollination() {
		return this.numCropsGrownSincePollination;
	}

	private void resetNumCropsGrownSincePollination() {
		this.numCropsGrownSincePollination = 0;
	}

	void incrementNumCropsGrownSincePollination() {
		++this.numCropsGrownSincePollination;
	}

	public void aiStep() {
		super.aiStep();
		if (!this.level.isClientSide) {
			if (this.stayOutOfHiveCountdown > 0) {
				--this.stayOutOfHiveCountdown;
			}

			if (this.remainingCooldownBeforeLocatingNewHive > 0) {
				--this.remainingCooldownBeforeLocatingNewHive;
			}

			if (this.remainingCooldownBeforeLocatingNewFlower > 0) {
				--this.remainingCooldownBeforeLocatingNewFlower;
			}

			boolean flag = this.isAngry() && !this.hasStung() && this.getTarget() != null
					&& this.getTarget().distanceToSqr(this) < 4.0D;
			this.setRolling(flag);
			if (this.tickCount % 20 == 0 && !this.isHiveValid()) {
				this.hivePos = null;
			}
		}

	}

	boolean isHiveValid() {
		if (!this.hasHive()) {
			return false;
		} else {
			BlockEntity blockentity = this.level.getBlockEntity(this.hivePos);
			return blockentity instanceof BeehiveBlockEntity;
		}
	}

	public boolean hasNectar() {
		return this.getFlag(8);
	}

	void setHasNectar(boolean p_27920_) {
		if (p_27920_) {
			this.resetTicksWithoutNectarSinceExitingHive();
		}

		this.setFlag(8, p_27920_);
	}

	public boolean hasStung() {
		return this.getFlag(4);
	}

	private void setHasStung(boolean p_27926_) {
		this.setFlag(4, p_27926_);
	}

	private boolean isRolling() {
		return this.getFlag(2);
	}

	private void setRolling(boolean p_27930_) {
		this.setFlag(2, p_27930_);
	}

	boolean isTooFarAway(BlockPos p_27890_) {
		return !this.closerThan(p_27890_, 32);
	}

	private void setFlag(int p_27833_, boolean p_27834_) {
		if (p_27834_) {
			this.entityData.set(DATA_FLAGS_ID, (byte) (this.entityData.get(DATA_FLAGS_ID) | p_27833_));
		} else {
			this.entityData.set(DATA_FLAGS_ID, (byte) (this.entityData.get(DATA_FLAGS_ID) & ~p_27833_));
		}

	}

	private boolean getFlag(int p_27922_) {
		return (this.entityData.get(DATA_FLAGS_ID) & p_27922_) != 0;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.FLYING_SPEED, (double) 0.6F)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.3F).add(Attributes.ATTACK_DAMAGE, 2.0D)
				.add(Attributes.FOLLOW_RANGE, 48.0D);
	}

	protected PathNavigation createNavigation(Level p_27815_) {
		FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_27815_) {
			public boolean isStableDestination(BlockPos p_27947_) {
				return !this.level.getBlockState(p_27947_.below()).isAir();
			}

			public void tick() {
				if (!TamedBee.this.TamedBeePollinateGoal.isPollinating()) {
					super.tick();
				}
			}
		};
		flyingpathnavigation.setCanOpenDoors(false);
		flyingpathnavigation.setCanFloat(false);
		flyingpathnavigation.setCanPassDoors(true);
		return flyingpathnavigation;
	}

	public boolean isFood(ItemStack p_27895_) {
		return p_27895_.is(ItemTags.FLOWERS);
	}

	boolean isFlowerValid(BlockPos p_27897_) {
		return this.level.isLoaded(p_27897_) && this.level.getBlockState(p_27897_).is(BlockTags.FLOWERS);
	}

	protected void playStepSound(BlockPos p_27820_, BlockState p_27821_) {
	}

	protected SoundEvent getAmbientSound() {
		return null;
	}

	protected SoundEvent getHurtSound(DamageSource p_27845_) {
		return SoundEvents.BEE_DEATH;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.BEE_DEATH;
	}

	protected float getSoundVolume() {
		return 0.4F;
	}

	public TamedBee getBreedOffspring(ServerLevel p_148760_, AgeableMob p_148761_) {
		
		return ModEntityTypes.BEE.get().create(p_148760_);
	}

	protected float getStandingEyeHeight(Pose p_27804_, EntityDimensions p_27805_) {
		return this.isBaby() ? p_27805_.height * 0.5F : p_27805_.height * 0.5F;
	}

	public boolean causeFallDamage(float p_148750_, float p_148751_, DamageSource p_148752_) {
		return false;
	}

	protected void checkFallDamage(double p_27754_, boolean p_27755_, BlockState p_27756_, BlockPos p_27757_) {
	}

	public boolean isFlapping() {
		return this.isFlying() && this.tickCount % TICKS_PER_FLAP == 0;
	}

	public boolean isFlying() {
		return !this.onGround;
	}

	public void dropOffNectar() {
		this.setHasNectar(false);
		this.resetNumCropsGrownSincePollination();
	}

	public boolean hurt(DamageSource p_27762_, float p_27763_) {
		if (this.isInvulnerableTo(p_27762_)) {
			return false;
		} else {
			if (!this.level.isClientSide) {
				this.TamedBeePollinateGoal.stopPollinating();
			}

			return super.hurt(p_27762_, p_27763_);
		}
	}

	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	@Deprecated // FORGE: use jumpInFluid instead
	protected void jumpInLiquid(TagKey<Fluid> p_204061_) {
		this.jumpInLiquidInternal();
	}

	private void jumpInLiquidInternal() {
		this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.01D, 0.0D));
	}

	@Override
	public void jumpInFluid(net.minecraftforge.fluids.FluidType type) {
		this.jumpInLiquidInternal();
	}

	public Vec3 getLeashOffset() {
		return new Vec3(0.0D, (double) (0.5F * this.getEyeHeight()), (double) (this.getBbWidth() * 0.2F));
	}

	boolean closerThan(BlockPos p_27817_, int p_27818_) {
		return p_27817_.closerThan(this.blockPosition(), (double) p_27818_);
	}

	abstract class BaseTamedBeeGoal extends Goal {
		public abstract boolean canTamedBeeUse();

		public abstract boolean canTamedBeeContinueToUse();

		public boolean canUse() {
			return this.canTamedBeeUse() && !TamedBee.this.isAngry();
		}

		public boolean canContinueToUse() {
			return this.canTamedBeeContinueToUse() && !TamedBee.this.isAngry();
		}
	}

	class TamedBeeAttackGoal extends MeleeAttackGoal {
		TamedBeeAttackGoal(PathfinderMob p_27960_, double p_27961_, boolean p_27962_) {
			super(p_27960_, p_27961_, p_27962_);
		}

		public boolean canUse() {
			return super.canUse() && TamedBee.this.isAngry() && !TamedBee.this.hasStung();
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && TamedBee.this.isAngry() && !TamedBee.this.hasStung();
		}
	}

	static class TamedBeeBecomeAngryTargetGoal extends NearestAttackableTargetGoal<Player> {
		TamedBeeBecomeAngryTargetGoal(TamedBee p_27966_) {
			super(p_27966_, Player.class, 10, true, false, p_27966_::isAngryAt);
		}

		public boolean canUse() {
			return this.TamedBeeCanTarget() && super.canUse();
		}

		public boolean canContinueToUse() {
			boolean flag = this.TamedBeeCanTarget();
			if (flag && this.mob.getTarget() != null) {
				return super.canContinueToUse();
			} else {
				this.targetMob = null;
				return false;
			}
		}

		private boolean TamedBeeCanTarget() {
			TamedBee TamedBee = (TamedBee) this.mob;
			return TamedBee.isAngry() && !TamedBee.hasStung();
		}
	}

	class TamedBeeEnterHiveGoal extends TamedBee.BaseTamedBeeGoal {
		public boolean canTamedBeeUse() {
			if (TamedBee.this.hasHive() && TamedBee.this.wantsToEnterHive()
					&& TamedBee.this.hivePos.closerToCenterThan(TamedBee.this.position(), 2.0D)) {
				BlockEntity blockentity = TamedBee.this.level.getBlockEntity(TamedBee.this.hivePos);
				if (blockentity instanceof BeehiveBlockEntity) {
					BeehiveBlockEntity Beehiveblockentity = (BeehiveBlockEntity) blockentity;
					if (!Beehiveblockentity.isFull()) {
						return true;
					}

					TamedBee.this.hivePos = null;
				}
			}

			return false;
		}

		public boolean canTamedBeeContinueToUse() {
			return false;
		}

		public void start() {
			BlockEntity blockentity = TamedBee.this.level.getBlockEntity(TamedBee.this.hivePos);
			if (blockentity instanceof BeehiveBlockEntity Beehiveblockentity) {
				Beehiveblockentity.addOccupant(TamedBee.this, TamedBee.this.hasNectar());
			}

		}
	}

	@VisibleForDebug
	public class TamedBeeGoToHiveGoal extends TamedBee.BaseTamedBeeGoal {
		public static final int MAX_TRAVELLING_TICKS = 600;
		int travellingTicks = TamedBee.this.level.random.nextInt(10);
		private static final int MAX_BLACKLISTED_TARGETS = 3;
		final List<BlockPos> blacklistedTargets = Lists.newArrayList();
		@Nullable
		private Path lastPath;
		private static final int TICKS_BEFORE_HIVE_DROP = 60;
		private int ticksStuck;

		TamedBeeGoToHiveGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canTamedBeeUse() {
			return TamedBee.this.hivePos != null && !TamedBee.this.hasRestriction() && TamedBee.this.wantsToEnterHive()
					&& !this.hasReachedTarget(TamedBee.this.hivePos)
					&& TamedBee.this.level.getBlockState(TamedBee.this.hivePos).is(BlockTags.BEEHIVES);
		}

		public boolean canTamedBeeContinueToUse() {
			return this.canTamedBeeUse();
		}

		public void start() {
			this.travellingTicks = 0;
			this.ticksStuck = 0;
			super.start();
		}

		public void stop() {
			this.travellingTicks = 0;
			this.ticksStuck = 0;
			TamedBee.this.navigation.stop();
			TamedBee.this.navigation.resetMaxVisitedNodesMultiplier();
		}

		public void tick() {
			if (TamedBee.this.hivePos != null) {
				++this.travellingTicks;
				if (this.travellingTicks > this.adjustedTickDelay(600)) {
					this.dropAndBlacklistHive();
				} else if (!TamedBee.this.navigation.isInProgress()) {
					if (!TamedBee.this.closerThan(TamedBee.this.hivePos, 16)) {
						if (TamedBee.this.isTooFarAway(TamedBee.this.hivePos)) {
							this.dropHive();
						} else {
							TamedBee.this.pathfindRandomlyTowards(TamedBee.this.hivePos);
						}
					} else {
						boolean flag = this.pathfindDirectlyTowards(TamedBee.this.hivePos);
						if (!flag) {
							this.dropAndBlacklistHive();
						} else if (this.lastPath != null && TamedBee.this.navigation.getPath().sameAs(this.lastPath)) {
							++this.ticksStuck;
							if (this.ticksStuck > 60) {
								this.dropHive();
								this.ticksStuck = 0;
							}
						} else {
							this.lastPath = TamedBee.this.navigation.getPath();
						}

					}
				}
			}
		}

		private boolean pathfindDirectlyTowards(BlockPos p_27991_) {
			TamedBee.this.navigation.setMaxVisitedNodesMultiplier(10.0F);
			TamedBee.this.navigation.moveTo((double) p_27991_.getX(), (double) p_27991_.getY(), (double) p_27991_.getZ(),
					1.0D);
			return TamedBee.this.navigation.getPath() != null && TamedBee.this.navigation.getPath().canReach();
		}

		boolean isTargetBlacklisted(BlockPos p_27994_) {
			return this.blacklistedTargets.contains(p_27994_);
		}

		private void blacklistTarget(BlockPos p_27999_) {
			this.blacklistedTargets.add(p_27999_);

			while (this.blacklistedTargets.size() > 3) {
				this.blacklistedTargets.remove(0);
			}

		}

		void clearBlacklist() {
			this.blacklistedTargets.clear();
		}

		private void dropAndBlacklistHive() {
			if (TamedBee.this.hivePos != null) {
				this.blacklistTarget(TamedBee.this.hivePos);
			}

			this.dropHive();
		}

		private void dropHive() {
			TamedBee.this.hivePos = null;
			TamedBee.this.remainingCooldownBeforeLocatingNewHive = 200;
		}

		private boolean hasReachedTarget(BlockPos p_28002_) {
			if (TamedBee.this.closerThan(p_28002_, 2)) {
				return true;
			} else {
				Path path = TamedBee.this.navigation.getPath();
				return path != null && path.getTarget().equals(p_28002_) && path.canReach() && path.isDone();
			}
		}
	}

	public class TamedBeeGoToKnownFlowerGoal extends TamedBee.BaseTamedBeeGoal {
		private static final int MAX_TRAVELLING_TICKS = 600;
		int travellingTicks = TamedBee.this.level.random.nextInt(10);

		TamedBeeGoToKnownFlowerGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canTamedBeeUse() {
			return TamedBee.this.savedFlowerPos != null && !TamedBee.this.hasRestriction() && this.wantsToGoToKnownFlower()
					&& TamedBee.this.isFlowerValid(TamedBee.this.savedFlowerPos)
					&& !TamedBee.this.closerThan(TamedBee.this.savedFlowerPos, 2);
		}

		public boolean canTamedBeeContinueToUse() {
			return this.canTamedBeeUse();
		}

		public void start() {
			this.travellingTicks = 0;
			super.start();
		}

		public void stop() {
			this.travellingTicks = 0;
			TamedBee.this.navigation.stop();
			TamedBee.this.navigation.resetMaxVisitedNodesMultiplier();
		}

		public void tick() {
			if (TamedBee.this.savedFlowerPos != null) {
				++this.travellingTicks;
				if (this.travellingTicks > this.adjustedTickDelay(600)) {
					TamedBee.this.savedFlowerPos = null;
				} else if (!TamedBee.this.navigation.isInProgress()) {
					if (TamedBee.this.isTooFarAway(TamedBee.this.savedFlowerPos)) {
						TamedBee.this.savedFlowerPos = null;
					} else {
						TamedBee.this.pathfindRandomlyTowards(TamedBee.this.savedFlowerPos);
					}
				}
			}
		}

		private boolean wantsToGoToKnownFlower() {
			return TamedBee.this.ticksWithoutNectarSinceExitingHive > 2400;
		}
	}

	class TamedBeeGrowCropGoal extends TamedBee.BaseTamedBeeGoal {
		static final int GROW_CHANCE = 30;

		public boolean canTamedBeeUse() {
			if (TamedBee.this.getCropsGrownSincePollination() >= 10) {
				return false;
			} else if (TamedBee.this.random.nextFloat() < 0.3F) {
				return false;
			} else {
				return TamedBee.this.hasNectar() && TamedBee.this.isHiveValid();
			}
		}

		public boolean canTamedBeeContinueToUse() {
			return this.canTamedBeeUse();
		}

		public void tick() {
			if (TamedBee.this.random.nextInt(this.adjustedTickDelay(30)) == 0) {
				for (int i = 1; i <= 2; ++i) {
					BlockPos blockpos = TamedBee.this.blockPosition().below(i);
					BlockState blockstate = TamedBee.this.level.getBlockState(blockpos);
					Block block = blockstate.getBlock();
					boolean flag = false;
					IntegerProperty integerproperty = null;
					if (blockstate.is(BlockTags.BEE_GROWABLES)) {
						if (block instanceof CropBlock) {
							CropBlock cropblock = (CropBlock) block;
							if (!cropblock.isMaxAge(blockstate)) {
								flag = true;
								integerproperty = cropblock.getAgeProperty();
							}
						} else if (block instanceof StemBlock) {
							int j = blockstate.getValue(StemBlock.AGE);
							if (j < 7) {
								flag = true;
								integerproperty = StemBlock.AGE;
							}
						} else if (blockstate.is(Blocks.SWEET_BERRY_BUSH)) {
							int k = blockstate.getValue(SweetBerryBushBlock.AGE);
							if (k < 3) {
								flag = true;
								integerproperty = SweetBerryBushBlock.AGE;
							}
						} else if (blockstate.is(Blocks.CAVE_VINES) || blockstate.is(Blocks.CAVE_VINES_PLANT)) {
							((BonemealableBlock) blockstate.getBlock()).performBonemeal((ServerLevel) TamedBee.this.level,
									TamedBee.this.random, blockpos, blockstate);
						}

						if (flag) {
							TamedBee.this.level.levelEvent(2005, blockpos, 0);
							TamedBee.this.level.setBlockAndUpdate(blockpos, blockstate.setValue(integerproperty,
									Integer.valueOf(blockstate.getValue(integerproperty) + 1)));
							TamedBee.this.incrementNumCropsGrownSincePollination();
						}
					}
				}

			}
		}
	}

	class TamedBeeHurtByOtherGoal extends HurtByTargetGoal {
		TamedBeeHurtByOtherGoal(TamedBee p_28033_) {
			super(p_28033_);
		}

		public boolean canContinueToUse() {
			return TamedBee.this.isAngry() && super.canContinueToUse();
		}

		protected void alertOther(Mob p_28035_, LivingEntity p_28036_) {
			if (p_28035_ instanceof TamedBee && this.mob.hasLineOfSight(p_28036_)) {
				p_28035_.setTarget(p_28036_);
			}

		}
	}

	class TamedBeeLocateHiveGoal extends TamedBee.BaseTamedBeeGoal {
		public boolean canTamedBeeUse() {
			return TamedBee.this.remainingCooldownBeforeLocatingNewHive == 0 && !TamedBee.this.hasHive()
					&& TamedBee.this.wantsToEnterHive();
		}

		public boolean canTamedBeeContinueToUse() {
			return false;
		}

		public void start() {
			TamedBee.this.remainingCooldownBeforeLocatingNewHive = 200;
			List<BlockPos> list = this.findNearbyHivesWithSpace();
			if (!list.isEmpty()) {
				for (BlockPos blockpos : list) {
					if (!TamedBee.this.goToHiveGoal.isTargetBlacklisted(blockpos)) {
						TamedBee.this.hivePos = blockpos;
						return;
					}
				}

				TamedBee.this.goToHiveGoal.clearBlacklist();
				TamedBee.this.hivePos = list.get(0);
			}
		}

		private List<BlockPos> findNearbyHivesWithSpace() {
			BlockPos blockpos = TamedBee.this.blockPosition();
			PoiManager poimanager = ((ServerLevel) TamedBee.this.level).getPoiManager();
			Stream<PoiRecord> stream = poimanager.getInRange((p_218130_) -> {
				return p_218130_.is(PoiTypeTags.BEE_HOME);
			}, blockpos, 20, PoiManager.Occupancy.ANY);
			return stream.map(PoiRecord::getPos).filter(TamedBee.this::doesHiveHaveSpace)
					.sorted(Comparator.comparingDouble((p_148811_) -> {
						return p_148811_.distSqr(blockpos);
					})).collect(Collectors.toList());
		}
	}

	class TamedBeeLookControl extends LookControl {
		TamedBeeLookControl(Mob p_28059_) {
			super(p_28059_);
		}

		public void tick() {
			if (!TamedBee.this.isAngry()) {
				super.tick();
			}
		}

		protected boolean resetXRotOnTick() {
			return !TamedBee.this.TamedBeePollinateGoal.isPollinating();
		}
	}

	class TamedBeePollinateGoal extends TamedBee.BaseTamedBeeGoal {
		private static final int MIN_POLLINATION_TICKS = 400;
		private static final int MIN_FIND_FLOWER_RETRY_COOLDOWN = 20;
		private static final int MAX_FIND_FLOWER_RETRY_COOLDOWN = 60;
		private final Predicate<BlockState> VALID_POLLINATION_BLOCKS = (p_28074_) -> {
			if (p_28074_.hasProperty(BlockStateProperties.WATERLOGGED)
					&& p_28074_.getValue(BlockStateProperties.WATERLOGGED)) {
				return false;
			} else if (p_28074_.is(BlockTags.FLOWERS)) {
				if (p_28074_.is(Blocks.SUNFLOWER)) {
					return p_28074_.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
				} else {
					return true;
				}
			} else {
				return false;
			}
		};
		private static final double ARRIVAL_THRESHOLD = 0.1D;
		private static final int POSITION_CHANGE_CHANCE = 25;
		private static final float SPEED_MODIFIER = 0.35F;
		private static final float HOVER_HEIGHT_WITHIN_FLOWER = 0.6F;
		private static final float HOVER_POS_OFFSET = 0.33333334F;
		private int successfulPollinatingTicks;
		private int lastSoundPlayedTick;
		private boolean pollinating;
		@Nullable
		private Vec3 hoverPos;
		private int pollinatingTicks;
		private static final int MAX_POLLINATING_TICKS = 600;

		TamedBeePollinateGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canTamedBeeUse() {
			if (TamedBee.this.remainingCooldownBeforeLocatingNewFlower > 0) {
				return false;
			} else if (TamedBee.this.hasNectar()) {
				return false;
			} else if (TamedBee.this.level.isRaining()) {
				return false;
			} else {
				Optional<BlockPos> optional = this.findNearbyFlower();
				if (optional.isPresent()) {
					TamedBee.this.savedFlowerPos = optional.get();
					TamedBee.this.navigation.moveTo((double) TamedBee.this.savedFlowerPos.getX() + 0.5D,
							(double) TamedBee.this.savedFlowerPos.getY() + 0.5D,
							(double) TamedBee.this.savedFlowerPos.getZ() + 0.5D, (double) 1.2F);
					return true;
				} else {
					TamedBee.this.remainingCooldownBeforeLocatingNewFlower = Mth.nextInt(TamedBee.this.random, 20, 60);
					return false;
				}
			}
		}

		public boolean canTamedBeeContinueToUse() {
			if (!this.pollinating) {
				return false;
			} else if (!TamedBee.this.hasSavedFlowerPos()) {
				return false;
			} else if (TamedBee.this.level.isRaining()) {
				return false;
			} else if (this.hasPollinatedLongEnough()) {
				return TamedBee.this.random.nextFloat() < 0.2F;
			} else if (TamedBee.this.tickCount % 20 == 0 && !TamedBee.this.isFlowerValid(TamedBee.this.savedFlowerPos)) {
				TamedBee.this.savedFlowerPos = null;
				return false;
			} else {
				return true;
			}
		}

		private boolean hasPollinatedLongEnough() {
			return this.successfulPollinatingTicks > 400;
		}

		boolean isPollinating() {
			return this.pollinating;
		}

		void stopPollinating() {
			this.pollinating = false;
		}

		public void start() {
			this.successfulPollinatingTicks = 0;
			this.pollinatingTicks = 0;
			this.lastSoundPlayedTick = 0;
			this.pollinating = true;
			TamedBee.this.resetTicksWithoutNectarSinceExitingHive();
		}

		public void stop() {
			if (this.hasPollinatedLongEnough()) {
				TamedBee.this.setHasNectar(true);
			}

			this.pollinating = false;
			TamedBee.this.navigation.stop();
			TamedBee.this.remainingCooldownBeforeLocatingNewFlower = 200;
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		public void tick() {
			++this.pollinatingTicks;
			if (this.pollinatingTicks > 600) {
				TamedBee.this.savedFlowerPos = null;
			} else {
				Vec3 vec3 = Vec3.atBottomCenterOf(TamedBee.this.savedFlowerPos).add(0.0D, (double) 0.6F, 0.0D);
				if (vec3.distanceTo(TamedBee.this.position()) > 1.0D) {
					this.hoverPos = vec3;
					this.setWantedPos();
				} else {
					if (this.hoverPos == null) {
						this.hoverPos = vec3;
					}

					boolean flag = TamedBee.this.position().distanceTo(this.hoverPos) <= 0.1D;
					boolean flag1 = true;
					if (!flag && this.pollinatingTicks > 600) {
						TamedBee.this.savedFlowerPos = null;
					} else {
						if (flag) {
							boolean flag2 = TamedBee.this.random.nextInt(25) == 0;
							if (flag2) {
								this.hoverPos = new Vec3(vec3.x() + (double) this.getOffset(), vec3.y(),
										vec3.z() + (double) this.getOffset());
								TamedBee.this.navigation.stop();
							} else {
								flag1 = false;
							}

							TamedBee.this.getLookControl().setLookAt(vec3.x(), vec3.y(), vec3.z());
						}

						if (flag1) {
							this.setWantedPos();
						}

						++this.successfulPollinatingTicks;
						if (TamedBee.this.random.nextFloat() < 0.05F
								&& this.successfulPollinatingTicks > this.lastSoundPlayedTick + 60) {
							this.lastSoundPlayedTick = this.successfulPollinatingTicks;
							TamedBee.this.playSound(SoundEvents.BEE_POLLINATE, 1.0F, 1.0F);
						}

					}
				}
			}
		}

		private void setWantedPos() {
			TamedBee.this.getMoveControl().setWantedPosition(this.hoverPos.x(), this.hoverPos.y(), this.hoverPos.z(),
					(double) 0.35F);
		}

		private float getOffset() {
			return (TamedBee.this.random.nextFloat() * 2.0F - 1.0F) * 0.33333334F;
		}

		private Optional<BlockPos> findNearbyFlower() {
			return this.findNearestBlock(this.VALID_POLLINATION_BLOCKS, 5.0D);
		}

		private Optional<BlockPos> findNearestBlock(Predicate<BlockState> p_28076_, double p_28077_) {
			BlockPos blockpos = TamedBee.this.blockPosition();
			BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

			for (int i = 0; (double) i <= p_28077_; i = i > 0 ? -i : 1 - i) {
				for (int j = 0; (double) j < p_28077_; ++j) {
					for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
						for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
							blockpos$mutableblockpos.setWithOffset(blockpos, k, i - 1, l);
							if (blockpos.closerThan(blockpos$mutableblockpos, p_28077_)
									&& p_28076_.test(TamedBee.this.level.getBlockState(blockpos$mutableblockpos))) {
								return Optional.of(blockpos$mutableblockpos);
							}
						}
					}
				}
			}

			return Optional.empty();
		}
	}

	class TamedBeeWanderGoal extends Goal {
		private static final int WANDER_THRESHOLD = 22;

		TamedBeeWanderGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			return TamedBee.this.navigation.isDone() && TamedBee.this.random.nextInt(10) == 0;
		}

		public boolean canContinueToUse() {
			return TamedBee.this.navigation.isInProgress();
		}

		public void start() {
			Vec3 vec3 = this.findPos();
			if (vec3 != null) {
				TamedBee.this.navigation.moveTo(TamedBee.this.navigation.createPath(new BlockPos(vec3), 1), 1.0D);
			}

		}

		@Nullable
		private Vec3 findPos() {
			Vec3 vec3;
			if (TamedBee.this.isHiveValid() && !TamedBee.this.closerThan(TamedBee.this.hivePos, 22)) {
				Vec3 vec31 = Vec3.atCenterOf(TamedBee.this.hivePos);
				vec3 = vec31.subtract(TamedBee.this.position()).normalize();
			} else {
				vec3 = TamedBee.this.getViewVector(0.0F);
			}

			int i = 8;
			Vec3 vec32 = HoverRandomPos.getPos(TamedBee.this, 8, 7, vec3.x, vec3.z, ((float) Math.PI / 2F), 3, 1);
			return vec32 != null ? vec32
					: AirAndWaterRandomPos.getPos(TamedBee.this, 8, 4, -2, vec3.x, vec3.z, (double) ((float) Math.PI / 2F));
		}
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<TamedBee>(this, "bee_controller", 0, this::predicate));
		
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ATTACK_DAMAGE, 3.0f)
				.add(Attributes.ATTACK_SPEED, 2.0f)
				// float underneath this comment must be 0.135 or higher to trigger .isMoving in
				// the "predicate" method
				.add(Attributes.MOVEMENT_SPEED, 0.3f)
				.add(Attributes.FLYING_SPEED).build();
	}
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bee.fly", true));
			
			return PlayState.CONTINUE;

		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bee.idle", true));
			return PlayState.CONTINUE;
		}
	}
}