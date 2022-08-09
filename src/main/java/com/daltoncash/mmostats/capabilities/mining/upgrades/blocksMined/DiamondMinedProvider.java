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

public class DiamondMinedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<DiamondMined> DIAMOND_MINED = CapabilityManager
			.get(new CapabilityToken<DiamondMined>() {
			});

	private DiamondMined total = null;
	private final LazyOptional<DiamondMined> optional = LazyOptional.of(this::createDiamondMined);

	private DiamondMined createDiamondMined() {
		if (this.total == null) {
			this.total = new DiamondMined();
		}

		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == DIAMOND_MINED) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createDiamondMined().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createDiamondMined().loadNBTData(nbt);
	}

}
