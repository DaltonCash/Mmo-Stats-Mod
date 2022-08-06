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

public class NightVisionUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<NightVisionUpgrade> NIGHT_VISION = CapabilityManager
			.get(new CapabilityToken<NightVisionUpgrade>() {
			});

	private NightVisionUpgrade isUpgraded = null;
	private final LazyOptional<NightVisionUpgrade> optional = LazyOptional.of(this::createNightVisionUpgrade);

	private NightVisionUpgrade createNightVisionUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new NightVisionUpgrade();
		}
		return this.isUpgraded;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == NIGHT_VISION) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createNightVisionUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createNightVisionUpgrade().loadNBTData(nbt);
	}

}
