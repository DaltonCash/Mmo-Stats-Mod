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

public class CoalMinedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<CoalMined> COAL_MINED = CapabilityManager
			.get(new CapabilityToken<CoalMined>() {
			});

	private CoalMined total = null;
	private final LazyOptional<CoalMined> optional = LazyOptional.of(this::createCoalMined);

	private CoalMined createCoalMined() {
		if (this.total == null) {
			this.total = new CoalMined();
		}

		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == COAL_MINED) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createCoalMined().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createCoalMined().loadNBTData(nbt);
	}
}
