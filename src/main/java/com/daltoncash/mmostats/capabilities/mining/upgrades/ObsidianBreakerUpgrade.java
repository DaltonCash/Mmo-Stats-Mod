package com.daltoncash.mmostats.capabilities.mining.upgrades;

import net.minecraft.nbt.CompoundTag;

public class ObsidianBreakerUpgrade {
	private boolean isUpgraded;

    public boolean getIsUpgraded() {
        return isUpgraded;
    }

    public void setIsUpgraded(boolean bool) {
        this.isUpgraded = bool;
    }

    public void copyFrom(ObsidianBreakerUpgrade source) {
        this.isUpgraded = source.isUpgraded;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putBoolean("isupgradedobsidianbreakerupgrade", isUpgraded);
    }

    public void loadNBTData(CompoundTag nbt) {
    	isUpgraded = nbt.getBoolean("isupgradedobsidianbreakerupgrade");
    }
}
