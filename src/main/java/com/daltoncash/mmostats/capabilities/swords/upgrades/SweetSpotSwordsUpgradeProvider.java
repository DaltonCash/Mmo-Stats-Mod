package com.daltoncash.mmostats.capabilities.swords.upgrades;

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

public class SweetSpotSwordsUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

	public static Capability<SweetSpotSwordsUpgrade> IS_UPGRADED = CapabilityManager
			.get(new CapabilityToken<SweetSpotSwordsUpgrade>() {});


	private SweetSpotSwordsUpgrade isUpgraded = null;
	private final LazyOptional<SweetSpotSwordsUpgrade> optional = LazyOptional
			.of(this::createSweetSpotUpgrade);

	private SweetSpotSwordsUpgrade createSweetSpotUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new SweetSpotSwordsUpgrade();
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
		createSweetSpotUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createSweetSpotUpgrade().loadNBTData(nbt);
	}
}
