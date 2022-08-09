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

public class GlowstoneMinedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<GlowstoneMined> GLOWSTONE_MINED = CapabilityManager
			.get(new CapabilityToken<GlowstoneMined>() {
			});

	private GlowstoneMined total = null;
	private final LazyOptional<GlowstoneMined> optional = LazyOptional.of(this::createGlowstoneMined);

	private GlowstoneMined createGlowstoneMined() {
		if (this.total == null) {
			this.total = new GlowstoneMined();
		}

		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == GLOWSTONE_MINED) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createGlowstoneMined().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createGlowstoneMined().loadNBTData(nbt);
	}

}
