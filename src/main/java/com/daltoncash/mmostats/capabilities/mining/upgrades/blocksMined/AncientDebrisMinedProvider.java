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

public class AncientDebrisMinedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<AncientDebrisMined> ANCIENT_DEBRIS_MINED = CapabilityManager
			.get(new CapabilityToken<AncientDebrisMined>() {
			});

	private AncientDebrisMined total = null;
	private final LazyOptional<AncientDebrisMined> optional = LazyOptional.of(this::createAncientDebrisMined);

	private AncientDebrisMined createAncientDebrisMined() {
		if (this.total == null) {
			this.total = new AncientDebrisMined();
		}

		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == ANCIENT_DEBRIS_MINED) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createAncientDebrisMined().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createAncientDebrisMined().loadNBTData(nbt);
	}
}
