package com.daltoncash.mmostats.capabilities.mining.upgrades;

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

public class BigSwingsUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<BigSwingsUpgrade> BIG_SWINGS = CapabilityManager
			.get(new CapabilityToken<BigSwingsUpgrade>() {
			});

	private BigSwingsUpgrade isUpgraded = null;
	private final LazyOptional<BigSwingsUpgrade> optional = LazyOptional.of(this::createBigSwingsUpgrade);

	private BigSwingsUpgrade createBigSwingsUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new BigSwingsUpgrade();
		}
		return this.isUpgraded;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == BIG_SWINGS) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createBigSwingsUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createBigSwingsUpgrade().loadNBTData(nbt);
	}

}