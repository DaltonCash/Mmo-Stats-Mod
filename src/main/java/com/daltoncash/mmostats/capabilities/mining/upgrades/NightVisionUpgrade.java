package com.daltoncash.mmostats.capabilities.mining.upgrades;

import net.minecraft.nbt.CompoundTag;

public class NightVisionUpgrade {
	private boolean isUpgraded;

	public boolean getIsUpgraded() {
		return isUpgraded;
	}

	public void setIsUpgraded(boolean bool) {
		this.isUpgraded = bool;
	}

	public void copyFrom(NightVisionUpgrade source) {
		this.isUpgraded = source.isUpgraded;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putBoolean("isupgradednightvisionupgrade", isUpgraded);
	}

	public void loadNBTData(CompoundTag nbt) {
		isUpgraded = nbt.getBoolean("isupgradednightvisionupgrade");
	}
}
