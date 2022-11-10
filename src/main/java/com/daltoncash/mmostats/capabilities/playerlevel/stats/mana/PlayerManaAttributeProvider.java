package com.daltoncash.mmostats.capabilities.playerlevel.stats.mana;

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

public class PlayerManaAttributeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<PlayerManaAttribute> MANA_LEVEL = CapabilityManager
			.get(new CapabilityToken<PlayerManaAttribute>() {
			});

	private PlayerManaAttribute playerManaAttribute = null;
	private final LazyOptional<PlayerManaAttribute> optional = LazyOptional.of(this::createPlayerManaAttribute);

	private PlayerManaAttribute createPlayerManaAttribute() {
		if (this.playerManaAttribute == null) {
			this.playerManaAttribute = new PlayerManaAttribute();
		}

		return this.playerManaAttribute;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == MANA_LEVEL) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerManaAttribute().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerManaAttribute().loadNBTData(nbt);
	}
}