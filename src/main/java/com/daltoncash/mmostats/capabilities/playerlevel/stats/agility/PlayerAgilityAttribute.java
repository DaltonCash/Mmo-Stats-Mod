package com.daltoncash.mmostats.capabilities.playerlevel.stats.agility;

import net.minecraft.nbt.CompoundTag;

public class PlayerAgilityAttribute {
	private int playerAgility;

    public int getPlayerAgilityAttribute() {
        return playerAgility;
    }

    public void addPlayerAgilityAttribute(int add) {
        this.playerAgility += add;
    }

    public void subPlayerAgilityAttribute(int sub) {
    	this.playerAgility = Math.max(playerAgility - sub, 0);
    }

    public void copyFrom(PlayerAgilityAttribute source) {
        this.playerAgility = source.playerAgility;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("playeragilityattribute", playerAgility);
    }

    public void loadNBTData(CompoundTag nbt) {
    	playerAgility = nbt.getInt("playeragilityattribute");
    }
}
