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

public class PlayerLevelExpProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerLevelExp> PLAYER_LEVEL_EXP = CapabilityManager
			.get(new CapabilityToken<PlayerLevelExp>() {
			});

	private PlayerLevelExp levelExp = null;
	private final LazyOptional<PlayerLevelExp> optional = LazyOptional.of(this::createPlayerLevelExp);

	private PlayerLevelExp createPlayerLevelExp() {
		if (this.levelExp == null) {
			this.levelExp = new PlayerLevelExp();
		}

		return this.levelExp;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_LEVEL_EXP) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerLevelExp().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerLevelExp().loadNBTData(nbt);
	}
}