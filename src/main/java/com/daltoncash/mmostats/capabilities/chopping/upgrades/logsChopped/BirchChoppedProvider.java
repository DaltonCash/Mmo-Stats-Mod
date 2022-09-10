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

public class BirchChoppedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<BirchChopped> TOTAL = CapabilityManager
			.get(new CapabilityToken<BirchChopped>() {});

	private BirchChopped total = null;
	private final LazyOptional<BirchChopped> optional = LazyOptional
			.of(this::createBirchChopped);

	private BirchChopped createBirchChopped() {
		if (this.total == null) {
			this.total = new BirchChopped();
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
		createBirchChopped().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createBirchChopped().loadNBTData(nbt);
	}
}