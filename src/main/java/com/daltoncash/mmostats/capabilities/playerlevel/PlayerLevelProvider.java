package com.daltoncash.mmostats.capabilities.playerlevel;

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

public class PlayerLevelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerLevel> PLAYER_LEVEL = CapabilityManager
			.get(new CapabilityToken<PlayerLevel>() {
			});

	private PlayerLevel playerLevel = null;
	private final LazyOptional<PlayerLevel> optional = LazyOptional.of(this::createPlayerLevel);

	private PlayerLevel createPlayerLevel() {
		if (this.playerLevel == null) {
			this.playerLevel = new PlayerLevel();
		}

		return this.playerLevel;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_LEVEL) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerLevel().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerLevel().loadNBTData(nbt);
	}
}
