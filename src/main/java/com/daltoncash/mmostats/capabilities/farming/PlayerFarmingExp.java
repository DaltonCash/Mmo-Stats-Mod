package com.daltoncash.mmostats.capabilities.farming;

import net.minecraft.nbt.CompoundTag;

public class PlayerFarmingExp {
	private int farmingExp;

	public int getFarmingExp() {
		return farmingExp;
	}

	public void addFarmingExp(int add) {
		this.farmingExp = farmingExp + add;
	}

	public void copyFrom(PlayerFarmingExp source) {
		this.farmingExp = source.farmingExp;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("farmingexp", farmingExp);
	}

	public void loadNBTData(CompoundTag nbt) {
		farmingExp = nbt.getInt("farmingexp");
	}
}
