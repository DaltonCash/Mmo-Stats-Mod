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

public class NoJunkBlocksUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<NoJunkBlocksUpgrade> NO_JUNK_BLOCKS = CapabilityManager
			.get(new CapabilityToken<NoJunkBlocksUpgrade>() {
			});

	private NoJunkBlocksUpgrade isUpgraded = null;
	private final LazyOptional<NoJunkBlocksUpgrade> optional = LazyOptional.of(this::createNoJunkBlocksUpgrade);

	private NoJunkBlocksUpgrade createNoJunkBlocksUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new NoJunkBlocksUpgrade();
		}
		return this.isUpgraded;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == NO_JUNK_BLOCKS) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createNoJunkBlocksUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createNoJunkBlocksUpgrade().loadNBTData(nbt);
	}

}
