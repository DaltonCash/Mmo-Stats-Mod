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

public class PlayerAttributePointsProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerAttributePoints> PLAYER_ATTRIBUTE_POINTS = CapabilityManager
			.get(new CapabilityToken<PlayerAttributePoints>() {
			});

	private PlayerAttributePoints playerAttributePoints = null;
	private final LazyOptional<PlayerAttributePoints> optional = LazyOptional.of(this::createPlayerAttributePoints);

	private PlayerAttributePoints createPlayerAttributePoints() {
		if (this.playerAttributePoints == null) {
			this.playerAttributePoints = new PlayerAttributePoints();
		}

		return this.playerAttributePoints;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_ATTRIBUTE_POINTS) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerAttributePoints().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerAttributePoints().loadNBTData(nbt);
	}
}
