package com.daltoncash.mmostats.capabilities.farming.upgrades.foodsEaten;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ChickenEatenProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<ChickenEaten> SUM = CapabilityManager
			.get(new CapabilityToken<ChickenEaten>() {});

	private ChickenEaten sum = null;
	private final LazyOptional<ChickenEaten> optional = LazyOptional
			.of(this::createChickenEaten);

	private ChickenEaten createChickenEaten() {
		if (this.sum == null) {
			this.sum = new ChickenEaten();
		}
		return this.sum;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == SUM) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createChickenEaten().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createChickenEaten().loadNBTData(nbt);
	}
}