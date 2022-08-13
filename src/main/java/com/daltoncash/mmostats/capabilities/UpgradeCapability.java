package com.daltoncash.mmostats.capabilities;

import net.minecraft.nbt.CompoundTag;

public class UpgradeCapability {
	private boolean isUpgraded;
	private String nbtString;

	protected UpgradeCapability(String nbtString){
		this.nbtString = nbtString;
	}
	
	public UpgradeCapability() {
		// TODO Auto-generated constructor stub
	}

	public boolean getIsUpgraded() {
		return isUpgraded;
	}

	public void setIsUpgraded(boolean bool) {
		this.isUpgraded = bool;
	}

	public void copyFrom(UpgradeCapability source) {
		this.isUpgraded = source.isUpgraded;
	}
	public void saveNBTData(CompoundTag nbt) {
		nbt.putBoolean(getNbtString(), getIsUpgraded());
	}

	public void loadNBTData(CompoundTag nbt) {
		setIsUpgraded(nbt.getBoolean(getNbtString()));
	}

	public String getNbtString() {
		return nbtString;
	}

	public void setNbtString(String nbtString) {
		this.nbtString = nbtString;
	}
}
