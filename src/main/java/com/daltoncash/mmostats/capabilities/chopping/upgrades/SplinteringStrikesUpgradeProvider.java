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

public class SplinteringStrikesUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

	public static Capability<SplinteringStrikesUpgrade> IS_UPGRADED = CapabilityManager
			.get(new CapabilityToken<SplinteringStrikesUpgrade>() {});


	private SplinteringStrikesUpgrade isUpgraded = null;
	private final LazyOptional<SplinteringStrikesUpgrade> optional = LazyOptional
			.of(this::createSplinteringStrikesUpgrade);

	private SplinteringStrikesUpgrade createSplinteringStrikesUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new SplinteringStrikesUpgrade();
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
		createSplinteringStrikesUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createSplinteringStrikesUpgrade().loadNBTData(nbt);
	}
}