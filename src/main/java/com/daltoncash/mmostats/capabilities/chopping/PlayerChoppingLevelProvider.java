package com.daltoncash.mmostats.capabilities.chopping;

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

public class PlayerChoppingLevelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerChoppingLevel> PLAYER_CHOPPING_LEVEL = CapabilityManager
			.get(new CapabilityToken<PlayerChoppingLevel>() {
			});

	private PlayerChoppingLevel choppingLevel = null;
	private final LazyOptional<PlayerChoppingLevel> optional = LazyOptional.of(this::createPlayerChoppingLevel);

	private PlayerChoppingLevel createPlayerChoppingLevel() {
		if (this.choppingLevel == null) {
			this.choppingLevel = new PlayerChoppingLevel();
		}

		return this.choppingLevel;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_CHOPPING_LEVEL) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerChoppingLevel().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerChoppingLevel().loadNBTData(nbt);
	}
}
