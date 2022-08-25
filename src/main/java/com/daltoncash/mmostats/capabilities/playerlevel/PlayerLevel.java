package com.daltoncash.mmostats.capabilities.playerlevel;

import net.minecraft.nbt.CompoundTag;

public class PlayerLevel {
	private int playerLevel;

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void addPlayerLevel(int add) {
        this.playerLevel += add;
    }

    public void subPlayerLevel(int sub) {
    	this.playerLevel = Math.max(playerLevel - sub, 0);
    }

    public void copyFrom(PlayerLevel source) {
        this.playerLevel = source.playerLevel;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("playerlevel", playerLevel);
    }

    public void loadNBTData(CompoundTag nbt) {
    	playerLevel = nbt.getInt("playerlevel");
    }
}
