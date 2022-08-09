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

public class EmeraldMinedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<EmeraldMined> EMERALD_MINED = CapabilityManager
			.get(new CapabilityToken<EmeraldMined>() {
			});

	private EmeraldMined total = null;
	private final LazyOptional<EmeraldMined> optional = LazyOptional.of(this::createEmeraldMined);

	private EmeraldMined createEmeraldMined() {
		if (this.total == null) {
			this.total = new EmeraldMined();
		}

		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == EMERALD_MINED) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createEmeraldMined().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createEmeraldMined().loadNBTData(nbt);
	}

}
