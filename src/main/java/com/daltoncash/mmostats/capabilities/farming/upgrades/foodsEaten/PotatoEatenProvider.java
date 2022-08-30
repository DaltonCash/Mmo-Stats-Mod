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

public class PotatoEatenProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PotatoEaten> SUM = CapabilityManager
			.get(new CapabilityToken<PotatoEaten>() {});

	private PotatoEaten sum = null;
	private final LazyOptional<PotatoEaten> optional = LazyOptional
			.of(this::createPotatoEaten);

	private PotatoEaten createPotatoEaten() {
		if (this.sum == null) {
			this.sum = new PotatoEaten();
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
		createPotatoEaten().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPotatoEaten().loadNBTData(nbt);
	}
}