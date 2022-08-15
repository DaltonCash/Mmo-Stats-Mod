package com.daltoncash.mmostats.capabilities.magic;

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

public class PlayerMagicExpProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerMagicExp> PLAYER_MAGIC_EXP = CapabilityManager
			.get(new CapabilityToken<PlayerMagicExp>() {
			});

	private PlayerMagicExp magicExp = null;
	private final LazyOptional<PlayerMagicExp> optional = LazyOptional.of(this::createPlayerMagicExp);

	private PlayerMagicExp createPlayerMagicExp() {
		if (this.magicExp == null) {
			this.magicExp = new PlayerMagicExp();
		}

		return this.magicExp;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_MAGIC_EXP) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerMagicExp().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerMagicExp().loadNBTData(nbt);
	}
}
