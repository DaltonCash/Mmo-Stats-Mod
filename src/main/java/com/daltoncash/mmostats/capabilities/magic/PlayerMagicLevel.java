package com.daltoncash.mmostats.capabilities.magic;

import com.daltoncash.mmostats.capabilities.UpgradeCapability;
import net.minecraft.nbt.CompoundTag;

public class PlayerMagicLevel {

    private int magicLevel;

    public int getMagicLevel() {
        return magicLevel;
    }

    public void addMagicLevel(int add) {
        this.magicLevel = magicLevel + add;
    }

    public void subMagicLevel(int sub) {
        this.magicLevel = Math.max(magicLevel - sub, 0);
    }

    public void copyFrom(PlayerMagicLevel source) {
        this.magicLevel = source.magicLevel;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("magicLevel", magicLevel);
    }

    public void loadNBTData(CompoundTag nbt) {
        magicLevel = nbt.getInt("magicLevel");
    }
}
