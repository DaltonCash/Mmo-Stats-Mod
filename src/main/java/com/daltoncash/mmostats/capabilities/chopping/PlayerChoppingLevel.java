package com.daltoncash.mmostats.capabilities.chopping;

import net.minecraft.nbt.CompoundTag;

public class PlayerChoppingLevel {
	private int choppingLevel;

	public int getChoppingLevel() {
		return choppingLevel;
	}

	public void addChoppingLevel(int add) {
		this.choppingLevel = choppingLevel + add;
	}

	public void subChoppingLevel(int sub) {
	    this.choppingLevel = Math.max(choppingLevel - sub, 0);
	}

	public void copyFrom(PlayerChoppingLevel source) {
		this.choppingLevel = source.choppingLevel;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("choppinglevel", choppingLevel);
	}

	public void loadNBTData(CompoundTag nbt) {
		choppingLevel = nbt.getInt("choppinglevel");
	}
}
