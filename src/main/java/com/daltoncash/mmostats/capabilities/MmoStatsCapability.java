package com.daltoncash.mmostats.capabilities;

import net.minecraft.nbt.CompoundTag;

public class MmoStatsCapability {
	private int upgradeLevel;
	private String nbtString;

	protected MmoStatsCapability(String nbtString){
		this.nbtString = nbtString;
	}
	
	public MmoStatsCapability() {
	}

	public int getUpgradeLevel() {
		return upgradeLevel;
	}

	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
	}

	public void copyFrom(MmoStatsCapability source) {
		this.upgradeLevel = source.upgradeLevel;
	}
	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt(getNbtString(), getUpgradeLevel());
	}

	public void loadNBTData(CompoundTag nbt) {
		setUpgradeLevel(nbt.getInt(getNbtString()));
	}

	public String getNbtString() {
		return nbtString;
	}

	public void setNbtString(String nbtString) {
		this.nbtString = nbtString;
	}
}
