package com.daltoncash.mmostats.capabilities.playerlevel.stats.mana;

import com.daltoncash.mmostats.capabilities.playerlevel.stats.mana.PlayerManaAttribute;

import net.minecraft.nbt.CompoundTag;

public class PlayerManaAttribute {
	private int playerMana;

    public int getPlayerManaAttribute() {
        return playerMana;
    }

    public void addPlayerManaAttribute(int add) {
        this.playerMana += add;
    }

    public void subPlayerManaAttribute(int sub) {
    	this.playerMana = Math.max(playerMana - sub, 0);
    }

    public void copyFrom(PlayerManaAttribute source) {
        this.playerMana = source.playerMana;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("playermanaattribute", playerMana);
    }

    public void loadNBTData(CompoundTag nbt) {
    	playerMana = nbt.getInt("playermanaattribute");
    }
}
