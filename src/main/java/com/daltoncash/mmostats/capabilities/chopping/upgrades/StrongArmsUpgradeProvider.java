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

public class StrongArmsUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

	public static Capability<StrongArmsUpgrade> IS_UPGRADED = CapabilityManager
			.get(new CapabilityToken<StrongArmsUpgrade>() {});


	private StrongArmsUpgrade isUpgraded = null;
	private final LazyOptional<StrongArmsUpgrade> optional = LazyOptional
			.of(this::createStrongArmsUpgrade);

	private StrongArmsUpgrade createStrongArmsUpgrade() {
		if (this.isUpgraded == null) {
			this.isUpgraded = new StrongArmsUpgrade();
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
		createStrongArmsUpgrade().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createStrongArmsUpgrade().loadNBTData(nbt);
	}
}
