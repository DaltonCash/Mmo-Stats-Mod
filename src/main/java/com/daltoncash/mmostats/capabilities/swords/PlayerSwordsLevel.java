package com.daltoncash.mmostats.capabilities.swords;

import net.minecraft.nbt.CompoundTag;

public class PlayerSwordsLevel {
	private int swordsLevel;

	public int getSwordsLevel() {
		return swordsLevel;
	}

	public void addSwordsLevel(int add) {
		this.swordsLevel = swordsLevel + add;
	}

	public void copyFrom(PlayerSwordsLevel source) {
		this.swordsLevel = source.swordsLevel;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("swordslevel", swordsLevel);
	}

	public void loadNBTData(CompoundTag nbt) {
		swordsLevel = nbt.getInt("swordslevel");
	}
}
