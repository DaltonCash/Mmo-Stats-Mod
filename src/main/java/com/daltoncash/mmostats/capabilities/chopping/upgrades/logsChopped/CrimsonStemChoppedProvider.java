package com.daltoncash.mmostats.capabilities.chopping.upgrades.logsChopped;

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

public class CrimsonStemChoppedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<CrimsonStemChopped> TOTAL = CapabilityManager
			.get(new CapabilityToken<CrimsonStemChopped>() {});

	private CrimsonStemChopped total = null;
	private final LazyOptional<CrimsonStemChopped> optional = LazyOptional
			.of(this::createCrimsonStemChopped);

	private CrimsonStemChopped createCrimsonStemChopped() {
		if (this.total == null) {
			this.total = new CrimsonStemChopped();
		}
		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == TOTAL) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createCrimsonStemChopped().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createCrimsonStemChopped().loadNBTData(nbt);
	}
}