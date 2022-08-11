package com.daltoncash.mmostats.capabilities.mining;

import net.minecraft.nbt.CompoundTag;

public class PlayerMiningLevel {
	private int miningLevel;

    public int getMiningLevel() {
        return miningLevel;
    }

    public void addMiningLevel(int add) {
        this.miningLevel += add;
    }

    public void subMiningLevel(int sub) {
    	this.miningLevel = Math.max(miningLevel - sub, 0);
    }

    public void copyFrom(PlayerMiningLevel source) {
        this.miningLevel = source.miningLevel;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("mininglevel", miningLevel);
    }

    public void loadNBTData(CompoundTag nbt) {
        miningLevel = nbt.getInt("mininglevel");
    }
}
