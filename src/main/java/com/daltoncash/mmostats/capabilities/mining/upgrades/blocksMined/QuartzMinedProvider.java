package com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined;

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

public class QuartzMinedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<QuartzMined> QUARTZ_MINED = CapabilityManager
			.get(new CapabilityToken<QuartzMined>() {
			});

	private QuartzMined total = null;
	private final LazyOptional<QuartzMined> optional = LazyOptional.of(this::createQuartzMined);

	private QuartzMined createQuartzMined() {
		if (this.total == null) {
			this.total = new QuartzMined();
		}

		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == QUARTZ_MINED) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createQuartzMined().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createQuartzMined().loadNBTData(nbt);
	}

}
