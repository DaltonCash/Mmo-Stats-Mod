package com.daltoncash.mmostats.capabilities.playerlevel;

import net.minecraft.nbt.CompoundTag;

public class PlayerAttributePoints {
	private int playerAttributePoints;

    public int getPlayerAttributePoints() {
        return playerAttributePoints;
    }

    public void addPlayerAttributePoints(int add) {
        this.playerAttributePoints += add;
    }

    public void subPlayerAttributePoints(int sub) {
    	this.playerAttributePoints = Math.max(playerAttributePoints - sub, 0);
    }

    public void copyFrom(PlayerAttributePoints source) {
        this.playerAttributePoints = source.playerAttributePoints;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("playerattributepoints", playerAttributePoints);
    }

    public void loadNBTData(CompoundTag nbt) {
    	playerAttributePoints = nbt.getInt("playerattributepoints");
    }
}
