package com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined;

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

public class RedstoneMinedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<RedstoneMined> REDSTONE_MINED = CapabilityManager
			.get(new CapabilityToken<RedstoneMined>() {
			});

	private RedstoneMined total = null;
	private final LazyOptional<RedstoneMined> optional = LazyOptional.of(this::createRedstoneMined);

	private RedstoneMined createRedstoneMined() {
		if (this.total == null) {
			this.total = new RedstoneMined();
		}

		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == REDSTONE_MINED) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createRedstoneMined().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createRedstoneMined().loadNBTData(nbt);
	}

}
