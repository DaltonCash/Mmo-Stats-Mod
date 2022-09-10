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

public class WarpedStemChoppedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<WarpedStemChopped> TOTAL = CapabilityManager
			.get(new CapabilityToken<WarpedStemChopped>() {});

	private WarpedStemChopped total = null;
	private final LazyOptional<WarpedStemChopped> optional = LazyOptional
			.of(this::createWarpedStemChopped);

	private WarpedStemChopped createWarpedStemChopped() {
		if (this.total == null) {
			this.total = new WarpedStemChopped();
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
		createWarpedStemChopped().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createWarpedStemChopped().loadNBTData(nbt);
	}
}