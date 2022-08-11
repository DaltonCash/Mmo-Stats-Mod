package com.daltoncash.mmostats.capabilities.archery;

import net.minecraft.nbt.CompoundTag;

public class PlayerArcheryExp {
	private int archeryExp;

	public int getArcheryExp() {
		return archeryExp;
	}

	public void addArcheryExp(int add) {
		this.archeryExp = archeryExp + add;
	}
	
	public void subArcheryExp(int sub) {
		this.archeryExp = Math.max(archeryExp - sub, 0);
	}

	public void copyFrom(PlayerArcheryExp source) {
		this.archeryExp = source.archeryExp;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("archeryexp", archeryExp);
	}

	public void loadNBTData(CompoundTag nbt) {
		archeryExp = nbt.getInt("archeryexp");
	}
}
