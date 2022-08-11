package com.daltoncash.mmostats.capabilities.archery;

import net.minecraft.nbt.CompoundTag;

public class PlayerArcheryLevel {
	private int archeryLevel;

	public int getArcheryLevel() {
		return archeryLevel;
	}

	public void addArcheryLevel(int add) {
		this.archeryLevel = archeryLevel + add;
	}
	
	public void subArcheryLevel(int sub) {
	    this.archeryLevel = Math.max(archeryLevel - sub, 0);
	}

	public void copyFrom(PlayerArcheryLevel source) {
		this.archeryLevel = source.archeryLevel;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("archerylevel", archeryLevel);
	}

	public void loadNBTData(CompoundTag nbt) {
		archeryLevel = nbt.getInt("archerylevel");
	}
}
