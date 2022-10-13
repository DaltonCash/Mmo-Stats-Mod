package com.daltoncash.mmostats.capabilities.farming.upgrades;

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

public class InsatiableUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

	public static Capability<InsatiableUpgrade> IS_UPGRADED = CapabilityManager
			.get(new CapabilityToken<InsatiableUpgrade>() {});


	private InsatiableUpgrade isUpgraded = null;
	private final LazyOptional<InsatiableUpgrade> optional = LazyOptional
			.of(this::createInsatiableUpgrade);

	private InsatiableUpgrade createInsatiableUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new InsatiableUpgrade();
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
		createInsatiableUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createInsatiableUpgrade().loadNBTData(nbt);
	}
}