package com.daltoncash.mmostats.capabilities.playerlevel.stats.health;

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

public class PlayerHealthAttributeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerHealthAttribute> HEALTH_LEVEL = CapabilityManager
			.get(new CapabilityToken<PlayerHealthAttribute>() {
			});

	private PlayerHealthAttribute playerHealthAttribute = null;
	private final LazyOptional<PlayerHealthAttribute> optional = LazyOptional.of(this::createPlayerHealthAttribute);

	private PlayerHealthAttribute createPlayerHealthAttribute() {
		if (this.playerHealthAttribute == null) {
			this.playerHealthAttribute = new PlayerHealthAttribute();
		}

		return this.playerHealthAttribute;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == HEALTH_LEVEL) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerHealthAttribute().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerHealthAttribute().loadNBTData(nbt);
	}
}