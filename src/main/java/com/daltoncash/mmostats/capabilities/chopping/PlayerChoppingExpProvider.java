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

public class PlayerChoppingExpProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerChoppingExp> PLAYER_CHOPPING_EXP = CapabilityManager
			.get(new CapabilityToken<PlayerChoppingExp>() {
			});

	private PlayerChoppingExp choppingExp = null;
	private final LazyOptional<PlayerChoppingExp> optional = LazyOptional.of(this::createPlayerChoppingExp);

	private PlayerChoppingExp createPlayerChoppingExp() {
		if (this.choppingExp == null) {
			this.choppingExp = new PlayerChoppingExp();
		}

		return this.choppingExp;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_CHOPPING_EXP) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerChoppingExp().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerChoppingExp().loadNBTData(nbt);
	}
}
