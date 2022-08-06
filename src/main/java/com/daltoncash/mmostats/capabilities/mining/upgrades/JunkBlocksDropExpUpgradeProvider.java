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

public class JunkBlocksDropExpUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<JunkBlocksDropExpUpgrade> JUNK_BLOCKS_DROP_EXP = CapabilityManager
			.get(new CapabilityToken<JunkBlocksDropExpUpgrade>() {});

	private JunkBlocksDropExpUpgrade isUpgraded = null;
	private final LazyOptional<JunkBlocksDropExpUpgrade> optional = LazyOptional
			.of(this::createJunkBlocksDropExpUpgrade);

	private JunkBlocksDropExpUpgrade createJunkBlocksDropExpUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new JunkBlocksDropExpUpgrade();
		}
		return this.isUpgraded;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == JUNK_BLOCKS_DROP_EXP) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createJunkBlocksDropExpUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createJunkBlocksDropExpUpgrade().loadNBTData(nbt);
	}
}
