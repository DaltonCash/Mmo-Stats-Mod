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

public class BreadEatenProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<BreadEaten> SUM = CapabilityManager
			.get(new CapabilityToken<BreadEaten>() {});

	private BreadEaten sum = null;
	private final LazyOptional<BreadEaten> optional = LazyOptional
			.of(this::createBreadEaten);

	private BreadEaten createBreadEaten() {
		if (this.sum == null) {
			this.sum = new BreadEaten();
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
		createBreadEaten().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createBreadEaten().loadNBTData(nbt);
	}
}