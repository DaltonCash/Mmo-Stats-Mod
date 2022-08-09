package com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined;

import net.minecraft.nbt.CompoundTag;

public class AncientDebrisMined {
	private int total;

    public int getBlocksMined() {
        return total;
    }

    public void addBlocksMined(int add) {
        this.total += add;
    }

    public void copyFrom(AncientDebrisMined source) {
        this.total = source.total;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("ancientdebrismined", total);
    }

    public void loadNBTData(CompoundTag nbt) {
        total = nbt.getInt("ancientdebrismined");
    }
}
