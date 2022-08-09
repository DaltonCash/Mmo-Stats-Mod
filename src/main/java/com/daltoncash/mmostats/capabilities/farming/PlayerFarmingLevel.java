package com.daltoncash.mmostats.capabilities.farming;

import net.minecraft.nbt.CompoundTag;

public class PlayerFarmingLevel {
	private int farmingLevel;

	public int getFarmingLevel() {
		return farmingLevel;
	}

	public void addFarmingLevel(int add) {
		this.farmingLevel = farmingLevel + add;
	}

	public void copyFrom(PlayerFarmingLevel source) {
		this.farmingLevel = source.farmingLevel;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("farminglevel", farmingLevel);
	}

	public void loadNBTData(CompoundTag nbt) {
		farmingLevel = nbt.getInt("farminglevel");
	}
}
