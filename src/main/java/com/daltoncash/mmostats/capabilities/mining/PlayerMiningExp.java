package com.daltoncash.mmostats.capabilities.mining;

import net.minecraft.nbt.CompoundTag;

public class PlayerMiningExp {
	private int miningExp;

	public int getMiningExp() {
		return miningExp;
	}

	public void addMiningExp(int add) {
		this.miningExp = miningExp + add;
	}

	public void subMiningExp(int sub) {
		this.miningExp = Math.max(miningExp - sub, 0);
	}

	public void copyFrom(PlayerMiningExp source) {
		this.miningExp = source.miningExp;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("miningexp", miningExp);
	}

	public void loadNBTData(CompoundTag nbt) {
		miningExp = nbt.getInt("miningexp");
	}
}
