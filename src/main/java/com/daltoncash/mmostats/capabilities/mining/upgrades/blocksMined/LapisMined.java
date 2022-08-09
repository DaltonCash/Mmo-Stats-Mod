package com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined;

import net.minecraft.nbt.CompoundTag;

public class LapisMined {
	private int total;

    public int getBlocksMined() {
        return total;
    }

    public void addBlocksMined(int add) {
        this.total += add;
    }

    public void copyFrom(LapisMined source) {
        this.total = source.total;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("lapismined", total);
    }

    public void loadNBTData(CompoundTag nbt) {
        total = nbt.getInt("lapismined");
    }
}
