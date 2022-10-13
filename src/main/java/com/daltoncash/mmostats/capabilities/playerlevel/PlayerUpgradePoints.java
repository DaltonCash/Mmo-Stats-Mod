package com.daltoncash.mmostats.capabilities.playerlevel;

import net.minecraft.nbt.CompoundTag;

public class PlayerUpgradePoints {
	private int playerUpgradePoints;

    public int getPlayerUpgradePoints() {
        return playerUpgradePoints;
    }

    public void addPlayerUpgradePoints(int add) {
        this.playerUpgradePoints += add;
    }

    public void subPlayerUpgradePoints(int sub) {
    	this.playerUpgradePoints = Math.max(playerUpgradePoints - sub, 0);
    }

    public void copyFrom(PlayerUpgradePoints source) {
        this.playerUpgradePoints = source.playerUpgradePoints;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("playerupgradepoints", playerUpgradePoints);
    }

    public void loadNBTData(CompoundTag nbt) {
    	playerUpgradePoints = nbt.getInt("playerupgradepoints");
    }
}
