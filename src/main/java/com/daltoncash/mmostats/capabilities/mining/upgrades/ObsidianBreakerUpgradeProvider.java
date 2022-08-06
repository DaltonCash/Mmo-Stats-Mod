package com.daltoncash.mmostats.capabilities.mining.upgrades;

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

public class ObsidianBreakerUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<ObsidianBreakerUpgrade> OBSIDIAN_BREAKER = CapabilityManager
			.get(new CapabilityToken<ObsidianBreakerUpgrade>() {
			});

	private ObsidianBreakerUpgrade isUpgraded = null;
	private final LazyOptional<ObsidianBreakerUpgrade> optional = LazyOptional.of(this::createObsidianBreakerUpgrade);

	private ObsidianBreakerUpgrade createObsidianBreakerUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new ObsidianBreakerUpgrade();
		}
		return this.isUpgraded;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == OBSIDIAN_BREAKER) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createObsidianBreakerUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createObsidianBreakerUpgrade().loadNBTData(nbt);
	}

}
