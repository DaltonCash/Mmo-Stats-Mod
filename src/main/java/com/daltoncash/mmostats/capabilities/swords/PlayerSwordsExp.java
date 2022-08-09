package com.daltoncash.mmostats.capabilities.swords;

import net.minecraft.nbt.CompoundTag;

public class PlayerSwordsExp {
	private int swordsExp;

	public int getSwordsExp() {
		return swordsExp;
	}

	public void addSwordsExp(int add) {
		this.swordsExp = swordsExp + add;
	}

	public void copyFrom(PlayerSwordsExp source) {
		this.swordsExp = source.swordsExp;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("swordsexp", swordsExp);
	}

	public void loadNBTData(CompoundTag nbt) {
		swordsExp = nbt.getInt("swordsexp");
	}
}
