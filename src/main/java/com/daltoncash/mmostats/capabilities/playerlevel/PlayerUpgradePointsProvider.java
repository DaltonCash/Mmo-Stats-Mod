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

public class PlayerUpgradePointsProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerUpgradePoints> PLAYER_UPGRADE_POINTS = CapabilityManager
			.get(new CapabilityToken<PlayerUpgradePoints>() {
			});

	private PlayerUpgradePoints playerUpgradePoints = null;
	private final LazyOptional<PlayerUpgradePoints> optional = LazyOptional.of(this::createPlayerUpgradePoints);

	private PlayerUpgradePoints createPlayerUpgradePoints() {
		if (this.playerUpgradePoints == null) {
			this.playerUpgradePoints = new PlayerUpgradePoints();
		}

		return this.playerUpgradePoints;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_UPGRADE_POINTS) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerUpgradePoints().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerUpgradePoints().loadNBTData(nbt);
	}
}