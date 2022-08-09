package com.daltoncash.mmostats.capabilities.farming;

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

public class PlayerFarmingLevelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerFarmingLevel> PLAYER_FARMING_LEVEL = CapabilityManager
			.get(new CapabilityToken<PlayerFarmingLevel>() {
			});

	private PlayerFarmingLevel farmingLevel = null;
	private final LazyOptional<PlayerFarmingLevel> optional = LazyOptional.of(this::createPlayerFarmingLevel);

	private PlayerFarmingLevel createPlayerFarmingLevel() {
		if (this.farmingLevel == null) {
			this.farmingLevel = new PlayerFarmingLevel();
		}

		return this.farmingLevel;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_FARMING_LEVEL) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerFarmingLevel().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerFarmingLevel().loadNBTData(nbt);
	}
}
