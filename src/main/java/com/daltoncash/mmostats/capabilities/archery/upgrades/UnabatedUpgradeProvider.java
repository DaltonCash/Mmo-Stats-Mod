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

public class UnabatedUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

	public static Capability<UnabatedUpgrade> IS_UPGRADED = CapabilityManager
			.get(new CapabilityToken<UnabatedUpgrade>() {});


	private UnabatedUpgrade isUpgraded = null;
	private final LazyOptional<UnabatedUpgrade> optional = LazyOptional
			.of(this::createUnabatedUpgrade);

	private UnabatedUpgrade createUnabatedUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new UnabatedUpgrade();
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
		createUnabatedUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createUnabatedUpgrade().loadNBTData(nbt);
	}
}
