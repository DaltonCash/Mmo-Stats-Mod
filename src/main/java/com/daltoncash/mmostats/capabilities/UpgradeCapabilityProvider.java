package com.daltoncash.mmostats.capabilities;

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

public class UpgradeCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

	protected static Capability<?> IS_UPGRADED = CapabilityManager
			.get(new CapabilityToken<UpgradeCapability>() {});


	private UpgradeCapability isUpgraded = null;
	private final LazyOptional<UpgradeCapability> optional = LazyOptional
			.of(this::createUpgradeCapability);

	private UpgradeCapability createUpgradeCapability() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new UpgradeCapability();
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
		createUpgradeCapability().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createUpgradeCapability().loadNBTData(nbt);
	}




}
