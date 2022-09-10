package com.daltoncash.mmostats.capabilities.chopping.upgrades.logsChopped;

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

public class JungleChoppedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<JungleChopped> TOTAL = CapabilityManager
			.get(new CapabilityToken<JungleChopped>() {});

	private JungleChopped total = null;
	private final LazyOptional<JungleChopped> optional = LazyOptional
			.of(this::createJungleChopped);

	private JungleChopped createJungleChopped() {
		if (this.total == null) {
			this.total = new JungleChopped();
		}
		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == TOTAL) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createJungleChopped().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createJungleChopped().loadNBTData(nbt);
	}
}