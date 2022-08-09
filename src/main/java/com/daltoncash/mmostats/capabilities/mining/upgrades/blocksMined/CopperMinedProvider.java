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

public class CopperMinedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<CopperMined> COPPER_MINED = CapabilityManager
			.get(new CapabilityToken<CopperMined>() {
			});

	private CopperMined total = null;
	private final LazyOptional<CopperMined> optional = LazyOptional.of(this::createCopperMined);

	private CopperMined createCopperMined() {
		if (this.total == null) {
			this.total = new CopperMined();
		}

		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == COPPER_MINED) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createCopperMined().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createCopperMined().loadNBTData(nbt);
	}

}
