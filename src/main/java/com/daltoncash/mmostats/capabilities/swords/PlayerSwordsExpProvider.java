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

public class PlayerSwordsExpProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerSwordsExp> PLAYER_SWORDS_EXP = CapabilityManager
			.get(new CapabilityToken<PlayerSwordsExp>() {
			});

	private PlayerSwordsExp swordsExp = null;
	private final LazyOptional<PlayerSwordsExp> optional = LazyOptional.of(this::createPlayerSwordsExp);

	private PlayerSwordsExp createPlayerSwordsExp() {
		if (this.swordsExp == null) {
			this.swordsExp = new PlayerSwordsExp();
		}

		return this.swordsExp;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_SWORDS_EXP) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerSwordsExp().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerSwordsExp().loadNBTData(nbt);
	}
}
