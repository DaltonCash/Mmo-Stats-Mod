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

public class PumpkinPieEatenProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PumpkinPieEaten> SUM = CapabilityManager
			.get(new CapabilityToken<PumpkinPieEaten>() {});

	private PumpkinPieEaten sum = null;
	private final LazyOptional<PumpkinPieEaten> optional = LazyOptional
			.of(this::createPumpkinPieEaten);

	private PumpkinPieEaten createPumpkinPieEaten() {
		if (this.sum == null) {
			this.sum = new PumpkinPieEaten();
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
		createPumpkinPieEaten().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPumpkinPieEaten().loadNBTData(nbt);
	}
}