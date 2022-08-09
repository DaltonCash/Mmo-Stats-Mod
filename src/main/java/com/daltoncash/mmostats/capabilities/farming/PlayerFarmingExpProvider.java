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

public class PlayerFarmingExpProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerFarmingExp> PLAYER_FARMING_EXP = CapabilityManager
			.get(new CapabilityToken<PlayerFarmingExp>() {
			});

	private PlayerFarmingExp farmingExp = null;
	private final LazyOptional<PlayerFarmingExp> optional = LazyOptional.of(this::createPlayerFarmingExp);

	private PlayerFarmingExp createPlayerFarmingExp() {
		if (this.farmingExp == null) {
			this.farmingExp = new PlayerFarmingExp();
		}

		return this.farmingExp;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_FARMING_EXP) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerFarmingExp().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerFarmingExp().loadNBTData(nbt);
	}
}
