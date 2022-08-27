package com.daltoncash.mmostats.capabilities;

import net.minecraft.nbt.CompoundTag;

public class UpgradeCapability {
	private int upgradeLevel;
	private String nbtString;

	protected UpgradeCapability(String nbtString){
		this.nbtString = nbtString;
	}
	
	public UpgradeCapability() {
	}

	public int getUpgradeLevel() {
		return upgradeLevel;
	}

	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
	}

	public void copyFrom(UpgradeCapability source) {
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
