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

public class DarkOakChoppedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<DarkOakChopped> TOTAL = CapabilityManager
			.get(new CapabilityToken<DarkOakChopped>() {});

	private DarkOakChopped total = null;
	private final LazyOptional<DarkOakChopped> optional = LazyOptional
			.of(this::createDarkOakChopped);

	private DarkOakChopped createDarkOakChopped() {
		if (this.total == null) {
			this.total = new DarkOakChopped();
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
		createDarkOakChopped().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createDarkOakChopped().loadNBTData(nbt);
	}
}