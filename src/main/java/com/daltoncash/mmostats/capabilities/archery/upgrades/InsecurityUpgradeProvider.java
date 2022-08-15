package com.daltoncash.mmostats.capabilities.archery.upgrades;

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

public class InsecurityUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

	public static Capability<InsecurityUpgrade> IS_UPGRADED = CapabilityManager
			.get(new CapabilityToken<InsecurityUpgrade>() {});


	private InsecurityUpgrade isUpgraded = null;
	private final LazyOptional<InsecurityUpgrade> optional = LazyOptional
			.of(this::createInsecurityUpgrade);

	private InsecurityUpgrade createInsecurityUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new InsecurityUpgrade();
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
		createInsecurityUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createInsecurityUpgrade().loadNBTData(nbt);
	}
}