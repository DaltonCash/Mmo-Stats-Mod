package com.daltoncash.mmostats.capabilities.combat;

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

public class PlayerCombatLevelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerCombatLevel> PLAYER_COMBAT_LEVEL = CapabilityManager
			.get(new CapabilityToken<PlayerCombatLevel>() {
			});

	private PlayerCombatLevel combatLevel = null;
	private final LazyOptional<PlayerCombatLevel> optional = LazyOptional.of(this::createPlayerCombatLevel);

	private PlayerCombatLevel createPlayerCombatLevel() {
		if (this.combatLevel == null) {
			this.combatLevel = new PlayerCombatLevel();
		}

		return this.combatLevel;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_COMBAT_LEVEL) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerCombatLevel().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerCombatLevel().loadNBTData(nbt);
	}
}
