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

public class PlayerArcheryExpProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerArcheryExp> PLAYER_ARCHERY_EXP = CapabilityManager
			.get(new CapabilityToken<PlayerArcheryExp>() {
			});

	private PlayerArcheryExp archeryExp = null;
	private final LazyOptional<PlayerArcheryExp> optional = LazyOptional.of(this::createPlayerArcheryExp);

	private PlayerArcheryExp createPlayerArcheryExp() {
		if (this.archeryExp == null) {
			this.archeryExp = new PlayerArcheryExp();
		}

		return this.archeryExp;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_ARCHERY_EXP) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerArcheryExp().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerArcheryExp().loadNBTData(nbt);
	}
}
