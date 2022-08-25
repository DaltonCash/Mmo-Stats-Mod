package com.daltoncash.mmostats.capabilities.playerlevel;


import net.minecraft.nbt.CompoundTag;

public class PlayerLevelExp {
	private int playerExp;

	public int getLevelExp() {
		return playerExp;
	}

	public void addLevelExp(int add) {
		this.playerExp = playerExp + add;
	}

	public void subLevelExp(int sub) {
		this.playerExp = Math.max(playerExp - sub, 0);
	}

	public void copyFrom(PlayerLevelExp source) {
		this.playerExp = source.playerExp;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("playerlevelexp", playerExp);
	}

	public void loadNBTData(CompoundTag nbt) {
		playerExp = nbt.getInt("playerlevelexp");
	}
}
