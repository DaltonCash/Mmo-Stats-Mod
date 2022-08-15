package com.daltoncash.mmostats.capabilities.chopping.upgrades;

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

public class GrannySmithUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

	public static Capability<GrannySmithUpgrade> IS_UPGRADED = CapabilityManager
			.get(new CapabilityToken<GrannySmithUpgrade>() {});


	private GrannySmithUpgrade isUpgraded = null;
	private final LazyOptional<GrannySmithUpgrade> optional = LazyOptional
			.of(this::createGrannySmithUpgrade);

	private GrannySmithUpgrade createGrannySmithUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new GrannySmithUpgrade();
		}
		return this.isUpgraded;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == IS_UPGRADED) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createGrannySmithUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createGrannySmithUpgrade().loadNBTData(nbt);
	}
}
