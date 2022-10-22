package com.daltoncash.mmostats.capabilities.playerlevel.stats.health;

import com.daltoncash.mmostats.capabilities.playerlevel.stats.health.PlayerHealthAttribute;

import net.minecraft.nbt.CompoundTag;

public class PlayerHealthAttribute {
	private int playerHealth;

    public int getPlayerHealthAttribute() {
        return playerHealth;
    }

    public void addPlayerHealthAttribute(int add) {
        this.playerHealth += add;
    }

    public void subPlayerHealthAttribute(int sub) {
    	this.playerHealth = Math.max(playerHealth - sub, 0);
    }

    public void copyFrom(PlayerHealthAttribute source) {
        this.playerHealth = source.playerHealth;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("playerhealthattribute", playerHealth);
    }

    public void loadNBTData(CompoundTag nbt) {
    	playerHealth = nbt.getInt("playerhealthattribute");
    }
}
