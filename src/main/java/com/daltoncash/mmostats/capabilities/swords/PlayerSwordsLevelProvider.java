package com.daltoncash.mmostats.capabilities.swords;

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

public class PlayerSwordsLevelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerSwordsLevel> PLAYER_SWORDS_LEVEL = CapabilityManager
			.get(new CapabilityToken<PlayerSwordsLevel>() {
			});

	private PlayerSwordsLevel swordsLevel = null;
	private final LazyOptional<PlayerSwordsLevel> optional = LazyOptional.of(this::createPlayerSwordsLevel);

	private PlayerSwordsLevel createPlayerSwordsLevel() {
		if (this.swordsLevel == null) {
			this.swordsLevel = new PlayerSwordsLevel();
		}

		return this.swordsLevel;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_SWORDS_LEVEL) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerSwordsLevel().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerSwordsLevel().loadNBTData(nbt);
	}
}
