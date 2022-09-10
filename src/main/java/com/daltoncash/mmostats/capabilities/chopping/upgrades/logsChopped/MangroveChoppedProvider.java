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

public class MangroveChoppedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<MangroveChopped> TOTAL = CapabilityManager
			.get(new CapabilityToken<MangroveChopped>() {});

	private MangroveChopped total = null;
	private final LazyOptional<MangroveChopped> optional = LazyOptional
			.of(this::createMangroveChopped);

	private MangroveChopped createMangroveChopped() {
		if (this.total == null) {
			this.total = new MangroveChopped();
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
		createMangroveChopped().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createMangroveChopped().loadNBTData(nbt);
	}
}