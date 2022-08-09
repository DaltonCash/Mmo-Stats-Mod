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

public class PlayerCombatExpProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerCombatExp> PLAYER_COMBAT_EXP = CapabilityManager
			.get(new CapabilityToken<PlayerCombatExp>() {
			});

	private PlayerCombatExp combatExp = null;
	private final LazyOptional<PlayerCombatExp> optional = LazyOptional.of(this::createPlayerCombatExp);

	private PlayerCombatExp createPlayerCombatExp() {
		if (this.combatExp == null) {
			this.combatExp = new PlayerCombatExp();
		}

		return this.combatExp;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_COMBAT_EXP) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerCombatExp().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerCombatExp().loadNBTData(nbt);
	}
}
