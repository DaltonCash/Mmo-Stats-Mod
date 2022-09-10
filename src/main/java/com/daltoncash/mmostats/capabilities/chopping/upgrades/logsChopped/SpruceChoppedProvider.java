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

public class SpruceChoppedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<SpruceChopped> TOTAL = CapabilityManager
			.get(new CapabilityToken<SpruceChopped>() {});

	private SpruceChopped total = null;
	private final LazyOptional<SpruceChopped> optional = LazyOptional
			.of(this::createSpruceChopped);

	private SpruceChopped createSpruceChopped() {
		if (this.total == null) {
			this.total = new SpruceChopped();
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
		createSpruceChopped().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createSpruceChopped().loadNBTData(nbt);
	}
}