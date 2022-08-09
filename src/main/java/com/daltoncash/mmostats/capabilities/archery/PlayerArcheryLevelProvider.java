package com.daltoncash.mmostats.capabilities.archery;

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

public class PlayerArcheryLevelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerArcheryLevel> PLAYER_ARCHERY_LEVEL = CapabilityManager
			.get(new CapabilityToken<PlayerArcheryLevel>() {
			});

	private PlayerArcheryLevel archeryLevel = null;
	private final LazyOptional<PlayerArcheryLevel> optional = LazyOptional.of(this::createPlayerArcheryLevel);

	private PlayerArcheryLevel createPlayerArcheryLevel() {
		if (this.archeryLevel == null) {
			this.archeryLevel = new PlayerArcheryLevel();
		}

		return this.archeryLevel;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_ARCHERY_LEVEL) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerArcheryLevel().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerArcheryLevel().loadNBTData(nbt);
	}
}
