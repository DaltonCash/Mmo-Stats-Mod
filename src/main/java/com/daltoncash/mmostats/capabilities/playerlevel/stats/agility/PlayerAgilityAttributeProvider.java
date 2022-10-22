package com.daltoncash.mmostats.capabilities.playerlevel.stats.agility;

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

public class PlayerAgilityAttributeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerAgilityAttribute> AGILITY_LEVEL = CapabilityManager
			.get(new CapabilityToken<PlayerAgilityAttribute>() {
			});

	private PlayerAgilityAttribute playerAgilityAttribute = null;
	private final LazyOptional<PlayerAgilityAttribute> optional = LazyOptional.of(this::createPlayerAgilityAttribute);

	private PlayerAgilityAttribute createPlayerAgilityAttribute() {
		if (this.playerAgilityAttribute == null) {
			this.playerAgilityAttribute = new PlayerAgilityAttribute();
		}

		return this.playerAgilityAttribute;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == AGILITY_LEVEL) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerAgilityAttribute().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerAgilityAttribute().loadNBTData(nbt);
	}
}