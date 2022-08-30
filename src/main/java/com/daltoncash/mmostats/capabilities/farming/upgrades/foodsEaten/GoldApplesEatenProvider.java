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

public class GoldApplesEatenProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<GoldApplesEaten> SUM = CapabilityManager
			.get(new CapabilityToken<GoldApplesEaten>() {});

	private GoldApplesEaten sum = null;
	private final LazyOptional<GoldApplesEaten> optional = LazyOptional
			.of(this::createGoldApplesEaten);

	private GoldApplesEaten createGoldApplesEaten() {
		if (this.sum == null) {
			this.sum = new GoldApplesEaten();
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
		createGoldApplesEaten().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createGoldApplesEaten().loadNBTData(nbt);
	}
}